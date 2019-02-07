package com.Poc;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.DaoFactory;
import com.Entity.Userdata;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String a  = request.getParameter("fname");	
	String b  = request.getParameter("lname");	
	String c  = request.getParameter("email");	
	String d  = request.getParameter("uname");	
	String e  = request.getParameter("pass");	
	if(passwordValidation(e)) {
	try {
		DaoFactory.addUserdata(a, b, c, d, e);
		
		RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}
	}
	else {
		RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
		rd.forward(request, response);
	}
	

	
	
	}
	public boolean passwordValidation(String password) {
		boolean valid = true;
		if (password.length() < 8) {
			valid = false;
		}

		String uppercase = "(.*[A-Z].*)";
		if (!password.matches(uppercase)) {
			valid = false;
		}

		String lowercase = "(.*[a-z].*)";
		if (!password.matches(lowercase)) {
			valid = false;
		}
		String numbers = "(.*[0-9].*)";
		if (!password.matches(numbers)) {
			valid = false;
		}

		String specialChars = "(.*[,~,!,@,#,$,%,^,&,*].*$)";
		if (!password.matches(specialChars)) {
			valid = false;
		}

		return valid;

	}

}
