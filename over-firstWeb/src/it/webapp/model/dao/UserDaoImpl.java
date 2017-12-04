/**
 * UserDaoImpl.java
 *
 * robgion
 * www.2clever.it
 * 
 * 05 lug 2017
 * For further information please write to info@2clever.it
 */
package it.webapp.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.webapp.exceptions.DatabaseException;
import it.webapp.exceptions.ErrorCodes;
import it.webapp.model.services.DatabaseServiceFactory;
import it.webapp.model.vo.UserVo;

/**
 * @author robgion
 *
 *         Classe per la gestione delle operazioni sulata tabella degli utenti.
 * 
 */
public class UserDaoImpl implements UserDao {

	/**
	 * Metodo per l'autenticazione applicativa dell'utente connesso.
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@Override
	public UserVo authorize(String username, String password) throws DatabaseException {

		UserVo retuser = null;

		Connection connection = null;

		try {

			connection = DatabaseServiceFactory.getJdbcDatabaseService().getDatabaseConnection();

			PreparedStatement ps = connection
					.prepareStatement("select * from utenti where username = ? and password = ?");
			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				retuser = new UserVo();
				retuser.setUserId(rs.getLong("id_utente"));
				retuser.setUsername(rs.getString("username"));
				retuser.setPassword(rs.getString("password"));
				retuser.setName(rs.getString("nome"));
				retuser.setLastName(rs.getString("cognome"));
			}

		} catch (Exception e) {

			e.printStackTrace();
			throw new DatabaseException("Errore durante la fase di autenticazione dell'utente", e, ErrorCodes.ERROR_CODE_GENERIC);

		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new DatabaseException("Errore durante la fase di autenticazione dell'utente", e, ErrorCodes.ERROR_CODE_GENERIC);
				}
		}

		return retuser;
	}

	/**
	 * Recupero della lista di tutti gli utenti da tabella.
	 * 
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<UserVo> findAllUsers() throws DatabaseException {

		List<UserVo> retList = null;

		Connection connection = null;
		try {

			connection = DatabaseServiceFactory.getJdbcDatabaseService().getDatabaseConnection();

			/*
			 * Recupero uno statement semplice perchè non ho esigenza di una
			 * query paramentrica.
			 */
			Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery("select * from utenti");
			retList = new ArrayList<>();

			while (rs.next()) {
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
			throw new DatabaseException("Errore durante il recupero della lista degli utenti.", e, ErrorCodes.ERROR_CODE_GENERIC);

		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new DatabaseException("Errore durante la fase di autenticazione dell'utente", e, ErrorCodes.ERROR_CODE_GENERIC);
				}
		}

		return retList;
	}

	@Override
	public UserVo findByPrimaryKey(Long id) throws DatabaseException {

		UserVo retuser = null;

		Connection connection = null;
		try {

			connection = DatabaseServiceFactory.getJdbcDatabaseService().getDatabaseConnection();
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

		} catch (Exception e) {

			e.printStackTrace();
			throw new DatabaseException("Errore durante il recupero del dettaglio utente.", e, ErrorCodes.ERROR_CODE_GENERIC);

		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new DatabaseException("Errore durante la fase di autenticazione dell'utente", e, ErrorCodes.ERROR_CODE_GENERIC);
				}
		}

		return retuser;
	}
}
