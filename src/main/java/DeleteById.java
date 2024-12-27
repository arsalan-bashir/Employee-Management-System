

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

@WebServlet("/DeleteById")
public class DeleteById extends HttpServlet {
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
    	ResultSet rs = null;
    	String sql = "DELETE FROM employees WHERE emp_id=?";
    	String fetchSql = "SELECT * FROM employees WHERE emp_id=?";
    	
    	String id = req.getParameter("id");
    	
    	try {
    		int nora = -1;
    		ps = con.prepareStatement(fetchSql);
    		ps.setString(1, id);
    		
    		rs = ps.executeQuery();
    		
    		if(rs.next()) {
    			ps = con.prepareStatement(sql);
    			ps.setString(1, id);
    			
    			nora = ps.executeUpdate();
    		}
    		
    		req.setAttribute("nora", String.valueOf(nora));
    		req.setAttribute("id", id);
    		req.getRequestDispatcher("delete.jsp").forward(req, res);
    	}
    	catch(Exception e) {
    		throw new ServletException("Error Deleting Record: " + e.getMessage());
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
    }
}
