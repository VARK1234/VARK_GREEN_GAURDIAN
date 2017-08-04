package demo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import database.DBConnection;

public class InsertMain {
	
private static DBConnection dbConnection;
	
	public static void main(String args[]) {
		dbConnection = new DBConnection();
		Connection con = null;
		Statement stmt = null;
		try {
			
			con = dbConnection.getConnection();
			String query = "INSERT INTO LOCATION values ('100002', '73.707016','18.599371','Kanpur') ";
			
			stmt = con.createStatement();
			stmt.executeUpdate(query);
		}
		catch(Exception e){
			
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
