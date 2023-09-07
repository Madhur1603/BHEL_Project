package com.Bhel.form;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

/**
 * Servlet implementation class Search
 */
@WebServlet("/GuestServlet")
public class GuestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String MasterName = request.getParameter("name");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/madhur","root","Madhur@1603");
			PreparedStatement pst = con.prepareStatement("select *from Bring_Along_People where MasterName = ?");
			pst.setString(1, MasterName);
			
			out.print("<table width=75% border=1>");
			    out.print("<caption><h2>Colleague Credentials :</h2></caption>");
			    
			    ResultSet rs = pst.executeQuery();
			    java.sql.ResultSetMetaData rsmd = rs.getMetaData();
			    int totalColumn = rsmd.getColumnCount();
			    out.print("<tr>");
			    for(int i=1; i<=totalColumn; i++) {
			    	
			    	out.print("<th>"+rsmd.getColumnName(i)+"</th>");
			    	
			    }
			    
			    out.print("<tr>");
			    while(rs.next()) {
					out.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td></tr>");
			    }
			    out.print("</table>");
			
		}catch(Exception e) {
			out.print(e);
		}
		
	}

}