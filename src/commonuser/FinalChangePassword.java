package commonuser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.*;

import Dao.accountDao;
import login.AllInterface;
import login.LoginInterface;
import login.TextFieldKeyListener;

public class FinalChangePassword extends AllInterface{
	//定义JLabel
	JLabel a1 = new JLabel("请输入您的新密码");
	JLabel a2 = new JLabel("请再次输入您的新密码");
	//定义JTextField
	JPasswordField newPassword = new JPasswordField();
	JPasswordField againNewPassword = new JPasswordField();
	
	public void setJframe()
	{		
		super.setJframe();		
		
		//设置JLabel
		a1.setBounds(300,180,350,70);
		a1.setFont(new java.awt.Font("Dialog",1,30));;
		a2.setBounds(300,320,350,70);
		a2.setFont(new java.awt.Font("Dialog",1,30));
		//设置JTextField
		newPassword.setBounds(350,250,200,40);
		newPassword.setFont(new java.awt.Font("Dialog",1,22));
		newPassword.addKeyListener(new TextFieldKeyListener(1));
		newPassword.addKeyListener(
	      		new KeyAdapter()
	      		{ 
	      		public void keyTyped(KeyEvent e) 
	      		{ 	    		
	      		int length=newPassword.getText().length();	 
	      		
	      		if((length>5))
	      		{ 
	      		e.consume(); 
	      		}
	      		
	      		
	      		} 
	      		});
		againNewPassword.setBounds(350,390,200,40);
		againNewPassword.setFont(new java.awt.Font("Dialog",1,22));
		againNewPassword.addKeyListener(new TextFieldKeyListener(1));
		againNewPassword.addKeyListener(
	      		new KeyAdapter()
	      		{ 
	      		public void keyTyped(KeyEvent e) 
	      		{ 	    		
	      		int length=againNewPassword.getText().length();	 
	      		
	      		if((length>5))
	      		{ 
	      		e.consume(); 
	      		}
	      		
	      		
	      		} 
	      		});
		determent.addActionListener(new ActionListener()
	      {
	      	public void actionPerformed(ActionEvent e)
	      	{  accountDao ad=new accountDao();
	      	   if(newPassword.getText().equals(againNewPassword.getText())){
	      		 ad.changePassword(getAccount(), newPassword.getText());
	      		 LoginInterface lg=new LoginInterface();
	      		 lg.SetJframe();
	      		 t.setVisible(false);
	      		
	      		   
	      	   }
	      	 else{JOptionPane.showMessageDialog(null, "密码不一致，请重新输入", "ERROR", JOptionPane.ERROR_MESSAGE);
	      	 newPassword.setText(" ");
	      	 againNewPassword.setText(" ");}
	      	}
	      	
	      });
		p.add(a1);
		p.add(a2);
		p.add(newPassword);
		p.add(againNewPassword);
		
	}

}
