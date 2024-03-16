package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dal.UsersDAO;
import model.Users;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("Login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String u = req.getParameter("user");
		String p = req.getParameter("pass");
		UsersDAO usd = new UsersDAO();
		Users us = usd.getAccount(u, p);
		if(us == null) {
			String er = "username: " + u + "password: " + p + "doesn't exist!";
			req.setAttribute("error", er);
			req.getRequestDispatcher("Login.jsp").forward(req, resp);
		}else {
			HttpSession session = req.getSession(true);
			session.setAttribute("account", us);
			req.getRequestDispatcher("Home.jsp").forward(req, resp);
		}
	}
}
