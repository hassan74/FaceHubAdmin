package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;

import db.DBConnection;

public class GetReports {
	
	ArrayList<Report> reports =new ArrayList<Report>();
	public HashMap<Integer,ArrayList> getReport () throws SQLException
	{
		int searchid=0;
		String sql="select * from matches";
		Connection conn =DBConnection.getActiveConnection();
//		   try {
//	            Class.forName("com.mysql.jdbc.Driver");
//	        } catch (ClassNotFoundException cnfe) {
//	            System.err.println("Error loading driver: " + cnfe);
//	        }
//        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/facehub", "root", "root");
//		
        if(conn!=null)
		{
			PreparedStatement stmt ;
			//stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt =conn.prepareStatement(sql);
			ResultSet resultSet= stmt.executeQuery();
		    HashMap<Integer,ArrayList> map = new HashMap<Integer, ArrayList>();           
			while(resultSet.next())
			{
				  searchid =resultSet.getInt("searchID");
				 int foundid =resultSet.getInt("foundID");
				 ArrayList<Integer> temparr=new ArrayList<Integer>();
				 if(map.get(searchid)!=null)
				 {
				  temparr=map.get(searchid);
				 }
				  temparr.add(foundid);
				  map.put(searchid, temparr);
			}
			
			conn.close();
			stmt.close();
			return map ;
		}
		else
		{
			return null;
		}
	}
	
}
