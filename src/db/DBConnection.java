package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection connection = null;
	public static Connection getActiveConnection (){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/facehub?"
			+"user=root&password=root&characterEncoding=utf8");
			return connection ;
		} catch (SQLException e) {
			 System.err.println("SQLException: ");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			 System.err.println("Error loading driver: ");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null ;
	}
}
