package manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import login.TextFieldKeyListener;
import Dao.accountDao;
import Dao.managerDao;

public class Freezeing {
	JPanel panel3;
	//JLabel
	JLabel a1 = new JLabel("请输入需要冻结的账号 ：");
	//JTextField
	JTextField b1 = new JTextField();
	//确定按钮
	JButton c1 = new JButton("确定");
	
	
	public JPanel freezeing()
	{
		panel3 = new JPanel();
		panel3.setLayout(null);
		//设置JLabel
		a1.setBounds(100,150,250,50);
		a1.setFont(new java.awt.Font("Dialog",1,20));
		//设置JTextField
		b1.setBounds(350,155,200,35);
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
		//设置确定按钮
		c1.setBounds(550,275,130,50);
		c1.setFont(new java.awt.Font("Dialog",1,20));
		c1.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{   managerDao md=new managerDao();
	    	     String account =b1.getText();
	    		accountDao ad = new accountDao();
	    		
	    		try {
	    			
	    			if(ad.accountCheck(account)){
	    				if(ad.checkUsalesstatus(account))
	    		    	 {
	    		    		 JOptionPane.showMessageDialog(null, "非法操作！该用户已被注销", "ERROR", JOptionPane.ERROR_MESSAGE);
	    		    		 b1.setText(""); 
	    		    	 }
	    		    	 else{
	    				String s = ad.status(account);
	    				if(s.equals("正常"))
	    				{
					md.freezeing(account);
					JOptionPane.showMessageDialog(null, "冻结成功","标题【冻结】",  JOptionPane.CLOSED_OPTION);
					b1.setText("");}
	    				if(s.equals("挂失"))
	    				{
	    					JOptionPane.showMessageDialog(null, "您输入的账号已经被挂失！\n请先解挂！", "ERROR", JOptionPane.ERROR_MESSAGE);
	    					b1.setText("");}
	    				if(s.equals("冻结"))
	    				{
	    					JOptionPane.showMessageDialog(null, "您输入的账号已经被冻结！\n请先解挂！", "ERROR", JOptionPane.ERROR_MESSAGE);
	    					b1.setText("");}
	    			}
	    			}
	    			else{
	    				JOptionPane.showMessageDialog(null, "您输入的账号有误！\n请重新输入！", "ERROR", JOptionPane.ERROR_MESSAGE);
	    				b1.setText("");
						
	    			}
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
	    	}
	    	
	    });
		//往panel3里添加组件
		panel3.add(a1);
		panel3.add(b1);
		panel3.add(c1);
		
		
		return panel3;
	}

}
