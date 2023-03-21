package JDBCpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class databasepractice {
	
	public static void main(String[] args) throws SQLException {
		Driver drive=new Driver();
		DriverManager.registerDriver(drive);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
		Statement sta = con.createStatement();
		String upd="update qspiders set Name='MISHRA' where id=2497;";
		
		int res=sta.executeUpdate(upd);
		if(res==1)
		{
			System.out.println(res+" data updated");
		}
		
		
		
		String query="select * from qspiders;";
		
		ResultSet result = sta.executeQuery(query);
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getInt(3));
		}
		
	}
	
	
	

}
