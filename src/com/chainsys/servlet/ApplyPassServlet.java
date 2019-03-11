package com.chainsys.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.dao.ApplyPassDAO;
import com.chainsys.modal.ApplyPass;

@WebServlet("/ApplyPassServlet")
public class ApplyPassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("Name");
		String department = request.getParameter("Department");
		int year = Integer.parseInt(request.getParameter("Year"));
		int rollno = Integer.parseInt(request.getParameter("Rollno"));
		String email = request.getParameter("Email");
		LocalDate leavedate = LocalDate.parse(request.getParameter("Leavedate"));
		String purpose = request.getParameter("Leavepurpose");
		long phoneno=Long.parseLong(request.getParameter("Phoneno"));
		
		
		ApplyPass applyPass = new ApplyPass();
		applyPass.name = name;
		applyPass.department = department;
		applyPass.year = year;
		applyPass.rollno = rollno;
		applyPass.email = email;
		applyPass.leavedate = leavedate;
		applyPass.leavepurpose = purpose;
		applyPass.phonenumber = phoneno;
		Timestamp datetime = Timestamp.valueOf(LocalDateTime.now());
		applyPass.createddate=datetime;
		//System.out.println(applyPass);
		ApplyPassDAO dao = new ApplyPassDAO();
		try {
			//System.out.println();
			dao.add(applyPass);
			
		RequestDispatcher rd = request.getRequestDispatcher("applyleave.html");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		//	System.out.println("false");
		}
		
		
		
		
	}
}
