/**
 * Parallel.java
 *
 * robgion
 * www.2clever.it
 * 
 * 26 nov 2017
 * For further information please write to info@2clever.it
 */
package it.clever.j2se.java8.streams;

import java.util.ArrayList;

/**
 * @author robgion
 *
 */
public class Parallel {

	private static final long MAX = 10000000l;
	
	
	public static void main(String[] args) {
		
		ArrayList<Long> integers = new ArrayList<Long>();
		for(long i=MAX; i>=1; i--) {
		    integers.add(i);
		}
		
		long start = System.nanoTime();
		 
		integers.stream().sorted();
		 
		long end = System.nanoTime();
		 
		System.out.println("Sequential sort time:"+(end-start));
		
		
		// Test con parallel programming
		start = System.nanoTime();
		 
		integers.parallelStream().sorted();
		 
		end = System.nanoTime();
		 
		System.out.println("Parallel sort time:"+(end-start));

	}
}
