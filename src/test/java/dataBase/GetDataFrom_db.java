package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class GetDataFrom_db {

	public static void main(String[] args) throws SQLException {
		//register driver
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//connection establishment
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		
		//issue statement
		Statement statement = connection.createStatement();
		
		//execute query
		ResultSet result = statement.executeQuery("select * from studentsinfo");
		
		while(result.next())
		{
			System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
			
		}
		
		//close the database
		connection.close();
		
	}
}
