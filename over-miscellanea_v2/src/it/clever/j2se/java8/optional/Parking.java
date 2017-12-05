/**
 * Parking.java
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
public class Parking {

	int numberOfPlaces;
	String  parkingType;

	public int getNumberOfPlaces() {
		return numberOfPlaces;
	}

	 
	public void setNumberOfPlaces(int numberOfPlaces) {
		this.numberOfPlaces = numberOfPlaces;
	}
	
//	public String getParkingType() {
//		return parkingType;
//	}

	public Optional<String> getParkingType() {
		return Optional.ofNullable(parkingType);
	}

	public void setParkingType(String parkingType) {
		this.parkingType = parkingType;
	}
}
