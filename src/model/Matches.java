package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBConnection;

public class Matches {

	public void deleteBadMatch(int searchID ,int foundID) throws SQLException
	{
		  Connection conn =DBConnection.getActiveConnection();
		  if(conn!=null)
			{
			    String sql="delete from matches where searchID="+searchID+" and foundID="+foundID;
				PreparedStatement stmt ;
				stmt =conn.prepareStatement(sql);
				stmt.executeUpdate();
				conn.close();
				stmt.close();
			}
		
	}
	public void confirmMatch()
	{
		
	}
}
