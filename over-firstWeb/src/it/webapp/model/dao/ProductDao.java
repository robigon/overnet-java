/**
 * ProductDao.java
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
import it.webapp.model.vo.ProductVo;

/**
 * @author robgion
 *
 */
public interface ProductDao {

	List<ProductVo> findAll() throws DatabaseException;

}