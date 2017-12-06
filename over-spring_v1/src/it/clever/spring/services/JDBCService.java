/**
 * <b> JDBCService.java
 * 
 * <br>
 * 
 *  Classe per la gestione delle connessioni con il database.
 * 
 */
package it.clever.spring.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import it.clever.spring.utils.ConfigBean;

/**
 * @author 2Clever.IT
 * 
 * JDBCService è gestito da Spring come un singleton
 * in quanto è stato specificato dalla relativa annotation.
 */
@Service("jdbcService")
@Scope(value = "singleton")
public class JDBCService implements DatabaseService {

	/**
	 * Ottiene la dipendenza di un bean popolato automaticamente
	 * con le configurazioni del file di properties.
	 * 
	 * Tutto questo avviene nel file di configurazione del contesto.
	 * E' possibile utilizzare direttamente il configBean senza
	 * disporre dei paramentri di connessione.
	 * 
	 */
	@Autowired(required=true)
	private ConfigBean configBean;
	
	private Connection connection;

	/**
	 * Metodo di inizializzazione del servizio e della connessione JDBC.
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@PostConstruct
	public void initService() throws Exception {

		/*
		 * Inizializzazione ed apertura di una connessione con username e
		 * password. Vengono passati i corrispondenti parametri di
		 * inizializzazione:
		 * 
		 * 1. string della connessione tipica di MySQL 
		 * 2. username utenza dedicata 
		 * 3. username utenza dedicata
		 */
		try {

			System.out.println("Istanziazione del driver in corso..");
			Class.forName(configBean.getDatabaseDriver());

			System.out.println("Apertura della connessione con il database in corso..");
			this.connection = DriverManager.getConnection(configBean.getDatabaseUrl(),
					configBean.getDatabaseUsername(), configBean.getDatabasePassword());

		} catch (Exception e) {

			e.printStackTrace();
			System.err.println("Errore durante l'apertura della connssione con la base dati.");
			System.err.println(e);
			throw e;
		}
		System.out.println("Connessione con il database avvenuta con successo..");
	}

	/**
	 * Chiude la connessione impagnata alla sua creazione.
	 */
	@PreDestroy
	public void terminateService() throws SQLException {
		this.connection.close();
		System.out.println("Terminazione della connessione con il database avvenuta con successo.");
	}

	/**
	 * restituisce un PreparedStatement configurato con la query passata come
	 * parametro.
	 */
	public PreparedStatement prepareStatement(String query) throws SQLException {
		return this.connection.prepareStatement(query);
	}

	/**
	 * Restituisce uno Statement.
	 */
	public Statement createStatement() throws SQLException {
		return this.connection.createStatement();
	}


	@Override
	public Connection getDatabaseConnection() throws SQLException {
		return this.connection;
	}

}
