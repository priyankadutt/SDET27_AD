package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertData_db {

	public static void main(String[] args) throws SQLException {
		
		//register database
		Driver driver=new Driver();
        DriverManager.registerDriver(driver);
        
        //connection establishment
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
        
        //issue statement
        Statement statement = connection.createStatement();
        
        //execute query
        int result = statement.executeUpdate("insert into studentsinfo(fname,lname,address) value('ranjitha','rt','india')");
        if(result==1)
        {
        	System.out.println("data added");
        }
        else
        {
        	System.out.println("data not added");
        }
        
        //close database
        connection.close();
	}

}
