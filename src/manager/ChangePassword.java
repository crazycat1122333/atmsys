package manager;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ChangePassword extends ChangePasswordInterface{
	JPanel panel9;
	
	
	//JButton
	JButton a1 = new JButton("修改用户密码");
	JButton a2 = new JButton("修改管理员密码");
	
	public JPanel changePassword()
	{
		panel9 = new JPanel();
		panel9.setLayout(null);
		
		//设置按钮
		a1.setBounds(100,250,200,50);
		a1.setFont(new java.awt.Font("Dialog",1,20));
		a2.setBounds(450,250,200,50);
		a2.setFont(new java.awt.Font("Dialog",1,20));
		
		//修改用户密码的监听事件
		a1.addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent e)
			{
				a1Action();
			}
			
		}
		);
		
		//修改管理员密码的监听事件
		a2.addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent e)
			{
				a2Action();
			}
			
		}
		);
		
		//往panel9里添加组件
		panel9.add(a1);
		panel9.add(a2);
		
		
		return panel9;
	}
	public void a1Action()
	{
         ChangePasswordInterface a1=new ChangePasswordInterface();
         
         a1.setFrame();
         
	}
	public void a2Action()
	{
		ChangeMPassword a2=new ChangeMPassword();
		a2.setAccount(account);
		a2.setFrame();
	}

}
