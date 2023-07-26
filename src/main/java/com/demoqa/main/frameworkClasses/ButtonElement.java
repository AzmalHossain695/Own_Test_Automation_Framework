package com.demoqa.main.frameworkClasses;

import org.openqa.selenium.By;

public class ButtonElement extends BaseElement {

    public ButtonElement(By locator, String name) {
        super(locator, name);
    }    
    public void click() {
        findElement().click();
    }
}
