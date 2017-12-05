package it.clever.j2se.java8.default_methods;

public class DefaultApp {

	public static void main(String[] args) {

		Developer devel = new Developer();
		devel.myDuties();
		devel.extraDuties();
		
		Tester tester = new Tester();
		tester.myDuties();
		tester.extraDuties();
		
	}

}
