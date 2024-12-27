

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

@WebServlet("/UpdateEmployee")
public class UpdateEmployee extends HttpServlet {
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
    
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PreparedStatement ps = null;

		String sql = "UPDATE employees SET emp_name = ?, salary=?, email=?, phone=?, address=? WHERE emp_id=?";
		
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		int salary = Integer.parseInt(req.getParameter("salary"));
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(6,id);
			ps.setString(1, name);
			ps.setInt(2, salary);
			ps.setString(3, email);
			ps.setString(4, phone);
			ps.setString(5, address);
			
			int nora = ps.executeUpdate();
			
			req.setAttribute("id", id);
			req.getRequestDispatcher("update.jsp").forward(req, res);
		}
		catch(Exception e) {
			throw new ServletException("Updation Error: "+e.getMessage());
		}
		finally {
			try {
				if(ps != null) ps.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
