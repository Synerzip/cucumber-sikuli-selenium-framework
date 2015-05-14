/**
 * 
 */
package com.synerzip.testframework.flow.impl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.stream.JsonReader;
import com.synerzip.testframework.action.BaseAction;
import com.synerzip.testframework.content.impl.ContentManagerImpl;
import com.synerzip.testframework.context.Context;
import com.synerzip.testframework.flow.FlowReader;

// TODO: Auto-generated Javadoc
/**
 * The Class FlowReaderImpl.
 *
 * @author rohitghatol
 */
@Component
public class FlowReaderImpl implements FlowReader {

	/** The Constant PREFIX. */
	private static final String PREFIX = "flows";

	/** The deserializer. */
	@Autowired
	private JsonDeserializer<List<BaseAction>> deserializer;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.synerzip.testframework.action.factory.FlowReader#read(com.synerzip.testframework.context
	 * .Context, java.lang.String)
	 */
	@Override
	public List<BaseAction> read(Context context, String flowName) {
		return this.read(context, flowName, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.synerzip.testframework.action.factory.FlowReaderFactory#read(com.synerzip.testframework
	 * .context.Context, java.lang.String)
	 */
	@Override
	public List<BaseAction> read(Context context, String flowName,
			Map<String, String> dictionary) {
		URL url = getFlowUrl(context.getFeature(), flowName);

		List<BaseAction> listBaseActions = new ArrayList<BaseAction>();

		GsonBuilder gb = new GsonBuilder();

		gb.registerTypeAdapter(listBaseActions.getClass(), deserializer);

		Gson gson = gb.create();
		JsonReader reader;
		try {
			reader = new JsonReader(new InputStreamReader(url.openStream()));
			listBaseActions = gson.fromJson(reader, listBaseActions.getClass());
			if (dictionary != null) {
				resolvePlaceHolders(listBaseActions, dictionary);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listBaseActions;
	}

	/**
	 * Resolve place holders.
	 *
	 * @param listBaseActions
	 *            the list base actions
	 * @param dictionary
	 *            the dictionary
	 */
	private void resolvePlaceHolders(List<BaseAction> listBaseActions,
			Map<String, String> dictionary) {
		for (BaseAction action : listBaseActions) {
			action.resolvePlaceHolders(dictionary);
		}

	}

	/**
	 * Gets the flow url.
	 *
	 * @param device
	 *            the device
	 * @param app
	 *            the app
	 * @param flowName
	 *            the flow name
	 * @return the flow url
	 */
	private URL getFlowUrl(String feature, String flowName) {
		URL url = ContentManagerImpl.class.getClassLoader().getResource(
				PREFIX + "/" + feature + "/" + flowName);
		if (url == null) {
			url = ContentManagerImpl.class.getClassLoader().getResource(
					PREFIX + "/" + flowName);
		}
		return url;
	}

}
