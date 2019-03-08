package com.chainsys.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.dao.ApplyPassDAO;
import com.chainsys.modal.ApplyPass;


@WebServlet("/StatusServlet")
public class StatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
	
		ApplyPassDAO applyPassdao = new ApplyPassDAO();
			
				String name=(String) session.getAttribute("NAME");
				System.out.println(name);
				ApplyPass applyPass1;
				try {
					ArrayList<ApplyPass> applyPass = applyPassdao.findByName(name);
					//applyPass1 = applyPassdao.findByName(name);
					request.setAttribute("STATUS",applyPass);
					RequestDispatcher rd=request.getRequestDispatcher("studentstatus.jsp");
					rd.forward(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
		
	}

}
