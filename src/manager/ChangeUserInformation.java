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
	public JFrame t = new JFrame("用户信息表");
	private JPanel jp1;
	String c_type;
	double setOver;
	userBean ub=new userBean();
	TableRowSorter<TableModel> sorter ;
	JButton exit;
	JButton search;
	String account;
	//JLabel
	
	
	JLabel a1 = new JLabel("姓名 ：");
	JLabel a2 = new JLabel("性别 ：");
	JLabel a3 = new JLabel("年龄 ：");
	JLabel a4 = new JLabel("身份证号码 ：");
	JLabel a5 = new JLabel("家庭住址 ：");
	JLabel a6 = new JLabel("手机号码 ：");
	JLabel a8 = new JLabel("工作地址 ：");
	
	//确定按钮
	JButton determent = new JButton("保存");
	
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
    		//性别选择框
    		
    		
    		
    		if(ub.getUsex())
    				{
    			male=new JRadioButton("男",true);
    			 female = new JRadioButton("女");
    				}
    		if(!ub.getUsex())
    		{
    			male=new JRadioButton("男");
   			 female = new JRadioButton("女",true);
    		}
    		//政治面貌选择框
    		JComboBox shenfen ;
    		//出生日期选择框
    		JComboBox birthYear;
    		JComboBox birthMonth;
    		JComboBox birthTime;
    		
    		
			search =new JButton("查询");
		    search.setBounds(490,50,150,40);
		    search.setFont(new java.awt.Font("Dialog",1,25));    
		   
		  
		    exit = new JButton("退出");
		    exit.setBounds(80,400,130,40);
		    exit.setFont(new java.awt.Font("Dialog",1,25));
		    
		    
		   
		    //exit的监听事件
		    exit.addActionListener(new ActionListener()
		    {
		    	public void actionPerformed(ActionEvent e)
		    	{
		    		
		    		t.setVisible(false);
		    	}
		    	
		    });
		    jp1 = new JPanel();
			jp1.setLayout(null);
			//设置JLabel
		
		//姓名
			 a1.setBounds(150, 90, 60, 40);
			 a1.setFont(new java.awt.Font("Dialog",1,15));
			 b1.setBounds(210,97,100,25);
			 b1.setFont(new java.awt.Font("Dialog",1,15));
			 //性别
			 a2.setBounds(150 , 130, 60, 40);
			 a2.setFont(new java.awt.Font("Dialog",1,15));
			//设置JRadioButton
			male.setBounds(210,130,50,40);
			male.setFont(new java.awt.Font("Dialog",1,15));		
			female.setBounds(260,130,50,40);
			female.setFont(new java.awt.Font("Dialog",1,15));
			 //年龄
			 a3.setBounds(150, 170, 60, 40);
			 a3.setFont(new java.awt.Font("Dialog",1,15));
			 a21.setBounds(210, 177, 60, 25);
			 a21.setFont(new java.awt.Font("Dialog",1,15));
			 //身份证
			 a4.setBounds(150, 210, 100, 40);
			 a4.setFont(new java.awt.Font("Dialog",1,15));
			 b2.setBounds(250,217,160,25);
			 b2.setFont(new java.awt.Font("Dialog",1,15));
			 //家庭住址
			 a5.setBounds(150, 250, 100, 40);
			 a5.setFont(new java.awt.Font("Dialog",1,15));
			 b3.setBounds(230,257,280,25);
			 b3.setFont(new java.awt.Font("Dialog",1,15));
			 
			 //手机号码
			 a6.setBounds(150, 290, 100, 40);
			 a6.setFont(new java.awt.Font("Dialog",1,15));
			 b4.setBounds(240,297,110,25);
			 b4.setFont(new java.awt.Font("Dialog",1,15));
			 
			//工作地址
			 a8.setBounds(150, 330, 100, 40);
			 a8.setFont(new java.awt.Font("Dialog",1,15));
			 b7.setBounds(240,337,280,25);
			 b7.setFont(new java.awt.Font("Dialog",1,15));
		 
			 //设置JTextField			
	
		
			//往性别选择框组里添加单选按钮
			sex.add(male);
			sex.add(female);
			
			//设置出生日期
			CreateCommonUser jjj= new CreateCommonUser();
			birthYear =  jjj.Year();
			birthMonth = jjj.Month();
			birthTime = jjj.Times();
			birthYear.setBounds(260,140,75,25);
			birthMonth.setBounds(335,140,60,25);
			birthTime.setBounds(395,140,60,25);
			
			//设置政治面貌下拉列表
			shenfen = new JComboBox();
			shenfen.addItem("群众");
			shenfen.addItem("共青团员");
			shenfen.addItem("党员");
			shenfen.setBounds(245,340,95,25);
		
		
			//设置确定按钮
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
			
			
			//往JPanel jp1里添加组件
			//往JPanel里添加 JLabel。
	
			jp1.add(a1);
			jp1.add(a2);
			jp1.add(a3);
			jp1.add(a4);
			jp1.add(a5);
			jp1.add(a6);
			jp1.add(a8);
			
			//往JPanel jp1里添加JTexeField
			jp1.add(b1);
			jp1.add(b2);
			jp1.add(b3);
			jp1.add(b4);		
			jp1.add(b7);
	     	jp1.add(a21);
			jp1.add(male);
			jp1.add(female);
			//添加政治面貌
		//	jp1.add(shenfen);
			
			//添加出生日期
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
		
	      //添加
	    	t.setSize(550,700);
	     	jp1.add(exit);
	    	jp1.add(determent);
	    	//把jp1和jp2加到jp3里。
	    	t.add(jp1);   
	      
	    	t.setVisible(true);
	    	t.setLocationRelativeTo(null);	
	    	t.setResizable(false);
	    	t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }
	
		boolean a111;

}

