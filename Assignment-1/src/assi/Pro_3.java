package assi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Pro_3
 */
@WebServlet("/Pro_3")
public class Pro_3 extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter pw = response.getWriter();
		
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
