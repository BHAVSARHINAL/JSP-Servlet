package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.entity.Employee;
import com.util.EmployeeUtil;
/**
 * <h3>This class represents that insert employee records in database.</h3>
 * @author : Hinal Bhavsar
 * @version 1.01 08-05-2024
 */
public class EmployeeDao {

	// Create method for save data in registration form.
	public int setEmployeeDetails(Employee employee) {
		Connection connection = null;
		int value = 0;
		connection = new EmployeeUtil().getEmployeeConnection();
		String insertQuery = "INSERT INTO Employee(first_name, last_name, user_name, password, address, contact_number) " + "VALUES (?,?,?,?,?,?)";
		try 
		{
			PreparedStatement statement = connection.prepareStatement(insertQuery);
			statement.setString(1, employee.getFirstName());
			statement.setString(2, employee.getLastName());
			statement.setString(3, employee.getUserName());
			statement.setString(4, employee.getPassword());
			statement.setString(5, employee.getAddress());
			statement.setString(6, employee.getContactNumber());
			//executeUpdate through store data in database. 
			value = statement.executeUpdate();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return value;
	}

}