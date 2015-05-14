package com.synerzip.testframework.flow;

import java.util.List;
import java.util.Map;

import com.synerzip.testframework.action.BaseAction;
import com.synerzip.testframework.context.Context;

// TODO: Auto-generated Javadoc
/**
 * The Interface FlowReader.
 */
public interface FlowReader {

	
	/**
	 * Read Flow.json
	 *
	 * @param context the context
	 * @param flowName the flow name
	 * @return the list
	 */
	List<BaseAction> read(Context context, String flowName);
	
	/**
	 * Read Flow.json
	 *
	 * @param context the context
	 * @param flowName the flow name
	 * @param dictionary the dictionary
	 * @return the list
	 */
	List<BaseAction> read(Context context, String flowName,Map<String,String> dictionary);
	
}
