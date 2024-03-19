package controller;

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dal.OrdersDAO;
import model.Cart;
import model.Users;

@WebServlet(urlPatterns = "/checkout")
public class CheckOutServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession(true);
		Cart cart = null;
		Object o = session.getAttribute("cart");
		if(o != null)
			cart = (Cart)o;
		else
			cart = new Cart();
		Users user = null;
		Object u = session.getAttribute("user");
		if(u != null) {
			user = (Users) u;
			OrdersDAO ord = new OrdersDAO();
			ord.addOrder(user, cart);
			session.removeAttribute("cart");
			session.setAttribute("size", 0);
			resp.sendRedirect("Home.jsp");
		}
		else
			resp.sendRedirect("login.jsp");
	}
}
