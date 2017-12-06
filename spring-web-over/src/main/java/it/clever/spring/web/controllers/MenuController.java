/**
 * MenuController.java
 *
 * robgion
 * www.2clever.it
 * 
 * 18 lug 2017
 * For further information please write to info@2clever.it
 */
package it.clever.spring.web.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.clever.spring.web.viewbeans.LoggedUser;

/**
 * @author robgion
 *
 */
@Controller
@RequestMapping("/")
public class MenuController {

	
	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
    public String basePath(ModelMap model, HttpSession session) {
		
		LoggedUser loggedUser = (LoggedUser)session.getAttribute("loggedUser");
		if(loggedUser != null && loggedUser.isActive()) {
			return "dashboard";
		}
        return "home";
    }

	@RequestMapping(value = { "/home"}, method = RequestMethod.GET)
	public String toHome(ModelMap model) {
		return "home";
	}
	
	@RequestMapping(value = { "/dashboard"}, method = RequestMethod.GET)
	public String toDashboard(ModelMap model) {
		return "dashboard";
	}
	
}
