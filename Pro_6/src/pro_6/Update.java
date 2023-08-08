package pro_6;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		   String sno=request.getParameter("txtno");
	       String sname =request.getParameter("txtname");
		
		
			try
			{  
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				String url = "jdbc:oracle:thin:@localhost:1521:XE";
				String user = "system";
				String password = "system";
				Connection conn = DriverManager.getConnection(url, user, password);
				
				//String q="update pstmt set sname=? where sno=?";
				CallableStatement clstmt = conn.prepareCall("{CALL add(?,?)}");
		 		clstmt.setString(1, sname);
		 		clstmt.setInt(2, Integer.valueOf(sno));
		 		
		 		int no=clstmt.executeUpdate();
		 		clstmt.close();

				System.out.println("record updated");
			}
			catch(Exception e)
			{
				System.out.println("Exception :"+ e);
			}
		
	}

}
