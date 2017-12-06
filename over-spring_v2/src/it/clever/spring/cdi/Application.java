/**
 * Application.java
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
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Calcolatrice calc = new Calcolatrice("STANDARD");
		Classe2 c2 = new Classe2(calc);
		c2.eseguiCalcolo();

	}

}
