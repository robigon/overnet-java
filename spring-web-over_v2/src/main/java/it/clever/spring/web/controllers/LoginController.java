/**
 * LoginController.java
 *
 * robgion
 * www.2clever.it
 * 
 * 18 lug 2017
 * For further information please write to info@2clever.it
 */
package it.clever.spring.web.controllers;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.clever.spring.business.model.Utente;
import it.clever.spring.business.services.UserService;
import it.clever.spring.utils.ConfigBean;
import it.clever.spring.web.viewbeans.LanguageViewBean;
import it.clever.spring.web.viewbeans.LoggedUser;
import it.clever.spring.web.viewbeans.LoginViewBean;

/**
 * @author robgion
 * 
 *         Classe controller per la gestione delle operazioni legati al login
 *         dell'utente. L'annotation @Controller ne garantisce la gestione da
 *         parte di Spring, coinvolgendola nelle operazioni di associazione tra
 *         vie e mapping dei metodi.
 *         
 *         Considerando l'annotation @RequestMapping, il valore "/" permette di intercettare
 *         tutti i path, il filtro viene poi applicato al singolo metodo.
 */
@Controller
@RequestMapping("/")
public class LoginController {

	private static Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired(required=true)
	private ConfigBean configBean;
	
	@Autowired
	private LoggedUser loggedUser;
	
	@Autowired
	private LanguageViewBean languageBean;
	
	@Autowired
	private UserService userService;
	
	/**
	 * Il metodo risponde alle chiamate di tipo POST.
	 * L'URL al quale viene mappato è "login-attemp" inviato dalla JSP.
	 * 
	 * 
	 * 
	 * @param loginViewBean
	 * @param request
	 * @return
	 */
	@PostMapping(value="/login-attempt")
	public String loginAttempt(@ModelAttribute LoginViewBean loginViewBean, HttpSession session) {

		String path = "home";
		try {
			
			 Utente user = userService.authorize(loginViewBean.getUsername(), loginViewBean.getPassword());
			 if(user != null) {
				 // Utente  riconosciuto.
				 
				 loggedUser.setUsername(loginViewBean.getUsername());
				 loggedUser.setLanguage(user.getLanguage());
				 
				 // Configurazione della lingua dell'utente.
				 languageBean.setUserLanguage(user.getLanguage());
				 languageBean.setDefaultLanguage(configBean.getDefaultLanguageCode());
				 
				 session.setAttribute("loggedUser", loggedUser);
				 session.setAttribute("languageBean", languageBean);
				 path = "dashboard";
			 }
			 
		} catch (Exception e) {
			
			logger.error("Errore durante la fase di login:");
			logger.error(e.getCause());
			
			path = "home";
		}
		return path;
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutAttempt(HttpSession session) {
		
		// Invalidazione della sessione utente.
		session.invalidate();
		return "home";
	}
}
