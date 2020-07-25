package com.sanjeev.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter writer=response.getWriter();
		HttpSession session=request.getSession(true);
		if(session!=null)
		{
			writer.println("session exists..");
			writer.println("Session Id :" + session.getId());
//			session.removeAttribute("username");
//			session.invalidate();
			RequestDispatcher rd=request.getRequestDispatcher("login-form.jsp");
			rd.forward(request, response);
//			request.getRequestDispatcher("Login.html").include(request, response);
//			writer.println("<h3>You are successfully logged out</h3>");
		}
		else
		{
			writer.println("Session not exists");
		}
	}

}
