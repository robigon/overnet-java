/**
 * UserDaoImpl.java
 *
 * robgion
 * www.2clever.it
 * 
 * 05 lug 2017
 * For further information please write to info@2clever.it
 */
package it.clever.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.clever.spring.services.DatabaseService;
import it.clever.spring.vo.UserVo;

/**
 * @author robgion
 *
 * Classe per la gestione delle operazioni sulata tabella degli utenti.
 * Le classi che accedono ai dati devono essere annotate con @Repository.
 * 
 */
@Repository(value="jpaUserDao")
public class UserDaoImpl implements UserDao {

	
	/**
	 * @Autowired sta a specificare l'esigenza di una iniezione
	 * di una classe che a sua volta deve essere gestita da Spring,
	 * quindi dovrà essere annotata con @controller, @Component o @Service
	 * 
	 * Con le annotation non c'è più necessità di specificare la 
	 * setter o costructor injection.
	 * 
	 * In questo caso inietto dentro al DAO una classe che gestisce le connessioni a database
	 */
	@Autowired(required=true)
	private DatabaseService databaseService;
	
	
	@Override
	public UserVo authorize(String username, String password) throws Exception {
		
		UserVo retuser = null;
		
		Connection connection = null; 
		
		try {
			
			connection = databaseService.getDatabaseConnection();

			// Fa la stessa cosa ma non ottimizza il codice.
//			JdbcService service = JdbcServiceImpl.getConfiguredInstance();
//			connection = service.getDatabaseConnection();
			
			PreparedStatement ps = connection.prepareStatement("select * from utenti where username = ? and password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				retuser = new UserVo();
				retuser.setUserId(rs.getLong("id_utente"));
				retuser.setUsername(rs.getString("username"));
				retuser.setPassword(rs.getString("password"));
				retuser.setName(rs.getString("nome"));
				retuser.setLastName(rs.getString("cognome"));
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new Exception("Errore durante la fase di autenticazione dell'utente");
			
		} finally {
			if(connection != null) 
				connection.close();
		}
		
		return retuser;
	}
	
	@Override
	public List<UserVo> findAllUsers() throws Exception {
		
		List<UserVo> retList = null;
		
		Connection connection = null;
		try {
			
			connection = databaseService.getDatabaseConnection();
			
			/*
			 * Recupero uno statement semplice perchè non ho esigenza di 
			 * una query paramentrica.
			 */
			Statement statement = connection.createStatement();
			
			ResultSet rs = statement.executeQuery("select * from utenti");
			retList = new ArrayList<>();
			
			while(rs.next()) {
				UserVo retuser = new UserVo();
				retuser.setUserId(rs.getLong("id_utente"));
				retuser.setUsername(rs.getString("username"));
				retuser.setPassword(rs.getString("password"));
				retuser.setName(rs.getString("nome"));
				retuser.setLastName(rs.getString("cognome"));
				
				retList.add(retuser);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new Exception("Errore durante il recupero della lista degli utenti.");
			
		} finally {
			if(connection != null) 
				connection.close();
		}
		
		return retList;
	}
	
	@Override
	public UserVo findByPrimaryKey(Long id) throws Exception {
		
		UserVo retuser = null;
		
		Connection connection = null;
		try {
			
			connection = databaseService.getDatabaseConnection();
			PreparedStatement ps = connection.prepareStatement("select * from utenti where id_utente = ?");
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				retuser = new UserVo();
				retuser.setUserId(rs.getLong("id_utente"));
				retuser.setUsername(rs.getString("username"));
				retuser.setPassword(rs.getString("password"));
				retuser.setName(rs.getString("nome"));
				retuser.setLastName(rs.getString("cognome"));
			}
			
		}  catch (Exception e) {
			
			e.printStackTrace();
			throw new Exception("Errore durante il recupero del dettaglio utente.");
			
		} finally {
			if(connection != null) 
				connection.close();
		}
		
		return retuser;
	}
}
