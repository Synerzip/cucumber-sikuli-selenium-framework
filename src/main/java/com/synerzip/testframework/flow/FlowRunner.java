package com.synerzip.testframework.flow;

import java.util.Map;

import com.synerzip.testframework.context.Context;
import com.synerzip.testframework.exceptions.ActionFailedException;

// TODO: Auto-generated Javadoc
/**
 * The Interface FlowRunner.
 */
public interface FlowRunner {

	/**
	 * Run Flow.json
	 *
	 * @param context the context
	 * @param flowName the flow name
	 * @throws ActionFailedException the action failed exception
	 */
	void run(Context context, String flowName) throws ActionFailedException;
	
	/**
	 * Run Flow.json
	 *
	 * @param context the context
	 * @param flowName the flow name
	 * @param dictionary the dictionary
	 * @throws ActionFailedException the action failed exception
	 */
	void run(Context context, String flowName,Map<String,String> dictionary) throws ActionFailedException;
	
}
