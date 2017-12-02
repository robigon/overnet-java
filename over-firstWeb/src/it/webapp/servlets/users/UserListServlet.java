package it.webapp.servlets.users;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.webapp.model.services.UserService;
import it.webapp.model.services.UserServiceImpl;
import it.webapp.model.vo.UserVo;

/**
 * @author robgion
 *
 * Classe Servlet per la gestione del caricamento degli utenti applicativi.
 */
public class UserListServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		try {
			
			// 1. creazione dello UserService
			UserService us = new UserServiceImpl();
			
			// 2. recupero della lista degli utenti
			List<UserVo> userList = us.findAllUsers();
					
			// 3. passaggio in avanti degli utenti alla successiva UI
			req.setAttribute("userList", userList);
			
			// 4. vado avanti verso la pagina di visualizzazione degli utenti
			getServletContext().getRequestDispatcher("/WEB-INF/pages/UserList.jsp").forward(req, res);
			
		} catch (Exception e) {
			String message = "Errore grave!";
			getServletContext().getRequestDispatcher("/WEB-INF/pages/Dashboard.jsp").forward(req, res);
		}
	}

	
}
