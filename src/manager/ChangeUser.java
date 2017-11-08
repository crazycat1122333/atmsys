package manager;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import login.TextFieldKeyListener;
import Bean.transsactionBean;
import Bean.userBean;
import Dao.JDBCUtils;
import Dao.accountDao;
import Dao.managerDao;

public class ChangeUser {
	JPanel panel3;
	JPanel jp1;
	JPanel jp2;
	//JLabel
	JLabel a1 = new JLabel("�������޸ĵ��˺� ��");
	JLabel a2 = new JLabel("�������ʺŵ����� ��");
	//JTextField
	JTextField b1 = new JTextField();
	JPasswordField b2 = new JPasswordField();

	//ȷ����ť
	JButton c1 = new JButton("ȷ��");
	
	
	public JPanel ChangeUser()
	{
		panel3 = new JPanel();
		panel3.setLayout(null);
		//����JLabel
		a1.setBounds(100,150,250,50);
		a1.setFont(new java.awt.Font("Dialog",1,20));
		a2.setBounds(100,200,250,50);
		a2.setFont(new java.awt.Font("Dialog",1,20));
		//����JTextField
		b1.setBounds(350,155,200,35);
		b1.setFont(new java.awt.Font("Dialog",1,20));
		b2.setBounds(350,205,200,35);
		b2.setFont(new java.awt.Font("Dialog",1,20));
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
		//����ȷ����ť
		c1.setBounds(550,300,130,50);
		c1.setFont(new java.awt.Font("Dialog",1,20));
		String[] columnNames={"�˺�","����","����","���֤����","�Ա�","�ֻ�����","סַ","������","������ַ"};
    	//String[] columnNames = {"Product","Number of Boxes","Price"};
    	Object[][] data =
    		{
    		};
    	DefaultTableModel tm=new DefaultTableModel(data, columnNames);
        tm.setColumnIdentifiers(columnNames);
		c1.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{ 
	    		String account= b1.getText();
	    		String password= b2.getText();
	    		accountDao ad = new accountDao();
	    		try {
					if((ad.login(account,password)))
					{
						ChangeUserInformation a1 = new ChangeUserInformation();
						a1.setAccount(account);

						a1.setJframe();
						b1.setText("");
						b2.setText("");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
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

