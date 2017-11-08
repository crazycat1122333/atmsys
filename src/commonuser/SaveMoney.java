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
    JLabel c1 = new JLabel("请输入您的存款金额  ");
    JTextField importMoney = new JTextField();
    //获取各个按钮的图片
   
   
    
    public void setJframe()
    {
    super.setJframe();

    super.removebackButton();
    super.removedetermentButton();
  
    //将图片添加到各个按钮
   
    ok=new ATMButton("确定");
    ok.setFont(new java.awt.Font("Dialog",1,20));
    back = new ATMButton("返回");
    back.setFont(new java.awt.Font("Dialog",1,20));
   //设置omportMoney
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
    //设置JLabel
    c1.setBounds(300,180,350,70);
    c1.setFont(new java.awt.Font("Dialog",1,30));
    //设置按钮的位置
    
    ok.setBounds(770, 200, 120, 50);
    back.setBounds(0,470,120,50);
  
   
    //确定按钮的监听事件
    ok.addActionListener(new ActionListener(){

		
		public void actionPerformed(ActionEvent e) {
			String s=importMoney.getText();
			int money =Integer.parseInt(importMoney.getText());
			accountDao ad=new accountDao();
			if(ad.getStatus(account).equals("挂失")||ad.getStatus(account).equals("冻结")){
	    		 JOptionPane.showMessageDialog(null, "非法操作！该账户已被"+ad.getStatus(account), "ERROR", JOptionPane.ERROR_MESSAGE);
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
			    		 JOptionPane.showMessageDialog(null, "您存入的金额超过单笔存款的最大金额\n请重新存入\n单笔存款的最大金额为10000元。", "ERROR", JOptionPane.ERROR_MESSAGE);
			    	 }
		     
		    }
		    else{JOptionPane.showMessageDialog(null, "请输入100的正整数倍!", "ERROR", JOptionPane.ERROR_MESSAGE);}}
		     
		    
			 importMoney.setText("");
			
			
		}
    	
    });
    //back的监听事件
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
   
   
    //将按钮添加到面板中
   
    p.add(c1);
    p.add(ok);
    p.add(back);
    p.add(importMoney);
	
    }
    public void removeok(){
    	p.remove(ok);
    }
}