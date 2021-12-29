package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertDataIntoDatabase {

	public static void main(String[] args) throws SQLException {
		
		//register the database
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//connection with the database
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		
		//issue the statement
		Statement statement = connection.createStatement();
		
		//execute query
	    int result = statement.executeUpdate("insert into studentsinfo (fname,lname,address) value('priya','das','india')");
	    if(result==1)
	    {
	    	System.out.println("data is added into database");
	    }
	    else
	    {
	    	System.out.println("data is not added into dtabase");
	    }
	    
		//close the database
	    connection.close();
	}
}
