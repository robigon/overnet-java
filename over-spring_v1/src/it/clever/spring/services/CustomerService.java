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

import it.clever.spring.vo.CustomerVO;

/**
 * @author robgion
 *
 */
public interface CustomerService {

	
	public List<CustomerVO> findAllcustomers() throws Exception;
	
}
