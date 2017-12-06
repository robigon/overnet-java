/**
 * BusinessException.java
 *
 * robgion
 * www.2clever.it
 * 
 * 26 apr 2017
 * For further information please write to info@2clever.it
 */
package it.clever.spring.exception;

/**
 * @author robgion
 *
 */
public class BusinessException extends Exception {

	private static final long serialVersionUID = 1L;

	public BusinessException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public BusinessException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public BusinessException(Throwable cause) {
		super(cause);
	}

}
