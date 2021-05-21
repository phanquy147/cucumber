package com;
import org.openqa.selenium.By;

public class Label extends Element{

    public Label(By by) {
        super(by);
    }

//    public String getTexts(int i) {
//        return findElements(by).get(i).getText();
//    }
//
//
//    public String getAttributes(String s, int i) {
//        return findElements(by).get(i).getAttribute(s);
//    }
//
//    public String getAttribute(String s) {
//        return findElement(by).getAttribute(s);
//    }

    @Override
    public boolean isDisplayed() {
        return super.isDisplayed();
    }

}
