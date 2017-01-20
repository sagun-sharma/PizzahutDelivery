package dbtest;

import java.sql.*;

public class DBRunner {

	public static void main(String args[]) throws SQLException{
		DBConnection d1 = new DBConnection();
		DBOperations d = new DBOperations(d1);
		ResultSet rs=null;
		d1.getConnection();
		d.insert();
		rs=d.select();
	}
}
