/**
 * Worker.java
 *
 * robgion
 * www.2clever.it
 * 
 * 22 nov 2017
 * For further information please write to info@2clever.it
 */
package it.clever.j2se.java8.lambda;

/**
 * @author robgion
 *
 * Classe per la gestioned elle attività
 */
public class Worker {

	private ActionListener actionListener;
	
	/**
	 * Setta l'action listener
	 * @param listener
	 */
	public void addActionListener(ActionListener listener){
		this.actionListener = listener;
	}
	
	public void executeTask(Object target) throws Exception {
		actionListener.performAction(target);	
	}
}
