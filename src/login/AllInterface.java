package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import commonuser.CommonUserInterface;
import commonuser.Transfer;

public class AllInterface extends JFrame{
	String account;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public JFrame t = new JFrame("中国建设银行ATM系统");
	//背景面板
    public Interface p = new Interface();
    public ATMButton determent;
   
    public  ATMButton back ;
    ATMButton exit;
  //获取各个按钮的图片
  //  Icon icon1 = new ImageIcon("src//button2-8.jpg");
  //  Icon icon2 = new ImageIcon("src//button10.jpg");
  //  Icon icon3 = new ImageIcon("src//button2-7.jpg"); 
  // icon4 = new ImageIcon("src//button1.jpg");
   
    
    public void setJframe()
    {
    //将图片添加到各个按钮	
   
    back = new ATMButton("返回");
    back.setFont(new java.awt.Font("Dialog",1,20));
    exit = new ATMButton("退卡");
    exit.setFont(new java.awt.Font("Dialog",1,20));
    determent = new ATMButton("确定");
    determent.setFont(new java.awt.Font("Dialog",1,20));
    //设置按钮的位置
   
    back.setBounds(0,480,120,45);
    exit.setBounds(770,520,120,45);
    determent.setBounds(770,240,120,50);
    //continue1的监听事件
   
    //back的监听事件
    back.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		CommonUserInterface c2 = new CommonUserInterface();
    		
    		c2.setAccount(account);
    		
    		c2.setJframe();
    		t.setVisible(false);
    	}
    	}
    	
    );
    //exit的监听事件
    exit.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		LoginInterface c3 = new LoginInterface();
    	
    		c3.SetJframe();
    		t.setVisible(false);
    	}
    	
    });
    //determent的监听事件
    determent.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		
    	}
    	
    });
    
  //将按钮添加到面板中
    
    p.add(back);
    p.add(exit);
    p.add(determent);
    p.setLayout(null);
	t.add(p);
	t.setSize(900,600);
	t.setVisible(true);
	t.setLocationRelativeTo(null);	
	t.setResizable(false);
	t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
    }
    
    public void removebackButton()
    {
    	p.remove(back);
    }
    public void removeexitButton()
    {
    	p.remove(exit);
    }
    public void removedetermentButton()
    {
    	p.remove(determent);
    }

}
