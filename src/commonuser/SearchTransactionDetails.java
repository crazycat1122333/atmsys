package commonuser;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import javax.swing.*;
import javax.swing.table.*;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.button.ClassicButtonShaper;
import org.jvnet.substance.skin.SubstanceBusinessBlueSteelLookAndFeel;
import org.jvnet.substance.title.ArcHeaderPainter;
import org.jvnet.substance.watermark.SubstanceBubblesWatermark;
import Bean.transsactionBean;
import Dao.JDBCUtils;

import login.ATMButton;
import login.LoginInterface;


public class SearchTransactionDetails extends JFrame{
private JPanel jp1;
private JPanel jp2;
Date date1 =new Date(1999-8-9);
Date date2=new Date(1999-8-9);
public JFrame t = new JFrame("中国建设银行ATM系统");
ATMButton back ;
ATMButton exit;
ATMButton search;
String account;

TableRowSorter<TableModel> sorter ;
//定义水平摆放组件的Box对象。
	//时间选择框
	JComboBox time;
	String tj ;
	
    public String getAccount() {
	return account;
}
public void setAccount(String account) {
	this.account = account;
}
	public void setJframe()
    {  
		
		
		t.setLayout(null);
		jp1 =new JPanel();
		jp2 = new JPanel();
		jp2.setLayout(null);
		//设置时间选择框
		time = new JComboBox();
		time.addItem("1个月");
		time.addItem("3个月");
		time.addItem("6个月");
		time.addItem("一年");
		time.addItem("三年");
		time.addItem("五年");
		time.setBounds(350,52,130,30);
		time.setFont(new java.awt.Font("Dialog",1,18));
   
	
            	
           
    search =new ATMButton("查询");
    search.setBounds(490,50,150,40);
    search.setFont(new java.awt.Font("Dialog",1,25));    
    back = new ATMButton("返回");
    back.setBounds(0,50,150,40);
    back.setFont(new java.awt.Font("Dialog",1,25));
    exit = new ATMButton("退卡");
    exit.setBounds(840,50,150,40);
    exit.setFont(new java.awt.Font("Dialog",1,25));
    
    
    back.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		CommonUserInterface c2 = new CommonUserInterface();
    		c2.setAccount(account);
    		c2.setJframe();
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
    
    	String[] columnNames={"交易流水号","账号","交易类型","金额","手续费","交易时间","目标账户"};
    	//String[] columnNames = {"Product","Number of Boxes","Price"};
    	Object[][] data =
    		{
    		};
    	DefaultTableModel tm=new DefaultTableModel(data, columnNames);
        tm.setColumnIdentifiers(columnNames);
        search.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{  tm.setRowCount(0);
        		//获取当前系统的日期
        		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        		System.out.println(sdf.format(new Date()));// new Date()为获取当前系统时间       
    			//获得当前时间的月份，月份从0开始所以结果要加1
        		Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
        		int year = c.get(Calendar.YEAR);        		
        		int date = c.get(Calendar.DATE); 
    			int month=c.get(Calendar.MONTH)+1;
    			int date10 = date+1;
    			String times= ""+year+"-"+month+"-"+date10;
    			String times1 ="";
				System.out.println(""+year+month+date);
				
        		//获取选择框的选择
        		if(time.getSelectedItem().toString().equals("1个月"))
        		{      			
        			     times1 = ""+year+"-"+"0"+(month-1)+"-"+date;       			
        		}
        		
        		if(time.getSelectedItem().toString().equals("3个月"))
        		{
        			 times1 = ""+year+"-"+ "0"+(month-3)+"-"+date;
        			
        		}
        		if(time.getSelectedItem().toString().equals("6个月"))
        		{
        			 times1 = ""+year+ "-"+"0"+(month-6)+"-"+date;
        		}
        		if(time.getSelectedItem().toString().equals("一年"))
        		{
        			 times1 = ""+(year-1)+"-"+ month+"-"+date;
        		}
        		if(time.getSelectedItem().toString().equals("三年"))
        		{
        			 times1 = ""+(year-3)+"-"+ month+"-"+date;
        		}
        		if(time.getSelectedItem().toString().equals("五年"))
        		{
        			  times1 = ""+(year-5)+ month+"-"+date;
        		}
        		System.out.println(""+(year-5)+ month+"-"+date);
        		try {
					 date1=sdf.parse(times);
					 System.out.println(date1);
				} catch (ParseException e2) {
					
					e2.printStackTrace();
			}  
        		try {
					 date2=sdf.parse(times1);
					 System.out.println(date2);
				} catch (ParseException e2) {
					
					e2.printStackTrace();
				}  
        		String sql="select * from TransactionInformation where Taccount='"+account+"'"+"and  Ttime between'"+times1+"'"+"and  '"+times+"'"+"";
        		transsactionBean tb=new transsactionBean();
        		
    		try{
    			Connection conn = JDBCUtils.getConnection();
    			Statement pstmt = conn.createStatement();
    		    int i=0;
    		    
    		    ResultSet rs = pstmt.executeQuery(sql);
    		    
    		    while(rs.next()){
    		    tb.setTaccount(account);
    		    tb.setTranssaction(rs.getString("Ttransaction"));
    		    tb.setType(rs.getString("Ttype"));
    		    tb.setTmoney(rs.getBigDecimal("Tmoney"));
    		    tb.setTfee(rs.getString("Tfee"));
    		    tb.setTtime(rs.getDate("Ttime"));
    		    tb.setTargetAccount(rs.getString("targetaccount"));
    		   
    		    Vector v = new Vector();
        		v.add(tb.getTranssaction());
        		v.add(tb.getTaccount());
        		v.add(tb.getType());
        		v.add(tb.getTmoney());
        		v.add(tb.getTfee());
        		v.add(tb.getTtime());
        		v.add(tb.getTargetAccount());
        		
        		tm.addRow(v);
    		    
    		    }
    		    
    		   }
    		    
    		catch(SQLException e1){
    				e1.printStackTrace();
    			}
        		
        		
    		
        		
        		
        		
        	}
        	
        });
        JTable table = new JTable(tm);
       
       
        sorter = new TableRowSorter<TableModel>(tm);
        
        table.setFont(new java.awt.Font("宋体", 0, 15));
        table.setPreferredScrollableViewportSize(new Dimension(990,500));
        table.setRowSorter(sorter);
        
        
        //居中显示  
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();     
        r.setHorizontalAlignment(JLabel.CENTER);     
        table.setDefaultRenderer(Object.class, r);  
            
    	JScrollPane scrollPane = new JScrollPane(table);
    	jp1.add(scrollPane);
    	//添加
    	t.setSize(1000,700);
     	jp2.add(exit);
    	jp2.add(back);
    	jp2.add(search);
    	jp2.add(time);
    	jp1.setBounds(0, 0, 990, 500);
    	jp2.setBounds(0, 500, 990, 200);
    	//把jp1和jp2加到jp3里。
    	t.add(jp1);
    	t.add(jp2);
    	
    	
    	
    
      
    	t.setVisible(true);
    	t.setLocationRelativeTo(null);	
    	t.setResizable(false);
    	t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    }

