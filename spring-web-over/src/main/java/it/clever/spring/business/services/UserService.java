/**
 * UserService.java
 *
 * robgion
 * www.2clever.it
 * 
 * 05 lug 2017
 * For further information please write to info@2clever.it
 */
package it.clever.spring.business.services;

import java.util.List;

import it.clever.spring.business.model.Utente;

/**
 * @author robgion
 *
 */
public interface UserService {

	public Utente authorize(String username, String password) throws Exception;
	
	public List<Utente> findAllUsers() throws Exception;
	
	public Utente findByPrimaryKey(Long id) throws Exception;
	
	public void update(Utente user) throws Exception;
}
