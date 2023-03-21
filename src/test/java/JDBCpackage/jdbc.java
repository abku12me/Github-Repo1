package JDBCpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class jdbc {
	@Test
	public void Mysql() throws SQLException
	{
		Connection con=null;
		try {
		// Step 1: Register the database
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		
		//step 2: //get the connection
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");
		
		// step 3: Issue the create statement 
		Statement sta=con.createStatement();
		
		// step 4: Execute the query
		// update the query
		int result=sta.executeUpdate("update qspiders set Name='Ranjani' where id=2497;");
		if(result>=1)
		{
			System.out.println(result+" Updated");
		}
		
		//
		ResultSet result1=sta.executeQuery("select * from qspiders;");
		while(result1.next())
		{
			System.out.println(result1.getString(1)+" "+result1.getString(2)+" "+result1.getInt(3));
					
		}
		}
		finally {
		
		//step 5: close the database
		con.close();
		}
		
		
		
	}
	

}
