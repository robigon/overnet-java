/**
 * UserUtils.java
 *
 * robgion
 * www.2clever.it
 * 
 * 25 ott 2017
 * For further information please write to info@2clever.it
 */
package it.webapp.utils;

import it.webapp.model.dto.UserDto;
import it.webapp.model.vo.UserVo;

/**
 * @author robgion
 *
 */
public class UserUtils {

	/**
	 * Metodo peril travaso delle informazioni dal VO al DTO.
	 * @param userVo
	 * @return
	 */
	public static UserDto fromUserVoToDto(UserVo userVo) {
		UserDto retDto = new UserDto();
		retDto.setLastName(userVo.getLastName());
		retDto.setName(userVo.getName());
		retDto.setUserId(userVo.getUserId());
		retDto.setUsername(userVo.getUsername());
		
		return retDto;
	}
}
