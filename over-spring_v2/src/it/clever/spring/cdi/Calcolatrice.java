/**
 * Calcolatrice.java
 *
 * robgion
 * www.2clever.it
 * 
 * 02 nov 2017
 * For further information please write to info@2clever.it
 */
package it.clever.spring.cdi;

/**
 * @author robgion
 *
 */
public class Calcolatrice {

	private String type;
	

	public Calcolatrice(String type) {
		this.type = type;
	}

	public int calcolaSomma(int op1, int op2) {
		return op1 + op2;
	}
	
	public double calcolaProdotto(double op1, double op2) {
		return op1 * op2;
	}
}
