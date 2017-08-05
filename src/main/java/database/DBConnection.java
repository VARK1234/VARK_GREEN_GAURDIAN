package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	static Connection con;
	public static Connection useConnection(){
		return con;
	}
	
	public static Connection getConnection(){
		try{	
		// step1 load the driver class
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// step2 create the connection object
		con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.22.65:1521:xe", "system", "password");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}
}
