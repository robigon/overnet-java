package com.opengest.core.business.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.webapp.web.utils.ConfigBean;

/**
 * 
 * @author 2Clever
 *
 */
class JpaServiceImpl implements JpaService {

	private static JpaServiceImpl _instance = null;
	private EntityManagerFactory emfactory = null;
	
	
	/**
	 * Costruttore private per l'implementazione del pattern Singleton
	 */
	private JpaServiceImpl(ConfigBean configs) throws RuntimeException {
		
		emfactory = Persistence.
				createEntityManagerFactory(configs.getJpaName());
	}
	
	/**
	 * Metodo di recupero dell'istanza Singleton.
	 * @return
	 */
	public static synchronized JpaServiceImpl getInstance(ConfigBean configs) throws RuntimeException {
		
		if(_instance == null) {
			_instance = new JpaServiceImpl(configs);
		}
		return _instance;
	}
	
	/**
	 * Metodo per il recupero dell'EntityManager.
	 * @return
	 */
	public EntityManager getEntityManager() {
		return emfactory.createEntityManager();
	}

	@Override
	public EntityManager getDatabaseConnection()  {
		return emfactory.createEntityManager();
	}

	@Override
	public void terminateServices() {
		emfactory.close();
	}
}
