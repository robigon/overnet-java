/**
 * StreamApp.java
 *
 * robgion
 * www.2clever.it
 * 
 * 26 nov 2017
 * For further information please write to info@2clever.it
 */
package it.clever.j2se.java8.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author robgion
 *
 */
public class StreamApp {

	private static final String FILE_NAME = "/results.txt";
	
	public static void main(String[] args) {
		String path = new Object().getClass().getResource(FILE_NAME).getPath();
		String newPath = path.replaceAll("%20", " ");
		try {
			loadResultsFromFileV5(newPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Legge i dati dal file utilizzando stream e lambda expressions.
	 * @param path
	 * @throws IOException
	 */
	private static void loadResultsFromFileV1(String path) throws IOException {
		
		List<String> strings = Files.readAllLines(Paths.get(path));
		strings.stream()
	    .filter(s -> !s.isEmpty())
	    .filter(s -> !s.startsWith("Giornata"))
	    .filter(s -> !s.startsWith("Data"))
	    .forEach(System.out::println);
	}
	
	/**
	 * Legge i dati dal file utilizzando stream e lambda expressions.
	 * Utilizzo di interfacce funzionali.
	 * 
	 * @param path
	 * @throws IOException
	 */
	private static void loadResultsFromFileV2(String path) throws IOException {
		
		List<String> strings = Files.readAllLines(Paths.get(path));
		strings.stream()
		.filter(DataUtils.not(String::isEmpty))
		.filter(s -> !s.startsWith("Giornata")) // Duplicazione che può essere evitata creando un metodo ad hoc.
		.filter(s -> !s.startsWith("Data"))
		.forEach(System.out::println);
		
		/*
		 * Potremmo ottimizzare il codice creando dei predicati ad hoc
		 * che potrebbero essere utilizzati in più punti del codice.
		 */
		Predicate<String> startsWithFileHeader = (n) -> n.startsWith("Giornata"); 
		Predicate<String> startsWithFileRowHeader= (n) -> n.startsWith("Data"); 
		
		strings.stream()
		.filter(DataUtils.not(String::isEmpty))
		.filter(startsWithFileHeader.negate())
		.filter(startsWithFileRowHeader.negate())
		.forEach(System.out::println);

	}
	
	/**
	 * Legge i dati dal file utilizzando stream e lambda expressions.
	 * Utilizzo di interfacce funzionali.
	 * 
	 * @param path
	 * @throws IOException
	 */
	private static void loadResultsFromFileV3(String path) throws IOException {
		
		List<String> strings = Files.readAllLines(Paths.get(path));
		strings.stream()
		.filter(DataUtils.not(String::isEmpty))
		.filter(DataUtils.not(DataUtils.startsWith("Giornata")))
		.filter(DataUtils.not(DataUtils.startsWith("Data")))
		.forEach(System.out::println);
	}
	
	
	/**
	 * Legge i dati dal file utilizzando stream e lambda expressions.
	 * Utilizzo di interfacce funzionali e compattamento del codice.
	 * 
	 * @param path
	 * @throws IOException
	 */
	private static void loadResultsFromFileV4(String path) throws IOException {
		
		List<String> strings = Files.readAllLines(Paths.get(path));
		
		// Viene invocato una sola volta il metodo filter sullo stream
		
		strings.stream()
		.filter(
				DataUtils.not(String::isEmpty)
					.and(DataUtils.not(DataUtils.startsWith("Giornata")))
					.and(DataUtils.not(DataUtils.startsWith("Data")))
				).forEach(System.out::println);
	}
	
	/**
	 * Legge i dati dal file utilizzando stream e lambda expressions.
	 * Riducendo al minimo le iterazioni e le righe di codice.
	 * 
	 * L'obiettivo è quello di trasferire informazioni dal file ad una lista di oggetti
	 * TeamItem al fine di calcolare una classifica.
	 * 
	 * @param path
	 * @throws IOException
	 */
	private static void loadResultsFromFileV5(String path) throws IOException {
		
		List<String> strings = Files.readAllLines(Paths.get(path));
		
		/*
		 * L'invocazione della mappa permette di prendere in considerazione 
		 * tutti gli oggetti nello stream e sottoporli ad una lambda expression
		 * 
		 * flatMap restituisce uno stream e non un singolo oggetto. 
		 */
		strings.stream()
		.filter(
				DataUtils.not(String::isEmpty)
					.and(DataUtils.not(DataUtils.startsWith("Giornata")))
					.and(DataUtils.not(DataUtils.startsWith("Data")))
				)
		    .flatMap(TeamItem::createItems)
		    
		    /*
		     * Ottenuta la lista della classifica è necessario:
		     * 
		     * 1. raggruppare i dati della classifica tramite il metodo collect
		     * 2. tramite il metodo groupingBy si esegue la somma rispetto ai punti di ciascuna squadra 
		     */
		    .collect(
		        Collectors.groupingBy(
		            TeamItem::getTeam,
		            Collectors.summingInt(TeamItem::getPoints)
		        )
		    )
		    .entrySet().stream()
		    .map(e -> new TeamItem(e.getKey(), e.getValue()))
		    .sorted(
		        Comparator.comparingInt(TeamItem::getPoints).reversed()
		        .thenComparing(Comparator.comparing(TeamItem::getTeam))
		    )
		    .forEach(System.out::println);
	}
	
}
