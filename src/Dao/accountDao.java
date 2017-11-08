package Dao;


import java.sql.*;

import javax.swing.JOptionPane;

import commonuser.Fee;
import Bean.accountBean;

public class accountDao {
	
	Connection conn=null;
	Statement pstmt=null;
	ResultSet rs=null;
	String a;
	double balance;
	int getmax;
	double transfer;
	String accountCheck;
	Double creditOver;
	String banktype;
	accountBean account = new accountBean();
	String type;
	String name;
	Boolean sex;
	String status;
	//登录
	public  boolean login (String id,String pwd) 
			throws SQLException
	{
		 
		String sql="select * from AccountInformation where Uaccount='"+id+"'" ;
		try{
			conn=JDBCUtils.getConnection();
			pstmt=conn.createStatement();
		    rs=pstmt.executeQuery(sql);
		    while(rs.next())
		    {
			 a=rs.getString("Upassword");
			 }
		}
		catch(SQLException e)
		{
				e.printStackTrace();
				
		}
		//核对密码
		if (pwd.equals(a))
		{
		    	return true;
		    	
		  }
		else
		{
			return false;
			
		}		   	
	}
	
	//取款
	public double getMoney(int money, String account){
		String account1 = account;
		 String banktype = bankType(account);
		 double over = getOver(account);
		 double balance = searchBalance(account);
		 
		  
			//是否为透支
			//透支
			if(money > balance)
			{
				Fee cc = new Fee(1, (double)(money-balance));
				double finalmoney = cc.calculateFee();
				Object[] options ={ "确定", "取消" };  
				int m = JOptionPane.showOptionDialog(null, "您正在进行信用卡透支取款 ！\n需要扣取手续费 ："+finalmoney
						+"\n您剩余透支额度 ："+over+"\n是否继续", "标题【取款】",JOptionPane.YES_NO_OPTION, 
						JOptionPane.QUESTION_MESSAGE, null, options, options[0]); 
						
				//确定透支
				if(m==0)
				{
					//余额大于手续费时
					if(balance >=finalmoney)
					{
			String sql=" update AccountInformation set Ubalance="+0.00+"where Uaccount='"+account1+"'";
			String sql1=" update AccountInformation set UgetMax=UgetMax-"+money+"where Uaccount='"+account1+"'";
			String sql2=" update AccountInformation set Uover=Uover+"+balance+"-"+finalmoney+"-"+money
					+"where Uaccount='"+account1+"'";
			
		try{
			conn=JDBCUtils.getConnection();
			pstmt=conn.createStatement();
		
		    int result = pstmt.executeUpdate(sql);
		    int result1 = pstmt.executeUpdate(sql1);
		    int result2 = pstmt.executeUpdate(sql2);
		    
		    
		    if (result != -1&& result1 != -1 && result2 != -1) {
		    	JOptionPane.showMessageDialog(null, "您已成功取款"+money+"!" ,"标题【取款】", 
		    			JOptionPane.CLOSED_OPTION);
		    }
		    }					    
		catch(SQLException e){
				e.printStackTrace();
			}
		
					}
					if(balance < finalmoney)
					{
						
						String sql1=" update AccountInformation set UgetMax=UgetMax-"+money+"where Uaccount='"+account1+"'";
						String sql2=" update AccountInformation set Uover=Uover-"+finalmoney+"-"+money
								+"where Uaccount='"+account1+"'";
						
					try{
						conn=JDBCUtils.getConnection();
						pstmt=conn.createStatement();
					
					  
					    int result1 = pstmt.executeUpdate(sql1);
					    int result2 = pstmt.executeUpdate(sql2);
					   
					    if (result1 != -1 && result2 != -1) {
					    	JOptionPane.showMessageDialog(null, "您已成功取款"+money+"!" ,"标题【取款】",  JOptionPane.CLOSED_OPTION);
					    }
					    }					    
					catch(SQLException e){
							e.printStackTrace();
						}
					
					}
					
				}
				//拒绝透支
				if(m==1)					
				{
					JOptionPane.showMessageDialog(null, "您已取消操作!" ,"标题【取款】",  JOptionPane.CLOSED_OPTION);
		}
			}
			
			//没有透支
			Fee cc = new Fee(1, (double)money);
			double finalmoney = cc.calculateFee();
			if((money +finalmoney)<= balance)
			{
				//是否跨行取款
				 //不是跨行取款
				if(banktype.equals("中国建设银行"))
				{
				finalmoney = 0;
				String sql=" update AccountInformation set Ubalance=Ubalance-"+money+"where Uaccount='"+account1+"'";
				String sql1=" update AccountInformation set UgetMax=UgetMax-"+money+"where Uaccount='"+account1+"'";
				
			try{
				conn=JDBCUtils.getConnection();
				pstmt=conn.createStatement();
			
			    int result = pstmt.executeUpdate(sql);
			    int result1 = pstmt.executeUpdate(sql1);
			    	
			    if (result != -1&& result1 != -1) {
			    	JOptionPane.showMessageDialog(null, "您已成功取款"+money+"!" ,"标题【取款】",  JOptionPane.CLOSED_OPTION);
			    }
			    }					    
			catch(SQLException e){
					e.printStackTrace();
				}
			
		}
				//跨行取款
				if(!banktype.equals("中国建设银行"))
				{
					try{												
						Object[] options1 ={ "确定", "取消" };  
						int m1 = JOptionPane.showOptionDialog(null, "跨行取款 ：需要扣取手续费"+finalmoney+"\n是否继续", "标题【取款】",JOptionPane.YES_NO_OPTION, 
								JOptionPane.QUESTION_MESSAGE, null, options1, options1[0]); 
						//确定扣取手续费
						if(m1==0)
						{
							//余额充足
							int result;
							int result1;
							
						String sql=" update AccountInformation set Ubalance=Ubalance-"+money+"-"+finalmoney+"where Uaccount='"+account1+"'";
						String sql1=" update AccountInformation set UgetMax=UgetMax-"+money+"where Uaccount='"+account1+"'";
						
					conn=JDBCUtils.getConnection();
					pstmt=conn.createStatement();
				
				    result = pstmt.executeUpdate(sql);
				     result1 = pstmt.executeUpdate(sql1);
				  
				     if (result != -1 && result1 !=-1) 
				     {
					    	JOptionPane.showMessageDialog(null, "您已成功取款"+money+"!" ,"标题【取款】",  JOptionPane.CLOSED_OPTION);
							}
				    
						}
						//取消操作
						if(m1==1)
						{
							JOptionPane.showMessageDialog(null, "您已取消操作!" ,"标题【取款】",  JOptionPane.CLOSED_OPTION);
						}
				    }
				    
				catch(SQLException e){
						e.printStackTrace();
					}
				}
			}
			return finalmoney;
						
		
	}
	//存款
	public double saveMoney(int money, String account){
		
		 String banktype = bankType(account);
		//计算跨行手续费
		 Fee cc = new Fee(2, (double)money);
		double finalmoney = cc.calculateFee();
		//判断是否为跨存款款。
		if(banktype.equals("中国建设银行"))
		{
			finalmoney = 0;
		String sql=" update AccountInformation set Ubalance=Ubalance+"+money+"where Uaccount='"+account+"'";
		
		try{
			conn=JDBCUtils.getConnection();
			pstmt=conn.createStatement();
		    
		    int result = pstmt.executeUpdate(sql);
		    
		    if (result != -1) {
		    	JOptionPane.showMessageDialog(null, "您已成功存入"+money+"!","【存款】",  JOptionPane.CLOSED_OPTION);
		    }}
		    
		catch(SQLException e){
				e.printStackTrace();
			}
		
		}
		if(!banktype.equals("中国建设银行"))
		{
			try{												
				Object[] options1 ={ "确定", "取消" };  
				int m1 = JOptionPane.showOptionDialog(null, "跨行存款 ：需要扣取手续费"+finalmoney+"\n是否继续", "标题【取款】",JOptionPane.YES_NO_OPTION, 
						JOptionPane.QUESTION_MESSAGE, null, options1, options1[0]); 
				//确定扣取手续费
				if(m1==0)
				{
			String sql=" update AccountInformation set Ubalance=Ubalance+"+money+"-"+finalmoney+"where Uaccount='"+account+"'";
			
				conn=JDBCUtils.getConnection();
				pstmt=conn.createStatement();
			    
			    int result = pstmt.executeUpdate(sql);
			   
			    if (result != -1) {
			    	JOptionPane.showMessageDialog(null, "您已成功存入"+money+"!","【存款】",  JOptionPane.CLOSED_OPTION);
			    }
			  
				}
				if(m1==1)
				{
					JOptionPane.showMessageDialog(null, "您已取消操作!" ,"标题【取款】",  JOptionPane.CLOSED_OPTION);
				}
			}
			    
			catch(SQLException e){
					e.printStackTrace();
				}
			
		}
		return finalmoney;
		
		
	}
	
