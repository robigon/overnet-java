/**
 * PrinterFactory.java
 *
 * robgion
 * www.2clever.it
 * 
 * 13 mag 2017
 * For further information please write to info@2clever.it
 */
package it.clever.spring.factory;

/**
 * @author robgion
 *
 */
public class PrinterFactory {

	
	public static final Integer PRINTER_TYPE_CONSOLE = 0; 
	public static final Integer PRINTER_TYPE_FILE = 1; 
	
	
	/**
	 * Metodo per la creazine dei printer.
	 * @param serviceType
	 * @return
	 */
	public Printer buildService(Integer serviceType) {

		Printer retService = null;
		
		if(serviceType == PRINTER_TYPE_CONSOLE) {
			retService = new ConsolePrinter();
		} else if(serviceType == PRINTER_TYPE_FILE) {
			retService = new FilePrinter();
		}
		
		return retService;
	}
	
}
