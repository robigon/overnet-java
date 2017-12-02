/**
 * UserDetailServlet.java
 *
 * robgion
 * www.2clever.it
 * 
 * 05 lug 2017
 * For further information please write to info@2clever.it
 */
package it.webapp.servlets.users;

import java.io.IOException;

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
 */
public class UserDetailServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		
		try {
			
			if(req.getServletPath().equals("/loadUserDetail")) {
				
				// Richiesto caricamento del dettaglio
				
					// 1. recupero dalla request il paramentro della user ID.
					String userId = req.getParameter("userId");
					
					if(userId != null && !userId.isEmpty()) {
						
						Long id = Long.parseLong(userId);
						
						// 2. attivo il service
						UserService us = new UserServiceImpl();
						
						// 3. recupero il dettaglio
						UserVo userDetail = us.findByPrimaryKey(id);
						
						// 4. passo il dato recuperato alla pagina di dettaglio
						req.setAttribute("userDetail", userDetail);
						
						getServletContext().getRequestDispatcher("/WEB-INF/pages/UserDetail.jsp").forward(req, res);
					}
					
			} else if(req.getServletPath().equals("/saveUserDetail")) {
				
				// 1. recuperare tutti i parametri dall request
				
				// 2. attivare il servizio
				
				// 3. salvare l'utente
				
				// 4. andare avanti verso la pagina di conferma (in genere è la stessa pagina del dettalgio con messaggio OK/KO)
				getServletContext().getRequestDispatcher("/loadUsers").forward(req, res);
				
			} else if(req.getServletPath().equals("/loadUserGroups")) {
				
			}
			
			
		} catch (Exception e) {
		}
	}

	
}
