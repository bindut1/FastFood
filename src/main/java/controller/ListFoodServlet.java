package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dal.FoodDAO;
import model.Food;

@WebServlet(urlPatterns = "/listFood")
public class ListFoodServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FoodDAO fd = new FoodDAO();
		List<Food> list1 = fd.getAll();
		
		int page, numperpage = 6;
		int size = list1.size();
		int num = (size % 6 == 0 ? (size/6) : ((size/6) + 1));
		String xpage = req.getParameter("page");
		if(xpage == null)
			page = 1;
		else {
			page = Integer.parseInt(xpage);
		}
		int start, end;
		start = (page - 1) * numperpage;
		end = Math.min(page * numperpage, size);
		List<Food> list2 = fd.getListByPage(list1, start, end);
		req.setAttribute("data", list2);
		req.setAttribute("page", page);
		req.setAttribute("num", num);
		
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
