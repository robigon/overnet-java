/**
 * GenericApp.java
 *
 * robgion
 * www.2clever.it
 * 
 * 26 nov 2017
 * For further information please write to info@2clever.it
 */
package it.clever.j2se.generics.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @author robgion
 *
 */
public class GenericApp {

	public static void drawShapes(List<? extends Shape> lists) {
		for (Shape s : lists) {
			s.draw();
		}
	}

	public static void main(String args[]) {
		
		List<Rectangle> list1 = new ArrayList<Rectangle>();
		list1.add(new Rectangle());

		List<Circle> list2 = new ArrayList<Circle>();
		list2.add(new Circle());
		list2.add(new Circle());

		drawShapes(list1);
		drawShapes(list2);
	}
}
