/**
 * ResourceUtils.java
 *
 * robgion
 * www.2clever.it
 * 
 * 18 apr 2017
 * For further information please write to info@2clever.it
 */
package it.clever.spring.utils;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author robgion
 *
 */
public class ResourceUtils {
	
	public static final String RESOURCE_FILE_BUNDLE_PATH = "i18n/bundle";

	/**
	 * Recupera un messaggio dal resource bundle tramite la chiave.
	 * 
	 * @param key
	 * @param lang
	 * @return
	 */
	public static String getMessageBundleByKey(String key, String lang) {
		ResourceBundle bundle = ResourceBundle.getBundle(RESOURCE_FILE_BUNDLE_PATH, new Locale(lang));
		return bundle.getString(key);
	}
}
