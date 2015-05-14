/**
 * 
 */
package com.synerzip.testframework.action;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.synerzip.testframework.exceptions.ActionFailedException;


// TODO: Auto-generated Javadoc
/**
 * The Class BrowserForegroundAction.
 */
public class BrowserForegroundAction extends BaseAction {

	/** The error message. */
	private String errorMessage;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.synerzip.testframework.action.BaseAction#execute()
	 */
	@Override
	public void execute() throws ActionFailedException {
		WebDriver webDriver = testDriver.getWebDriver();
		String currentWindowHandle = webDriver.getWindowHandle();

		// Needed on Mac to get Chrome in Foreground
		// run your javascript and alert code
		((JavascriptExecutor) webDriver).executeScript("alert('Test')");
		webDriver.switchTo().alert().accept();

		// Switch back to to the window using the handle saved earlier
		webDriver.switchTo().window(currentWindowHandle);

		webDriver.manage().window().maximize();

	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BrowserForegroundAction [errorMessage=" + errorMessage
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
