package com.Dao;

import java.sql.*;

public class DaoFactory {

	public static void addUserdata(String fname, String lname, String email, String uname, String password)
			throws SQLException, ClassNotFoundException {
		Class.forName("org.h2.Driver");

		String url = "jdbc:h2:tcp://localhost/~/Login";
		String username = "sa";
		String pass = "";
		String sql = "insert into userdata values(?,?,?,?,?)";

		Connection con = DriverManager.getConnection(url, username, pass);
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, fname);
		st.setString(2, lname);
		st.setString(3, email);
		st.setString(4, uname);
		st.setString(5, password);
		st.executeUpdate();
		st.close();
		con.close();

	}

	public static String checkUsername(String u) throws ClassNotFoundException, SQLException {
		Class.forName("org.h2.Driver");
		String pass = "";
		String url = "jdbc:h2:tcp://localhost/~/Login";
		String username = "sa";
		String sql = "select uname from userdata where uname='" + u + "'";

		Connection con = DriverManager.getConnection(url, username, pass);
		Statement st = con.createStatement();

		ResultSet rs=st.executeQuery(sql);
		rs.next();
		String a=rs.getString(1);
		st.close();
		con.close();
		return a;
	}

	public static Object checkPassword(String u) throws ClassNotFoundException, SQLException {

		Class.forName("org.h2.Driver");
		String pass = "";
		String url = "jdbc:h2:tcp://localhost/~/Login";
		String username = "sa";
		String sql = "select pass from userdata where uname='" + u + "'";

		Connection con = DriverManager.getConnection(url, username, pass);
		Statement st = con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		rs.next();
		String a=rs.getString(1);
		st.close();
		con.close();
		return a;
	}

}
