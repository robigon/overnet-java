/**
 * BaseClass.java
 *
 * robgion
 * www.2clever.it
 * 
 * 21 nov 2017
 * For further information please write to info@2clever.it
 */
package it.clever.j2se.blocks;

/**
 * @author robgion
 *
 */
public class BaseClass {
	
	static { System.out.println("Base Class Static Block"); }
	
	public BaseClass() {
		System.out.println("Base Class Constructor");
	}
}
