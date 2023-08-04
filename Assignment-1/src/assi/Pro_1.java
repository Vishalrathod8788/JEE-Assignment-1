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
	
	String URL, Username, Password, drvr;
	Connection cnn;
	
	public boolean mySQLCnn() {
		URL = "jdbc:mysql://localhost:3306/mysql";
		Username = "root";
		Password = "";
		drvr = "com.mysql.jdbc.Driver";

		try {
			Class.forName(drvr);
			cnn = DriverManager.getConnection(URL, Username, Password);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
    
	public boolean ORCLCnn() {
		URL = "jdbc:oracle:thin:@localhost:1521:orcl";
		Username = "system";
		Password = "system";
		drvr = "oracle.jdbc.driver.OracleDriver";

		try {
			Class.forName(drvr);
			cnn = DriverManager.getConnection(URL, Username, Password);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean AccessCnn() {

		URL = "jdbc:ucanaccess://D://Java//Java_Assignment//J2EE//DB//jdbc_dbAccess.accdb";
		Username = "";
		Password = "";
		drvr = "net.ucanaccess.jdbc.UcanaccessDriver";

		try {
			Class.forName(drvr);
			cnn = DriverManager.getConnection(URL, Username, Password);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		if (mySQLCnn() == true) {
			out.println("<h2>MySQL Connected</h2>");
		}
		
		if (ORCLCnn() == true) {
			out.println("<h2>Oracle Connected</h2>");
		}
		
		if (AccessCnn() == true) {
			out.println("<h2>Access Connected</h2>");
		}

	}

}
