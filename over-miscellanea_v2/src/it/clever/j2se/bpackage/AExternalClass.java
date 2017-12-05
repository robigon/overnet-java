/**
 * AExternalClass.java
 *
 * robgion
 * www.2clever.it
 * 
 * 31 mag 2017
 * For further information please write to info@2clever.it
 */
package it.clever.j2se.bpackage;

import it.clever.j2se.apackage.BaseClass;

/**
 * @author robgion
 *
 */
public class AExternalClass {

	// Aggregazione
	private BaseClass bClass;
	
	public void doSomethingElse() {
		
		bClass = new BaseClass();
		
		// Utilizzo delle variabili
		//bClass.aVar = "a string";
		bClass.bVar = "b string";
		
		//bClass.privateMethod();

//		bClass.protectedMethod();
		
//		bClass.friendlyMethod();
		
		bClass.publicMethod();
		
	}
	
	// Associazione
	public void goodJob(BaseClass bClass) {
		bClass.publicMethod();
	}
}
