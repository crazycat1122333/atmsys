package manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.*;

import login.TextFieldKeyListener;
import Dao.managerDao;
import commonuser.SearchTransactionDetails;

public class DeleteCommonUser extends AllInterface{
	JPanel panel3;
	//JLabel
	JLabel a1 = new JLabel("请输入需要销户的账号 ：");
	JLabel a2 = new JLabel("   请输入账号的密码 ： ");
	JLabel a3 = new JLabel("请输入账号的身份证号  ：");
	//JTextField
	JTextField b1 = new JTextField();
	JPasswordField b2 = new JPasswordField();
	JTextField b3= new JTextField();
	//确定按钮
	JButton c1 = new JButton("确定");
	
	
	public JPanel delete()
	{
		panel3 = new JPanel();
		panel3.setLayout(null);
		//设置JLabel
		a1.setBounds(100,150,250,50);
		a1.setFont(new java.awt.Font("Dialog",1,20));
		a2.setBounds(100,200,250,50);
		a2.setFont(new java.awt.Font("Dialog",1,20));
		a3.setBounds(100,250,250,50);
		a3.setFont(new java.awt.Font("Dialog",1,20));
		//设置JTextField
		b1.setBounds(350,155,210,35);
		b1.setFont(new java.awt.Font("Dialog",1,20));
		b1.addKeyListener(new TextFieldKeyListener(1));
		  b1.addKeyListener(
		    		new KeyAdapter()
		    		{ 
		    		public void keyTyped(KeyEvent e) 
		    		{ 	    		
		    		int length=b1.getText().length();	 
		    		
		    		if((length>15))
		    		{ 
		    		e.consume(); 
		    		}
		    		
		    		} 
		    		});
		b2.setBounds(350,205,210,35);
		b2.setFont(new java.awt.Font("Dialog",1,20));
		b2.addKeyListener(new TextFieldKeyListener(1));
		  b2.addKeyListener(
		    		new KeyAdapter()
		    		{ 
		    		public void keyTyped(KeyEvent e) 
		    		{ 	    		
		    		int length=b2.getText().length();	 
		    		
		    		if((length>5))
		    		{ 
		    		e.consume(); 
		    		}
		    		
		    		} 
		    		});
		b3.setBounds(350,255,210,35);
		b3.setFont(new java.awt.Font("Dialog",1,20));
		b3.addKeyListener(new TextFieldKeyListener(1));
		  b3.addKeyListener(
		    		new KeyAdapter()
		    		{ 
		    		public void keyTyped(KeyEvent e) 
		    		{ 	    		
		    		int length=b3.getText().length();	 
		    		
		    		if((length>17))
		    		{ 
		    		e.consume(); 
		    		}
		    		
		    		} 
		    		});
		//设置确定按钮
		c1.setBounds(550,375,130,50);
		c1.setFont(new java.awt.Font("Dialog",1,20));
		c1.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{  
	    		managerDao md=new managerDao();	    	
	    		String account=b1.getText();
	    		String pwd=b2.getText();
	    		String id=b3.getText();
	    		try {
					if(md.deleteCheck(account, pwd, id))
					{
						md.deleteAccount(account);
						b1.setText("");
						b2.setText("");
						b3.setText("");
					}
					if(!md.deleteCheck(account, pwd, id))
					{
						JOptionPane.showMessageDialog(null, "请输入正确的用户信息！", "ERROR", JOptionPane.ERROR_MESSAGE);
						b1.setText("");
						b2.setText("");
						b3.setText("");
					}
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
	    	}
	    	
	    });
		//往panel3里添加组件
		panel3.add(a1);
		panel3.add(a2);
		panel3.add(a3);
		panel3.add(b1);
		panel3.add(b2);
		panel3.add(b3);
		panel3.add(c1);
		
		
		return panel3;
	}

}
