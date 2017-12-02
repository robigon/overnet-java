/**
 * ProductService.java
 *
 * robgion
 * www.2clever.it
 * 
 * 25 ott 2017
 * For further information please write to info@2clever.it
 */
package it.webapp.model.services;

import java.util.List;

import it.webapp.exceptions.DatabaseException;
import it.webapp.model.vo.ProductVo;

/**
 * @author robgion
 *
 */
public interface ProductService {

	List<ProductVo> findAll() throws DatabaseException;

}