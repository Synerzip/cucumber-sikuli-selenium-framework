/**
 * 
 */
package com.synerzip.testframework.webelement.impl;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import com.synerzip.testframework.webelement.WebSelector;

/**
 * @author rohitghatol
 *
 */
@Component
public class WebSelectorImpl implements WebSelector {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.synerzip.testframework.webelement.WebSelector#getBySelector(java.
	 * lang.String)
	 */
	@Override
	public By getBySelector(String selector) {
		String split[] = selector.split(":");

		String byPart = split[0];
		String selectorPart = split[1];

		By by = null;
		if ("id".equals(byPart)) {
			by = By.id(selectorPart);
		} else if ("name".equals(byPart)) {
			by = By.name(selectorPart);
		} else if ("linkText".equals(byPart)) {
			by = By.linkText(selectorPart);
		} else if ("partialLinkText".equals(byPart)) {
			by = By.partialLinkText(selectorPart);
		} else if ("className".equals(byPart)) {
			by = By.className(selectorPart);
		} else if ("cssSelector".equals(byPart)) {
			by = By.cssSelector(selectorPart);
		} else if ("linkText".equals(byPart)) {
			by = By.linkText(selectorPart);
		} else if ("xpath".equals(byPart)) {
			by = By.xpath(selectorPart);
		} else if ("tagName".equals(byPart)) {
			by = By.tagName(selectorPart);
		} else {
			throw new IllegalArgumentException(
					"selector needs to be on of this formats \"id:<<selector>>\",\"name:<<selector>>\",\"linkText:<<selector>>\",\"partialLinkText:<<selector>>\",\"className:<<selector>>\",\"cssSelector:<<selector>>\",\"xpath:<<selector>>\",\"tagName:<<selector>>\"");
		}
		return by;
	}

}
