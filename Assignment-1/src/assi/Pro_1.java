package assi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Pro_1")
public class Pro_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String URL, Username, Password, Qry;
	Connection cnn;
	
	public void mySql()
	{
		URL = "jdbc:mysql://localhost:3306/mysql";
		Username = "root";
		Password = "";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			cnn = DriverManager.getConnection(URL);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
				
		
	}

}
