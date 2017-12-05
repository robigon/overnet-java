package it.clever.j2se.printers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class FilePrinterImpl implements Printer {

	@Override
	public void print(String output) throws PrintException {

		BufferedWriter bw = null;
		try {

			System.out.println("Stampa su file in corso..");
			
			bw = new BufferedWriter(new FileWriter("./export.txt"));
			bw.write(output);

		} catch (IOException ioe) {

			throw new PrintException("Errore durante la scrittura su file", ioe);

		} finally {
			if(bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					throw new PrintException("Errore durante la chiusura dello stream", e);
				}
			}
		}
	}

}
