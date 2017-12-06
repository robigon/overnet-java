/**
 * UserService.java
 *
 * robgion
 * www.2clever.it
 * 
 * 05 lug 2017
 * For further information please write to info@2clever.it
 */
package it.clever.spring.services;

import java.util.List;

import it.clever.spring.vo.UserVo;

/**
 * @author robgion
 *
 */
public interface UserService {

	public UserVo authorize(String username, String password) throws Exception;
	
	public List<UserVo> findAllUsers() throws Exception;
	
	public UserVo findByPrimaryKey(Long id) throws Exception;
}
