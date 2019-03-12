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

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("Name");
		String department = request.getParameter("Department");
		int year = Integer.parseInt(request.getParameter("Year"));
		int rollno = Integer.parseInt(request.getParameter("Rollno"));
		String email = request.getParameter("Email");
		LocalDate leavedate = LocalDate
				.parse(request.getParameter("Leavedate"));
		String purpose = request.getParameter("Leavepurpose");
		long phoneno = Long.parseLong(request.getParameter("Phoneno"));

		ApplyPass applyPass = new ApplyPass();
		applyPass.setName(name);
		applyPass.setDepartment(department);
		applyPass.setYear(year);
		applyPass.setRollno(rollno);
		applyPass.setEmail(email);
		applyPass.setLeavedate(leavedate);
		applyPass.setLeavepurpose(purpose);
		applyPass.setPhonenumber(phoneno);
		Timestamp datetime = Timestamp.valueOf(LocalDateTime.now());
		applyPass.setCreateddate(datetime);
		ApplyPassDAO dao = new ApplyPassDAO();
		try {
			dao.add(applyPass);
			RequestDispatcher rd = request
					.getRequestDispatcher("applyleave.html");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
