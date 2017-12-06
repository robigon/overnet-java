/**
 * CustomerDaoImpl.java
 *
 * robgion
 * www.2clever.it
 * 
 * 07 giu 2017
 * For further information please write to info@2clever.it
 */
package it.clever.spring.business.dao;

import org.springframework.stereotype.Repository;

import it.clever.spring.business.model.Customer;

/**
 * @author robgion
 *
 */
@Repository(value = "customerDao")
public class CustomerDaoImpl extends GenericDaoImpl<Customer>  implements CustomerDao {

}
