/**
 * LdapUserDaoImpl.java
 *
 * robgion
 * www.2clever.it
 * 
 * 06 nov 2017
 * For further information please write to info@2clever.it
 */
package it.clever.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import it.clever.spring.vo.UserVo;

/**
 * @author robgion
 *
 */
@Repository(value="ldapUserDao")
public class LdapUserDaoImpl implements UserDao {

	/* (non-Javadoc)
	 * @see it.clever.spring.dao.UserDao#authorize(java.lang.String, java.lang.String)
	 */
	@Override
	public UserVo authorize(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see it.clever.spring.dao.UserDao#findAllUsers()
	 */
	@Override
	public List<UserVo> findAllUsers() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see it.clever.spring.dao.UserDao#findByPrimaryKey(java.lang.Long)
	 */
	@Override
	public UserVo findByPrimaryKey(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
