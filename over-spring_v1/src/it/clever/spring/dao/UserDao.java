/**
 * UserDao.java
 *
 * robgion
 * www.2clever.it
 * 
 * 16 lug 2017
 * For further information please write to info@2clever.it
 */
package it.clever.spring.dao;

import java.util.List;

import it.clever.spring.services.DatabaseService;
import it.clever.spring.vo.UserVo;

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
	UserVo authorize(String username, String password) throws Exception;

	/**
	 * Recupero della lista di tutti gli utenti da tabella.
	 * 
	 * @return
	 * @throws Exception
	 */
	List<UserVo> findAllUsers() throws Exception;

	UserVo findByPrimaryKey(Long id) throws Exception;

}