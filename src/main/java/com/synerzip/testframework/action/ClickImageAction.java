/**
 * 
 */
package com.synerzip.testframework.action;

import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.sikuli.api.robot.Mouse;

import com.synerzip.testframework.exceptions.ActionFailedException;

// TODO: Auto-generated Javadoc
/**
 * The Class ClickImageAction.
 *
 * @author rohitghatol
 */
public class ClickImageAction extends BaseAction {

	/** The image. */
	private String image;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.synerzip.testframework.action.BaseAction#execute()
	 */
	@Override
	public void execute() throws ActionFailedException {

		ScreenRegion screenRegion = testDriver.getScreenRegion();
		Mouse mouse = testDriver.getMouse();

		Target imageTarget = contentMgr.getImage(context, image);

		ScreenRegion newmessage = screenRegion.wait(imageTarget,
				waitPeriodInMillis);

		assertNotNull(errorMessage, newmessage);

		mouse.click(newmessage.getCenter());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.synerzip.testframework.action.BaseAction#toString()
	 */
	@Override
	public String toString() {
		return "ClickImageAction [image=" + image + ", errorMessage="
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
