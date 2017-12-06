/**
 * Printer.java
 *
 * robgion
 * www.2clever.it
 * 
 * 13 mag 2017
 * For further information please write to info@2clever.it
 */
package it.clever.spring.factory;

import it.clever.spring.exception.BusinessException;

/**
 * @author robgion
 *
 */
public interface Printer {

	public void print(String text) throws BusinessException;
	
	public void createService();
	public void terminateService();
}
