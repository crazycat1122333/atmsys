package Dao;
import java.sql.*;

public class JDBCUtils {
	public static Connection getConnection()
	{
		//���ݿ���
		String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		//·��
		String url ="jdbc:sqlserver://localhost:1433;DatabaseName=atm";
		//���ݿ��û���
		String user ="sa";
		//���ݿ�����
		String password="123456";
		Connection con = null ;
		try{
			Class.forName(driverName);
			con=DriverManager.getConnection(url,user,password);
		//	System.out.println("success");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	public static void free(ResultSet rs,Statement sta,Connection con){
		try{
			if(null!=rs){
				rs.close();
				rs=null;
			}
			if(null!=sta){
				sta.close();
				sta=null;
			}
			if(null!=con){
				con.close();
				con=null;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
