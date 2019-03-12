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

@WebServlet("/UpdateRejectServlet")
public class UpdateRejectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int selectedRollno = Integer.parseInt(request
				.getParameter("Rejectrollno"));
		ApplyPass applyPass = new ApplyPass();
		applyPass.setRollno(selectedRollno);
		ApplyPassDAO applyPassdao = new ApplyPassDAO();
		try {
			@SuppressWarnings("unused")
			ApplyPass applyPass1 = applyPassdao.updateRejectStatus(applyPass);
			request.setAttribute("LEAVELIST", applyPassdao.findPending());
			RequestDispatcher rd = request
					.getRequestDispatcher("leavelist.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("Failure.html");
			rd.forward(request, response);
		}
	}
}
