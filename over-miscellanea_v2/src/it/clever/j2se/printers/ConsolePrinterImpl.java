package it.clever.j2se.printers;

class ConsolePrinterImpl implements Printer {

	@Override
	public void print(String output) {
		
		System.out.println("\nPrint to console..\n");
		System.out.println(output);
		
	}

}
