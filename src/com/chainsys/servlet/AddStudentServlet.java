package com.chainsys.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.dao.AddStudentDAO;
import com.chainsys.modal.AddStudent;


 @WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("Name");
		int year = Integer.parseInt(request.getParameter("Year"));
		int rollno = Integer.parseInt(request.getParameter("Rollno"));
		String department = request.getParameter("Department");
		String email = request.getParameter("Email");
		String password = request.getParameter("Password");
		
		
		
		AddStudent addStudent = new AddStudent();
		addStudent.name = name;
		addStudent.year = year;
		addStudent.rollno = rollno;
		addStudent.department = department;
		addStudent.email = email;
		addStudent.password = password;
		//System.out.println(applyPass);
		AddStudentDAO addStudentdao = new AddStudentDAO();
		try {
			//System.out.println();
			addStudentdao.add(addStudent);
			
		RequestDispatcher rd = request.getRequestDispatcher("addstudent.html");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		//	System.out.println("false");
		}
		
		
	}

}
