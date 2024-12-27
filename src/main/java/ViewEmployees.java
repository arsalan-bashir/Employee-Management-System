import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewEmployees")
public class ViewEmployees extends HttpServlet {
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
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM employees";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			ArrayList<Employee> employeeList = new ArrayList<>();
			
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getString("emp_id"));
				emp.setName(rs.getString("emp_name"));
				emp.setSalary(rs.getInt("salary"));
				emp.setEmail(rs.getString("email"));
				emp.setPhone(rs.getString("phone"));
				emp.setAddress(rs.getString("address"));
				
				employeeList.add(emp);
			}
			
			req.setAttribute("employeeList", employeeList);
			
			req.getRequestDispatcher("viewEmployees.jsp").forward(req, res);
		}
		catch(Exception e) {
			throw new ServletException("Error Fetching Employee List: " + e.getMessage());
		}
		finally {
				try {
					if(rs != null) rs.close();
					if(stmt != null) stmt.close();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
		}
		
	}

	public void destroy() {
		try {
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
