package com.hotel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Reviews
 */
@WebServlet("/Reviews")
public class Reviews extends HttpServlet {
	private static final long serialVersionUID = 1;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String emailaddress = request.getParameter("emailaddress");
		String comment = request.getParameter("comment");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database", "root", "Mysqlworkbench");
			Statement st = con.createStatement();
			ResultSet rs;
			int i = st.executeUpdate("insert into reviews values('"+firstname+"','"+lastname+"','"+emailaddress+"','"+comment+"')");
			}catch(Exception e){
				System.out.println(e);
			}
		response.sendRedirect("reviews.html");
	}
}
