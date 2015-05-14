package com.synerzip.testframework.driver.impl;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.robot.Keyboard;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopKeyboard;
import org.sikuli.api.robot.desktop.DesktopMouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.synerzip.testframework.driver.TestDriver;
import com.synerzip.testframework.webelement.WebSelector;

// TODO: Auto-generated Javadoc
//FIXME - Wire this using Dependency Injection (Pico or Spring)
/**
 * The Class TestDriverImpl.
 */
@Component
public class TestDriverImpl implements TestDriver {

	/** The web driver. */
	private WebDriver webDriver;

	/** The web selector. */
	@Autowired
	private WebSelector webSelector;

	/** The screen region. */
	private ScreenRegion screenRegion;

	/** The keyboard. */
	private Keyboard keyboard;

	/** The mouse. */
	private Mouse mouse;

	/**
	 * Instantiates a new test driver impl.
	 */
	public TestDriverImpl() {

		String browserType = System.getProperty("browser", "chrome");
		if (browserType.equals("chrome")) {
			webDriver = new ChromeDriver();
		} else {
			webDriver = null;
		}
		screenRegion = new DesktopScreenRegion();
		keyboard = new DesktopKeyboard();
		mouse = new DesktopMouse();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.synerzip.driver.TestDriver#getWebDriver()
	 */
	@Override
	public WebDriver getWebDriver() {
		return webDriver;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.synerzip.driver.TestDriver#getScreenRegion()
	 */
	@Override
	public ScreenRegion getScreenRegion() {
		return screenRegion;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.synerzip.driver.TestDriver#getKeyboard()
	 */
	@Override
	public Keyboard getKeyboard() {
		return keyboard;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.synerzip.driver.TestDriver#getMouse()
	 */
	@Override
	public Mouse getMouse() {
		return mouse;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.synerzip.testframework.driver.TestDriver#getWebSelector()
	 */
	@Override
	public WebSelector getWebSelector() {

		return webSelector;
	}

}
