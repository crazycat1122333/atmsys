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
   
  //��ȡ������ť��ͼƬ
 //   Icon icon1 = new ImageIcon("src//button8.jpg");
 //   Icon icon2 = new ImageIcon("src//button9.jpg");
   
    
    public void setJframe()
    {
    	super.setJframe();
   
    	super.removedetermentButton();
    //��ͼƬ��ӵ�������ť	
    searchBalance = new ATMButton("��ѯ���");
    searchBalance.setFont(new java.awt.Font("Dialog",1,22));
    searchTransactionDetails = new ATMButton("��ѯ������ϸ");
    searchTransactionDetails.setFont(new java.awt.Font("Dialog",1,22));
   
    //���ð�ť��λ��
    searchBalance.setBounds(0,200,165,65);
    searchTransactionDetails.setBounds(730,200,165,65);
  
    //searchBalance�ļ����¼�
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
    // searchTransactionDetails�ļ����¼�
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
   
  
  //����ť��ӵ������
    p.add(searchBalance);
    p.add(searchTransactionDetails);

    }

}
