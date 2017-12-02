package it.webapp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.webapp.model.dto.UserDto;
import it.webapp.model.services.UserService;
import it.webapp.model.services.UserServiceImpl;
import it.webapp.model.vo.UserVo;
import it.webapp.utils.UserUtils;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/*
		 * Performo la LOGOUT:
		 * 
		 * 1. recupero della sessione precedentemente creata
		 * 2. invalidazione della sessione utente
		 */
		
		HttpSession session = req.getSession(false);
		if(session != null) {
			session.invalidate();
		}
		req.setAttribute("message", "Sessione scaduta");
		getServletContext().getRequestDispatcher("/WEB-INF/pages/Index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		/*
		 * 1. creazione del DAO
		 * 2. chiamata al mentodo di autorizzazione passando username e password
		 * 3. valutazione del riultato
		 * 4. scelta delle asucessiva vista da presentare all'utente.
		 */
		UserService us = new UserServiceImpl();
		try {
			UserVo user = us.authorize(username, password);
			if(user != null) {
				// Autenticato (da prevedere una autenticazione reale su db opengest
				
				/*
				 * Creo una NUOVA sessione utente.
				 * Il parametro booleano definisce la necessità di 
				 * creare o meno una nuova sessione nel caso in cui non ne trovi
				 * una già presente.
				 */
				UserDto userDto = UserUtils.fromUserVoToDto(user);
				HttpSession session = req.getSession(true);
				session.setAttribute("loggedUser", userDto);
				getServletContext().getRequestDispatcher("/WEB-INF/pages/Dashboard.jsp").forward(req, resp);
/*				
				ServletContext sc = getServletContext();
				RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/pages/Dashboard.jsp");
				rd.forward(req, resp);
*/				
			} else {
				// Torno alla pagina di login con un messaggio di errore.
				
				String message = "Credenziali errate o utente non censito.";
				req.setAttribute("message", message);
				getServletContext().getRequestDispatcher("/WEB-INF/pages/Index.jsp").forward(req, resp);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			String message = "Errore grave!";
			req.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/WEB-INF/pages/Index.jsp").forward(req, resp);
			
		}
		
	}

}
