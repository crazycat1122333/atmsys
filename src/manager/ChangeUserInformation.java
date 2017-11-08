package manager;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import login.ATMButton;
import login.LoginInterface;
import Bean.accountBean;
import Bean.userBean;
import Dao.JDBCUtils;
import Dao.accountDao;
import Dao.managerDao;
import commonuser.CommonUserInterface;
import commonuser.FinalChangePassword;

public class ChangeUserInformation extends AllInterface {
	public JFrame t = new JFrame("�û���Ϣ��");
	private JPanel jp1;
	String c_type;
	double setOver;
	userBean ub=new userBean();
	TableRowSorter<TableModel> sorter ;
	JButton exit;
	JButton search;
	String account;
	//JLabel
	
	
	JLabel a1 = new JLabel("���� ��");
	JLabel a2 = new JLabel("�Ա� ��");
	JLabel a3 = new JLabel("���� ��");
	JLabel a4 = new JLabel("���֤���� ��");
	JLabel a5 = new JLabel("��ͥסַ ��");
	JLabel a6 = new JLabel("�ֻ����� ��");
	JLabel a8 = new JLabel("������ַ ��");
	
	//ȷ����ť
	JButton determent = new JButton("����");
	
	JRadioButton male =new JRadioButton();
	JRadioButton female =new JRadioButton();
	ButtonGroup sex = new ButtonGroup();
	
