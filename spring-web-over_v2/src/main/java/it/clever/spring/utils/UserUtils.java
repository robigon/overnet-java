/**
 * UserUtils.java
 *
 * robgion
 * www.2clever.it
 * 
 * 19 lug 2017
 * For further information please write to info@2clever.it
 */
package it.clever.spring.utils;

import it.clever.spring.business.model.Utente;
import it.clever.spring.web.viewbeans.UserViewBean;

/**
 * @author robgion
 *
 */
public class UserUtils {

	/**
	 * Trasforma un ViewBean in un Vo.
	 * 
	 * @param uvb
	 * @return
	 */
	public static Utente fromViewBeanToVo(UserViewBean uvb) {
		Utente vo = new Utente();
		vo.setIdUtente(uvb.getUserId());
		vo.setCognome(uvb.getLastName());
		vo.setNome(uvb.getName());
		vo.setUsername(uvb.getUsername());
		vo.setPassword(uvb.getPassword());
		return vo;
	}
}
