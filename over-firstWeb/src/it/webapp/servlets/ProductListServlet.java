/**
 * ProductListServlet.java
 *
 * robgion
 * www.2clever.it
 * 
 * 25 ott 2017
 * For further information please write to info@2clever.it
 */
package it.webapp.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.webapp.exceptions.DatabaseException;
import it.webapp.model.services.ProductService;
import it.webapp.model.services.ProductServiceImpl;
import it.webapp.model.vo.ProductVo;

/**
 * @author robgion
 *
 */
public class ProductListServlet extends HttpServlet {

	private static final long serialVersionUID = -1332757599335833591L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// 1. REcupero il servizio
			ProductService productService = new ProductServiceImpl();
			
			// 2. recupero la lista dei prodotti
			List<ProductVo> productList;
			productList = productService.findAll();
			
			// 3. Setto la lista dei prodotti in modo tale che arrivino in pagina.
			request.setAttribute("productList", productList);
			
			// 4. Invio la navigazione verso la pagina JPS dei prodotti
			getServletContext().getRequestDispatcher("/WEB-INF/pages/ProductList.jsp").forward(request, response);
			
		} catch (DatabaseException e) {
			e.printStackTrace();
			String errorMsg = "Errore durante il recupero dei prodotti";
			request.setAttribute("errorMsg", errorMsg);
			getServletContext().getRequestDispatcher("/WEB-INF/pages/Dashboard.jsp").forward(request, response);
		}
		
		
	}

	
}
