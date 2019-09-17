package librarydata;
import java.sql.*;
public class Dbconnection {
	static Dbconnection get=new Dbconnection();
	private Connection connect;

	public Connection connectDb() throws SQLException 
	{
	try 
	{
	Class.forName("com.mysql.jdbc.Driver");
	connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
	} 
	catch (Exception e) 
	{
	System.out.println(e);
	}
	return connect;
	}
}
