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
public class BlockClass3 {

	static { System.out.println("Static Block"); }
	
	{ System.out.println("Instance Block"); }
	
	public BlockClass3() {
		System.out.println("Constructor");
	}
	
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		BlockClass3 oca1 = new BlockClass3();
		BlockClass3 oca2 = new BlockClass3();
		BlockClass3 oca3 = new BlockClass3();
	}
	
}
