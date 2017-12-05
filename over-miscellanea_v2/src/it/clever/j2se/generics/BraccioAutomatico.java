package it.clever.j2se.generics;

public class BraccioAutomatico {

	private Bottiglia<? extends Bevanda<?>> bottiglia;
	
	public <T extends Bottiglia<? extends Bevanda<?>>> BraccioAutomatico(T bottiglia) {
		this.bottiglia = bottiglia;
		System.out.println("Ho preso"+this.bottiglia.getContenuto());
	}
	
	public BraccioAutomatico(){}
	
	public <T extends Bottiglia<? extends Bevanda<?>>> void prendiBottiglia(T bottiglia){
		System.out.println("Ho preso"+bottiglia.getContenuto());
		this.bottiglia=bottiglia;
	}
	
	public void versaBevanda(){
		if(bottiglia != null) 
			System.out.println("Versa"+bottiglia.getContenuto().toString());
		else
			System.out.println("Bottiglia vuota");
	}
}
