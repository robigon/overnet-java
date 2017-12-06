/**
 * MiscellaneaApp.java
 *
 * robgion
 * www.2clever.it
 * 
 * 22 nov 2017
 * For further information please write to info@2clever.it
 */
package it.clever.j2se.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import it.clever.j2se.printers.Printer;
import it.clever.j2se.printers.PrinterService;

/**
 * @author robgion
 *
 */
public class MiscellaneaApp {

	public static void main(String[] args) {

//		 runAnonymousClasses();

//		testMapStream();
		
		//runLambdaExpressionExamples();

		 useStreams();
		
	}

	/**
	 * Metodo di test per le classi anonime.
	 */
	private static void runAnonymousClasses() {

		User user = new User("Roberto", "Giontella", 20);

		Worker worker3 = new Worker();
		worker3.addActionListener(new ActionListenerImpl());
		
		// Costruzione e setup dei worker associati ai pulsanti per la stampa
		Worker worker1 = new Worker();
		
		ActionListener commonListner = new ActionListener() {
			
			@Override
			public void performAction(Object target) throws Exception {
				Printer p = new PrinterService().getPrinter(Printer.PRINTER_TYPE_CONSOLE);
				p.print(target.toString());
			}
		};
		
		worker1.addActionListener(new ActionListener() {

			/**
			 * Setup del listener per la stampa su console
			 * 
			 * @throws Exception
			 */
			@Override
			public void performAction(Object target) throws Exception {
				Printer p = new PrinterService().getPrinter(Printer.PRINTER_TYPE_CONSOLE);
				p.print(target.toString());
			}
		});

		// Il secondo worker stampa su file
		Worker worker2 = new Worker();
		worker2.addActionListener(new ActionListener() {

			/**
			 * Setup del listener per la stampa su file
			 * 
			 * @throws Exception
			 */
			@Override
			public void performAction(Object target) throws Exception {
				Printer p = new PrinterService().getPrinter(Printer.PRINTER_TYPE_FILE);
				p.print(target.toString());
			}
		});

		// ...
		// Codice di attivazione dei due worker
		try {
			worker1.executeTask("Hello world!");
			worker2.executeTask(user);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	/**
	 * Metodo per il test delle Lambda Expressions in Java 8.
	 * 
	 * 1. Classi Anonime - stesso codice del precedente ma con Lmbda Expression
	 * 2. Ricerche e Confronti
	 */
	public static void runLambdaExpressionExamples() {

		// Example 1: Classi Anonime - stesso codice del precedente ma con
		// Lambda Expression
		Worker worker = new Worker();
		worker.addActionListener((target) -> {
			Printer p = new PrinterService().getPrinter(Printer.PRINTER_TYPE_CONSOLE);
			p.print(target.toString());

		});

		// Example 2: Foreach
		System.out.println("\nEsempio classico di stampa");
		List<Integer> numberList = Arrays.asList(1, 2, 3, 5);
		for (Integer n : numberList) {
			System.out.print(n);
		}

		System.out.println("\n\nEsempio di stampa con lambda:");
		numberList.forEach(n -> System.out.print(n));

		System.out.println("\n\nEsempio di stampa con lambda compatto:");
		numberList.forEach(System.out::print);

		/*
		 * Possiamo utilizzare la forma compatta (method reference) solo se 
		 * la funzione non modifica il parametro passato.
		 * Nel caso in cui questo avvenga è necessario utilizzare l'espressione
		 * lambda completa
		 */
		numberList.forEach(s -> System.out.print( s * 10));
	}

	/**
	 * Metodo per il test dei metodi <b>map</b> e <b>flatMap</b>
	 */
	private static void testMapStream() {
		
		// Utilizzo di map
		List<Integer> listOfIntegers = Stream.of("1", "2", "3", "4") 
								.map(Integer::valueOf)
								.collect(Collectors.toList());

		/*
		 * Utilizzo di flatMap su una struttura a più livelli:
		 * 
		 * [ [1,2,3],[4,5,6],[7,8,9] ] 
		 * 
		 * 
		 */
		List<Integer> evens = Arrays.asList(2, 4, 6, 8); 
		List<Integer> odds = Arrays.asList(3, 5, 7); 
		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11);
		
		List<Integer> numbers = Stream.of(evens, odds, primes).flatMap(list -> list.stream()).collect(Collectors.toList());
		
		System.out.println("\nflattend list: " + numbers);

	}
	
	/**
	 * Metodo per l'utilizzo degli Streams
	 */
	private static void useStreams() {

		List<String> nameList = Arrays.asList("Roberto", "Sara", "Silvia", "Giovanni", "Antonio");

		/*
		 * Utilizzo degli stream intermedi L’invocazione del metodo stream()
		 * consente di ottenere uno Stream sulla lista
		 * 
		 * Il metodo filter che accetta in input un tipo Predicate<T>. Predicate
		 * è un’interfaccia funzionale e richiede l’implementazione del metodo
		 * test(), la signature di questo metodo richiede un parametro di un
		 * generico tipo T e restituisce un booleano. Nel caso corrente
		 * l’espressione Lambda.
		 */
		System.out.println("\n\nSelezione e stampa della lista di stringhe:");
		nameList.stream().filter((s) -> s.startsWith("S")).forEach(s -> System.out.println(s));
		
		for(String s : nameList) {
			if(s.startsWith("S"))
				System.out.println();
		}

		/*
		 * Esiste la possibilità di applicare un metodo a tutti gli elementi di
		 * uno Stream ottenendo un nuovo Stream di oggetti modificati.
		 * Utilizzando map() è possibile fare in modo che il metodo
		 * toUpperCase() della classe String sia applicato a tutte le stringhe
		 * di uno Stream:
		 */
		System.out.println("\n\nSelezione ed ordinamento della lista di stringhe:");
		nameList.stream().map(String::toUpperCase).sorted().forEach(System.out::println);

		/*
		 * Gestione dell'ordinamento con comparazione.
		 */
		System.out.println("\n\nSelezione ed ordinamento della lista di utenti:");

		List<User> people = createUserList();

		Stream<User> usersStream = people.stream().sorted(new UserComparator());
		
		/*
		 * Sullo stream intermedio posso essere effettuate delle operazioni finali
		 */
		usersStream.forEach(u -> System.out.println(u.getId() + " " + u.getNome() + " " + u.getCognome()));

		/*
		 * Il metodo sorted restiruisce uno stream ordinato in base al Comparator fornito.
		 */
		people.stream().sorted(new UserComparator()).forEach(System.out::println);

		System.out.println("\n\nSelezione ed ordinamento della lista di utenti:");

		/*
		 * Nel primo caso osserviamo delle istruzioni familiari: prendere un
		 * singolo elemento dalla lista, processarlo e avanzare verso il
		 * successivo. Questo modo di operare, si chiama iterazione esterna:
		 */
		// for(User u : people) {
		// if(u.getNome().startsWith("M")) {
		// System.out.println(u.getNome());
		// }
		// }

		/*
		 * Nel secondo caso il codice restituisce un oggetto stream dalla
		 * collezione. Su questo viene utilizzato il metodo filter che permette
		 * di considerare solo gli utenti che soddisfano il nostro criterio
		 * tramite una lambda. Sugli utenti che superano la selezione, tramite
		 * map e con un method reference, viene restituito solo il nome e
		 * che viene stampato su ciascuno di questi elementi.
		 */
		people.stream().filter(
				u -> u.getNome().startsWith("M")
		).map(User::getNome).forEach(System.out::println);
		
		System.out.println("\n\nGestione dei gruppi di appartenenza:");
		
		people.stream()
	    .filter(user -> user.getEta() > 20)
	    .flatMap(user -> user.getGroups().stream())
	    .sorted()
	    .distinct()
	    .limit(3)
	    .forEach(System.out::println);
		
		
		System.err.println("\n\nStessa cosa in Java 7..\n");
		List<String> groups = new ArrayList<>();
		
		// Ottenimento di una lista di tutti i gruppi disponibli
		for(User user : people) {
			if(user.getEta() > 20) {
				for(String g : user.getGroups()) {
					if(!groups.contains(g)){
						// Si evitano i duplicati
						groups.add(g);
					}
				}
			}
		}
		int limit = 2;
		int counter = 0;
		for(String g : groups) {
			counter++;
			if(counter <= limit){
				System.out.println(g);
			}
		}
	}

	
	private static List<User> createUserList() {
		List<User> people = new ArrayList<>();
		
		User u = new User("Roberto", "Giontella", 20);
		u.addGroups("Admin");
		people.add(u);
		
		u = new User("Maria", "Bianchi", 30);
		u.addGroups("Admin", "Operator", "Team Leader");
		people.add(u);
		
		u = new User("Mario", "Rossi", 40);
		u.addGroups("Operator");
		people.add(u);
		
		return people;
	}
}
