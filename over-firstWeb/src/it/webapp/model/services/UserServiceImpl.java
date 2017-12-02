/**
 * UserServiceImpl.java
 *
 * robgion
 * www.2clever.it
 * 
 * 05 lug 2017
 * For further information please write to info@2clever.it
 */
package it.webapp.model.services;

import java.util.List;

import it.webapp.model.dao.UserDao;
import it.webapp.model.dao.UserDaoImpl;
import it.webapp.model.vo.UserVo;

/**
 * @author robgion
 *
 */
public class UserServiceImpl implements UserService {

	@Override
	public UserVo authorize(String username, String password) throws Exception {
		UserDao ud = new UserDaoImpl();
		return ud.authorize(username, password);
	}

	public List<UserVo> findAllUsers() throws Exception {
		UserDao ud = new UserDaoImpl();
		return ud.findAllUsers();
	}

	@Override
	public UserVo findByPrimaryKey(Long id) throws Exception {
		UserDao ud = new UserDaoImpl();
		return ud.findByPrimaryKey(id);
	}
}