	  public String getAccount() {
			return account;
		}
		public void setAccount(String account) {
			this.account = account;
		}
		public void setJframe()
	    {  
			
			
			jp1 =new JPanel();
			accountDao ad = new accountDao();
    		try {
				
					String sql="select * from UserInformation where Uaccount='"+account+"'";
				
					
					
						Connection conn = JDBCUtils.getConnection();
						Statement pstmt = conn.createStatement();
					    int i=0;
					    
					    ResultSet rs = pstmt.executeQuery(sql);
					    
					    while(rs.next()){
					    ub.setUaccount(account);
					    ub.setUname(rs.getString("Uname"));
					    ub.setUage(rs.getString("Uage"));
					    
					    ub.setUid(rs.getString("Uid"));
					    ub.setUsex(rs.getBoolean("Usex"));
					    ub.setUphone(rs.getString("Uphone"));
					    ub.setUaddress(rs.getString("Uaddress"));
					    ub.setUopenbank(rs.getString("Uopenbank"));
					    ub.setUworkplace(rs.getString("Uworkplace"));					    
					    }					  					
				}
			 catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		
    		
    		JTextField b1 = new JTextField(ub.getUname());
    		JTextField b2 = new JTextField(ub.getUid());
    		JTextField b3 = new JTextField(50);
    		JTextField b4 = new JTextField(ub.getUphone());  	
    		JTextField b7 = new JTextField(50); 
    		b3.setText(ub.getUaddress());
    		b7.setText(ub.getUworkplace());
    		System.out.println(ub.getUage());
    		JTextField a21 = new JTextField(ub.getUage());
    		//�Ա�ѡ���
    		
    		
    		
    		if(ub.getUsex())
    				{
    			male=new JRadioButton("��",true);
    			 female = new JRadioButton("Ů");
    				}
    		if(!ub.getUsex())
    		{
    			male=new JRadioButton("��");
   			 female = new JRadioButton("Ů",true);
    		}
    		//������òѡ���
    		JComboBox shenfen ;
    		//��������ѡ���
    		JComboBox birthYear;
    		JComboBox birthMonth;
    		JComboBox birthTime;
    		
    		
			search =new JButton("��ѯ");
		    search.setBounds(490,50,150,40);
		    search.setFont(new java.awt.Font("Dialog",1,25));    
		   
		  
		    exit = new JButton("�˳�");
		    exit.setBounds(80,400,130,40);
		    exit.setFont(new java.awt.Font("Dialog",1,25));
		    
		    
		   
		    //exit�ļ����¼�
		    exit.addActionListener(new ActionListener()
		    {
		    	public void actionPerformed(ActionEvent e)
		    	{
		    		
		    		t.setVisible(false);
		    	}
		    	
		    });
		    jp1 = new JPanel();
			jp1.setLayout(null);
			//����JLabel
		
		//����
			 a1.setBounds(150, 90, 60, 40);
			 a1.setFont(new java.awt.Font("Dialog",1,15));
			 b1.setBounds(210,97,100,25);
			 b1.setFont(new java.awt.Font("Dialog",1,15));
			 //�Ա�
			 a2.setBounds(150 , 130, 60, 40);
			 a2.setFont(new java.awt.Font("Dialog",1,15));
			//����JRadioButton
			male.setBounds(210,130,50,40);
			male.setFont(new java.awt.Font("Dialog",1,15));		
			female.setBounds(260,130,50,40);
			female.setFont(new java.awt.Font("Dialog",1,15));
			 //����
			 a3.setBounds(150, 170, 60, 40);
			 a3.setFont(new java.awt.Font("Dialog",1,15));
			 a21.setBounds(210, 177, 60, 25);
			 a21.setFont(new java.awt.Font("Dialog",1,15));
			 //���֤
			 a4.setBounds(150, 210, 100, 40);
			 a4.setFont(new java.awt.Font("Dialog",1,15));
			 b2.setBounds(250,217,160,25);
			 b2.setFont(new java.awt.Font("Dialog",1,15));
			 //��ͥסַ
			 a5.setBounds(150, 250, 100, 40);
			 a5.setFont(new java.awt.Font("Dialog",1,15));
			 b3.setBounds(230,257,280,25);
			 b3.setFont(new java.awt.Font("Dialog",1,15));
			 
			 //�ֻ�����
			 a6.setBounds(150, 290, 100, 40);
			 a6.setFont(new java.awt.Font("Dialog",1,15));
			 b4.setBounds(240,297,110,25);
			 b4.setFont(new java.awt.Font("Dialog",1,15));
			 
			//������ַ
			 a8.setBounds(150, 330, 100, 40);
			 a8.setFont(new java.awt.Font("Dialog",1,15));
			 b7.setBounds(240,337,280,25);
			 b7.setFont(new java.awt.Font("Dialog",1,15));
		 
			 //����JTextField			
	
		
			//���Ա�ѡ���������ӵ�ѡ��ť
			sex.add(male);
			sex.add(female);
			
			//���ó�������
			CreateCommonUser jjj= new CreateCommonUser();
			birthYear =  jjj.Year();
			birthMonth = jjj.Month();
			birthTime = jjj.Times();
			birthYear.setBounds(260,140,75,25);
			birthMonth.setBounds(335,140,60,25);
			birthTime.setBounds(395,140,60,25);
			
			//����������ò�����б�
			shenfen = new JComboBox();
			shenfen.addItem("Ⱥ��");
			shenfen.addItem("������Ա");
			shenfen.addItem("��Ա");
			shenfen.setBounds(245,340,95,25);
		
		
			//����ȷ����ť
			determent.setBounds(380,400,130,40);
			determent.setFont(new java.awt.Font("Dialog",1,20));
			determent.addActionListener(new ActionListener()
		    {
		    	public void actionPerformed(ActionEvent e)
		    	{ 
		    		managerDao md=new managerDao();
		    		boolean Usex =false;
		    		if(male.isSelected()){
			      		Usex=true; 
			      	}
			      	if(female.isSelected()){
			      		Usex=false; 
			      	}
			      	 md.changerUser(account,b1.getText(),Usex,a21.getText(),b2.getText(),b3.getText(),b4.getText(),b7.getText());
		    		
		    	}
		    	});
			
			
			//��JPanel jp1��������
			//��JPanel����� JLabel��
	
			jp1.add(a1);
			jp1.add(a2);
			jp1.add(a3);
			jp1.add(a4);
			jp1.add(a5);
			jp1.add(a6);
			jp1.add(a8);
			
			//��JPanel jp1�����JTexeField
			jp1.add(b1);
			jp1.add(b2);
			jp1.add(b3);
			jp1.add(b4);		
			jp1.add(b7);
	     	jp1.add(a21);
			jp1.add(male);
			jp1.add(female);
			//���������ò
		//	jp1.add(shenfen);
			
			//��ӳ�������
		//	jp1.add(birthYear);
		//	jp1.add(birthMonth);
		//	jp1.add(birthTime);		
	
			
			jp1.add(determent);
//			birthYear.addItemListener(new ItemListener()
//	        {
//	            public void itemStateChanged(ItemEvent evt)
//	            {
//	            	//if (ItemEvent.SELECTED == evt.getStateChange()) { 
//	            	ub.setUage((birthYear.getSelectedItem().toString()));
//	            	
//	            	//}
//	            }
//	        });
		
	      //���
	    	t.setSize(550,700);
	     	jp1.add(exit);
	    	jp1.add(determent);
	    	//��jp1��jp2�ӵ�jp3�
	    	t.add(jp1);   
	      
	    	t.setVisible(true);
	    	t.setLocationRelativeTo(null);	
	    	t.setResizable(false);
	    	t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }
	
		boolean a111;

}

