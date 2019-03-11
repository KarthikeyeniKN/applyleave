package com.chainsys.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.dao.ApplyPassDAO;
import com.chainsys.modal.ApplyPass;


@WebServlet("/UpdateApproveServlet")
public class UpdateApproveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int selectedRollno = Integer.parseInt(request.getParameter("Aproverollno"));
		ApplyPass applyPass=new ApplyPass();
		applyPass.setRollno(selectedRollno);
			
		ApplyPassDAO applyPassdao = new ApplyPassDAO();
		
		try {
			ApplyPass applyPass1=applyPassdao.updateApproveStatus(applyPass);
			//System.out.println(applyPass1);
			request.setAttribute("LEAVELIST", applyPassdao.findAll());
			RequestDispatcher rd=request.getRequestDispatcher("leavelist.jsp");
			rd.forward(request, response);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			RequestDispatcher rd=request.getRequestDispatcher("Failure.html");
			rd.forward(request, response);
		}
	}
}

