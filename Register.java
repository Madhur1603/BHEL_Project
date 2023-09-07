package com.Bhel.form;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Username = request.getParameter("name");
		String Email = request.getParameter("email");
		String Password = request.getParameter("pass");
		String Contact = request.getParameter("contact");

				

		RequestDispatcher dispatcher = null;
		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/madhur?useSSL=false","root","Madhur@1603");
			PreparedStatement pst = con.prepareStatement("insert into Register(Username,Email,Password,Contact) values(?,?,?,?)");
		    pst.setString(1, Username);
		    pst.setString(2, Email);
		    pst.setString(3, Password);
		    pst.setString(4, Contact);

		    
		    int rowCount = pst.executeUpdate();
	    	dispatcher = request.getRequestDispatcher("registration.jsp");
	    	
		    if(rowCount > 0) {
		    	request.setAttribute("status","success");
		    	
		    }else {
		    	request.setAttribute("status","failed");
		    }
		
		    dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}