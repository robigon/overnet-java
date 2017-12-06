/**
 * ActionListenerImpl.java
 *
 * robgion
 * www.2clever.it
 * 
 * 06 dic 2017
 * For further information please write to info@2clever.it
 */
package it.clever.j2se.java8.lambda;

import it.clever.j2se.printers.Printer;
import it.clever.j2se.printers.PrinterService;

/**
 * @author robgion
 *
 */
public class ActionListenerImpl implements ActionListener {

	/* (non-Javadoc)
	 * @see it.clever.j2se.java8.lambda.ActionListener#performAction(java.lang.Object)
	 */
	@Override
	public void performAction(Object target) throws Exception {
		Printer p = new PrinterService().getPrinter(Printer.PRINTER_TYPE_CONSOLE);
		p.print(target.toString());

	}

}
