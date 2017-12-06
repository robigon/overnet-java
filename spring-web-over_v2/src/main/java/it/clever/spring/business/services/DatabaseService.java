/**
 * DatabaseService.java
 *
 * robgion
 * www.2clever.it
 * 
 * 05 lug 2017
 * For further information please write to info@2clever.it
 */
package it.clever.spring.business.services;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author robgion
 *
 */
public interface DatabaseService {

	public Connection getDatabaseConnection() throws SQLException;
	
	public void terminateService() throws SQLException;
}
