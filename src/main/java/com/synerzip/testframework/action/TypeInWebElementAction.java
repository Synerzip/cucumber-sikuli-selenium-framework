/**
 * 
 */
package com.synerzip.testframework.action;

import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.synerzip.testframework.exceptions.ActionFailedException;
import com.synerzip.testframework.webelement.WebSelector;

// TODO: Auto-generated Javadoc
/**
 * The Class ClickImageAction.
 *
 * @author rohitghatol
 */
public class TypeInWebElementAction extends BaseAction {

	/** The image. */
	private String selector;	
	
	private String text;

	/** The error message. */
	private String errorMessage;

	/** The wait period in millis. */
	private int waitPeriodInMillis;

	
	/**
	 * @return the selector
	 */
	public String getSelector() {
		return selector;
	}

	/**
	 * @param selector the selector to set
	 */
	public void setSelector(String selector) {
		this.selector = selector;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
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
		WebSelector webSelector = testDriver.getWebSelector();
		
		By by = webSelector.getBySelector(selector);
		
		WebDriverWait wait = new WebDriverWait(webDriver, waitPeriodInMillis/1000);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
		
		WebElement webElement = webDriver.findElement(by);
		assertNotNull(errorMessage, webElement);
		webElement.sendKeys(text);
	}

	

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.synerzip.testframework.action.BaseAction#resolvePlaceHolders(java.util.Map)
	 */
	@Override
	public void resolvePlaceHolders(Map<String, String> dictionary) {
		for (String key : dictionary.keySet()) {
			text = text.replace("{{" + key + "}}", dictionary.get(key));
			selector = selector.replace("{{" + key + "}}", dictionary.get(key));
		}

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TypeInWebElementAction [selector=" + selector + ", text="
				+ text + ", errorMessage=" + errorMessage
				+ ", waitPeriodInMillis=" + waitPeriodInMillis + ", name="
				+ name + ", type=" + type + "]";
	}
	
	

}
