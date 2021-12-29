package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class VerifyData_db {

	public static void main(String[] args) throws SQLException {
		
		Connection connection=null;

		try
		{
		String expectedname = "ranjitha";
		//register database
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		//connection establishment
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		
		//issue statement
		Statement statement = connection.createStatement();
		
		//execute query
		ResultSet result = statement.executeQuery("select * from studentsinfo");
		while(result.next())
		{
			if(result.getString(2).equals(expectedname))
				{
				System.out.println("passed");
				}
			
		}
		}
		catch(Exception e)
		{
			
		}
		finally
		{
		
		//close database
		connection.close();
		
		}
				

	}

}
