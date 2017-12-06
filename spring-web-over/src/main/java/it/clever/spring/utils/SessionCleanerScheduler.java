/**
 * SessionCleanerScheduler.java
 *
 * robgion
 * www.2clever.it
 * 
 * 30 giu 2017
 * For further information please write to info@2clever.it
 */
package it.clever.spring.utils;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import it.clever.spring.business.services.ScheduleService;

/**
 * @author robgion
 *
 * Classe che attiva un task 
 */
@Component
public class SessionCleanerScheduler {

	private final static long DELAY = 5000;
	
	private static Logger logger = Logger.getLogger(SessionCleanerScheduler.class);

	@Autowired
	private ScheduleService scheduleService;
	

    @Scheduled(fixedRate = DELAY)
    public void reportCurrentTime() {
    	
    	
    	try {
			scheduleService.clean();
			
		} catch (Exception e) {
			logger.error("Errore durante la cancellazione delle sessioi");
			logger.error(e);
		}
    	
    	logger.info("Pulizia conclusa.");
    }
    
}
