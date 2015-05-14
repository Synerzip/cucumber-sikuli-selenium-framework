package com.synerzip.testframework.driver;

import org.openqa.selenium.WebDriver;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.robot.Keyboard;
import org.sikuli.api.robot.Mouse;

import com.synerzip.testframework.webelement.WebSelector;

// TODO: Auto-generated Javadoc
/**
 * The Interface TestDriver.
 */
public interface TestDriver {

	/**
	 * Gets the web driver.
	 *
	 * @return the web driver
	 */
	WebDriver getWebDriver();

	/**
	 * Gets the web selector.
	 *
	 * @return the web selector
	 */
	WebSelector getWebSelector();

	/**
	 * Gets the screen region.
	 *
	 * @return the screen region
	 */
	ScreenRegion getScreenRegion();

	/**
	 * Gets the keyboard.
	 *
	 * @return the keyboard
	 */
	Keyboard getKeyboard();

	/**
	 * Gets the mouse.
	 *
	 * @return the mouse
	 */
	Mouse getMouse();

}
