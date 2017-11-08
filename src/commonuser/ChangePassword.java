package commonuser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.*;

import Dao.accountDao;
import login.ATMButton;
import login.AllInterface;
import login.TextFieldKeyListener;

public class ChangePassword extends AllInterface{
	JLabel c1 = new JLabel("���������ľ�����  ��");
	JPasswordField oldPassword = new JPasswordField();
	//�����˺�
	String account;
	ATMButton back ;
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	
	public void setJframe()
	{			
      super.setJframe();
     
      super.removebackButton();;
      //����JLabel
      c1.setBounds(300,180,350,70);
      c1.setFont(new java.awt.Font("Dialog",1,30));	
      //����JTextField
      oldPassword.setBounds(350,275,200,40);
      oldPassword.setFont(new java.awt.Font("Dialog",1,22));
      oldPassword.addKeyListener(new TextFieldKeyListener(1));
      oldPassword.addKeyListener(
      		new KeyAdapter()
      		{ 
      		public void keyTyped(KeyEvent e) 
      		{ 	    		
      		int length=oldPassword.getText().length();	 
      		
      		if((length>5))
      		{ 
      		e.consume(); 
      		}
      		
      		
      		} 
      		});
      
      back = new ATMButton("����");
      back.setFont(new java.awt.Font("Dialog",1,20));
      back.setBounds(0,480,120,45);
    //back�ļ����¼�
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
   
      //����determent�ļ����¼�
      determent.addActionListener(new ActionListener()
      {
      	public void actionPerformed(ActionEvent e)
      	{  
      	   accountDao ad=new accountDao();
      	   try 
      	   {
			if(ad.login(account, oldPassword.getText()))
			{
				FinalChangePassword a1 = new FinalChangePassword();
				a1.setAccount(account);
				a1.setJframe();
				t.setVisible(false);
				}
			else
			{
				JOptionPane.showMessageDialog(null, "��������ȷ������", "ERROR", JOptionPane.ERROR_MESSAGE);
				
			}
		} catch (SQLException e1) 
      	  {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}
      	}     	
      });
      
      p.add(oldPassword);
	  p.add(c1);
	  p.add(back);
	  
	}
	
}
