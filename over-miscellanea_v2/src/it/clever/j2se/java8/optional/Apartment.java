/**
 * Apartment.java
 *
 * robgion
 * www.2clever.it
 * 
 * 26 nov 2017
 * For further information please write to info@2clever.it
 */
package it.clever.j2se.java8.optional;

import java.util.Optional;

/**
 * @author robgion
 *
 */
public class Apartment {

	private int number;
	private int numberOfRooms;
	private Parking parking;

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

//	public Parking getParking() {
//		return parking;
//	}

	public Optional<Parking> getParking() {
		return Optional.ofNullable(parking);
	}

	public void setParking(Parking parking) {
		this.parking = parking;
	}

}
