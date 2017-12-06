/**
 * LoginViewBean.java
 *
 * robgion
 * www.2clever.it
 * 
 * 18 lug 2017
 * For further information please write to info@2clever.it
 */
package it.clever.spring.web.viewbeans;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * @author robgion
 *
 */
@Component("languageBean")
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS, value="session")
public class LanguageViewBean {

	private String defaultLanguage;
	private String userLanguage;

	public String getDefaultLanguage() {
		return defaultLanguage;
	}

	public void setDefaultLanguage(String defaultLanguage) {
		this.defaultLanguage = defaultLanguage;
	}

	public String getUserLanguage() {
		return userLanguage;
	}

	public void setUserLanguage(String userLanguage) {
		this.userLanguage = userLanguage;
	}
	
	/**
	 * Recupera la lingua corrente da utilizzare per 
	 * l'internazionalizzaizone dell'applicazione in base all'utente corrente.
	 * @return
	 */
	public String getCurrentLanguage() {
		return (userLanguage != null ? userLanguage : defaultLanguage);
	}
}
