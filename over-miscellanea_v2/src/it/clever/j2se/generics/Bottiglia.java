package it.clever.j2se.generics;

public class Bottiglia<T extends Bevanda<T>> {

	private T contenuto;

	public Bottiglia(T t){
		contenuto=t;
	}
	
	public  T getContenuto() {
		return contenuto;
	}
}
