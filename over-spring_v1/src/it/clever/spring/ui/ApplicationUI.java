package it.clever.spring.ui;

import java.util.Scanner;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import it.clever.spring.services.ImpiegatoService;

public class ApplicationUI {

	public static void main(String[] args) {
		
		AbstractApplicationContext  context = null;
		try {

			// Caricamento del contesto e lettura delle configurazioni.
			context = new ClassPathXmlApplicationContext(
					"/spring/application-context.xml");
			
			// Richiamo in memoria del @Service
			ImpiegatoService impiegatoService = (ImpiegatoService) context.getBean("impiegatoService");
			Scanner sc = new Scanner(System.in);
			System.out.println("Inserisci un id: ");
			Long id = Long.parseLong(sc.nextLine());
			System.out.println(impiegatoService.findImpiegatoById(id));
			
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