	public void changePassword(String account,String pwd){
		
		String sql=" update AccountInformation set UPassword="+pwd+"where Uaccount='"+account+"'";
		try{
			conn=JDBCUtils.getConnection();
			pstmt=conn.createStatement();
		    
		    int result = pstmt.executeUpdate(sql);
		    
		    if (result != -1) {
		    	JOptionPane.showMessageDialog(null, "您已成功修改密码！","【修改用户密码密码】",  JOptionPane.CLOSED_OPTION);
		    }}
		    
		catch(SQLException e){
				e.printStackTrace();
			}
	}
	public void updatePassword(String pwd){
		String sql=" update AccountInformation set UPassword="+pwd+"where Uaccount=(select MAX(cast (Uaccount as bigint)) from UserInformation)";
		try{
			conn=JDBCUtils.getConnection();
			pstmt=conn.createStatement();
		    
		    int result = pstmt.executeUpdate(sql);
		    
		    if (result != -1) {
		    	JOptionPane.showMessageDialog(null, "您已成功设置密码！","【设置密码】",  JOptionPane.CLOSED_OPTION);
		    }}
		    
		catch(SQLException e){
				e.printStackTrace();
			}
	}
	
	//查询余额
	public double searchBalance(String account){
		
		String sql="select Ubalance from AccountInformation where Uaccount='"+account+"'";
		
		try {
			conn=JDBCUtils.getConnection();
			pstmt=conn.createStatement();
			ResultSet rs = pstmt.executeQuery(sql);
			while(rs.next()){
				 balance=rs.getDouble("Ubalance");
				
			}
		} catch (SQLException 
				e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return balance;
		
	}
	public void transferAdd(String account,double money){
		
		String sql=" update AccountInformation set Ubalance=Ubalance+"+money+"where Uaccount='"+account+"'";
		try{
			conn=JDBCUtils.getConnection();
			pstmt=conn.createStatement();
		    
		    int result = pstmt.executeUpdate(sql);
		    
		    if (result != -1) {
		    	System.out.println("转账存款成功");
		    }}
		    
		catch(SQLException e){
				e.printStackTrace();
			}
	}
	public double transferReduce(String account,double money,String targetaccount){
		
		
		String banktype = bankType(account);
		String banktype1 = bankType(targetaccount);
		//获取剩余透支额度
		 double over = getOver(account);
		 //获取余额
		 double balance = searchBalance(account);
		 //计算跨行转账的手续费
		 
		//是否为透支
		//透支
		if(money > balance)
		{
			Fee cc = new Fee(1, over+balance-(double)money);
			double finalmoney = cc.calculateFee();
			Object[] options ={ "确定", "取消" };  
			int m = JOptionPane.showOptionDialog(null, "您正在进行信用卡透支转账 ！\n需要扣取手续费 ："+finalmoney
					+"\n您剩余透支额度 ："+over+"\n是否继续", "标题【转账】",JOptionPane.YES_NO_OPTION, 
					JOptionPane.QUESTION_MESSAGE, null, options, options[0]); 
					
			//确定透支
			if(m==0)
			{
				
				//余额大于手续费时
				if(balance >=finalmoney)
				{
		String sql=" update AccountInformation set Ubalance="+0.00+"where Uaccount='"+account+"'";
		String sql1=" update AccountInformation set UtransferMax=UtransferMax-"+money+"where Uaccount='"+account+"'";
		String sql2=" update AccountInformation set Uover=Uover+"+balance+"-"+finalmoney+"-"+money
				+"where Uaccount='"+account+"'";
		
	try{
		conn=JDBCUtils.getConnection();
		pstmt=conn.createStatement();
	
	    int result = pstmt.executeUpdate(sql);
	    int result1 = pstmt.executeUpdate(sql1);
	    int result2 = pstmt.executeUpdate(sql2);
	    
	    if (result != -1&& result1 != -1 && result2 != -1) {
	    	JOptionPane.showMessageDialog(null, "您已成功转账!" ,"标题【转账】", 
	    			JOptionPane.CLOSED_OPTION);
	    }
	    }					    
	catch(SQLException e){
			e.printStackTrace();
		}
	
				}
				if(balance < finalmoney)
				{
					
					String sql1=" update AccountInformation set UtransferMax=UtransferMax-"+money+"where Uaccount='"+account+"'";
					String sql2=" update AccountInformation set Uover=Uover-"+finalmoney+"-"+money
							+"where Uaccount='"+account+"'";
					
				try{
					conn=JDBCUtils.getConnection();
					pstmt=conn.createStatement();
				
				  
				    int result1 = pstmt.executeUpdate(sql1);
				    int result2 = pstmt.executeUpdate(sql2);
				   
				    
				    if (result1 != -1 && result2 != -1) {
				    	JOptionPane.showMessageDialog(null, "您已成功转账!" ,"标题【转账】",  JOptionPane.CLOSED_OPTION);
				    }
				    }					    
				catch(SQLException e){
						e.printStackTrace();
					}
				
				}
				
			}
			//拒绝透支
			if(m==1)					
			{
				JOptionPane.showMessageDialog(null, "您已取消操作!" ,"标题【转账】",  JOptionPane.CLOSED_OPTION);
				}
		}
		//没有透支
		Fee cc = new Fee(3, over+balance-(double)money);
		double finalmoney = cc.calculateFee();
		if((money +finalmoney)<= balance)
		{
			//是否跨行转账
			 //不是跨行转账
			if(banktype.equals("中国建设银行")&& banktype1.equals("中国建设银行"))
			{
			finalmoney = 0;
			String sql=" update AccountInformation set Ubalance=Ubalance-"+money+"where Uaccount='"+account+"'";
			String sql1=" update AccountInformation set UtransferMax=UtransferMax-"+money+"where Uaccount='"+account+"'";
			
		try{
			conn=JDBCUtils.getConnection();
			pstmt=conn.createStatement();
		
		    int result = pstmt.executeUpdate(sql);
		    int result1 = pstmt.executeUpdate(sql1);	
		    
		    if (result != -1&& result1 != -1) {
		    	JOptionPane.showMessageDialog(null, "您已成功转账!" ,"标题【转账】",  JOptionPane.CLOSED_OPTION);
		    }
		    }					    
		catch(SQLException e){
				e.printStackTrace();
			}
		
	}
			//跨行转账
			else
			{
																
					Object[] options1 ={ "确定", "取消" };  
					int m1 = JOptionPane.showOptionDialog(null, "跨行转账！\n 需要扣取手续费 ："+finalmoney
							+"\n是否继续", "标题【转账】",JOptionPane.YES_NO_OPTION, 
							JOptionPane.QUESTION_MESSAGE, null, options1, options1[0]); 
					//确定扣取手续费
					if(m1==0)
					{
						try{
						//余额充足
						int result;
						int result1;
						
					String sql=" update AccountInformation set Ubalance=Ubalance-"+money+"-"+finalmoney+"where Uaccount='"+account+"'";
					String sql1=" update AccountInformation set UtransferMax=UtransferMax-"+money+"where Uaccount='"+account+"'";
					
					conn=JDBCUtils.getConnection();
				pstmt=conn.createStatement();
			
			    result = pstmt.executeUpdate(sql);
			     result1 = pstmt.executeUpdate(sql1);
			   
			     if (result != -1 && result1 !=-1) 
			     {
				    	JOptionPane.showMessageDialog(null, "您已成功转账!" ,"标题【转账】",  JOptionPane.CLOSED_OPTION);
						
			     }
					}
			     catch(SQLException e){
						e.printStackTrace();
					}
					
			    
			    
					}
					//取消操作
					if(m1==1)
					{
						JOptionPane.showMessageDialog(null, "您已取消操作!" ,"标题【转账】",  JOptionPane.CLOSED_OPTION);
					}
			    
			    
			
			}
		}
		return finalmoney;
		

		
		
		
	}
	//检查转账账号的状态
	public boolean transferCheck(String account ,double money){
		boolean oo=true;
		
		String status="";
		
		String sql="select * from AccountInformation where Uaccount='"+account+"'";
		try {
			conn=JDBCUtils.getConnection();
			pstmt=conn.createStatement();
			ResultSet rs = pstmt.executeQuery(sql);
			while(rs.next()){
				 balance=rs.getDouble("Ubalance");
				 status=rs.getString("Ustatus");
				 
				
			}
		} catch (SQLException 
				e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		if((status.equals("正常")||status.equals("冻结")))
		{
			oo=true;
			}
		if(!(status.equals("正常")||status.equals("冻结")))
		{
			oo = false;
			
			}
		return oo;
		
		
	}
	//检查账号是否存在
	public boolean accountCheck(String account ){
		
		String sql="select Uaccount from AccountInformation where Uaccount='"+account+"'";
		try {
		conn=JDBCUtils.getConnection();
		pstmt=conn.createStatement();
		ResultSet rs = pstmt.executeQuery(sql);
		while(rs.next()){
			 accountCheck=rs.getString("Uaccount");			
		}
	   } catch (SQLException 
			e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
		if(accountCheck != null)
		{
			return true;}
		else
		{
			return false;
			}
	}
	public boolean checkUsalesstatus(String account){
		
		String sql="select Usalesstatus from AccountInformation where Uaccount='"+account+"'";
		boolean b = false;
		try {
			conn=JDBCUtils.getConnection();
			pstmt=conn.createStatement();
			ResultSet rs = pstmt.executeQuery(sql);
			while(rs.next()){
				  b=rs.getBoolean("Usalesstatus");
				  
			}
		} catch (SQLException 
				e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		if(b)
		{
			return true;
			}
		else{
			return false;
			}
		}
	//获取账号的状态
	public String getStatus(String account){
		
		String sql="select Ustatus from AccountInformation where Uaccount='"+account+"'";
		
		try {
			conn=JDBCUtils.getConnection();
			pstmt=conn.createStatement();
			ResultSet rs = pstmt.executeQuery(sql);
			while(rs.next()){
				 a=rs.getString("Ustatus");
				
			}
		} catch (SQLException 
				e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return a;
		
	}
	//获取账户的信用卡额度
	public Double getOver(String account){
		
		String sql="select Uover from AccountInformation where Uaccount='"+account+"'";
		
		try {
			conn=JDBCUtils.getConnection();
			pstmt=conn.createStatement();
			ResultSet rs = pstmt.executeQuery(sql);
			while(rs.next()){
				creditOver = rs.getDouble("Uover");
				
			}
		} catch (SQLException 
				e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return creditOver;
		
	}
	/*public boolean a(String c,String b){
		String sql="select * from AccountInformation ";
		try{
			conn=JDBCUtils.getConnection();
			pstmt=conn.prepareStatement(sql);
		    rs=pstmt.executeQuery();}
		    
		catch(SQLException e){
				e.printStackTrace();
			}
		return true;
	}*/
	/*public void addaccount(accountBean stu){
		String sql="insert into AccountInformation values(2,1,16,1,1,1,1,1,1)";
		try{
			conn=JDBCUtils.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, stu.getUaccount());
			pstmt.setString(2, stu.getUname());
			pstmt.setString(3, stu.getUpassword());
			pstmt.setDate(4, stu.getUopentime());
			pstmt.setString(5, stu.getUopencity());
			pstmt.setString(6, stu.getUstatus());
			pstmt.setDouble(7, stu.getUbalance());
			pstmt.setDouble(8, stu.getUavailablebalance());
			pstmt.setDouble(9, stu.getUlimite());
			pstmt.setString(10, stu.getUtype());
			pstmt.setString(11, stu.getUover());
			pstmt.setBoolean(12, stu.isUsalesstatus());
			pstmt.executeUpdate();
            System.out.println("修改账户成功！");
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtils.free(rs, pstmt, conn);
		}*/
	public int getMax(String account){
		
		String sql="select UgetMax from AccountInformation where Uaccount='"+account+"'";
		
		try {
			conn=JDBCUtils.getConnection();
			pstmt=conn.createStatement();
			ResultSet rs = pstmt.executeQuery(sql);
			while(rs.next()){
				getmax =rs.getInt("UgetMax");
				
			}
		} catch (SQLException 
				e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return getmax;
		
	}
	public double transferMax(String account){
		
		String sql="select UtransferMax from AccountInformation where Uaccount='"+account+"'";
		
		try {
			conn=JDBCUtils.getConnection();
			pstmt=conn.createStatement();
			ResultSet rs = pstmt.executeQuery(sql);
			while(rs.next()){
				transfer =rs.getInt("UtransferMax");
				
			}
		} catch (SQLException 
				e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return transfer;
		
	}
	public String bankType(String account){
		
		String sql="select Ubanktype from AccountInformation where Uaccount='"+account+"'";
		
		try {
			conn=JDBCUtils.getConnection();
			pstmt=conn.createStatement();
			ResultSet rs = pstmt.executeQuery(sql);
			while(rs.next()){
				banktype =rs.getString("Ubanktype");
				
			}
		} catch (SQLException 
				e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return banktype;
		
	}
	//获取卡的类型
	public String cardType(String account){
		
		String sql="select Utype from AccountInformation where Uaccount='"+account+"'";
		
		try {
			conn=JDBCUtils.getConnection();
			pstmt=conn.createStatement();
			ResultSet rs = pstmt.executeQuery(sql);
			while(rs.next()){
				type =rs.getString("Utype");
				
			}
		} catch (SQLException 
				e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return type;
		
	}
	//获取姓名
		public String name(String account){
			
			String sql="select Uname from AccountInformation where Uaccount='"+account+"'";
			
			try {
				conn=JDBCUtils.getConnection();
				pstmt=conn.createStatement();
				ResultSet rs = pstmt.executeQuery(sql);
				while(rs.next()){
					name =rs.getString("Uname");
					
				}
			} catch (SQLException 
					e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
			return name;
			
		}
	
		//获取性别
				public Boolean sex(String account){
					
					String sql="select Usex from UserInformation where Uaccount='"+account+"'";
					
					try {
						conn=JDBCUtils.getConnection();
						pstmt=conn.createStatement();
						ResultSet rs = pstmt.executeQuery(sql);
						while(rs.next()){
							sex =rs.getBoolean("Usex");
							
						}
					} catch (SQLException 
							e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
					
					return sex;
					
				}
				//获取账号状态
public String status(String account){
					
					String sql="select Ustatus from AccountInformation where Uaccount='"+account+"'";
					
					try {
						conn=JDBCUtils.getConnection();
						pstmt=conn.createStatement();
						ResultSet rs = pstmt.executeQuery(sql);
						while(rs.next()){
							status =rs.getString("Ustatus");
							
						}
					} catch (SQLException 
							e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
					
					return status;
					
				}


	
	}
	 
	 


