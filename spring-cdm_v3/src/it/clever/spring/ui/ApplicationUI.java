package it.clever.spring.ui;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import it.clever.spring.entities.Utente;
import it.clever.spring.services.CustomerService;
import it.clever.spring.services.UserService;


public class ApplicationUI {

	public static void main(String[] args) {
		
		AbstractApplicationContext  context = null;
		try {

			// Caricamento del contesto e lettura delle configurazioni.
			context = new ClassPathXmlApplicationContext(
					"/spring/application-context.xml");
			
			// Richiamo in memoria del @Service
			UserService userService = (UserService) context.getBean("userService");
			
			Utente user = userService.authorize("admin", "admin");
			if(user != null) {
				System.out.println("\n" + user + "\n");
				
				// Simulazione della chiamata al dao dei customers
				
				CustomerService custService = (CustomerService)context.getBean("customerService");
				custService.findAllcustomers();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			/*
			 * Spegnimento controllato del contesto;
			 * In questo modo, prima di eliminare tutti i bean controllati,
			 * vengono chiamati tutti i metodi dei bean annotati con @PreDestroy.
			 */
			if(context != null)
				context.registerShutdownHook();
			
			System.exit(0);
		}
		
	}
}
