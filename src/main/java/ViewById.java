

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.print.attribute.PrintJobAttribute;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ViewById")
public class ViewById extends HttpServlet {
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
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM employees WHERE emp_id=?";
		String action = req.getParameter("action");
		
		String id = req.getParameter("id");
		Employee emp = null;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				emp = new Employee();
				emp.setId(rs.getString(1));
				emp.setName(rs.getString(2));
				emp.setSalary(rs.getInt(3));
				emp.setEmail(rs.getString(4));
				emp.setPhone(rs.getString(5));
				emp.setAddress(rs.getString(6));
			}
			
		}
		catch(Exception e) {
			throw new ServletException("Error Fetching Employee by ID " + e.getMessage());
		}
		
		finally {
			try {
				if(ps != null) ps.close();
				if(rs != null) rs.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		req.setAttribute("employee", emp);
		
		if(action.equals("view")) {
			req.getRequestDispatcher("viewById.jsp").forward(req, res);
		}
		else if(action.equals("update")) {
			if(emp != null ) {
				//req.setAttribute("nora", 0);
				req.getRequestDispatcher("update.jsp").forward(req, res);
			}
			else {
				req.getRequestDispatcher("updateById.jsp").forward(req, res);
			}
		}
	}
}
