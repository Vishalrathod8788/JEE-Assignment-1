package pro3;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String no = request.getParameter("txtno");
		String name = request.getParameter("txtname");
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "system";
			String password = "system";
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connection Done");
			
			Statement stmt = conn.createStatement();
			//stmt.execute("create table student_info (sno varchar(5),sname varchar(30))");
			
			String q="insert into student values(";
			q+="'"+no+"',";
			q+="'"+name+"')";
			
			stmt.execute(q);
			
			conn.close();
			System.out.println("record inserted");
		} 
		catch (Exception e) 
		{
			System.out.println("Error :" + e);
		}
	}

}
