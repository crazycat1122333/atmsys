package commonuser;

import java.awt.event.*;

import javax.swing.*;

import Dao.accountDao;
import login.ATMButton;
import login.AllInterface;
import login.Interface;
import login.LoginInterface;

public class Search extends AllInterface{
	
    ATMButton searchBalance ;
    ATMButton searchTransactionDetails;
   
  //获取各个按钮的图片
 //   Icon icon1 = new ImageIcon("src//button8.jpg");
 //   Icon icon2 = new ImageIcon("src//button9.jpg");
   
    
    public void setJframe()
    {
    	super.setJframe();
   
    	super.removedetermentButton();
    //将图片添加到各个按钮	
    searchBalance = new ATMButton("查询余额");
    searchBalance.setFont(new java.awt.Font("Dialog",1,22));
    searchTransactionDetails = new ATMButton("查询交易明细");
    searchTransactionDetails.setFont(new java.awt.Font("Dialog",1,22));
   
    //设置按钮的位置
    searchBalance.setBounds(0,200,165,65);
    searchTransactionDetails.setBounds(730,200,165,65);
  
    //searchBalance的监听事件
    searchBalance.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		accountDao ad=new accountDao();
    		SearchBalance a1=new SearchBalance();
    		a1.setAccount(getAccount());
    		double balance=ad.searchBalance(getAccount());
    		double over = ad.getOver(getAccount());
    		double usedbalance = over+balance;
    		String b=""+balance;
    		String d =""+usedbalance;
    		System.out.println(b);
    		System.out.println(d);
    		JLabel c =new JLabel(b);
    		JLabel g =new JLabel(d);
    		a1.setJl3(c);
    		a1.setJl5(g);
    		a1.setJframe();
    		t.setVisible(false);
    	}
    	
    });
    // searchTransactionDetails的监听事件
    searchTransactionDetails.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		SearchTransactionDetails c1 = new SearchTransactionDetails();
    		c1.setAccount(getAccount());
    		c1.setJframe();
    		t.setVisible(false);
    	}
    	
    });
   
  
  //将按钮添加到面板中
    p.add(searchBalance);
    p.add(searchTransactionDetails);

    }

}
