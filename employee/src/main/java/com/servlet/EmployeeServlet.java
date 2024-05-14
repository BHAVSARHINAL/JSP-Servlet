package com.servlet;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDao;
import com.entity.Employee;
/**
 * <h3>This class represents that save employee data.</h3>*
 * @author : Hinal Bhavsar
 * @version 1.01 08-05-2024
 */
@WebServlet("/register")
public class EmployeeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public EmployeeServlet() {
		super();
	}

	// Post mapping
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee employee = new Employee();
		employee.setFirstName(request.getParameter("firstname"));
		employee.setLastName(request.getParameter("lastname"));
		employee.setUserName(request.getParameter("username"));
		employee.setPassword(request.getParameter("password"));
		employee.setAddress(request.getParameter("address"));
		employee.setContactNumber(request.getParameter("contact"));

		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String contactNumber = request.getParameter("contact");

		Map<String, String> errors = new HashMap<String, String>();
		if (firstName.isEmpty()) {
			errors.put("firstname", "<b>Enter valid first name.</b>");
		}
		if (!Pattern.matches("[a-zA-Z]*", firstName)) {
			errors.put("firstname", "<b>Please enter alphabet characters only.</b>");
		}
		if (lastName.isEmpty()) {
			errors.put("lastname", "<b>Enter valid last name.</b>");
		}
		if (!Pattern.matches("[a-zA-Z]*", lastName)) {
			errors.put("lastname", "<b>Please enter alphabet characters only.</b>");
		}
		if (userName.isEmpty()) {
			errors.put("username", "<b>Enter valid user name.</b>");
		}
		if (password.isEmpty() || !Pattern.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{6,}$", password)) {
			errors.put("password", "<b>Enter minimum 6 value in password [ex: Abc@12]</b>");
		}
		if (address.isEmpty()) {
			errors.put("address", "<b>Enter valid address.</b>");
		}
		if (!Pattern.matches("\\d{10}", contactNumber)) {
			errors.put("contact", "<b>Enter only digits, characters are not allow.</b>");
		}
		if (contactNumber.isEmpty()) {
			errors.put("contact", "<b>Enter valid contact number.</b>");
		}
		
		RequestDispatcher dispatcher = null;
		if (errors.isEmpty()) {
			int value = new EmployeeDao().setEmployeeDetails(employee);
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("errors", errors);
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		}
	}

}