/**
 * UserDto.java
 *
 * robgion
 * www.2clever.it
 * 
 * 24 ott 2017
 * For further information please write to info@2clever.it
 */
package it.webapp.model.dto;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * @author robgion
 *
 */
public class UserDto implements HttpSessionBindingListener {

	private Long userId;
	private String username;
	private String password;
	private String name;
	private String lastName;
	private int enabled;
	private String language;
	
	//private String active;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getActive() {
		return (enabled == 0) ? "OFF" : "ON";
	}

	public void setActive(String active) {
		if("OFF".equals(active)){
			this.enabled = 0;
		} else {
			this.enabled = 1;
		}
	}

	@Override
	public void valueBound(HttpSessionBindingEvent bindingEvent) {

		/*
		 * Gestione degli eventi legati all'interazione con la sessione
		 * nel momento dell'aggancio.
		 */
		
		System.out.println("Aggancio alla sessione");
	}

	/*
	 * Gestione degli eventi legati all'interazione con la sessione
	 * nel momento della invalidazione.
	 */
	@Override
	public void valueUnbound(HttpSessionBindingEvent bindingEvent) {
		System.out.println("Sgancio dalla sessione");
	}
	
}
