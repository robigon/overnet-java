/**
 * FilePrinter.java
 *
 * robgion
 * www.2clever.it
 * 
 * 13 mag 2017
 * For further information please write to info@2clever.it
 */
package it.clever.spring.factory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import it.clever.spring.exception.BusinessException;

/**
 * @author robgion
 *
 */
public class FilePrinter implements Printer {

	@Override
	public void print(String text) throws BusinessException {

		FileWriter pw = null;
		try {
			
			System.out.println("Printing to file..");
			
			pw = new FileWriter(new File("destination.txt"), true);
			pw.write(text);
			pw.flush();

			System.out.println("File has been updated..");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("Error during printing to file", e);
		} finally {
			try {
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw new BusinessException("Error during printing to file", e);
			}
		}
	}

	public void createService() {
		System.out.println("Creating printer service");
	}
	
	public void terminateService() {
		System.out.println("Terminating printer service");
	}
}
