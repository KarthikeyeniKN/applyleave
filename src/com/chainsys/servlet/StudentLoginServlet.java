package com.chainsys.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import com.chainsys.dao.StudentLoginDAO;
import com.chainsys.modal.StudentLogin;

@WebServlet("/StudentLoginServlet")
public class StudentLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
			
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		StudentLogin studentLogin = new StudentLogin();
		studentLogin.setName(name);
		studentLogin.setPassword(password);
		
		StudentLoginDAO studentLogindao = new StudentLoginDAO();
			boolean result;
			try {
			result = studentLogindao.validator(studentLogin);
		//	System.out.println(result);
			
			if (result == true) {
			session.setAttribute("NAME", name);
			RequestDispatcher rd = request.getRequestDispatcher("applyleave.html");
			rd.forward(request, response);
			} 
			else {
			request.setAttribute("ERROR", "Wrong password. Try again or click forget password");
			RequestDispatcher rd = request.getRequestDispatcher("studentlogin.html");
			rd.include(request, response);
			}
		}
		
			catch(Exception e) {
			e.printStackTrace();
			//System.out.println("false");	
			}
	}
}
