package com.demoqa.main.frameworkClasses;

import org.openqa.selenium.By;

public class InputElement extends BaseElement {

    public InputElement(By locator, String name) {
        super(locator, name);
    }
    public void type(String text) {
        findElement().sendKeys(text);
    }   
}

