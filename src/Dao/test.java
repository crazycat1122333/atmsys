package Dao;



import java.sql.*;

import Bean.accountBean;

public class test {
	public static void main(String[] args) throws Exception{
		String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url ="jdbc:sqlserver://localhost:1433;DatabaseName=atm";
		String user ="sa";
		String password="123456";
		Connection con = null ;
		try{
			Class.forName(driverName);
			con=DriverManager.getConnection(url,user,password);
			System.out.println("success");
			Statement stmt = con.createStatement();
			String sql="select * from student";
           // String sql = "create table AccountInfo(Uaccount varchar(16),Uname varchar(16),Upassword varchar(6),Uopentime date,Uopencity varchar(40),Ustatus varchar(4),Ubalance decimal(20, 2) ,Uavailablebalance decimal(20, 2),Ulimite decimal(20, 2),Utype varchar(20),Uover varchar(10),Usalesstatus bit,primary key(Uaccount))";
			
            int result = stmt.executeUpdate(sql);// executeUpdate���᷵��һ����Ӱ����������������-1��û�гɹ�
            /*if (result != -1) {
                System.out.println("�������ݱ�ɹ�");
                sql = "insert into student(NO,name) values('2012001','��ΰ��')";
                result = stmt.executeUpdate(sql);
                sql = "insert into student(NO,name) values('2012002','��С��')";
                result = stmt.executeUpdate(sql);
                sql = "select * from student";
                ResultSet rs = stmt.executeQuery(sql);// executeQuery�᷵�ؽ���ļ��ϣ����򷵻ؿ�ֵ
                System.out.println("ѧ��\t����");
                while (rs.next()) {
                    System.out
                            .println(rs.getString(1) + "\t" + rs.getString(2));// ��������ص���int���Ϳ�����getInt()
                }
            }*/
		}catch(Exception e){
			e.printStackTrace();
		}
		
		}
	}