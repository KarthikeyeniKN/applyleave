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

@WebServlet("/HistoryServlet")
public class HistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ApplyPassDAO applyPassdao = new ApplyPassDAO();
		try {
			ArrayList<ApplyPass> history = applyPassdao.findAllHistory();
			request.setAttribute("HISTORY", history);
			RequestDispatcher rd = request.getRequestDispatcher("history.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
