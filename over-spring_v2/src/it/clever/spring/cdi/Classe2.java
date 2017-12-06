/**
 * Classe2.java
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
public class Classe2 {

	private Calcolatrice calc = null;
	

	public Classe2(Calcolatrice calc) {
		this.calc = calc;
	}

	public void eseguiCalcolo() {

		//Calcolatrice calc = new Calcolatrice("STANDARD");
		int tipoCalcolo = -1;

		if (0 == tipoCalcolo) {
			// eseguo la somma
			calc.calcolaSomma(1, 10);

		} else if (1 == tipoCalcolo) {
			// eseguo il prodotto.

			calc.calcolaProdotto(20, 6);
		}

	}

	public void setCalc(Calcolatrice calc) {
		this.calc = calc;
	}
	
	
}
