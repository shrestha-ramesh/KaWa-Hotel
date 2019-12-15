package com.hotel;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Hotel")
public class Hotel extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String check = request.getParameter("checkin");
		String check1 = request.getParameter("checkout");
		String check2 = request.getParameter("people");
		String check3 = request.getParameter("firstname");
		String check4 = request.getParameter("lastname");
		HttpSession session = request.getSession();
		session.setAttribute("check3", check);
		if(check != "" && check1 !="" && check2 !="" &&check3 !="" && check4 != "") {
			String[] date = check.split("-");
			String[] date1 = check1.split("-");
			int people = Integer.parseInt(check2);
			int d10 = Integer.parseInt((date[0]));
			int d11 = Integer.parseInt((date[1]));
			int d12 = Integer.parseInt((date[2]));
			int d20 = Integer.parseInt((date1[0]));
			int d21 =  Integer.parseInt((date1[1]));
			int d22 = Integer.parseInt((date1[2]));
			int d1 = d10 - d20;
			int d2 = d11 - d21;
			int d3 = d12 - d22;	
			if(d1 <= 0 && d2 <= 0) {
				if(d2 < 0) {
					int d4 = 32 - d12;
					int d6 = d4 + d22;
					int cost = 100 + 50*(people-1);
					int total = cost*d6;
					request.setAttribute("Total",total);
					request.getRequestDispatcher("hotel.jsp").forward(request, response);
				}
				else if(d2 == 0 && d3 < 0) {
					int d5 = d22 - d12;
					int cost = 100 + 50*(people-1);
					int total = cost*d5;
					request.setAttribute("Total",total);
					request.setAttribute("checkin",check);
					request.setAttribute("checkout",check1);
					request.setAttribute("people",check2);
					request.getRequestDispatcher("hotel.jsp").forward(request, response);
				}
				else {
					response.sendRedirect("hotel.html");
				}
			}
			else {
				response.sendRedirect("hotel.html");
			}
		}
		else {
			response.sendRedirect("hotel.html");
		}
	}
}
