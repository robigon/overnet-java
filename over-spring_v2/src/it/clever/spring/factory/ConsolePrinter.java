/**
 * ConsolePrinter.java
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
public class ConsolePrinter implements Printer {

	@Override
	public void print(String text) throws BusinessException {
		System.out.println("Printing to console..");
		System.out.println("\n" + text);
	}

	public void createService() {
		System.out.println("Creating printer service");
	}
	
	public void terminateService() {
		System.out.println("Terminating printer service");
	}
}
