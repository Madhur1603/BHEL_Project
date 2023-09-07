package com.Bhel.form;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String Email = request.getParameter("username");
		String Password = request.getParameter("password");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/madhur?useSSL=false","root","Madhur@1603");
			PreparedStatement pst = con.prepareStatement("select * from Register where Email = ? and Password = ?");
			pst.setString(1, Email);
			pst.setString(2, Password);
			
			ResultSet rs = pst.executeQuery();
			if(Email.equals("madhursinghnain@gmail.com") && Password.equals("Madhur@1603")){
					response.sendRedirect("Admin.jsp");
					
			}
			else if(rs.next()) {
				session.setAttribute("name", rs.getString("Username"));
				dispatcher = request.getRequestDispatcher("index.jsp");
			}
			else {
				request.setAttribute("status", "failed");
				dispatcher = request.getRequestDispatcher("registration.jsp");
			}
			dispatcher.forward(request, response);

		}catch (Exception e) {
			
		}
		
	}

}
