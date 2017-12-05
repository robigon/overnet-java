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
public class BlockClass2 {

	static { System.out.println("Static Block 2"); }
	
	{ System.out.println("Instance Block 1"); } 
	
	{ System.out.println("Instance Block 2"); } 

	public BlockClass2() {
		System.out.println("Constructor");
	}
	
	static { System.out.println("Static Block 1"); }
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		BlockClass2 oca = new BlockClass2();
	}
}
