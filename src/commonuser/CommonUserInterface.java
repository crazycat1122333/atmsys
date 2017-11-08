package commonuser;


import java.awt.event.*;

import javax.swing.*;

import Dao.accountDao;
import login.ATMButton;
import login.AllInterface;


public class CommonUserInterface extends AllInterface{
	String account;
    //ȡ�ת�ˣ�����ѯ���޸����룬�˳��İ�ť��
    ATMButton getMoney ;
    ATMButton transfer ;
    ATMButton saveMoney ;
    ATMButton search ;
    ATMButton changePassword ;
    
  
    //��ȡͼƬ
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
      //��������ť�����ͼƬ
    getMoney = new ATMButton("ȡ��");
    getMoney.setFont(new java.awt.Font("Dialog",1,22));
    transfer = new ATMButton("ת��");
    transfer.setFont(new java.awt.Font("Dialog",1,22));
    saveMoney = new ATMButton("���");
    saveMoney.setFont(new java.awt.Font("Dialog",1,22));
    search = new ATMButton("��ѯ");
    search.setFont(new java.awt.Font("Dialog",1,22));
    changePassword = new ATMButton("�޸�����");
    changePassword.setFont(new java.awt.Font("Dialog",1,22));
   
   
    //���ð�ť��λ�ü���С
    getMoney.setBounds(0,250,150,60);	
    transfer.setBounds(740,300,150,60);
    saveMoney.setBounds(0,350,150,60);
    search.setBounds(740,400,150,60);
    changePassword.setBounds(0,450,150,60);
   
    //ȡ�ť�ļ����¼�
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
    //ת�˰�ť�ļ����¼�
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
    //��ť�ļ����¼�
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
    //��ѯ��ť�ļ����¼�
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
    //�޸�����ļ����¼�
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
    JLabel a1 = new JLabel(finalsir+finalsex+"����ѡ������Ҫ�Ĳ��� : "); 
   
    a1.setBounds(250,160,380,100);
    a1.setFont(new java.awt.Font("Dialog",1,25));      
    p.add(getMoney);
    p.add(transfer);    
    p.add(saveMoney);  
    p.add(search);
    p.add(changePassword);
  
    p.add(a1);
		
    }
    //�ж��Ա𷽷�
    public String judgeSex(Boolean a)
    {
    	String sex ="";
    	if(a)
    		sex = "����";
    	if(!a)
    		sex="Ůʿ";
    	
    	return sex;
    	
    }

}
