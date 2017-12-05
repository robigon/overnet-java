package it.clever.j2se.generics;

public class Demo {

	public static void main(String[] args) {
		Bottiglia<Acqua> bottiglia1= new Bottiglia<Acqua>(new Acqua());
		Bottiglia<Vino>  bottiglia2= new Bottiglia<Vino>(new Vino());
		
		BraccioAutomatico braccio = new BraccioAutomatico(bottiglia1);
		braccio.versaBevanda();
		braccio.prendiBottiglia(bottiglia2);	
		braccio.versaBevanda();	
	}
}
