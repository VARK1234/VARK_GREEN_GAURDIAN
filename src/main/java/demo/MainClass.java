package demo;

import java.sql.*;

import database.DBConnection;

class MainClass {
	
	private static DBConnection dbConnection;
	
	public static void main(String args[]) {
		dbConnection = new DBConnection();
		Connection con = null;
		try {
			
			con = dbConnection.getConnection();

			// step3 create the statement object
			Statement stmt = con.createStatement();

			// step4 execute query
			System.out.println("Location");
			ResultSet rs = stmt.executeQuery("select * from location");
			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			
			
			// step5 close the connection object
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}