package manager;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

import Dao.accountDao;
import commonuser.SearchTransactionDetails;

public class ChangePasswordInterface extends AllInterface {
public JButton jb;
	
	
	public void  setFrame()
	{   JPanel p=new JPanel();
		JLabel jl3=new JLabel("请输入密码：");
		JLabel jl2=new JLabel("再次确认密码：");
		JLabel jl1=new JLabel("输入需要修改的用户账号:");
		
		p.setLayout(null);
		JPasswordField jf3=new JPasswordField(6);
		JPasswordField jf2=new JPasswordField(6);
		JTextField jf1=new JTextField(16);
		jb=new JButton("确定");
		jl1.setBounds(20,70,180,40);
		jl1.setFont(new java.awt.Font("Dialog",1,15));
		jl2.setBounds(60,160,120,40);
		jl2.setFont(new java.awt.Font("Dialog",1,15));
		jl3.setBounds(60,250,120,40);
		jl3.setFont(new java.awt.Font("Dialog",1,15));
		jf1.setBounds(200,75,150,27);
		jf1.addKeyListener(
	    		new KeyAdapter()
	    		{ 
	    		public void keyTyped(KeyEvent e) 
	    		{ 	    		
	    		int length=jf1.getText().length();	 
	    		
	    		if((length>15))
	    		{ 
	    		e.consume(); 
	    		}
	    		
	    		} 
	    		});
		jf1.setFont(new java.awt.Font("Dialog",1,15));
		jf2.setBounds(180,165,120,30);
		jf2.addKeyListener(
	    		new KeyAdapter()
	    		{ 
	    		public void keyTyped(KeyEvent e) 
	    		{ 	    		
	    		int length=jf2.getText().length();	 
	    		
	    		if((length>5))
	    		{ 
	    		e.consume(); 
	    		}
	    		
	    		} 
	    		});
		jf2.setFont(new java.awt.Font("Dialog",1,15));
		jf3.setBounds(180,255,120,30);
		jf3.addKeyListener(
	    		new KeyAdapter()
	    		{ 
	    		public void keyTyped(KeyEvent e) 
	    		{ 	    		
	    		int length=jf3.getText().length();	 
	    		
	    		if((length>5))
	    		{ 
	    		e.consume(); 
	    		}
	    		
	    		} 
	    		});
		jf3.setFont(new java.awt.Font("Dialog",1,20));
		jb.setBounds(150, 350, 120, 45);
		jb.setFont(new java.awt.Font("Dialog",1,20));
		p.add(jl3);
		p.add(jf3);
		p.add(jl1);
		p.add(jf1);
		p.add(jl2);
		p.add(jf2);
		
		p.add(jb);
		
		this.add(p);
		this.setSize(400,500);
		this.setVisible(true);
		this.setLocationRelativeTo(null);	
		this.setResizable(false);
	//当出现多个窗口，只关闭当前窗口的代码
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	Font font = new Font("微软雅黑",Font.BOLD,22);
	jb.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent e)
    	{  
    		if(jf2.getText().equals(jf3.getText())&&jf1.getText()!=null)
    		{
    		accountDao ad= new accountDao();
    		ad.changePassword(jf1.getText(), jf2.getText());
    	
    		}
    	else{
    		jf1.setText("");
    		jf2.setText("");
    		jf3.setText("");
    		JOptionPane.showMessageDialog(null, "请输入正确的账号和密码", "ERROR", JOptionPane.ERROR_MESSAGE);
    		
    	}
    		
    	}
    	
    });
	
	
	}

}
