package it.webapp.model.services;

import it.webapp.utils.ConfigBean;

@SuppressWarnings("rawtypes")
public class DatabaseServiceFactory {

	private static JdbcService _jdbcService;
	private static JpaService _jpaService;

	public static void initServices(ConfigBean configs) {

		_jdbcService = JdbcServiceImpl.getInstance(configs);
		_jpaService = JpaServiceImpl.getInstance(configs);
	}

	public static void terminateServices() throws RuntimeException {
		
		_jdbcService.terminateServices();
		_jpaService.terminateServices();
	}

	/**
	 * restituisce una istanza del servizio database tramite JDBC.
	 * 
	 * @return
	 */
	public static JdbcService getJdbcDatabaseService() {

		if (_jdbcService == null)
			throw new RuntimeException("Servizio non disponibile");

		return _jdbcService;
	}
	
	/**
	 * restituisce una istanza del servizio database tramite JPA.
	 * 
	 * @return
	 */
	public static JpaService getJPADatabaseService() {
		
		if (_jpaService == null)
			throw new RuntimeException("Servizio non disponibile");
		
		return _jpaService;
	}
}
