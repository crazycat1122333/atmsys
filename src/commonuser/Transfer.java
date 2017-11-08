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
	JLabel transferAccount = new JLabel("请输入您要转账的账户  ");
	JLabel transferMoney = new JLabel("请输入您的转账金额   ");
	JTextField accountText = new JTextField();
	JTextField moneyText = new JTextField();
	
    public void setJframe()
    {
       super.setJframe();
       super.removebackButton();
       back = new ATMButton("返回");
       back.setFont(new java.awt.Font("Dialog",1,20));
       back.setBounds(0,470,120,50);
       //设置JLabel的位置
       transferAccount.setBounds(300,180,350,70);
       transferAccount.setFont(new java.awt.Font("Dialog",1,30));
       transferMoney.setBounds(300,320,350,70);
       transferMoney.setFont(new java.awt.Font("Dialog",1,30));
       //设置JTextField的位置
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
     //back的监听事件
       back.addActionListener(new ActionListener()
       {
       	public void actionPerformed(ActionEvent e)
       	{
       		CommonUserInterface c2 = new CommonUserInterface();
       		
       		c2.setAccount(account);
       		
       		c2.setJframe();
       		t.setVisible(false);
       	}});
       
       //确定按钮的监听事件
       determent.addActionListener(new ActionListener()
       {
          	public void actionPerformed(ActionEvent e)
          	{          		          		         		
          accountDao ad = new accountDao();         		        		
          transactionDao td=new transactionDao();
          //获取输入金额的值
      	  double b=Double.valueOf(moneyText.getText()).doubleValue(); 
      	  double t = ad.transferMax(getAccount());
     	 
 		   
      	  //检查输入的账号是否存在
          	  if( ad.accountCheck(accountText.getText()))
             {
          		 //账号检查
          	   if(  (ad.transferCheck(accountText.getText(),b)) == true)
          	{
          		   if(account.equals(accountText.getText()))
          		   {
          			 JOptionPane.showMessageDialog(null, "请您输入正确的账号！\n不能转账给自己！", "ERROR", JOptionPane.ERROR_MESSAGE);
          		   }
          		
          		if(!account.equals(accountText.getText()))
          		{
          		   //输入的金额超过单笔转账的最大金额
          		if(b>50000)
		    	 {
		    		 JOptionPane.showMessageDialog(null, "您输入的金额超过单笔转账的最大金额\n请重新输入", "ERROR", JOptionPane.ERROR_MESSAGE);
		    	 }
          		//没有超过
          		if(b <= 50000 )
          		{
          			//是否超过上限
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
          					JOptionPane.showMessageDialog(null, "您已额度已用完！\n！", "ERROR", JOptionPane.ERROR_MESSAGE);
          				}
          		
          			}
          			if((d1-d2)>0.0000001)
          			{
          				JOptionPane.showMessageDialog(null, "请您输入正确格式的金额！\n只能输入两位小数！", "ERROR", JOptionPane.ERROR_MESSAGE);
          			}
          			
          		}
          		
          		
          		if((t-b)<=0)
          		{
          			 JOptionPane.showMessageDialog(null, "您当日转账金额已超过上限\n禁止再取款", "ERROR", JOptionPane.ERROR_MESSAGE);
          		}
          		}
          		
          		System.out.println("2");
          	}
          	}
          	if((ad.transferCheck(accountText.getText(),b)) == false)
          	{
          		JOptionPane.showMessageDialog(null, "您输入的账号已挂失", "ERROR", JOptionPane.ERROR_MESSAGE);
          		
          	}          	
          	}
          	  else
          	{
          		JOptionPane.showMessageDialog(null, "请您输入正确的账号！", "ERROR", JOptionPane.ERROR_MESSAGE);
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
