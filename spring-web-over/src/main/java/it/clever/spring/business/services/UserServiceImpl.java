/**
 * UserServiceImpl.java
 *
 * robgion
 * www.2clever.it
 * 
 * 05 lug 2017
 * For further information please write to info@2clever.it
 */
package it.clever.spring.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.clever.spring.business.dao.UserDao;
import it.clever.spring.business.exceptions.AuthenticationException;
import it.clever.spring.business.model.Utente;

/**
 * @author robgion
 *
 */
@Service(value="userService")
public class UserServiceImpl implements UserService {

	
	@Autowired
	UserDao userdao;
	
	@Override
	public Utente authorize(String username, String password) throws Exception {
		 List<Utente> users = userdao.findByUsernameAndPassword(username, password);
		 if(users != null && !users.isEmpty()) {
			 
			 if(users.size() > 1)
				 throw new AuthenticationException("Too many users");
			 
			 return users.get(0);
		 }
		 throw new AuthenticationException("User not found");
	}

	@Override
	public List<Utente> findAllUsers() throws Exception {
		return userdao.findAll();
	}

	@Override
	public Utente findByPrimaryKey(Long id) throws Exception {
		return userdao.find(id);
	}

	@Override
	public void update(Utente user) throws Exception {
		userdao.update(user);
	}
}
