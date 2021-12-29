package com.rmgyantra.testSript;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class AddProject_db {

	public static void main(String[] args) throws SQLException {
		
		Connection connection=null;
		try
		{
		
		//register database
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		//connection establishment
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		//issue statement
		Statement statement = connection.createStatement();
		//execute query
		int result = statement.executeUpdate("insert into project(project_id,created_by,created_on,project_name,status,team_size) value('TY_PROJ_300','ranjitha','16/12/2021','laptop','on going','1')");
        if(result==1)
        {
        	System.out.println("data added");
        }
		
		String expectedProjectName = "laptop";
		ResultSet result1 = statement.executeQuery("select * from project");
		while(result1.next())
		{
			if(result1.getString(4).equals(expectedProjectName))
			{
				System.out.println("project name present");
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
