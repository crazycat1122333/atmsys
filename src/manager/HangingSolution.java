package manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import login.TextFieldKeyListener;
import Dao.accountDao;
import Dao.managerDao;

public class HangingSolution {
	JPanel panel3;
	//JLabel
	JLabel a1 = new JLabel("��������Ҫ��ҵ��˺� ��");

	//JTextField
	JTextField b1 = new JTextField();

	//ȷ����ť
	JButton c1 = new JButton("ȷ��");
	
	
	public JPanel hangingSolution()
	{
		panel3 = new JPanel();
		panel3.setLayout(null);
		//����JLabel
		a1.setBounds(100,150,250,50);
		a1.setFont(new java.awt.Font("Dialog",1,20));

		
		
		//����JTextField
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
	
		//����ȷ����ť
		c1.setBounds(550,300,130,50);
		c1.setFont(new java.awt.Font("Dialog",1,20));
		c1.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{  
	    		accountDao ad = new accountDao();
    		    managerDao md=new managerDao();
   	            String account =b1.getText();
	    		
	    		try {
	    			
	    			if(ad.accountCheck(account)){
	    				 
	    				if(ad.checkUsalesstatus(account))
	    		    	 {
	    		    		 JOptionPane.showMessageDialog(null, "�Ƿ����������û��ѱ�ע��", "ERROR", JOptionPane.ERROR_MESSAGE);
	    		    		 b1.setText("");
	    		    	 }
	    		    	 else {
	    				String s = ad.status(account);
	    				
	    				if(s.equals("����"))
	    				{
	    							
	    						JOptionPane.showMessageDialog(null, "�����˺�������\n�����ң�","ERROR",  JOptionPane.CLOSED_OPTION);
	    						b1.setText("");
	    				}
	    				if(s.equals("��ʧ"))
	    				{
	    					md.hangingSolution(account);
	    				
	    					b1.setText("");
	    				}
	    				if(s.equals("����"))
	    				{
	    					JOptionPane.showMessageDialog(null, "��������˺��Ѿ������ᣡ\n���Ƚⶳ��", "ERROR", JOptionPane.ERROR_MESSAGE);
	    				
	    					b1.setText("");}
	    			}
	    			}
	    			else{
	    				JOptionPane.showMessageDialog(null, "��������˺�����\n���������룡", "ERROR", JOptionPane.ERROR_MESSAGE);
	    				b1.setText("");
						
	    			}
				
	    		} catch (Exception e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
	    	}
	    	
	    });
		//��panel3��������
		panel3.add(a1);	
		panel3.add(b1);
		panel3.add(c1);
		
		
		return panel3;
	}

}
