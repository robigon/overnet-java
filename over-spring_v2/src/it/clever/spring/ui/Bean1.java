/**
 * Bean1.java
 *
 * robgion
 * www.2clever.it
 * 
 * 16 lug 2017
 * For further information please write to info@2clever.it
 */
package it.clever.spring.ui;

import it.clever.spring.exception.BusinessException;
import it.clever.spring.factory.Printer;
import it.clever.spring.factory.PrinterFactory;

/**
 * @author robgion
 *
 */
public class Bean1 implements Bean {

	private Printer printer;
	
	private PrinterFactory factoryService;
	
	/**
	 * COSTRUCTOR INJECTION
	 * Bean1 riceve una istanza di UN Printer 
	 * tramite l'inerfaccia di base.
	 * Sta a chi costruisce l'istanza a sapere come e perchè.
	 * 
	 * @param printer
	 */
	public Bean1(Printer printer) {
		this.printer = printer;
	}

	/**
	 * Bean1 sfrutta i metodo print del Printer
	 * senz sare quale effettiva istanza gli viene passata da Spring (Console o FilePrinter?)
	 * 
	 * @param text
	 * @throws BusinessException
	 */
	public void method1(String text) throws BusinessException {
		printer.print(text);
	}

	public void setFactoryService(PrinterFactory factoryService) {
		this.factoryService = factoryService;
	}

}
