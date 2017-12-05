/**
 * Application.java
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
public class Application {

	public static void main(String[] args) {
		
		BaseClass bClass = new BaseClass();
		
		AExternalClass aExt = new AExternalClass();
		aExt.goodJob(bClass);
	}
}
