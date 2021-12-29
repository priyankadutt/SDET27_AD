package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class GetTheDataFromDatabase {

	public static void main(String[] args) throws SQLException {
		
		
		//register the database
	    Driver driver = new Driver();
	    DriverManager.registerDriver(driver);
	    
	    
		//establish the connection with  database
	     Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
	     
	     
		//issue the statement
	    Statement statement = connection.createStatement();
	    
	    
		//execute the query
	    ResultSet result = statement.executeQuery("select * from studentsinfo");
	    while(result.next()) {
	    	System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
	    }
	    
	    
		//close the database
	    connection.close();

	}

}
