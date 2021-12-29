package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class VerifyTheFromDatabase {

	public static void main(String[] args) throws SQLException {
		
		String expectedname="smith";
		
		//register the database
				Driver driver = new Driver();
				DriverManager.registerDriver(driver);
				
				//connection with the database
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
				
				//issue the statement
				Statement statement = connection.createStatement();
				
				//execute query
				 ResultSet result = statement.executeQuery("select * from studentsinfo");
				    while(result.next()) {
				    	if(result.getString(2).equals(expectedname))
				    	{
				    		System.out.println("passed");
				    	}
				    }
				    
				    //close
				    connection.close();

	}

}
