/**
 * 
 */
package com.synerzip.testframework.flow.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.synerzip.testframework.action.BaseAction;
import com.synerzip.testframework.context.Context;
import com.synerzip.testframework.exceptions.ActionFailedException;
import com.synerzip.testframework.flow.FlowReader;
import com.synerzip.testframework.flow.FlowRunner;

// TODO: Auto-generated Javadoc
/**
 * The Class FlowRunnerImpl.
 *
 * @author rohitghatol
 */
@Component
public class FlowRunnerImpl implements FlowRunner {

	/** The flow reader. */
	@Autowired
	private FlowReader flowReader;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.synerzip.testframework.flow.FlowRunner#run(com.synerzip.testframework.context.Context,
	 * java.lang.String)
	 */
	@Override
	public void run(Context context, String flowName)
			throws ActionFailedException {
		List<BaseAction> actions = flowReader.read(context, flowName);

		for (BaseAction action : actions) {
			action.execute();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.synerzip.testframework.flow.FlowRunner#run(com.synerzip.testframework.context.Context,
	 * java.lang.String, java.util.Map)
	 */
	@Override
	public void run(Context context, String flowName,
			Map<String, String> dictionary) throws ActionFailedException{
		List<BaseAction> actions = flowReader.read(context, flowName,
				dictionary);

		for (BaseAction action : actions) {
			action.execute();
		}

	}

}
