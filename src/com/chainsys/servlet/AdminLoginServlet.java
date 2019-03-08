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

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		String name = request.getParameter("name");
    		String password = request.getParameter("password");
    		ApplyPassDAO applyPassdao = new ApplyPassDAO();
    		
    		try {
    		if (name.equalsIgnoreCase("admin")
    		&& password.equalsIgnoreCase("admin")) {
    		
    			ArrayList<ApplyPass> leaveList=applyPassdao.findAll();
    		request.setAttribute("LEAVELIST", leaveList);
    	    RequestDispatcher rd = request.getRequestDispatcher("leavelist.jsp");
    		rd.forward(request, response);
    		} else {
    			System.out.println("false");
    		request.setAttribute("ERROR", "Wrong password");
    		RequestDispatcher rd = request
    		.getRequestDispatcher("admin.html");
    		rd.include(request, response);
    		}
    		}
    		catch(Exception e) {
    			e.printStackTrace();
    			System.out.println("false");	
    			}
    		}
	}


