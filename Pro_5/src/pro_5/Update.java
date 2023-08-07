package pro_5;

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


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String sno=request.getParameter("txtno");
	       String sname =request.getParameter("txtname");
		
		
			try
			{  
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				String url = "jdbc:oracle:thin:@localhost:1521:XE";
				String user = "system";
				String password = "system";
				Connection conn = DriverManager.getConnection(url, user, password);
				
				String q="update pstmt set sname=? where sno=?";
				PreparedStatement ps=conn.prepareStatement(q);
		 		ps.setString(1, sname);
		 		ps.setInt(2, Integer.valueOf(sno));
		 		
		 		int no=ps.executeUpdate();
		 		ps.close();
					//stmt.execute(q);
				System.out.println("record updated");
			}
			catch(Exception e)
			{
				System.out.println("Exception :"+ e);
			}
		
	}

}
