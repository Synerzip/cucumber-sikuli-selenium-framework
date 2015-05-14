/**
 * 
 */
package com.synerzip.testframework.flow.impl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.synerzip.testframework.action.BaseAction;
import com.synerzip.testframework.action.BrowserForegroundAction;
import com.synerzip.testframework.action.ClickImageAction;
import com.synerzip.testframework.action.ClickWebElementAction;
import com.synerzip.testframework.action.OpenUrlAction;
import com.synerzip.testframework.action.TypeInImageAction;
import com.synerzip.testframework.action.TypeInWebElementAction;
import com.synerzip.testframework.action.VerifyImageAction;
import com.synerzip.testframework.action.VerifyWebElementAction;
import com.synerzip.testframework.content.ContentManager;
import com.synerzip.testframework.context.Context;
import com.synerzip.testframework.driver.TestDriver;

// TODO: Auto-generated Javadoc
/**
 * The Class ActionDeserializer.
 *
 * @author rohitghatol
 */
@Component
public class ActionDeserializer implements JsonDeserializer<List<BaseAction>> {

	/** The map. */
	private static Map<String, Class> map = new TreeMap<String, Class>();

	
	static {

		map.put("ClickImageAction", ClickImageAction.class);
		map.put("TypeInImageAction", TypeInImageAction.class);
		map.put("VerifyImageAction", VerifyImageAction.class);
		map.put("OpenUrlAction", OpenUrlAction.class);
		map.put("BrowserForegroundAction", BrowserForegroundAction.class);
		map.put("ClickWebElementAction", ClickWebElementAction.class);
		map.put("TypeInWebElementAction", TypeInWebElementAction.class);
		map.put("VerifyWebElementAction", VerifyWebElementAction.class);
		
	}

	/** The test driver. */
	@Autowired
	protected TestDriver testDriver;
	
	/** The content mgr. */
	@Autowired
	protected ContentManager contentMgr;
	
	/** The context. */
	@Autowired
	protected Context context;
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.gson.JsonDeserializer#deserialize(com.google.gson.JsonElement,
	 * java.lang.reflect.Type, com.google.gson.JsonDeserializationContext)
	 */
	public List<BaseAction> deserialize(JsonElement json, Type typeOfT,
			JsonDeserializationContext jsonContext) throws JsonParseException {

		List<BaseAction> list = new ArrayList<BaseAction>();
		JsonArray ja = json.getAsJsonArray();

		for (JsonElement je : ja) {

			String type = je.getAsJsonObject().get("type").getAsString();
			Class<BaseAction> c = map.get(type);
			if (c == null)
				throw new RuntimeException("Unknow class: " + type);
			BaseAction action = ((BaseAction)jsonContext.deserialize(je, c));
			
			//Manually Inject the contentManager, context and testDriver
			action.setContentMgr(this.contentMgr);
			action.setContext(this.context);
			action.setTestDriver(this.testDriver);
			

			
			list.add(action);
		}

		return list;

	}

}
