package Dao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import commonuser.SearchTransactionDetails;
import manager.ChangePasswordInterface;

public class managerDao {
	String account;
	public String getAccount() 
	{
		return account;
	}
	public void setAccount(String account) 
	{
		this.account = account;
	}
	Connection conn=null;
	Statement pstmt=null;
	ResultSet rs=null;
	ResultSet rs2=null;
	String a;
	String b ;
	String id2;
	public  boolean login (String id,String pwd) 
			throws SQLException
	{

		 
		String sql="select * from ManagerInformation where Maccount='" +id+"'"  ;
		try{
			conn=JDBCUtils.getConnection();
			pstmt=conn.createStatement();
		    rs=pstmt.executeQuery(sql);
		    while(rs.next()){
			 a=rs.getString("Mpassword");
			 }
		}
		catch(SQLException e){
				e.printStackTrace();
			}
		
		if (pwd.equals(a)){
		    	return true;
		    }
		else{return false;}
		    
	
		
		
		    
			
		
	}
	public void changePassword(String account,String pwd){
		
		String sql=" update ManagerInformation set MPassword="+pwd+"where Maccount='"+account+"'";
		try{
			conn=JDBCUtils.getConnection();
			pstmt=conn.createStatement();
		    
		    int result = pstmt.executeUpdate(sql);
		    
		    if (result != -1) {
		    	JOptionPane.showMessageDialog(null, "修改成功","【修改管理员密码】",  JOptionPane.CLOSED_OPTION);
		    }}
		    
		catch(SQLException e){
				e.printStackTrace();
			}
	}
	public void createCommonUser(String Uname,String Uage,String Uid,boolean Usex,String Uphone,String Uadress,String Uopenbank,String Uworkplace){
		String sql="insert into UserInformation(Uaccount,Uname,Uage,Uid,Usex,Uphone,"
				+ "Uaddress,Uopenbank,Uworkplace)select ((select MAX(cast (Uaccount as bigint)) from UserInformation)+1),'"+Uname+"',"+Uage+","+Uid+",'"+Usex+"',"+Uphone
				+",'"+Uadress+"','"+Uopenbank+"','"+Uworkplace+"'";
		try{
			conn=JDBCUtils.getConnection();
			pstmt=conn.createStatement();
		    
		    int result = pstmt.executeUpdate(sql);
		    
		    if (result != -1) {
		    	JOptionPane.showMessageDialog(null, "开户成功","标题【开户】",  JOptionPane.CLOSED_OPTION);
		    	
		    }else{JOptionPane.showMessageDialog(null, "请输入正确的账号和密码", "ERROR", JOptionPane.ERROR_MESSAGE);}}
		    
		catch(SQLException e){
				e.printStackTrace();
			}
		
		
	}
	public void changerUser(String Uaccount,String Uname,boolean Usex,String Uage,String Uid,String Uphone,String Uaddress,String Uworkplace)
	{
		String sql="update UserInformation set Uname='"+Uname+"',Usex='"
			    +Usex+"',Uage='"+Uage+"',Uid='"+Uid+"',Uphone='"+Uphone+"',Uaddress='"+Uaddress
			    +"',Uworkplace='"+Uworkplace+"'where Uaccount='" +Uaccount+"'";
				
		try{
			conn=JDBCUtils.getConnection();
			pstmt=conn.createStatement();
		    
		    int result = pstmt.executeUpdate(sql);
		    
		    if (result != -1) {
		    	JOptionPane.showMessageDialog(null, "修改用户信息成功！","标题【修改用户信息】",  JOptionPane.CLOSED_OPTION);
		    	
		    }
		    else{
		    	JOptionPane.showMessageDialog(null, "修改失败", "ERROR", JOptionPane.ERROR_MESSAGE);
		    	}}
		    
		catch(SQLException e){
				e.printStackTrace();
			}
		
		
	}
	
