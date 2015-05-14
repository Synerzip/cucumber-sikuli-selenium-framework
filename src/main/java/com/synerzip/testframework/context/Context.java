/**
 * 
 */
package com.synerzip.testframework.context;

// TODO: Auto-generated Javadoc
/**
 * The Interface Context.
 *
 * @author rohitghatol
 */
public interface Context {

	
	/**
	 * Sets the feature.
	 *
	 * @param feature the new feature
	 */
	void setFeature(String feature);
	
	
	/**
	 * Gets the feature.
	 *
	 * @return the feature
	 */
	String getFeature();
	
	
	/**
	 * Contains key.
	 *
	 * @param key the key
	 * @return true, if successful
	 */
	boolean containsKey(String key);

	/**
	 * Gets the.
	 *
	 * @param key the key
	 * @return the string
	 */
	String get(String key);

	/**
	 * Put.
	 *
	 * @param key the key
	 * @param value the value
	 * @return the string
	 */
	String put(String key, String value);

	/**
	 * Removes the.
	 *
	 * @param key the key
	 * @return the string
	 */
	String remove(String key);

	/**
	 * Clear.
	 */
	void clear();
}
