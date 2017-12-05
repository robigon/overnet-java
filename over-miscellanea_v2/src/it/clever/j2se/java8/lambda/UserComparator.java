/**
 * UserComparator.java
 *
 * robgion
 * www.2clever.it
 * 
 * 25 nov 2017
 * For further information please write to info@2clever.it
 */
package it.clever.j2se.java8.lambda;

import java.util.Comparator;


/**
 * @author robgion
 * 
 * Classe per la comparazione di istanze di User.
 */
public class UserComparator  implements Comparator<User>{

	@Override
	public int compare(User o1, User o2) {
		int i = 0;
		i = o1.getNome().compareTo(o2.getNome());
		if(i == 0 ) {
			i = o1.getCognome().compareTo(o2.getCognome());
		}
		if(i == 0 ) {
			i = o1.getId().compareTo(o2.getId());
		}
		return i;
	}

}