	public void createCommonAccount(
			String name,String password,String opentime,String opencity,String status,String balance
			,String type,double over,boolean salesstatus,String UgetMax,double UtransferMax,String Ubanktype)
	{
		String sql="insert into AccountInformation (Uaccount,Uname,Upassword,Uopentime,Uopencity,Ustatus"
				+ ",Ubalance,Utype,Uover,Usalesstatus,UgetMax,UtransferMax,Ubanktype)"
				+"select ((select MAX(cast (Uaccount as bigint)) from AccountInformation)+1),'"+name
				+"',"+"'"+password+"','"+opentime+"','"+opencity+"','"+status+"',"+balance+",'"+type
				+"',"+over+",'"+salesstatus+"',"+UgetMax+","+UtransferMax+",'"+Ubanktype+"'";
		
		try{
			conn=JDBCUtils.getConnection();
			pstmt=conn.createStatement();
		    
		    int result = pstmt.executeUpdate(sql);
		    
		    }
		    
		catch(SQLException e){
				e.printStackTrace();
			}
	}
	public void deleteAccount(String account){
		
		String sql="update AccountInformation set Usalesstatus='true' where Uaccount='"+account+"'";
		try{
			conn=JDBCUtils.getConnection();
			pstmt=conn.createStatement();
		    
		    int result = pstmt.executeUpdate(sql);
		    
		    if (result != -1) {
		    	JOptionPane.showMessageDialog(null, "销户成功","标题【销户】",  JOptionPane.CLOSED_OPTION);
		    	
		    }else{JOptionPane.showMessageDialog(null, "请输入正确的账号和密码", "ERROR", JOptionPane.ERROR_MESSAGE);}}
		    
		catch(SQLException e){
				e.printStackTrace();
			}
	}
	public void freezeing(String account){

		String sql="update AccountInformation set Ustatus='冻结' where Uaccount='"+account+"'";
		try{
			conn=JDBCUtils.getConnection();
			pstmt=conn.createStatement();
		    
		    int result = pstmt.executeUpdate(sql);
		    
		    if (result != -1) {
		    
		    	
		    }
		    else{JOptionPane.showMessageDialog(null, "请输入正确的账号和密码", "ERROR", JOptionPane.ERROR_MESSAGE);}}
		
		    
		catch(SQLException e){
				e.printStackTrace();
			}
	}
	public void thawing (String account){
		
		String sql="update AccountInformation set Ustatus='正常' where Uaccount='"+account+"'";
		try{
			conn=JDBCUtils.getConnection();
			pstmt=conn.createStatement();
		    
		    int result = pstmt.executeUpdate(sql);
		    
		    if (result != -1) {
		    	JOptionPane.showMessageDialog(null, "解冻成功","标题【解冻】",  JOptionPane.CLOSED_OPTION);
		    	
		    }else{JOptionPane.showMessageDialog(null, "请输入正确的账号和密码", "ERROR", JOptionPane.ERROR_MESSAGE);}}
		    
		catch(SQLException e){
				e.printStackTrace();
			}
	}
	public void loss (String account){
		
		String sql="update AccountInformation set Ustatus='挂失' where Uaccount='"+account+"'";
		try{
			conn=JDBCUtils.getConnection();
			pstmt=conn.createStatement();
		    
		    int result = pstmt.executeUpdate(sql);
		    
		    if (result != -1) {
		    	
		    	
		    }else{
		    	
		    	}}
		    
		catch(SQLException e){
				e.printStackTrace();
			}
	}
	public void hangingSolution (String account){
		
		String sql="update AccountInformation set Ustatus='正常' where Uaccount='"+account+"'";
		try{
			conn=JDBCUtils.getConnection();
			pstmt=conn.createStatement();
		    
		    int result = pstmt.executeUpdate(sql);
		    
		    if (result != -1) {
		    	JOptionPane.showMessageDialog(null, "解挂成功","标题【解挂】",  JOptionPane.CLOSED_OPTION);
		    	
		    }else{JOptionPane.showMessageDialog(null, "请输入正确的账号和密码", "ERROR", JOptionPane.ERROR_MESSAGE);}}
		    
		catch(SQLException e){
				e.printStackTrace();
			}
	}
	public boolean deleteCheck(String account,String pwd,String id) throws SQLException{
		
	
		
		String sql="select Upassword from AccountInformation where Uaccount='"+account+"'";
		
		try{
			conn=JDBCUtils.getConnection();
			pstmt=conn.createStatement();
		    rs=pstmt.executeQuery(sql);
		   
		    
		    while(rs.next()){
			 a=rs.getString("Upassword");
			
			 }
  
		    
		    
		    
		}
		catch(SQLException e){
				e.printStackTrace();
			}
		if (pwd.equals(a)&& thawingCheck(account,id) )
		{
	    	return true;
	    }
	else{ 
		return false;
		}
	}
	
public boolean thawingCheck(String account,String id) 
		throws SQLException
{
	String id3 ="";
	accountDao ad = new accountDao();
	
	
		String sql1="select Uid from UserInformation where Uaccount= '"+account+"'";
		try{
			conn=JDBCUtils.getConnection();
			pstmt=conn.createStatement();
		    ResultSet rs1=pstmt.executeQuery(sql1);

		    
		    while(rs1.next()){
			 id3=rs1.getString("Uid");
			
			 }
		    
		}
		catch(SQLException e){
				e.printStackTrace();
			}
	
	
		if (id.equals(id3))
		{
	    	return true;
	    }
	else{ 
		return false;
		}
	}
}
