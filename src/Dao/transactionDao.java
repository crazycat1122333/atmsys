package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import Bean.transsactionBean;

public class transactionDao {
	Connection conn=null;
	Statement pstmt=null;
	ResultSet rs=null;
	
 
	public void GetT(String account,int money,double fee){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sql="insert into TransactionINformation(Ttransaction,Taccount,Ttype,Tmoney,Tfee,Ttime"+ ",targetaccount) select ((select MAX(cast(Ttransaction as bigint)) from "+ "TransactionINformation)+1)+'00000000','"+account+"','取款',"+money+","+fee+","+"'"+
				df.format(new Date())+"'"+",null";
		try{
			conn=JDBCUtils.getConnection();
			pstmt=conn.createStatement();
		    
		    int result = pstmt.executeUpdate(sql);
		    
		    if (result != -1) {
		    	System.out.println("取款插入成功！");
		    }}
		    
		catch(SQLException e){
				e.printStackTrace();
			}
	}
	public void saveT(String account,int money,double fee){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sql="insert into TransactionINformation(Ttransaction,Taccount,Ttype,Tmoney,Tfee,Ttime,targetaccount) select ((select MAX(cast(Ttransaction as bigint)) from TransactionINformation)+1),'"+account+"','存款',"+money+","+fee+","+"'"+df.format(new Date())+"'"+",null";
		try{
			conn=JDBCUtils.getConnection();
			pstmt=conn.createStatement();
		    
		    int result = pstmt.executeUpdate(sql);
		    
		    if (result != -1) {
		    	System.out.println("存款插入成功！");
		    }}
		    
		catch(SQLException e){
				e.printStackTrace();
			}
	}
	public void transactionDetails(String account,transsactionBean tb){
		
		String sql="select * from TransactionINformation where Taccount='"+account+"'";
		try{
			conn=JDBCUtils.getConnection();
			pstmt=conn.createStatement();
		    int i=0;
		    rs = pstmt.executeQuery(sql);
		    while(rs.next()){
		    tb.setTaccount(account);
		    tb.setTranssaction(rs.getString("Ttransaction"));
		    tb.setType(rs.getString("Ttype"));
		    tb.setTmoney(rs.getBigDecimal("Tmoney"));
		    tb.setTfee(rs.getString("Tfee"));
		    tb.setTtime(rs.getDate("Ttime"));
		    tb.setTargetAccount(rs.getString("targetaccount"));
		    
		    }
		    
		   }
		    
		catch(SQLException e){
				e.printStackTrace();
			}
		
	}
	public String getTransactionNum(String account){
		
		String sql="select * from TransactionINformation where Taccount='"+account+"'";
		String transaction="";
		try {
			conn=JDBCUtils.getConnection();
			pstmt=conn.createStatement();
			ResultSet rs = pstmt.executeQuery(sql);
			while(rs.next()){
				String s=rs.getString("Ttransaction");
				transaction=s;
				
			}
		} catch (SQLException 
				e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return transaction;
	}
	
	public void transferT(String account,double money,String targetAccount,double fee){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sql="insert into TransactionINformation(Ttransaction,Taccount"
				+ ",Ttype,Tmoney,Tfee,Ttime,targetaccount) select ((select MAX(cast(Ttransaction as bigint)) "
				+ "from TransactionINformation)+1),'"+account+"','转账支出',"+money+","+fee+","+"'"
				+df.format(new Date())+"'"+","+targetAccount;
		String sql1="insert into TransactionINformation(Ttransaction,Taccount"
				+ ",Ttype,Tmoney,Tfee,Ttime,targetaccount) select ((select MAX(cast(Ttransaction as bigint)) "
				+ "from TransactionINformation)+1),'"+targetAccount+"','转账收入',"+money+",0.0,"+"'"
				+df.format(new Date())+"',null";
		try{
			conn=JDBCUtils.getConnection();
			pstmt=conn.createStatement();
		    
		    int result = pstmt.executeUpdate(sql);
		    int result1 = pstmt.executeUpdate(sql1);
		    
		    if (result != -1 && result1 != -1) {
		    	System.out.println("转账记录输入！");
		    }}
		    
		catch(SQLException e){
				e.printStackTrace();
			}
	}
}
