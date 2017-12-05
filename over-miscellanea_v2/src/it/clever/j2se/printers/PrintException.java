/**
 * PrintException.java
 *
 * robgion
 * www.2clever.it
 * 
 * 22 nov 2017
 * For further information please write to info@2clever.it
 */
package it.clever.j2se.printers;

/**
 * @author robgion
 *
 */
public class PrintException extends Exception {

	private static final long serialVersionUID = 5739858946057709928L;

	public PrintException() {
	}

	/**
	 * @param message
	 */
	public PrintException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public PrintException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public PrintException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public PrintException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
