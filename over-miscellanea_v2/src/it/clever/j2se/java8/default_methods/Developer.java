/**
 * Developer.java
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
public class Developer implements MyService {

	@Override
	public void myDuties() {
		System.out.println("I will develop the application");
	}

	@Override
	public void extraDuties() {
		System.out.println("I will perform extra duties for my service");
	}
}
