package com.chainsys.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.dao.ApplyPassDAO;
import com.chainsys.modal.ApplyPass;


@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search=request.getParameter("search");
		
		//String department=request.getParameter("search");
		ApplyPassDAO applyPassdao = new ApplyPassDAO();
		
		
		try {
			ArrayList<ApplyPass> applyPass = applyPassdao.searchBy(search, search, search);
			request.setAttribute("HISTORY",applyPass);
			System.out.println(applyPass);
			RequestDispatcher rd=request.getRequestDispatcher("history.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
