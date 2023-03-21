package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class JDBCExecuteQuery {
	@Test
	public void DBconnection() throws SQLException
	{
		//import from MySql package
		Driver driverref=new Driver();
		
		
		//step 1: Register the driver/databases
		DriverManager.registerDriver(driverref);
		
		//step 2: Get the connection
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/advanceselenium", "root", "root");
		
		//step 3:issue create the statement
		Statement stm=con.createStatement();
		
		//step 4: Execute the query
		ResultSet result=stm.executeQuery("select * from selenium");
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getInt(2)+" "+result.getString(3));
			
		}
		
		//update the data
		
		int update=stm.executeUpdate("update selenium set Emp_name='karen' where Emp_address='USA'");
		System.out.println(update);
		
		//create the table
		//int table=stm.executeUpdate("create table qspider(Name varchar(23) not null,id int(12) unique,address varchar(24) not null);");
		//System.out.println(table);
		
		//insert the record into the table
		
		//int record=stm.executeUpdate("insert into qspider values('mishra',23,'bangalore'),('kumar',34,'mumbai')");
	   // System.out.println(record);
		
		
		
		//step 5: close the database
		con.close();
		System.out.println("DB closed");
		
		
		
		
		
		
		
		
	}
	

}
