package match;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import db.DBConnection;

/**
 * Servlet implementation class DeleteMatch
 */
@WebServlet("/DeleteMatch")
public class DeleteMatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");	       
	        
	    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMatch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int searchID=Integer.parseInt(request.getParameter("search_id")) ;
		int foundID=Integer.parseInt(request.getParameter("found_id"));
		Connection conn =DBConnection.getActiveConnection();
		  if(conn!=null)
			{
			    String sql="delete from matches where searchID="+searchID+" and foundID="+foundID;
				PreparedStatement stmt ;
				try {
					stmt =conn.prepareStatement(sql);
					stmt.executeUpdate();
					conn.close();
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
	response.sendRedirect("NewFile.jsp");
	}

}
