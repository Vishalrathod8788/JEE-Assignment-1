package pro_9;

import java.sql.*;

public class transf {
	public static void main(String[] args) throws Exception 
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver loaded");
		
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="system";
		String password="system";
		Connection conn = DriverManager.getConnection(url, user, password);
		System.out.println("Oracle Connection Done");
		
		String SQl ="select * from tblfororcl";
		ResultSet rs=conn.createStatement().executeQuery(SQl);
		
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("sql driver loaded");
		
		String URL="jdbc:mysql://localhost:3306/test";
		String USER="root";
		String PASSWORD="";
		Connection cnn = DriverManager.getConnection(URL, USER, PASSWORD);
		System.out.println("MySql Connection Done");

		java.sql.Statement st = cnn.createStatement();
	while (rs.next()) 
	{
		String QRY ="insert into tblforsql values("+rs.getString(1)+",'"
	+rs.getString(2)+"')";
		st.execute(QRY);
	}
	System.out.println("Record Inserted");
	}
}
