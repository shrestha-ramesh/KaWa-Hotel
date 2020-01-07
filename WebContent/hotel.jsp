<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "javax.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color:#e6ffff">
	<%
		if(session.getAttribute("check3")== null){
			response.sendRedirect("hotel.html");
		}
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String checkin = request.getParameter("checkin");
		String checkout = request.getParameter("checkout");
		String people = request.getParameter("people");
		String InOut = "After 4:00 PM Before 11:00 AM";
		int total = (int)request.getAttribute("Total");
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database", "root", "Mysqlworkbench");
		Statement st = con.createStatement();
		ResultSet rs;
		int id = 0;
		rs = st.executeQuery("select * from hotel");
		if(rs.last()){
			id = rs.getInt("id");
			id = id + 1;
		}
		int i = st.executeUpdate("insert into hotel values('"+firstname+"','"+lastname+"','"+checkin+"','"+checkout+"','"+people+"','"+InOut+"','"+total+"','"+id+"')");
		}catch(Exception e){
			out.println(e);
		}
	%>
<div style ="background-color:#ffff80"><h1>KaWa Hotel</h1>
		<table style ="margin:auto; background-color:#b3b300">
			<tr>
				<td style ="font-size:25px; width:200px"><a href="hotel.html">Home</a></td>
				<td style ="font-size:25px; width:200px"><a href="location.html">Location</a></td>
				<td style ="font-size:25px; width:200px"><a href="photos.html">Photos</a></td>
				<td style ="font-size:25px; width:200px"><a href="aboutus.html">About Us</a></td>
				<td style ="font-size:25px; width:200px"><a href="contactus.html">Contact Us</a></td>
				<td style ="font-size:25px; width:200px"><a href="reviews.html">Reviews</a></td>
			</tr>
		</table>
	</div>
	<table style ="background-color:#d9d9d9; margin:auto; border:1px solid black; margin-top:200px">
		<tr>
			<td style ="font-size:30px; padding:20px"><%=firstname%></td>
			<td style ="font-size:30px; padding:20px"><%=lastname%></td>
		</tr>
		<tr>
			<td style ="font-size:20px; padding:20px">Check In</td>
			<td style ="font-size:20px; padding:20px">Check Out</td>
		</tr>
		<tr>
			<td style ="font-size:20px; padding:20px">After 4:00 PM</td>
			<td style ="font-size:20px; padding:20px">Before 11:00 AM</td>
		</tr>
		<tr>
			<td style ="font-size:20px; padding:20px">${checkin}</td>
			<td style ="font-size:20px; padding:20px">${checkout}</td>
		</tr>
		<tr>
			<td style ="font-size:20px; padding:20px">Person</td>
			<td style ="font-size:20px; padding:20px">${people}</td>
		</tr>
		<tr>
			<td style ="font-size:20px; padding:20px">Total:</td>
			<td style ="font-size:20px; padding:20px">${Total}</td>
		</tr>
		<tr>
			<td style ="font-size:20px; padding:20px"><button onclick="myFunction()">Confirmed</button></td>
		</tr>
	</table>
	<script>
		function myFunction(){
			var r = confirm("Do you want to booked Room");
			if(r == true){
				window.open("photos.html","_self");
			}
			else{
				window.open("hotel.html","_self");
			}
		}
	</script>
</body>
</html>