/**
 * UserServiceImpl.java
 *
 * robgion
 * www.2clever.it
 * 
 * 05 lug 2017
 * For further information please write to info@2clever.it
 */
package it.clever.spring.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import it.clever.spring.dao.UserDao;
import it.clever.spring.vo.UserVo;

/**
 * @author robgion
 *
 */
@Service(value="userService")
public class UserServiceImpl implements UserService {

	
	@Autowired
	@Qualifier(value="jpaUserDao")
	UserDao userdao;

	@Autowired
	@Qualifier(value="ldapUserDao")
	UserDao ldapUserDao;
	
	@Autowired
	@Qualifier(value="activeDUserDao")
	UserDao activeDUserDao;
	
	@PostConstruct
	public void init() {
		//userdao.findAllUsers();
	}
	
	
	@Override
	public UserVo authorize(String username, String password) throws Exception {
		return userdao.authorize(username, password);
	}

	public List<UserVo> findAllUsers() throws Exception {
		return userdao.findAllUsers();
	}

	@Override
	public UserVo findByPrimaryKey(Long id) throws Exception {
		return userdao.findByPrimaryKey(id);
	}
}
