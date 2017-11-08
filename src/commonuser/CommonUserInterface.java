package commonuser;


import java.awt.event.*;

import javax.swing.*;

import Dao.accountDao;
import login.ATMButton;
import login.AllInterface;


public class CommonUserInterface extends AllInterface{
	String account;
    //取款，转账，存款，查询，修改密码，退出的按钮。
    ATMButton getMoney ;
    ATMButton transfer ;
    ATMButton saveMoney ;
    ATMButton search ;
    ATMButton changePassword ;
    
  
    //获取图片
 //   Icon icon1 = new ImageIcon("src//button2.jpg");
 //   Icon icon2 = new ImageIcon("src//button3.jpg");
 //   Icon icon3 = new ImageIcon("src//button4.jpg");
 //   Icon icon4 = new ImageIcon("src//button5.jpg");
  //  Icon icon5 = new ImageIcon("src//button6.jpg");
 //   Icon icon6 = new ImageIcon("src//button7.jpg");
    
    public void setAccount(String account){
    	this.account=account;
    }
    public String getAccount(){return account;}
    public void setJframe()
    {
    	super.setJframe();
    	
    	super.removebackButton();
    	
    	super.removedetermentButton();
    	accountDao ad = new accountDao();
      //往各个按钮里添加图片
    getMoney = new ATMButton("取款");
    getMoney.setFont(new java.awt.Font("Dialog",1,22));
    transfer = new ATMButton("转账");
    transfer.setFont(new java.awt.Font("Dialog",1,22));
    saveMoney = new ATMButton("存款");
    saveMoney.setFont(new java.awt.Font("Dialog",1,22));
    search = new ATMButton("查询");
    search.setFont(new java.awt.Font("Dialog",1,22));
    changePassword = new ATMButton("修改密码");
    changePassword.setFont(new java.awt.Font("Dialog",1,22));
   
   
    //设置按钮的位置及大小
    getMoney.setBounds(0,250,150,60);	
    transfer.setBounds(740,300,150,60);
    saveMoney.setBounds(0,350,150,60);
    search.setBounds(740,400,150,60);
    changePassword.setBounds(0,450,150,60);
   
    //取款按钮的监听事件
    getMoney.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		GetMoney a1 = new GetMoney();
    		a1.setAccount(account);
			a1.setJframe();
			t.setVisible(false);
    	}
    	
    });
    //转账按钮的监听事件
    transfer.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		Transfer a2 = new Transfer();
    		a2.setAccount(account);
			a2.setJframe();
			t.setVisible(false);
    	}
    	
    });
    //存款按钮的监听事件
    saveMoney.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		SaveMoney a3 = new SaveMoney();
    		
    		System.out.println(account);
    		a3.setAccount(account);
    		a3.setJframe();
			t.setVisible(false);
    	}
    	
    });
    //查询按钮的监听事件
    search.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		Search a4 = new Search();
    		a4.setAccount(account);
			a4.setJframe();
			t.setVisible(false);
    	}
    	
    });
    //修改密码的监听事件
    changePassword.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		ChangePassword a5 = new ChangePassword();
    		System.out.println(account);
    		a5.setAccount(account);
			a5.setJframe();
			t.setVisible(false);
    	}
    	
    });
    String sir = ad.name(account);
    Boolean sex = ad.sex(account);
    String finalsex = judgeSex(sex);
    String finalsir = sir.substring(0, 1);
    JLabel a1 = new JLabel(finalsir+finalsex+"，请选择您需要的操作 : "); 
   
    a1.setBounds(250,160,380,100);
    a1.setFont(new java.awt.Font("Dialog",1,25));      
    p.add(getMoney);
    p.add(transfer);    
    p.add(saveMoney);  
    p.add(search);
    p.add(changePassword);
  
    p.add(a1);
		
    }
    //判断性别方法
    public String judgeSex(Boolean a)
    {
    	String sex ="";
    	if(a)
    		sex = "先生";
    	if(!a)
    		sex="女士";
    	
    	return sex;
    	
    }

}
