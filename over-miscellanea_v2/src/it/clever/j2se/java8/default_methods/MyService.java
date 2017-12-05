/**
 * MyService.java
 *
 * robgion
 * www.2clever.it
 * 
 * 26 nov 2017
 * For further information please write to info@2clever.it
 */
package it.clever.j2se.java8.default_methods;

/**
 * @author robgion
 *
 */
public interface MyService {

	public void myDuties();

	default public void extraDuties() {
		System.out.println("Perform extra duties");
	}
	
}
