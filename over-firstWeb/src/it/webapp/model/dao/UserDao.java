/**
 * UserDao.java
 *
 * robgion
 * www.2clever.it
 * 
 * 29 nov 2017
 * For further information please write to info@2clever.it
 */
package it.webapp.model.dao;

import java.util.List;

import it.webapp.exceptions.DatabaseException;
import it.webapp.model.vo.UserVo;

/**
 * @author robgion
 *
 */
public interface UserDao {

	/**
	 * Metodo per l'autenticazione applicativa dell'utente connesso.
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	UserVo authorize(String username, String password) throws DatabaseException;

	/**
	 * Recupero della lista di tutti gli utenti da tabella.
	 * 
	 * @return
	 * @throws Exception
	 */
	List<UserVo> findAllUsers() throws DatabaseException;

	UserVo findByPrimaryKey(Long id) throws DatabaseException;

}