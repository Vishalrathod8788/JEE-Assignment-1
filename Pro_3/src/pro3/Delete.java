package pro3;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String no = request.getParameter("txtno");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "system";
			String password = "system";
			Connection conn = DriverManager.getConnection(url, user, password);

			
			//String q = "update stud set sname=? where srno=?";
			
			Statement stmt = conn.createStatement();
			
			String q = "delete from student where no="+no+"";
			stmt.execute(q);

			stmt.close();
			conn.close();
			System.out.println(no + "row(s) Deleted");
		} catch (Exception e) {
			System.out.println("Error :" + e);
		}
	}

}
