package manager;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import login.LoginInterface;
import Bean.accountBean;
import Bean.transsactionBean;
import Dao.JDBCUtils;
import commonuser.CommonUserInterface;

public class SearchAccount extends JFrame{
private JPanel jp1;
private JPanel jp2;
public JFrame t = new JFrame("中国建设银行ATM系统");
JButton back ;
JButton exit;
JButton search;
String account;
    public String getAccount() {
	return account;
}
public void setAccount(String account) {
	this.account = account;
}
	public void setJframe()
    {   jp1=new JPanel();
   
    search =new JButton("查询");
    back = new JButton("返回");
    exit = new JButton("退卡");
    
    back.setBounds(100,500,80,45);
    exit.setBounds(100,600,80,45);
   search.setBounds(100,700,80,45);
    back.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		
    		t.setVisible(false);
    	}
    	
    });
    //exit的监听事件
    exit.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		LoginInterface c3 = new LoginInterface();
    	    
    		c3.SetJframe();
    		t.setVisible(false);
    	}
    	
    });
    
    	String[] columnNames={"账号","姓名","密码","开户时间","开户银行","状态","余额","卡类型","透支度","是否销户","取款限额","转账限额"};
    	//String[] columnNames = {"Product","Number of Boxes","Price"};
    	Object[][] data =
    		{
    		};
    	DefaultTableModel tm=new DefaultTableModel(data, columnNames);
        tm.setColumnIdentifiers(columnNames);
        search.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{  
        		String sql="select * from AccountInformation where Uaccount='"+account+"'";
        		accountBean ab=new accountBean();
        		
    		try{
    			Connection conn = JDBCUtils.getConnection();
    			Statement pstmt = conn.createStatement();
    		    int i=0;
    		    ResultSet rs = pstmt.executeQuery(sql);
    		    
    		    while(rs.next()){
    		    ab.setUaccount(account);
    		    ab.setUname(rs.getString("Uname"));
    		    ab.setUpassword(rs.getString("Upassword"));
    		    ab.setUopentime(rs.getDate("Uopentime"));
    		    ab.setUopencity(rs.getString("Uopencity"));
    		    ab.setUstatus(rs.getString("Ustatus"));
    		    ab.setUbalance(rs.getDouble("Ubalance"));
    		    ab.setUgetMax(rs.getInt("UgetMax"));
    		    ab.setUtype(rs.getString("Utype"));
    		    ab.setUover(rs.getDouble("Uover"));
    		    ab.setUsalesstatus(rs.getBoolean("Usalesstatus"));
    		    ab.setUtransferMax(rs.getDouble("UtransferMax"));
        
    		    Vector v = new Vector();
        		v.add(ab.getUaccount());
        		v.add(ab.getUname());
        		v.add(ab.getUpassword());
        		v.add(ab.getUopentime());
        		v.add(ab.getUopencity());
        		v.add(ab.getUstatus());
        		v.add(ab.getUbalance());
        		
        		v.add(ab.getUtype());
        		v.add(ab.getUover());
        		v.add(ab.isUsalesstatus());
        		v.add(ab.getUgetMax());
        		v.add(ab.getUtransferMax());
        		tm.addRow(v);
    		    
    		    }
    		    
    		   }
    		    
    		catch(SQLException e1){
    				e1.printStackTrace();
    			}
        		
        		
        		
        		
        		
        		
        		
        	}
        	
        });
        JTable table = new JTable(tm);
        table.setFont(new java.awt.Font("宋体", 0, 20));
        table.setPreferredScrollableViewportSize(new Dimension(1300,500));
        
    	JScrollPane scrollPane = new JScrollPane(table);
    	jp1.add(scrollPane);
    	
    	jp1.add(exit);
    	jp1.add(back);
    	jp1.add(search);
    	t.setSize(1500,700);
    	t.add(jp1);
    
    	t.setVisible(true);
    	t.setLocationRelativeTo(null);	
    	t.setResizable(false);
    	t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    }
}
