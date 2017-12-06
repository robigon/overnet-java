/**
 * robgion
 * www.2clever.it
 * 
 * 10 apr 2017
 * For further information please write to info@2clever.it
 */
package it.clever.spring.business.dao;

import java.util.List;

import it.clever.spring.business.model.Utente;

public interface UserDao extends GenericDao<Utente> {

	public List<Utente> findByUsernameAndPassword(String username, String password);
}
