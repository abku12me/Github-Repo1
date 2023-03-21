package JDBCpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;



public class JDBCpractice {
	
	
	@Test
	public void databaseConn() throws SQLException
	{
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
		Statement sta = con.createStatement();
		String update="update qspiders set Name='Trisha' where id=2321";
		
		int up = sta.executeUpdate(update);
		if(up==1)
		{
			System.out.println(up);
		}
		
		String sqlquery="select * from qspiders";
		ResultSet result = sta.executeQuery(sqlquery);
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getInt(3)+" "+result.getInt(4));
			
		}
		System.out.println(" information fetched");
		con.close();
		
		
		
		
		
	}

}
