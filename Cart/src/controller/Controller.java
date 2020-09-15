package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CartBean;
import model.Product;
import model.ProductCart;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void processRequest(HttpServletRequest request, HttpServletResponse response) {
		try (PrintWriter out = response.getWriter()){
			String action = request.getParameter("action");
			if(action.equals("Add To Cart")) {
				HttpSession session = request.getSession(true);
				CartBean shop = (CartBean)session.getAttribute("SHOP");
				
				if(shop == null) {
					shop = new CartBean();
				}
				String code = request.getParameter("txtcode");
				String name = request.getParameter("txtname");
				String price = request.getParameter("txtprice");
				float pri = Float.parseFloat(price);
				Product pr = new Product(code, name, pri);
				ProductCart sp = new ProductCart(pr);
				shop.addtocart(sp);
				session.setAttribute("SHOP", shop);
				RequestDispatcher rq = request.getRequestDispatcher("index.jsp");
				rq.forward(request, response);
			}
			if(action.equals("View Cart")) {
				RequestDispatcher rq = request.getRequestDispatcher("viewcart.jsp");
				rq.forward(request, response);
			}
			if(action.equals("Addmore")) {
				RequestDispatcher rq = request.getRequestDispatcher("index.jsp");
				rq.forward(request, response);
			}
			if(action.equals("Remove")) {
				String[] list = request.getParameterValues("rmv");
				if(list!=null) {
					HttpSession session = request.getSession();
					if(session!=null) {
						CartBean shop = (CartBean)session.getAttribute("SHOP");
						for (int i = 0; i < list.length; i++) {
							shop.removecart(list[i]);
						}
						session.setAttribute("SHOP", shop);
					}
				}
				RequestDispatcher rq = request.getRequestDispatcher("viewcart.jsp");
				rq.forward(request, response);
			}
		} catch (Exception e) {
		}
	}
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
