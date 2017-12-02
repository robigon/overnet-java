/**
 * ProductDaoImpl.java
 *
 * robgion
 * www.2clever.it
 * 
 * 25 ott 2017
 * For further information please write to info@2clever.it
 */
package it.webapp.model.dao;

import java.util.ArrayList;
import java.util.List;

import it.webapp.exceptions.DatabaseException;
import it.webapp.model.vo.ProductVo;

/**
 * @author robgion
 *
 */
public class ProductDaoImpl implements ProductDao {

	@Override
	public List<ProductVo> findAll() throws DatabaseException {
		
		List<ProductVo> retList = new ArrayList<>();
		
		// Recupero tramite JDBC la lista dei prodotti
		
		return retList;
		
	}
}
