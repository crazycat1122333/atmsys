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
	//��¼
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
		//�˶�����
		if (pwd.equals(a))
		{
		    	return true;
		    	
		  }
		else
		{
			return false;
			
		}		   	
	}
	
	//ȡ��
	public double getMoney(int money, String account){
		String account1 = account;
		 String banktype = bankType(account);
		 double over = getOver(account);
		 double balance = searchBalance(account);
		 
		  
			//�Ƿ�Ϊ͸֧
			//͸֧
			if(money > balance)
			{
				Fee cc = new Fee(1, (double)(money-balance));
				double finalmoney = cc.calculateFee();
				Object[] options ={ "ȷ��", "ȡ��" };  
				int m = JOptionPane.showOptionDialog(null, "�����ڽ������ÿ�͸֧ȡ�� ��\n��Ҫ��ȡ������ ��"+finalmoney
						+"\n��ʣ��͸֧��� ��"+over+"\n�Ƿ����", "���⡾ȡ�",JOptionPane.YES_NO_OPTION, 
						JOptionPane.QUESTION_MESSAGE, null, options, options[0]); 
						
				//ȷ��͸֧
				if(m==0)
				{
					//������������ʱ
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
		    	JOptionPane.showMessageDialog(null, "���ѳɹ�ȡ��"+money+"!" ,"���⡾ȡ�", 
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
					    	JOptionPane.showMessageDialog(null, "���ѳɹ�ȡ��"+money+"!" ,"���⡾ȡ�",  JOptionPane.CLOSED_OPTION);
					    }
					    }					    
					catch(SQLException e){
							e.printStackTrace();
						}
					
					}
					
				}
				//�ܾ�͸֧
				if(m==1)					
				{
					JOptionPane.showMessageDialog(null, "����ȡ������!" ,"���⡾ȡ�",  JOptionPane.CLOSED_OPTION);
		}
			}
			
			//û��͸֧
			Fee cc = new Fee(1, (double)money);
			double finalmoney = cc.calculateFee();
			if((money +finalmoney)<= balance)
			{
				//�Ƿ����ȡ��
				 //���ǿ���ȡ��
				if(banktype.equals("�й���������"))
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
			    	JOptionPane.showMessageDialog(null, "���ѳɹ�ȡ��"+money+"!" ,"���⡾ȡ�",  JOptionPane.CLOSED_OPTION);
			    }
			    }					    
			catch(SQLException e){
					e.printStackTrace();
				}
			
		}
				//����ȡ��
				if(!banktype.equals("�й���������"))
				{
					try{												
						Object[] options1 ={ "ȷ��", "ȡ��" };  
						int m1 = JOptionPane.showOptionDialog(null, "����ȡ�� ����Ҫ��ȡ������"+finalmoney+"\n�Ƿ����", "���⡾ȡ�",JOptionPane.YES_NO_OPTION, 
								JOptionPane.QUESTION_MESSAGE, null, options1, options1[0]); 
						//ȷ����ȡ������
						if(m1==0)
						{
							//������
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
					    	JOptionPane.showMessageDialog(null, "���ѳɹ�ȡ��"+money+"!" ,"���⡾ȡ�",  JOptionPane.CLOSED_OPTION);
							}
				    
						}
						//ȡ������
						if(m1==1)
						{
							JOptionPane.showMessageDialog(null, "����ȡ������!" ,"���⡾ȡ�",  JOptionPane.CLOSED_OPTION);
						}
				    }
				    
				catch(SQLException e){
						e.printStackTrace();
					}
				}
			}
			return finalmoney;
						
		
	}
	//���
	public double saveMoney(int money, String account){
		
		 String banktype = bankType(account);
		//�������������
		 Fee cc = new Fee(2, (double)money);
		double finalmoney = cc.calculateFee();
		//�ж��Ƿ�Ϊ����
		if(banktype.equals("�й���������"))
		{
			finalmoney = 0;
		String sql=" update AccountInformation set Ubalance=Ubalance+"+money+"where Uaccount='"+account+"'";
		
		try{
			conn=JDBCUtils.getConnection();
			pstmt=conn.createStatement();
		    
		    int result = pstmt.executeUpdate(sql);
		    
		    if (result != -1) {
		    	JOptionPane.showMessageDialog(null, "���ѳɹ�����"+money+"!","����",  JOptionPane.CLOSED_OPTION);
		    }}
		    
		catch(SQLException e){
				e.printStackTrace();
			}
		
		}
		if(!banktype.equals("�й���������"))
		{
			try{												
				Object[] options1 ={ "ȷ��", "ȡ��" };  
				int m1 = JOptionPane.showOptionDialog(null, "���д�� ����Ҫ��ȡ������"+finalmoney+"\n�Ƿ����", "���⡾ȡ�",JOptionPane.YES_NO_OPTION, 
						JOptionPane.QUESTION_MESSAGE, null, options1, options1[0]); 
				//ȷ����ȡ������
				if(m1==0)
				{
			String sql=" update AccountInformation set Ubalance=Ubalance+"+money+"-"+finalmoney+"where Uaccount='"+account+"'";
			
				conn=JDBCUtils.getConnection();
				pstmt=conn.createStatement();
			    
			    int result = pstmt.executeUpdate(sql);
			   
			    if (result != -1) {
			    	JOptionPane.showMessageDialog(null, "���ѳɹ�����"+money+"!","����",  JOptionPane.CLOSED_OPTION);
			    }
			  
				}
				if(m1==1)
				{
					JOptionPane.showMessageDialog(null, "����ȡ������!" ,"���⡾ȡ�",  JOptionPane.CLOSED_OPTION);
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
		    	JOptionPane.showMessageDialog(null, "���ѳɹ��޸����룡","���޸��û��������롿",  JOptionPane.CLOSED_OPTION);
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
		    	JOptionPane.showMessageDialog(null, "���ѳɹ��������룡","���������롿",  JOptionPane.CLOSED_OPTION);
		    }}
		    
		catch(SQLException e){
				e.printStackTrace();
			}
	}
	
	//��ѯ���
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
			// TODO �Զ����ɵ� catch ��
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
		    	System.out.println("ת�˴��ɹ�");
		    }}
		    
		catch(SQLException e){
				e.printStackTrace();
			}
	}
	public double transferReduce(String account,double money,String targetaccount){
		
		
		String banktype = bankType(account);
		String banktype1 = bankType(targetaccount);
		//��ȡʣ��͸֧���
		 double over = getOver(account);
		 //��ȡ���
		 double balance = searchBalance(account);
		 //�������ת�˵�������
		 
		//�Ƿ�Ϊ͸֧
		//͸֧
		if(money > balance)
		{
			Fee cc = new Fee(1, over+balance-(double)money);
			double finalmoney = cc.calculateFee();
			Object[] options ={ "ȷ��", "ȡ��" };  
			int m = JOptionPane.showOptionDialog(null, "�����ڽ������ÿ�͸֧ת�� ��\n��Ҫ��ȡ������ ��"+finalmoney
					+"\n��ʣ��͸֧��� ��"+over+"\n�Ƿ����", "���⡾ת�ˡ�",JOptionPane.YES_NO_OPTION, 
					JOptionPane.QUESTION_MESSAGE, null, options, options[0]); 
					
			//ȷ��͸֧
			if(m==0)
			{
				
				//������������ʱ
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
	    	JOptionPane.showMessageDialog(null, "���ѳɹ�ת��!" ,"���⡾ת�ˡ�", 
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
				    	JOptionPane.showMessageDialog(null, "���ѳɹ�ת��!" ,"���⡾ת�ˡ�",  JOptionPane.CLOSED_OPTION);
				    }
				    }					    
				catch(SQLException e){
						e.printStackTrace();
					}
				
				}
				
			}
			//�ܾ�͸֧
			if(m==1)					
			{
				JOptionPane.showMessageDialog(null, "����ȡ������!" ,"���⡾ת�ˡ�",  JOptionPane.CLOSED_OPTION);
				}
		}
		//û��͸֧
		Fee cc = new Fee(3, over+balance-(double)money);
		double finalmoney = cc.calculateFee();
		if((money +finalmoney)<= balance)
		{
			//�Ƿ����ת��
			 //���ǿ���ת��
			if(banktype.equals("�й���������")&& banktype1.equals("�й���������"))
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
		    	JOptionPane.showMessageDialog(null, "���ѳɹ�ת��!" ,"���⡾ת�ˡ�",  JOptionPane.CLOSED_OPTION);
		    }
		    }					    
		catch(SQLException e){
				e.printStackTrace();
			}
		
	}
			//����ת��
			else
			{
																
					Object[] options1 ={ "ȷ��", "ȡ��" };  
					int m1 = JOptionPane.showOptionDialog(null, "����ת�ˣ�\n ��Ҫ��ȡ������ ��"+finalmoney
							+"\n�Ƿ����", "���⡾ת�ˡ�",JOptionPane.YES_NO_OPTION, 
							JOptionPane.QUESTION_MESSAGE, null, options1, options1[0]); 
					//ȷ����ȡ������
					if(m1==0)
					{
						try{
						//������
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
				    	JOptionPane.showMessageDialog(null, "���ѳɹ�ת��!" ,"���⡾ת�ˡ�",  JOptionPane.CLOSED_OPTION);
						
			     }
					}
			     catch(SQLException e){
						e.printStackTrace();
					}
					
			    
			    
					}
					//ȡ������
					if(m1==1)
					{
						JOptionPane.showMessageDialog(null, "����ȡ������!" ,"���⡾ת�ˡ�",  JOptionPane.CLOSED_OPTION);
					}
			    
			    
			
			}
		}
		return finalmoney;
		

		
		
		
	}
	//���ת���˺ŵ�״̬
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		if((status.equals("����")||status.equals("����")))
		{
			oo=true;
			}
		if(!(status.equals("����")||status.equals("����")))
		{
			oo = false;
			
			}
		return oo;
		
		
	}
	//����˺��Ƿ����
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
		// TODO �Զ����ɵ� catch ��
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
			// TODO �Զ����ɵ� catch ��
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
	//��ȡ�˺ŵ�״̬
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return a;
		
	}
	//��ȡ�˻������ÿ����
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
			// TODO �Զ����ɵ� catch ��
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
            System.out.println("�޸��˻��ɹ���");
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
			// TODO �Զ����ɵ� catch ��
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
			// TODO �Զ����ɵ� catch ��
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return banktype;
		
	}
	//��ȡ��������
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		return type;
		
	}
	//��ȡ����
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
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			
			return name;
			
		}
	
		//��ȡ�Ա�
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
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
					
					return sex;
					
				}
				//��ȡ�˺�״̬
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
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
					
					return status;
					
				}


	
	}
	 
	 


