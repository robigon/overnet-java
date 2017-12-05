/**
 * DataUtils.java
 *
 * robgion
 * www.2clever.it
 * 
 * 26 nov 2017
 * For further information please write to info@2clever.it
 */
package it.clever.j2se.java8.streams;

import java.util.function.Predicate;

/**
 * @author robgion
 *
 * Interfaccia che colleziona dati da attivare per ridurre il codice.
 * Vengono definiti <b>higher-order function<b>, ovvero
 * metodi che non restituiscono un risultato ma un altro metodo 
 * che viene eseguito.
 */
public interface DataUtils {

	public static <T> Predicate<T> not(Predicate<T> t) {
	    return t.negate();
	}
	
	public static Predicate<String> startsWith(String start) {
	    return s -> s.startsWith(start);
	}
}
