package controller;

import java.io.IOException;
import java.util.*;
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

@WebServlet(urlPatterns = "/process")
public class ProcessServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
			
			if((num == -1) && (cart.getQuantityById(id) <= 1))
				cart.removeItem(id);
			else {
				FoodDAO fd = new FoodDAO();
				Food f = fd.getFoodById(id);
				Items it = new Items(f, num, f.getPrice());
				cart.addItem(it);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		List<Items> list = cart.getItems();
		session.setAttribute("cart", cart);
		session.setAttribute("size", list.size());
		req.getRequestDispatcher("Cart.jsp").forward(req, resp);
	}
}
