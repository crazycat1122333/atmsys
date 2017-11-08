package commonuser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

import Dao.accountDao;
import Dao.transactionDao;
import login.ATMButton;
import login.AllInterface;
import login.TextFieldKeyListener;
public class Transfer extends AllInterface{
	String account ;
	  private ATMButton back;
	JLabel transferAccount = new JLabel("��������Ҫת�˵��˻�  ");
	JLabel transferMoney = new JLabel("����������ת�˽��   ");
	JTextField accountText = new JTextField();
	JTextField moneyText = new JTextField();
	
    public void setJframe()
    {
       super.setJframe();
       super.removebackButton();
       back = new ATMButton("����");
       back.setFont(new java.awt.Font("Dialog",1,20));
       back.setBounds(0,470,120,50);
       //����JLabel��λ��
       transferAccount.setBounds(300,180,350,70);
       transferAccount.setFont(new java.awt.Font("Dialog",1,30));
       transferMoney.setBounds(300,320,350,70);
       transferMoney.setFont(new java.awt.Font("Dialog",1,30));
       //����JTextField��λ��
       accountText.setBounds(350,250,220,40);
       accountText.setFont(new java.awt.Font("Dialog",1,22));
       moneyText.setBounds(380,390,150,40);
       moneyText.setFont(new java.awt.Font("Dialog",1,22));
      
       accountText.addKeyListener(new TextFieldKeyListener(1));
       accountText.addKeyListener(
       		new KeyAdapter()
       		{ 
       		public void keyTyped(KeyEvent e) 
       		{ 	    		
       		int length= accountText.getText().length();	 
       		
       		if((length>15))
       		{ 
       		e.consume(); 
       		}
       		
       		
       		} 
       		});
       moneyText.addKeyListener(new TextFieldKeyListener(2));
       moneyText.addKeyListener(
       		new KeyAdapter()
       		{ 
       		public void keyTyped(KeyEvent e) 
       		{ 	    		
       		int length= moneyText.getText().length();	 
       		
       		if((length>7))
       		{ 
       		e.consume(); 
       		}
       		
       		
       		} 
       		});
     //back�ļ����¼�
       back.addActionListener(new ActionListener()
       {
       	public void actionPerformed(ActionEvent e)
       	{
       		CommonUserInterface c2 = new CommonUserInterface();
       		
       		c2.setAccount(account);
       		
       		c2.setJframe();
       		t.setVisible(false);
       	}});
       
       //ȷ����ť�ļ����¼�
       determent.addActionListener(new ActionListener()
       {
          	public void actionPerformed(ActionEvent e)
          	{          		          		         		
          accountDao ad = new accountDao();         		        		
          transactionDao td=new transactionDao();
          //��ȡ�������ֵ
      	  double b=Double.valueOf(moneyText.getText()).doubleValue(); 
      	  double t = ad.transferMax(getAccount());
     	 
 		   
      	  //���������˺��Ƿ����
          	  if( ad.accountCheck(accountText.getText()))
             {
          		 //�˺ż��
          	   if(  (ad.transferCheck(accountText.getText(),b)) == true)
          	{
          		   if(account.equals(accountText.getText()))
          		   {
          			 JOptionPane.showMessageDialog(null, "����������ȷ���˺ţ�\n����ת�˸��Լ���", "ERROR", JOptionPane.ERROR_MESSAGE);
          		   }
          		
          		if(!account.equals(accountText.getText()))
          		{
          		   //����Ľ�������ת�˵������
          		if(b>50000)
		    	 {
		    		 JOptionPane.showMessageDialog(null, "������Ľ�������ת�˵������\n����������", "ERROR", JOptionPane.ERROR_MESSAGE);
		    	 }
          		//û�г���
          		if(b <= 50000 )
          		{
          			//�Ƿ񳬹�����
          		if((t-b)>0)
          		{
          			double d = Double.valueOf(moneyText.getText());
          			System.out.println(d);
          			int i =(int) d;
          			System.out.println(i);
          			
          			double d1 = (d-i)*100;
          			System.out.println(d1);
          			int d2 = (int)d1;
          			System.out.println(d2);
          			
          			if((d1-d2)<=0.0000001)
          			{
          				
          			   Fee cc = new Fee(1, d);
          				double finalmoney2 = cc.calculateFee();
          				
          				if((ad.getOver(account)-finalmoney2-d)>=0){
          		ad.transferAdd(accountText.getText(), b);
          		double fee = ad.transferReduce(getAccount(),b,accountText.getText());
          		td.transferT(getAccount(), b, accountText.getText(),fee);  
          				}
          				if((ad.getOver(account))<0)
          				{
          					JOptionPane.showMessageDialog(null, "���Ѷ�������꣡\n��", "ERROR", JOptionPane.ERROR_MESSAGE);
          				}
          		
          			}
          			if((d1-d2)>0.0000001)
          			{
          				JOptionPane.showMessageDialog(null, "����������ȷ��ʽ�Ľ�\nֻ��������λС����", "ERROR", JOptionPane.ERROR_MESSAGE);
          			}
          			
          		}
          		
          		
          		if((t-b)<=0)
          		{
          			 JOptionPane.showMessageDialog(null, "������ת�˽���ѳ�������\n��ֹ��ȡ��", "ERROR", JOptionPane.ERROR_MESSAGE);
          		}
          		}
          		
          		System.out.println("2");
          	}
          	}
          	if((ad.transferCheck(accountText.getText(),b)) == false)
          	{
          		JOptionPane.showMessageDialog(null, "��������˺��ѹ�ʧ", "ERROR", JOptionPane.ERROR_MESSAGE);
          		
          	}          	
          	}
          	  else
          	{
          		JOptionPane.showMessageDialog(null, "����������ȷ���˺ţ�", "ERROR", JOptionPane.ERROR_MESSAGE);
          	}
          	accountText.setText("");
          	moneyText.setText("");
       }
          	
          });
       p.add(back);
       p.add(transferAccount);
       p.add(transferMoney);
       p.add(accountText);
       p.add(moneyText);
      
    }
    public void setAccount(String account){
    	this.account=account;
    }
    public String getAccount(){return account;}

}
