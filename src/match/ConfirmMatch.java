package match;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBConnection;

/**
 * Servlet implementation class ConfirmMatch
 */
@WebServlet("/ConfirmMatch")
public class ConfirmMatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmMatch() {
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
		int userId=Integer.parseInt(request.getParameter("user_id"));
		int searchID=Integer.parseInt(request.getParameter("search_id")) ;
		int foundID=Integer.parseInt(request.getParameter("found_id"));
		String info=request.getParameter("info");
		Connection conn =DBConnection.getActiveConnection();
		  if(conn!=null)
			{
			   // String sql="delete from matches where searchID="+searchID+" and foundID="+foundID;
			    String sql2="insert into correctmatch (userid,info,searchID,matchID) values ("+userId+",'"+info+"',"+searchID+","+foundID+")";
				PreparedStatement stmt ;
				PreparedStatement stm2;
				try {
				//	stmt =conn.prepareStatement(sql);
					stm2=conn.prepareStatement(sql2);
					//stmt.executeUpdate();
					stm2.executeUpdate();
					conn.close();
					//stmt.close();
					stm2.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
	response.sendRedirect("NewFile.jsp");
	}
	}