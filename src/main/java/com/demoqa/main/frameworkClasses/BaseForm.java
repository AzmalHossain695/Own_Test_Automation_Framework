package com.demoqa.main.frameworkClasses;

public abstract class BaseForm {
	private BaseElement uniqueElement;

	public BaseForm(BaseElement uniqueElement, String formName) {
		this.uniqueElement = uniqueElement;
	}
	public boolean isPageLoaded() throws Exception {
		return uniqueElement.isDisplayed();
	}
}