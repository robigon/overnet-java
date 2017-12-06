/**
 * Bean1.java
 *
 * robgion
 * www.2clever.it
 * 
 * 16 lug 2017
 * For further information please write to info@2clever.it
 */
package it.clever.spring.ui;

import it.clever.spring.exception.BusinessException;

/**
 * @author robgion
 *
 */
public class Bean2 implements Bean {

	private Bean1 bean1;

	/**
	 * 
	 */
	public Bean2() {
	}
	
	
	public Bean1 getBean1() {
		return bean1;
	}

	public void setBean1(Bean1 bean1) {
		this.bean1 = bean1;
	}

	
	public void method1() throws BusinessException {
		bean1.method1("Ciao sono Bean2!");
		
	}
	
	public void init() {
		System.out.println("Bean2 initialization");
	}
	
	public void destroy() {
		System.out.println("Bean2 destroy");
	}
}
