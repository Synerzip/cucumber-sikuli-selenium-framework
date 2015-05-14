/**
 * 
 */
package com.synerzip.testframework.content.impl;

import java.net.URL;

import org.sikuli.api.ImageTarget;
import org.sikuli.api.Target;
import org.springframework.stereotype.Component;

import com.synerzip.testframework.content.ContentManager;
import com.synerzip.testframework.context.Context;

// TODO: Auto-generated Javadoc
/**
 * The Class ContentManagerImpl.
 *
 * @author rohitghatol
 */
@Component
public class ContentManagerImpl implements ContentManager {

	/** The Constant PREFIX. */
	private static final String PREFIX = "images";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.synerzip.testframework.content.ContentManager#getImage(com.synerzip.testframework.context
	 * .Context, java.lang.String)
	 */
	@Override
	public Target getImage(Context context, String image) {
		return getImage(context.getFeature(), image);
	}

	
	/**
	 * Gets the image.
	 *
	 * @param feature the feature
	 * @param image the image
	 * @return the image
	 */
	private Target getImage(String feature, String image) {
		Target target = null;
		URL url = this.getImageURL(feature, image);
		if (url != null) {
			target = new ImageTarget(url);
		}
		return target;
	}

	
	/**
	 * Gets the image url.
	 *
	 * @param feature the feature
	 * @param image the image
	 * @return the image url
	 */
	private URL getImageURL(String feature, String image) {
		URL url = ContentManagerImpl.class.getClassLoader().getResource(
				PREFIX + "/" + feature + "/" + image);

		if (url == null) {

			url = ContentManagerImpl.class.getClassLoader().getResource(
					PREFIX + "/" + image);

		}

		return url;
	}

}
