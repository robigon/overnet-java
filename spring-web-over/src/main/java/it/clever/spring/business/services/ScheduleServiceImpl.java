/**
 * ScheduleServiceImpl.java
 *
 * robgion
 * www.2clever.it
 * 
 * 30 giu 2017
 * For further information please write to info@2clever.it
 */
package it.clever.spring.business.services;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * @author robgion
 *
 * Servizio 
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {


	private static Logger logger = Logger.getLogger(ScheduleServiceImpl.class);
	
	@Override
	public void clean() throws Exception {

		logger.info("Pulizia in corso");
	}

}
