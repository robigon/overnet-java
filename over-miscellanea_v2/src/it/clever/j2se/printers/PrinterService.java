/**
 * PrinterService.java
 *
 * robgion
 * www.2clever.it
 * 
 * 22 nov 2017
 * For further information please write to info@2clever.it
 */
package it.clever.j2se.printers;

/**
 * @author robgion
 *
 */
public class PrinterService {

	public Printer getPrinter(int type) {
		
		if(type == Printer.PRINTER_TYPE_CONSOLE) {
			return new ConsolePrinterImpl();
		} else if(type == Printer.PRINTER_TYPE_FILE) {
			return new FilePrinterImpl();
		}
		return null;
	}
	
}
