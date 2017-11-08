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
import login.LoginInterface;
import login.TextFieldKeyListener;

public class GetMoney extends AllInterface{

String account;
    
    public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
    ATMButton get100;//100
    ATMButton get200;//200
    ATMButton get500;//500
    ATMButton get1000;//1000
    ATMButton get1500;//1500
    ATMButton get2000;//2000
    private ATMButton ok;
    private ATMButton back;
    JLabel c1 = new JLabel("请输入您的取款金额    ");
    JTextField importMoney = new JTextField();
    //获取各个按钮的图片
 //   Icon icon1 = new ImageIcon("src//button2-1.jpg");
  //  Icon icon2 = new ImageIcon("src//button2-2.jpg");
//    Icon icon3 = new ImageIcon("src//button2-3.jpg");
//    Icon icon4 = new ImageIcon("src//button2-4.jpg");
//    Icon icon5 = new ImageIcon("src//button2-5.jpg");
//    Icon icon6 = new ImageIcon("src//button2-6.jpg");
//    Icon icon7 = new ImageIcon("src//button10.jpg");
   
    
    public void setJframe()
    {
    super.setJframe();
   
    super.removebackButton();
    super.removedetermentButton();
  
    //将图片添加到各个按钮
    get100 = new  ATMButton("100");
    get100.setFont(new java.awt.Font("Dialog",1,20));
    get200 = new  ATMButton("200");	
    get200.setFont(new java.awt.Font("Dialog",1,20));
    get500 = new  ATMButton("500");	
    get500.setFont(new java.awt.Font("Dialog",1,20));
    get1000 = new  ATMButton("1000");	
    get1000.setFont(new java.awt.Font("Dialog",1,20));
    get1500 = new  ATMButton("1500");	
    get1500.setFont(new java.awt.Font("Dialog",1,20));
    get2000 = new  ATMButton("2000");
    get2000.setFont(new java.awt.Font("Dialog",1,20));
    ok=new  ATMButton("取款");
    ok.setFont(new java.awt.Font("Dialog",1,20));
    back = new ATMButton("返回");
    back.setFont(new java.awt.Font("Dialog",1,20));
   //设置omportMoney
    importMoney.setBounds(350,275,200,40);
    importMoney.setFont(new java.awt.Font("Dialog",1,22));
   
    importMoney.addKeyListener(new TextFieldKeyListener(1));
    importMoney.addKeyListener(
    		new KeyAdapter()
    		{ 
    		public void keyTyped(KeyEvent e) 
    		{ 	    		
    		int length=importMoney.getText().length();	 
    		
    		if((length>3))
    		{ 
    		e.consume(); 
    		}
    		
    		
    		} 
    		});
    //设置JLabel
    c1.setBounds(300,180,350,70);
    c1.setFont(new java.awt.Font("Dialog",1,30));
    //设置按钮的位置
    get100.setBounds(0,240,120,50);
    get200.setBounds(0,300,120,50);
    get500.setBounds(0,360,120,50);
    get1000.setBounds(770,270,120,50);
    get1500.setBounds(770,330,120,50);
    get2000.setBounds(770,390,120,50);
    ok.setBounds(770, 200, 120, 50);
    back.setBounds(0,470,120,50);
  
    //get100的监听事件
    get100.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		importMoney.setText("100");
    	}
    	
    });
  //get200的监听事件
    get200.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		importMoney.setText("200");
    	}
    	
    });
  //get500的监听事件
    get500.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		importMoney.setText("500");
    	}
    	
    });
  //get1000的监听事件
    get1000.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		importMoney.setText("1000");
    	}
    	
    });
  //get1500的监听事件
    get1500.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		importMoney.setText("1500");
    	}
    	
    });
  //get2000的监听事件
    get2000.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		importMoney.setText("2000");
    	}
    	
    });
    //确定按钮的监听事件
    ok.addActionListener(new ActionListener(){

		
		public void actionPerformed(ActionEvent e) {
			String s=importMoney.getText();
			int money =Integer.parseInt(importMoney.getText());
		    	 System.out.println(getAccount());
		    	 accountDao ad=new accountDao();
		    	 //判断账号是否为销户或冻结
		    	 if(ad.getStatus(account).equals("挂失")||ad.getStatus(account).equals("冻结"))
		    	 {
		    		 JOptionPane.showMessageDialog(null, "非法操作！该账户已被"+ad.getStatus(account), "ERROR", JOptionPane.ERROR_MESSAGE);
		    	 }
		    	
		    	 else{
		    		 //输入合法的金额
		    	 if(money >0 && money%100 ==0)
				    {
		    		 int t =ad.getMax(getAccount());
		    		 double over = ad.getOver(getAccount());
		    		 double balance = ad.searchBalance(getAccount());
		    		 System.out.println(over);
		    		 String cardType = ad.cardType(getAccount());
		    		 
		    		 Fee cc = new Fee(1, (double)money);
					double finalmoney2 = cc.calculateFee();
		    				
		    		 //判断是否超过单笔取款的最大金额 			    	
		    		 //超过
		    		 if(money>5000)
			    	 {
		    			 JOptionPane.showMessageDialog(null, "您输入的金额超过单笔取款的最大金额 ！\n请重新输入！\n单笔取款的最大金额为5000元。", "ERROR", JOptionPane.ERROR_MESSAGE);
			    	 }
		    		 //没超过
		    		 if( money <= 5000)
			    	 {
		    		//是否超过当日可取现额	
		    			// 没超过
		    		 if((t - money) >0)
		    		 {
		    		    //是否可取
		    			if((balance + over -money )>0) 
		    			{
		    		       transactionDao td=new transactionDao();
						   						
					       double fee= ad.getMoney(money, getAccount());	
					       td.GetT(getAccount(), money,fee);
					       //取款成功					      
			    	 }
		    			else
		    			{
		    				
		    				JOptionPane.showMessageDialog(null,
		    						"取款失败！\n您的余额不足！", "ERROR", JOptionPane.ERROR_MESSAGE);
			    		 }
		    		 
			    	 }
		    		 }
		    		 //超过
		    		 if((t-money)<= 0)
		    		 {
		    			 JOptionPane.showMessageDialog(null, "您当日取款金额已超过上限！\n禁止再取款！", "ERROR", JOptionPane.ERROR_MESSAGE);
		    		 }
					
					}
				    
				    
		    	 else{JOptionPane.showMessageDialog(null, "请输入100的正整数倍！", "ERROR", JOptionPane.ERROR_MESSAGE);}
		    	 
		    	
		    	 }
		   
		    
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
    		t.setVisible(false);
    	}
    	
    });
   
   
    //将按钮添加到面板中
    p.add(get100);
    p.add(get200);
    p.add(get500);
    p.add(get1000);
    p.add(get1500);
    p.add(get2000);   
    p.add(c1);
    p.add(ok);
    p.add(back);
    p.add(importMoney);
	
    }
    public void removeok(){
    	p.remove(ok);
    }
}
