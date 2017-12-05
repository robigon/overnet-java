/**
 * BlockClass1.java
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
public class BlockClass1 {

	{ System.out.println("Instance Block"); }
	
	public BlockClass1() {
		System.out.println("Constructor");
	}
	
	static { System.out.println("Static Block"); }
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		BlockClass1 oca = new BlockClass1();
	}
	
}
