package commonuser;
import java.awt.event.*;

import javax.swing.*;

import Dao.accountDao;
import Dao.transactionDao;
import login.*;
public class SaveMoney extends AllInterface{

String account;
    
    public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
   
    private ATMButton ok;
    private ATMButton back;
    JLabel c1 = new JLabel("���������Ĵ����  ");
    JTextField importMoney = new JTextField();
    //��ȡ������ť��ͼƬ
   
   
    
    public void setJframe()
    {
    super.setJframe();

    super.removebackButton();
    super.removedetermentButton();
  
    //��ͼƬ��ӵ�������ť
   
    ok=new ATMButton("ȷ��");
    ok.setFont(new java.awt.Font("Dialog",1,20));
    back = new ATMButton("����");
    back.setFont(new java.awt.Font("Dialog",1,20));
   //����omportMoney
    importMoney.setBounds(350,275,200,40);
    importMoney.setFont(new java.awt.Font("Dialog",1,22));
    int a = 1;
    importMoney.addKeyListener(new TextFieldKeyListener(1));
    importMoney.addKeyListener(
    		new KeyAdapter()
    		{ 
    		public void keyTyped(KeyEvent e) 
    		{ 	    		
    		int length=importMoney.getText().length();	    		
    		if((length>4))
    		{ 
    		e.consume(); 
    		}
    		
    		} 
    		});
    //����JLabel
    c1.setBounds(300,180,350,70);
    c1.setFont(new java.awt.Font("Dialog",1,30));
    //���ð�ť��λ��
    
    ok.setBounds(770, 200, 120, 50);
    back.setBounds(0,470,120,50);
  
   
    //ȷ����ť�ļ����¼�
    ok.addActionListener(new ActionListener(){

		
		public void actionPerformed(ActionEvent e) {
			String s=importMoney.getText();
			int money =Integer.parseInt(importMoney.getText());
			accountDao ad=new accountDao();
			if(ad.getStatus(account).equals("��ʧ")||ad.getStatus(account).equals("����")){
	    		 JOptionPane.showMessageDialog(null, "�Ƿ����������˻��ѱ�"+ad.getStatus(account), "ERROR", JOptionPane.ERROR_MESSAGE);
	    	 }else{
		    if(money >0 && money%100 ==0)
		    {
		    	if(money<10000)
		    	 {
		    	// System.out.println(getAccount());
					
					transactionDao td=new transactionDao();
					double fee = ad.saveMoney(money, getAccount());
					td.saveT(getAccount(), money,fee);
					
					
		    	 }
					 if(money>10000)
			    	 {
			    		 JOptionPane.showMessageDialog(null, "������Ľ������ʴ��������\n�����´���\n���ʴ��������Ϊ10000Ԫ��", "ERROR", JOptionPane.ERROR_MESSAGE);
			    	 }
		     
		    }
		    else{JOptionPane.showMessageDialog(null, "������100����������!", "ERROR", JOptionPane.ERROR_MESSAGE);}}
		     
		    
			 importMoney.setText("");
			
			
		}
    	
    });
    //back�ļ����¼�
    back.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		CommonUserInterface d1 = new CommonUserInterface();
    		System.out.println(getAccount());
    		d1.setAccount(account);
    		d1.setJframe();
    	}
    	
    });
   
   
    //����ť��ӵ������
   
    p.add(c1);
    p.add(ok);
    p.add(back);
    p.add(importMoney);
	
    }
    public void removeok(){
    	p.remove(ok);
    }
}