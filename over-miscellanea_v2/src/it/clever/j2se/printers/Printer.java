/**
 * Printer.java
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
public interface Printer {

	int PRINTER_TYPE_CONSOLE = 0; 
	int PRINTER_TYPE_FILE = 1;
	
	void print(String output) throws PrintException;
}
