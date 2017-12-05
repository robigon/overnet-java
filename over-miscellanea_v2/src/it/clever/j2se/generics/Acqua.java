package it.clever.j2se.generics;

public class Acqua implements Bevanda<Acqua> {
	
	@Override
	public String toString(){
		return " una bottiglia d'acqua";
	}

}
