/**
 * 
 */
package com.synerzip.testframework.context.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.synerzip.testframework.context.Context;

// TODO: Auto-generated Javadoc
/**
 * The Class ContextImpl.
 *
 * @author rohitghatol
 */
@Component
public class ContextImpl implements Context {

	/** The map. */
	private Map<String, String> map = new HashMap<String, String>();

	/* (non-Javadoc)
	 * @see com.synerzip.testframework.context.Context#containsKey(java.lang.String)
	 */
	public boolean containsKey(String key) {
		return map.containsKey(key);
	}

	/* (non-Javadoc)
	 * @see com.synerzip.testframework.context.Context#get(java.lang.String)
	 */
	public String get(String key) {
		return map.get(key);
	}

	/* (non-Javadoc)
	 * @see com.synerzip.testframework.context.Context#put(java.lang.String, java.lang.String)
	 */
	public String put(String key, String value) {
		return map.put(key, value);
	}

	/* (non-Javadoc)
	 * @see com.synerzip.testframework.context.Context#remove(java.lang.String)
	 */
	public String remove(String key) {
		return map.remove(key);
	}

	/* (non-Javadoc)
	 * @see com.synerzip.testframework.context.Context#clear()
	 */
	public void clear() {
		map.clear();
	}

	

	/* (non-Javadoc)
	 * @see com.synerzip.testframework.context.Context#setFeature(java.lang.String)
	 */
	@Override
	public void setFeature(String feature) {
		map.put("feature",feature);
		
	}

	@Override
	public String getFeature() {
		return map.get("feature");
	}

}
