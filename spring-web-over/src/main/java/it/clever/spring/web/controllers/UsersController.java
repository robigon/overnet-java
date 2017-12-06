/**
 * UsersController.java
 *
 * robgion
 * www.2clever.it
 * 
 * 18 lug 2017
 * For further information please write to info@2clever.it
 */
package it.clever.spring.web.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.clever.spring.business.model.Utente;
import it.clever.spring.business.services.UserService;
import it.clever.spring.utils.ResourceUtils;
import it.clever.spring.utils.UserUtils;
import it.clever.spring.web.viewbeans.LanguageViewBean;
import it.clever.spring.web.viewbeans.UserViewBean;

/**
 * @author robgion
 *
 */
@Controller
@RequestMapping("/")
public class UsersController {

	private static Logger logger = Logger.getLogger(UsersController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String loadUsers(Model model) {

		String path = "home";
		try {

			// Caricamento della lista degli utenti
			List<Utente> userList = userService.findAllUsers();

			// Aggiunta degli utenti nel Model, ovvero nella mappa degli
			// attributi di request.
			model.addAttribute("userList", userList);
			path = "userList";

		} catch (Exception e) {

			logger.error("Errore durante la fase di login:");
			logger.error(e.getCause());

			path = "home";
		}
		return path;
	}

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public String findUser( @ModelAttribute("message") final String message, @PathVariable("userId") Long id, Model model) {

		String path = "home";
		try {

			// Caricamento del'utente
			Utente user = userService.findByPrimaryKey(id);

			// Aggiunta degli utenti nel Model, ovvero nella mappa degli
			
			// attributi di request.
			model.addAttribute("userDetail", user);
			
			if(message != null) {
				model.addAttribute("message", message);
			}
			path = "userUpdate";

		} catch (Exception e) {

			logger.error("Errore durante il recupero dell'uente.");
			logger.error(e.getCause());

			path = "home";
		}
		return path;
	}

	@RequestMapping(value = "/userUpdate", method = RequestMethod.POST)
	public String update(UserViewBean userViewBean, @SessionAttribute LanguageViewBean languageBean,  Model model, 
	        final RedirectAttributes redirectAttributes) {

		String path = "home";
		try {

			if(userViewBean.getUsername().isEmpty()) {
				String message  = ResourceUtils.getMessageBundleByKey("error.validation.username", languageBean.getCurrentLanguage());
				redirectAttributes.addFlashAttribute("message", message);
				return "redirect:user/" + userViewBean.getUserId();
			}
			
			// Caricamento del'utente
			Utente user = UserUtils.fromViewBeanToVo(userViewBean);
			userService.update(user);

			
			// Aggiunta degli utenti nel Model, ovvero nella mappa degli
			// attributi di request.
			model.addAttribute("userDetail", user);
			path = "redirect:users";

		} catch (Exception e) {

			logger.error("Errore durante la fase di login:");
			logger.error(e.getCause());

			path = "home";
		}
		return path;
	}
}
