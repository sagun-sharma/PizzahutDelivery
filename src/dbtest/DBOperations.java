package dbtest;

import java.sql.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBOperations {
	Connection c = null;
    Statement stmt = null;
    ResultSet rs=null;
    
    public DBOperations(DBConnection conn) {
		// TODO Auto-generated constructor stub
    	c = conn.getConnection();
	}
	public void insert() throws SQLException{
	
    try
    {

       stmt = c.createStatement();
       String sql = "INSERT INTO employee2 (eid,name,age,dpt) "
             + "VALUES (1, 'abc', 32, 'development');";
       stmt.executeUpdate(sql);

       sql = "INSERT INTO employee2 (eid,name,age,dpt) "
             + "VALUES (2, 'xyz', 25, 'testing');";
 stmt.executeUpdate(sql);
    }catch (Exception e) {
        System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        System.exit(0);
     }
    finally{
    	
       stmt.close();
       c.commit();
       
    }
       
    
    
    System.out.println("Records created successfully");
 }
	
public ResultSet select() throws SQLException{
	
    try {
       stmt = c.createStatement();
       rs = stmt.executeQuery( "SELECT * FROM employee2;" );
      
          
       }
       catch (Exception e) {
          System.err.println( e.getClass().getName()+": "+ e.getMessage() );
          System.exit(0);
       }
    finally{

        stmt.close();
        c.commit();
        
    }
    System.out.println("Records created successfully");
    return rs;
       
    }
}
