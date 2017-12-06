/**
 * LoggedUser.java
 *
 * robgion
 * www.2clever.it
 * 
 * 18 lug 2017
 * For further information please write to info@2clever.it
 */
package it.clever.spring.web.viewbeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * @author robgion
 * 
 * Bean di sessione che mantiene i dati dell'utente loggato. 
 * Viene attivato quando l'istanza viene agganciata alla sessione.
 * In questo momento del ciclo di vita viene chiamato 
 * il metodo con @PostConstruct.
 * 
 * Quando viene rimosso dalla sessione, viene invece chiamato il metodo 
 * con @PreDestroy.
 * 
 */
@Component("loggedUser")
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS, value="session")
public class LoggedUser implements Serializable{

	private static final long serialVersionUID = 7065800772077859541L;

	private String username;
	private String language;
	private boolean active = false;
	
	@PostConstruct
	public void onActivateSession() {
		
		this.active = true;
		System.out.println("--- Attivazione della sessione utente ---");
	}
	
	@PreDestroy
	public void onDeactivateSession() {
		System.out.println("--- Disattivazione della sessione utente ---");
		this.active = false;
	}
	

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean isActive() {
		return active;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
}
