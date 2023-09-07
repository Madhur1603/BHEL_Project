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
@WebServlet("/BHEL")
public class BHEL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Firstname = request.getParameter("fname");
		String Lastname = request.getParameter("lname");
		String Address = request.getParameter("address");
		String Age = request.getParameter("age");
		String ContactNo = request.getParameter("phone");
		String Stuff = request.getParameter("stuff");
		String VerificationID = request.getParameter("ID");
		String Id_No = request.getParameter("verify");
		String Arrival_Date = request.getParameter("date");
		String Arrival_Time = request.getParameter("time");
		String Duration = request.getParameter("duration");


		RequestDispatcher dispatcher = null;
		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/madhur?useSSL=false","root","Madhur@1603");
			PreparedStatement pst = con.prepareStatement("insert into visitor_master(Firstname,Lastname,Address,Age,ContactNo,Stuff,VerificationID,Id_No,Arrival_Date,Arrival_Time,Duration) values(?,?,?,?,?,?,?,?,?,?,?)");
		    pst.setString(1, Firstname);
		    pst.setString(2, Lastname);
		    pst.setString(3, Address);
		    pst.setString(4, Age);
		    pst.setString(5, ContactNo);
		    pst.setString(6, Stuff);
		    pst.setString(7, VerificationID);
		    pst.setString(8, Id_No);
		    pst.setString(9, Arrival_Date);
		    pst.setString(10, Arrival_Time);
		    pst.setString(11, Duration);

		    
		    int rowCount = pst.executeUpdate();
	    	dispatcher = request.getRequestDispatcher("BHEL.jsp");
	    	
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