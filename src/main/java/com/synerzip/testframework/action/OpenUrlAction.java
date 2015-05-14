/**
 * 
 */
package com.synerzip.testframework.action;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.synerzip.testframework.exceptions.ActionFailedException;

// TODO: Auto-generated Javadoc
/**
 * The Class ClickImageAction.
 *
 * @author rohitghatol
 */
public class OpenUrlAction extends BaseAction {

	/** The image. */
	private String url;

	/** The error message. */
	private String errorMessage;

	/** The wait period in millis. */
	private int waitPeriodInMillis;

	

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Gets the error message.
	 *
	 * @return the error message
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Sets the error message.
	 *
	 * @param errorMessage
	 *            the new error message
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * Gets the wait period in millis.
	 *
	 * @return the wait period in millis
	 */
	public int getWaitPeriodInMillis() {
		return waitPeriodInMillis;
	}

	/**
	 * Sets the wait period in millis.
	 *
	 * @param waitPeriodInMillis
	 *            the new wait period in millis
	 */
	public void setWaitPeriodInMillis(int waitPeriodInMillis) {
		this.waitPeriodInMillis = waitPeriodInMillis;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.synerzip.testframework.action.BaseAction#execute()
	 */
	@Override
	public void execute() throws ActionFailedException {

		WebDriver webDriver = testDriver.getWebDriver();
		webDriver.get(url);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.synerzip.testframework.action.BaseAction#toString()
	 */
	@Override
	public String toString() {
		return "OpenUrlAction [url=" + url + ", errorMessage="
				+ errorMessage + ", waitPeriodInMillis=" + waitPeriodInMillis
				+ ", name=" + name + ", type=" + type + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.synerzip.testframework.action.BaseAction#resolvePlaceHolders(java.util.Map)
	 */
	@Override
	public void resolvePlaceHolders(Map<String, String> dictionary) {
		// TODO Auto-generated method stub

	}

}
