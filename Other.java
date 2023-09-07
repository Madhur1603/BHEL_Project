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
@WebServlet("/Other")
public class Other extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MasterName = request.getParameter("master");
		String NumberOfPeople = request.getParameter("people_no");
		String PeopleName = request.getParameter("name");
		String ContactNo = request.getParameter("phone");
		String VerificationId = request.getParameter("ID");
		String ID_No = request.getParameter("Id_No");
		String Stuff = request.getParameter("stuff");
		


		RequestDispatcher dispatcher = null;
		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/madhur?useSSL=false","root","Madhur@1603");
			PreparedStatement pst = con.prepareStatement("insert into Bring_Along_People(MasterName,NumberOfPeople,PeopleName,ContactNo,VerificationId,ID_No,Stuff) values(?,?,?,?,?,?,?)");
		    pst.setString(1, MasterName);
			pst.setString(2, NumberOfPeople);
		    pst.setString(3, PeopleName);
		    pst.setString(4, ContactNo);
		    pst.setString(5, VerificationId);
		    pst.setString(6, ID_No);
		    pst.setString(7, Stuff);

		    
		    int rowCount = pst.executeUpdate();
	    	dispatcher = request.getRequestDispatcher("Other.jsp");
	    	
		    if(rowCount > 0) {
		    	request.setAttribute("status","success");
				dispatcher = request.getRequestDispatcher("index.jsp");
		    	
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