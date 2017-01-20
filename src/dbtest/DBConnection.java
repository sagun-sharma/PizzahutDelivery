package dbtest;

import java.sql.*;
import java.sql.Connection;

public class DBConnection {
	
	// singleton
	public Connection getConnection(){
	Connection c = null;
	Statement stmt = null;
	
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "postgres", "sagun");
			System.out.println("Opened database successfully");
			stmt = c.createStatement();
			String sql = "CREATE TABLE if not exists employee2" + "(eid int PRIMARY KEY NOT NULL," + "name text NOT NULL,"
					+ "age int NOT NULL," + "dpt char(50) )";
			stmt.executeUpdate(sql);
			
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		} finally {
			
		}
		System.out.println("Table created successfully");
		return c;
	}
}
