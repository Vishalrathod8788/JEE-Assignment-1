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
	
	public boolean mySQLCnn() {
		url = "jdbc:mysql://localhost:3306/mysql";
		user = "root";
		pass = "";
		drvr = "com.mysql.jdbc.Driver";

		try {
			Class.forName(drvr);
			cnn = DriverManager.getConnection(url, user, pass);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
	}

}
