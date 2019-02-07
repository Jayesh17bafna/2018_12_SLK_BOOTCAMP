<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.label-color{
 background-color: 	#800080;
  color: white;
}
table, th, td {
  border: 1px solid black;
  padding:5px;
}
table {
  border-spacing: 15px;
}

table tr:nth-child(even) {
  background-color:#FF0000;
}
table tr:nth-child(odd) {
 background-color: #fff;
}
table th {
  background-color: black;
  color: white;
}
</style>
</head>
<body>

	<form action="RegisterServlet" method="POST">
		<center>
			<table>
				<thead>
					<tr>
					<th> Enter your Information</th>
					</tr>
				</thead>

				<tbody>
					<tr>
						<td class="label-color">First Name</td>
						<td><input type="text" name="fname" value="" /></td>
					</tr>
					<tr>
						<td>Last Name</td>
						<td><input type="text" name="lname" value="" /></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><input type="text" name="email" value="" /></td>
					</tr>
					<tr>
						<td>User Name</td>
						<td><input type="text" name="uname" value="" /></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="pass" value="" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Submit"  /></td>
						<td><input type="reset" value="Reset" /></td>
					</tr>


				</tbody>

			</table>
		</center>
	</form>

</body>
</html>