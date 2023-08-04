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
		ResultSet rs;
		
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
				pw.print("Enter a number:");
				i = sc.nextInt();
				switch (i) {
					case 1: {
						sql = "SELECT * FROM tbl_studinfo ORDER BY SBDate";
						pr = cnn.prepareStatement(sql);
						rs = pr.executeQuery();

						while (rs.next()) {
							pw.print("<h4>Ascending Order \"SBDate\" :-</h4>");
							pw.print("<P style='color:Green;'>");
							pw.print(" | " + rs.getInt("SRNO"));
							pw.print(" | " + rs.getString("SNAME"));
							pw.print(" | " + rs.getString("SCITY"));
							pw.print(" | " + rs.getString("SBDATE"));
							pw.print(" | " + rs.getString("SGENDER"));
							pw.print("<br />");
						}
					}
					break;
					case 2: {
						sql = "SELECT * FROM tbl_studeinfo WHERE SGENDER = MALE ORDER BY SCITY DESC";
						pr = cnn.prepareStatement(sql);
						rs = pr.executeQuery();

						while (rs.next()) {
							pw.print("<h4>Descending order of \"SCity\" whose Gender is \"Male\"</h4>");
							pw.print("<P style='color:Green;'>");
							pw.print(" | " + rs.getInt("SRNO"));
							pw.print(" | " + rs.getString("SNAME"));
							pw.print(" | " + rs.getString("SCITY"));
							pw.print(" | " + rs.getString("SBDATE"));
							pw.print(" | " + rs.getString("SGENDER"));
							pw.print("<br />");
						}
					}
					case 3:{
						sql = "SELECT * FROM tbl_studeinfo WHERE SGENDER = MALE ORDER BY SCITY DESC";
						pr = cnn.prepareStatement(sql);
						rs = pr.executeQuery();
						
						while (rs.next()) {
							pw.print("<h4>Descending order of SCity where Scity = \"Jamnagar\" & \"Rajkot\"</h4>");
							pw.print("<P style='color:Green;'>");
							pw.print(" | " + rs.getInt("SRNO"));
							pw.print(" | " + rs.getString("SNAME"));
							pw.print(" | " + rs.getString("SCITY"));
							pw.print(" | " + rs.getString("SBDATE"));
							pw.print(" | " + rs.getString("SGENDER"));
							pw.print("<br />");
						}
					}
				default:
					throw new IllegalArgumentException("Unexpected value: " + i);
				}
			} while (i > 0);
			
		} catch (Exception e) 
		{
			// TODO: handle exception
		}
	}

}
