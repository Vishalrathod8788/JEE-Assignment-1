//Developed By Vishal Rathod
package pro_8;

import java.sql.*;

public class dbmddemo {
	public static void main(String[] args) 
	{
		try
		{   
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String user="system";
			String password="system";
			Connection con=DriverManager.getConnection(url, user, password);
			DatabaseMetaData dmd=con.getMetaData();
			System.out.println(dmd.getCatalogSeparator());
			
			String q="select*from pstmt";
			 ResultSet rs=con.createStatement().executeQuery(q);
			 	System.out.println("size ="+rs.getFetchSize());
			 	System.out.println("direction="+rs.getFetchDirection());
			 	System.out.println("concurency="+rs.getConcurrency());
			 	System.out.println("holdability="+rs.getHoldability());
			 	System.out.println("rows="+rs.getRow());
		}
		catch(Exception e)
		{
			System.out.println("Exception :"+e.toString());
	
		}
	

	}

}
