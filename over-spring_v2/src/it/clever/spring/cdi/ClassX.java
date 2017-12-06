/**
 * ClassX.java
 *
 * robgion
 * www.2clever.it
 * 
 * 03 nov 2017
 * For further information please write to info@2clever.it
 */
package it.clever.spring.cdi;

/**
 * @author robgion
 *
 */
public class ClassX {

	private Calcolatrice calc;

	
	public void calcola() {
		calc.calcolaProdotto(12,  2);
	}
	
	
	public void setCalc(Calcolatrice calc) {
		this.calc = calc;
	}
	
	
}
