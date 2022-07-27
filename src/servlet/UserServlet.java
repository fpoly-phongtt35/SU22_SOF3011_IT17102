package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;

import service.ProductService;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

	private ProductService productService = new ProductService();
	
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		// Lấy danh sách sản phẩm
		List<Product> products = productService.getAllProduct();
		// Gửi danh sách đến giao diện
		req.setAttribute("products", products);
		req.getRequestDispatcher("/WEB-INF/view/user.jsp")
			.forward(req, resp);
	}
}
