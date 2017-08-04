package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	public Connection getConnection(){
		Connection con = null;
		try{	
		// step1 load the driver class
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// step2 create the connection object
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "password");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}
}
