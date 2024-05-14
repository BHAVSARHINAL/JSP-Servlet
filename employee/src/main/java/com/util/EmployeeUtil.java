package com.util;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 * <h3>This class represents that connection with database.</h3>
 * @author : Hinal Bhavsar
 * @version 1.01 08-05-2024
 */
public class EmployeeUtil {

	Connection connection = null;
	// connection with database
	public Connection getEmployeeConnection() {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeRegistration", "root", "root");
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return connection;
	}

}