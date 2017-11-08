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

public class Thawing {
	JPanel panel3;
	//JLabel
	JLabel a1 = new JLabel("��������Ҫ�ⶳ���˺� ��");
	JLabel a2 = new JLabel("�������ʺŵ����֤�� ��");
	//JTextField
	JTextField b1 = new JTextField();
	JTextField b2 = new JTextField();
	//ȷ����ť
	JButton c1 = new JButton("ȷ��");
	
	
	public JPanel thawing()
	{
		panel3 = new JPanel();
		panel3.setLayout(null);
		//����JLabel
		a1.setBounds(100,150,250,50);
		a1.setFont(new java.awt.Font("Dialog",1,20));
		a2.setBounds(100,200,250,50);
		a2.setFont(new java.awt.Font("Dialog",1,20));
		//����JTextField
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
		b1.addKeyListener(new TextFieldKeyListener(1));
		  b2.addKeyListener(
		    		new KeyAdapter()
		    		{ 
		    		public void keyTyped(KeyEvent e) 
		    		{ 	    		
		    		int length=b2.getText().length();	 
		    		
		    		if((length>17))
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
	    		managerDao md=new managerDao();
	    		accountDao ad=new accountDao();
	    	     String account =b1.getText();
	    	     String id =b2.getText();
	    		try {
	    			if(ad.accountCheck(account))
	    			{
					if(md.thawingCheck(account,id))
					{
						if(ad.checkUsalesstatus(account))
	    		    	 {
	    		    		 JOptionPane.showMessageDialog(null, "�Ƿ����������û��ѱ�ע��", "ERROR", JOptionPane.ERROR_MESSAGE);
	    		    			b1.setText("");
	    						b2.setText("");
	    		    	 }
	    		    	 else{
						System.out.println("00");
						String s =ad.status(account);
						if(s.equals("����") ){
							
	    			md.thawing(account);
	    			b1.setText("");
					b2.setText("");
						}
						if(s.equals("����"))
						{
							JOptionPane.showMessageDialog(null, "�����˺�״̬Ϊ������\n������нⶳ������", "ERROR", JOptionPane.ERROR_MESSAGE);
							b1.setText("");
							b2.setText("");
							}
						if(s.equals("��ʧ"))
						{
							JOptionPane.showMessageDialog(null, "�����˺�״̬Ϊ��ʧ��\n���Ƚ��н�ң�", "ERROR", JOptionPane.ERROR_MESSAGE);
						
							b1.setText("");
							b2.setText("");
							}
					}
					}
					else{
						JOptionPane.showMessageDialog(null, "��������ȷ�û���Ϣ��", "ERROR", JOptionPane.ERROR_MESSAGE);
						b1.setText("");
						b2.setText("");
					}
	    			}
	    			else{
	    				
	    				JOptionPane.showMessageDialog(null, "��������˺�����\n���˺Ų�����", "ERROR", JOptionPane.ERROR_MESSAGE);
	    				b1.setText("");
						b2.setText("");
	    			}
	    			
				} catch (Exception e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
	    	}
	    	
	    });
		//��panel3��������
		panel3.add(a1);
		panel3.add(a2);
		panel3.add(b1);
		panel3.add(b2);
		panel3.add(c1);
		
		
		return panel3;
	}

}
