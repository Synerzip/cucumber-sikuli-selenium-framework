# cucumber-sikuli-selenium-framework 
Sikuli Cucumber Gradle Test Framework Showcase

## Setup
* Java SDK 7
* Eclipse Luna
* Eclipse Plugins
  * Gradle Integration for Eclipse http://dist.springsource.com/milestone/TOOLS/gradle
 
Eclipse Setup
* Open Eclipse Luna 
* Install Plugin - Gradle Integration for Eclipse http://dist.springsource.com/milestone/TOOLS/gradle
* Restart Eclipse
* click on File -> Import -> Gradle Project
* Choose the checkout directory
* Click on "Build Model" then you will see the project in the list below, select that and click "Finish"

## Steps

* Checkout the project
* Close all Browser Windows
* On Linux/Mac run $>./gradlew cucumber
* on Windows run cmd>gradlew.bat cucumber

This should start a new Browser window, shows Google Text Search and Image Search for keyword "facebook".
The Text Search uses Selenium and the Image Search uses Sikuli.

## Architecture

The way this framework works is Feature file are run by cucumber which calls the Step Definition classes, which in turn call FlowRunner.java class, which in turn runs step.json file. In step.json file we have Actions (Selenium and Sikuli actions for verifying element/image is present, clicking them, typing in them). See BaseAction and its derived classes.

Feature File ==> Step Definitions ==> Flow.json ==> Actions

Feature File
```
Feature: Google Text Search


Scenario: Doing Google Text Search
    Given Google in Open in Browser    
    When I search for "Facebook"
    Then I can see "Welcome to Facebook - Log In, Sign Up or Learn More" link in search result

Scenario: Doing Google Text Search
    Given Google in Open in Browser    
    When I search for "Facebook" image
    Then I can see facebook image in search result
    
```

Step Definition File
```
package com.synerzip.testframework.steps;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.synerzip.testframework.context.Context;
import com.synerzip.testframework.flow.FlowRunner;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleImageSearchStepDefinitions {

	
	@Autowired
	private Context context;

	@Autowired
	private FlowRunner flowRunner;
	
	
	@When("^I search for \"(.*?)\" image$")
	public void i_search_for_image(String searchKeyword) throws Throwable {
		context.setFeature("google/image");
		Map<String,String> dictionary = new HashMap<String,String>();
		dictionary.put("text", searchKeyword);
	    flowRunner.run(context, "when-1.json",dictionary);
	}

	@Then("^I can see facebook image in search result$")
	public void i_can_see_facebook_image_in_search_result() throws Throwable {
		context.setFeature("google/image");
	    flowRunner.run(context, "then-1.json");
	}

	

}

```

Step.json
```
[{
    "name": "Type in Google Search Text Box",
    "type": "TypeInWebElementAction",

    "selector": "id:lst-ib",
    "text": "{{text}}",
    "errorMessage": "Could not search for keyword in Google Search",
    "waitPeriodInMillis": 10000

},
{
    "name": "Click on Search Button",
    "type": "ClickWebElementAction",

    "selector": "name:btnG",
    "text": "{{text}}",
    "errorMessage": "Could not find Search Button",
    "waitPeriodInMillis": 10000

}]
```

Base Action class
```
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
```


TypeInImageAction (sikuli)
```
/**
 * 
 */
package com.synerzip.testframework.action;

import static org.junit.Assert.assertNotNull;
import static org.sikuli.api.API.pause;

import java.util.Map;

import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.sikuli.api.robot.Key;
import org.sikuli.api.robot.Keyboard;
import org.sikuli.api.robot.Mouse;

import com.synerzip.testframework.exceptions.ActionFailedException;

// TODO: Auto-generated Javadoc
/**
 * The Class TypeInImageAction.
 *
 * @author rohitghatol
 */
public class TypeInImageAction extends BaseAction {

	/** The image. */
	private String image;

	/** The text. */
	private String text;

	/** The error message. */
	private String errorMessage;

	/** The wait period in millis. */
	private int waitPeriodInMillis;

	/**
	 * Gets the image.
	 *
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * Sets the image.
	 *
	 * @param image
	 *            the new image
	 */
	public void setImage(String image) {
		this.image = image;
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

	/**
	 * Gets the text.
	 *
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the text.
	 *
	 * @param text
	 *            the new text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.synerzip.testframework.action.BaseAction#execute()
	 */
	@Override
	public void execute() throws ActionFailedException {
		ScreenRegion screenRegion = testDriver.getScreenRegion();
		Mouse mouse = testDriver.getMouse();
		Keyboard keyboard = testDriver.getKeyboard();

		Target imageTarget = contentMgr.getImage(context, image);

		ScreenRegion newmessage = screenRegion.wait(imageTarget,
				waitPeriodInMillis);

		assertNotNull(errorMessage, newmessage);

		mouse.click(newmessage.getCenter());

		keyboard.type(text);
		pause(waitPeriodInMillis);
		keyboard.type(Key.ENTER);

	}

	@Override
	public String toString() {
		return "TypeInImageAction [image=" + image + ", text=" + text
				+ ", errorMessage=" + errorMessage + ", waitPeriodInMillis="
				+ waitPeriodInMillis + ", name=" + name + ", type=" + type
				+ "]";
	}

	@Override
	public void resolvePlaceHolders(Map<String, String> dictionary) {
		for (String key : dictionary.keySet()) {
			text = text.replace("{{" + key + "}}", dictionary.get(key));
		}

	}

}

```

TypeInWebElement (selenium)
```
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

```
