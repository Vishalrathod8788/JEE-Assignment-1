package assi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Pro_4")
public class Pro_4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter pw = response.getWriter();
		Connection cnn;
		PreparedStatement pr;
		
		String URL = "jdbc:mysql://localhost:3306/Student";
		String Username = "root";
		String Password = "";
		String sql = "";
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			pw.println("Class Load...");
			
			cnn = DriverManager.getConnection(URL, Username, Password);
			pw.println("Connection Successfuly...");
			
			int i = 0;
			Scanner sc = new Scanner(System.in);
			
			do {
				
			} while (i > 0);
			
		} catch (Exception e) 
		{
			// TODO: handle exception
		}
	}

}
