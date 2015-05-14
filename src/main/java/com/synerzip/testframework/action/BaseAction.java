/**
 * 
 */
package com.synerzip.testframework.action;

import java.util.Map;

import com.synerzip.testframework.content.ContentManager;
import com.synerzip.testframework.context.Context;
import com.synerzip.testframework.driver.TestDriver;
import com.synerzip.testframework.exceptions.ActionFailedException;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseAction.
 *
 * @author rohitghatol
 */
public abstract class BaseAction {

	// The testDriver, contentMgr and context is injected by ActionDeserializer
	// class and does not
	// happen using Spring Dependency Injection. Reason being these classes are
	// create by ActionDeserializer
	// reading from flow.json and not by Spring, hence @Autowire does not work
	// here.
	// For more details visit ActionDeserailizer class
	/** The test driver. */
	protected TestDriver testDriver;

	/** The content mgr. */
	protected ContentManager contentMgr;

	/** The context. */
	protected Context context;

	/** The name. */
	protected String name;

	/** The type. */
	protected String type;

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type
	 *            the new type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the test driver.
	 *
	 * @return the test driver
	 */
	public TestDriver getTestDriver() {
		return testDriver;
	}

	/**
	 * Sets the test driver.
	 *
	 * @param testDriver
	 *            the new test driver
	 */
	public void setTestDriver(TestDriver testDriver) {
		this.testDriver = testDriver;
	}

	/**
	 * Gets the content mgr.
	 *
	 * @return the content mgr
	 */
	public ContentManager getContentMgr() {
		return contentMgr;
	}

	/**
	 * Sets the content mgr.
	 *
	 * @param contentMgr
	 *            the new content mgr
	 */
	public void setContentMgr(ContentManager contentMgr) {
		this.contentMgr = contentMgr;
	}

	/**
	 * Gets the context.
	 *
	 * @return the context
	 */
	public Context getContext() {
		return context;
	}

	/**
	 * Sets the context.
	 *
	 * @param context
	 *            the new context
	 */
	public void setContext(Context context) {
		this.context = context;
	}

	/**
	 * Execute.
	 *
	 * @throws ActionFailedException
	 *             the action failed exception
	 */
	public abstract void execute() throws ActionFailedException;

	public abstract void resolvePlaceHolders(Map<String, String> dictionary);

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public abstract String toString();

}
