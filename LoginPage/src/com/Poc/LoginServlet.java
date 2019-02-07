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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String u = request.getParameter("uname");
		String p = request.getParameter("pass");

		try {
			if (u.equals(DaoFactory.checkUsername(u)) && p.equals(DaoFactory.checkPassword(u))) {

				RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
				rd.forward(request, response);
			} else {

				RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
				rd.forward(request, response);

			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			RequestDispatcher rd = request.getRequestDispatcher("error1.jsp");
			rd.forward(request, response);
			e.printStackTrace();
		}

	}
}
