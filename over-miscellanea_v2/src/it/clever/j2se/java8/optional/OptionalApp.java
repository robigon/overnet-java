/**
 * OptionalApp.java
 *
 * robgion
 * www.2clever.it
 * 
 * 26 nov 2017
 * For further information please write to info@2clever.it
 */
package it.clever.j2se.java8.optional;

/**
 * @author robgion
 *
 */
public class OptionalApp {

	public static void main(String[] args) {

		Apartment apt23 = new Apartment();
		apt23.setNumber(23);
		apt23.setNumberOfRooms(3);

		System.out.println(getScore(apt23));
	}

	/**
	 * Metodo per il cacolo dello score di un appartamento.
	 * 
	 * @param apt
	 * @return
	 */
/*	
	public static int getScore(Apartment apt) {
		int score = 0;
		if (apt != null) {
			score = apt.getNumberOfRooms() * 20;
			score += apt.getParking().getNumberOfPlaces() * 4;

			if (apt.getParking().getParkingType() == ParkingType.COVERED)
				score += 5;
		}
		return score;

	}
*/
	/**
	 *  Controllo per evitare errori durante l'analisi del Parcking.
	 * @param apt
	 * @return
	 */
/*	
	public static int getScore(Apartment apt) {
		int score = 0;
		if (apt != null) {
			score = apt.getNumberOfRooms() * 20;
			if (apt.getParking() != null) {
				score += apt.getParking().getNumberOfPlaces() * 4;
				if (apt.getParking().getParkingType() != null) {
					if (apt.getParking().getParkingType() == ParkingType.COVERED)
						score += 5;
				}
			}
		}
		return score;
	}
*/	
	public static int getScore(Apartment apt) {
		int score = 0;
		if (apt != null) {
			score = apt.getNumberOfRooms() * 20;
			if (apt.getParking().isPresent()) {
				score += apt.getParking().get().getNumberOfPlaces() * 4;
				if (apt.getParking().get().getParkingType().isPresent()) {
					if (apt.getParking().get().getParkingType().get() == ParkingType.COVERED)
						score += 5;
				}
			}
		}
		return score;
	}
	
	public static int getScoreV2(Apartment apt) {
		int score = 0;
		if (apt != null) {
			score = apt.getNumberOfRooms() * 20;
			if (apt.getParking().isPresent()) {
				
				/*
				 * Map restituisce un Optional e per ottenere il suo valore potremmo utilizzare il metodo get.
				 * Potendo però restituire un valore vuoto, per essere sicuri di avere sempre un valore
				 * viene utilizzato il metodo orElse.
				 */
				score += apt.getParking().map(p -> p.getNumberOfPlaces() * 4).orElse(0);
				if (apt.getParking().get().getParkingType().isPresent()) {
					if (apt.getParking().get().getParkingType().get() == ParkingType.COVERED)
						score += 5;
				}
				
			}
		}
		return score;
	}
}
