package pro_6;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String sno=request.getParameter("txtno");
	       String sname =request.getParameter("txtname");
		
			try
			{  
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				String url ="jdbc:oracle:thin:@localhost:1521:XE";
				String user = "system";
				String password = "system";
				Connection conn = DriverManager.getConnection(url, user, password);
				System.out.println("connection done");
				
				Statement stmt = conn.createStatement();
				//stmt.execute("create table clstmt(sno varchar(5),sname varchar(30))");
				
//				String q = "insert into clstmt (sno,sname) ";
//				q += "values (?,?)";
				
				CallableStatement clstmt = conn.prepareCall("{CALL add(?,?)}");
				
				//clstmt.setString(1, "102");
				//clstmt.setString(2, "Rahul");
				
				clstmt.setString(1,sno);
				clstmt.setString(2,sname);
				
				int no = clstmt.executeUpdate();
				
				clstmt.close();
				conn.close();
				
				System.out.println("record inserted");
			}
			catch(Exception e)
			{
				System.out.println("Exception :"+ e);
			}
	}

}
