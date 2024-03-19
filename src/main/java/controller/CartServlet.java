package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dal.FoodDAO;
import model.Cart;
import model.Food;
import model.Items;

import java.util.*;
@WebServlet(urlPatterns = "/Cart")
public class CartServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(true);
		Cart cart = null;
		Object o = session.getAttribute("cart");
		if(o != null)
			cart = (Cart)o;
		else
			cart = new Cart();
		String num1 = req.getParameter("num");
		String id1 = req.getParameter("id");
		int num, id;
		try {
			num = Integer.parseInt(num1);
			id = Integer.parseInt(id1);
			
			FoodDAO fd = new FoodDAO();
			Food f = fd.getFoodById(id);
			Items it = new Items(f, num, f.getPrice());
			cart.addItem(it);
		} catch (Exception e) {
			num = 1;
		}
		List<Items> list = cart.getItems();
		session.setAttribute("cart", cart);
		session.setAttribute("size", list.size());
		req.getRequestDispatcher("Cart.jsp").forward(req, resp);
	}
}
