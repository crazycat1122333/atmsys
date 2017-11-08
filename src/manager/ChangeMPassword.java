package manager;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import Dao.accountDao;
import Dao.managerDao;

public class ChangeMPassword extends AllInterface{
	public void  setFrame()
	{   JPanel p=new JPanel();
	  p.setLayout(null);
		JLabel jl1=new JLabel("���������룺");
		jl1.setFont(new java.awt.Font("Dialog",1,20));
		JLabel jl2=new JLabel("�ٴ�ȷ�����룺");
		jl2.setFont(new java.awt.Font("Dialog",1,20));
		JPasswordField jf1=new JPasswordField(6);
		 jf1.addKeyListener(
		    		new KeyAdapter()
		    		{ 
		    		public void keyTyped(KeyEvent e) 
		    		{ 	    		
		    		int length=jf1.getText().length();	 
		    		
		    		if((length>5))
		    		{ 
		    		e.consume(); 
		    		}
		    		
		    		} 
		    		});
		jf1.setFont(new java.awt.Font("Dialog",1,20));
		JPasswordField jf2=new JPasswordField(6);
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
		jf2.setFont(new java.awt.Font("Dialog",1,20));
		JButton jb=new JButton("ȷ��");
		jb.setFont(new java.awt.Font("Dialog",1,20));
		jl1.setBounds(50,70,150,50);
		jl2.setBounds(50,200,150,50);
		jf1.setBounds(190,75,130,35);
		jf2.setBounds(200,205,130,35);
		jb.setBounds(130, 350, 130, 50);
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
	//�����ֶ�����ڣ�ֻ�رյ�ǰ���ڵĴ���
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	Font font = new Font("΢���ź�",Font.BOLD,22);
	jb.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent e)
    	{   if(jf1.getText().equals(jf2.getText())){
    		managerDao md=new managerDao();
    		md.changePassword(account, jf2.getText());
    	}
    		
    	else{
    		jf1.setText("");
    		jf2.setText("");
    		JOptionPane.showMessageDialog(null, "��������ȷ���˺ź�����", "ERROR", JOptionPane.ERROR_MESSAGE);
    		
    	}
    	}
    	
    });
	
	
	}
}

