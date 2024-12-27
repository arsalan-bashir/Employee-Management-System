

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddEmployee")
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
       
	public void init() throws ServletException{
		try {
			con = ConnectDB.getInstance().getConnection();
		} 
		catch (SQLException e) {
			throw new ServletException("DB Connection Error: "+e.getMessage());
		}
	}
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PreparedStatement ps = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "INSERT into employees VALUES (?,?,?,?,?,?)";
		String fetchSql = "SELECT * FROM employees WHERE emp_id=?";
		
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		int salary = Integer.parseInt(req.getParameter("salary"));
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		try {
			int nora;
			// Check for existing data with the id
			stmt = con.prepareStatement(fetchSql);
			stmt.setString(1,id);
			rs = stmt.executeQuery();
			
			if(!rs.next()) {
				ps = con.prepareStatement(sql);
				
				ps.setString(1,id);
				ps.setString(2, name);
				ps.setInt(3, salary);
				ps.setString(4, email);
				ps.setString(5, phone);
				ps.setString(6, address);
				
				nora = ps.executeUpdate();
			}
			else {
				nora = -1;
			}
			
			req.setAttribute("nora", String.valueOf(nora));
			req.getRequestDispatcher("add.jsp").forward(req, res);
		}
		catch(Exception e) {
			throw new ServletException("Insertion Error: " +e.getMessage());
		}
		finally {
			try {
				if(ps != null) ps.close();
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
