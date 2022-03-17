package com.simplilearn.sportyshoes.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.simplilearn.sportyshoes.helper.FactoryProvider;
import com.smplilearn.sportyshoes.entities.User;

/**
 * Servlet implementation class registerServlet
 */
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public registerServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String name = request.getParameter("user_name");
		String email = request.getParameter("user_email");
		String password = request.getParameter("user_password");
		String phone = request.getParameter("user_phone");
		String address = request.getParameter("user_address");
		
		
		if(name.isEmpty()) {
			out.println("Name is blank");
		}
		
		
		User user= new User(name, email, password, phone,"default.jsp" ,address,"normal");
		
		Session session = FactoryProvider.getFactory().openSession();
		Transaction tx = session.beginTransaction();
		
	int userId = (Integer) session.save(user);
		tx.commit();
		session.close();
		
		
		HttpSession httpSession=request.getSession();
		
		httpSession.setAttribute("message", "Registration Successfully Done !!");
		
		response.sendRedirect("register.jsp");
		return;
		
		
	}

}
