package com;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Element implements WebElement {
    private By by;

    public Element(By by) {
        this.by = by;
    }

    public WebElement webElement(){
        return DriverUlti.findElement(by);
    }

    @Override
    public void click() {
        webElement().click();
    }

    @Override
    public void submit() {
        webElement().submit();
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        webElement().sendKeys(charSequences);
    }

    @Override
    public void clear() {
        webElement().clear();
    }

    @Override
    public String getTagName() {
        return webElement().getTagName();
    }

    @Override
    public String getAttribute(String s) {
        return webElement().getAttribute(s);
    }

    @Override
    public boolean isSelected() {
        return webElement().isSelected();
    }

    @Override
    public boolean isEnabled() {
        return webElement().isEnabled();
    }

    @Override
    public String getText() {
        return webElement().getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return webElement().findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return webElement().findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    @Override
    public Point getLocation() {
        return webElement().getLocation();
    }

    @Override
    public Dimension getSize() {
        return webElement().getSize();
    }

    @Override
    public Rectangle getRect() {
        return webElement().getRect();
    }

    @Override
    public String getCssValue(String s) {
        return webElement().getCssValue(s);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return getScreenshotAs(outputType);
    }

    public void waitForElement(By by, int second){
        WebDriverWait waitElement = new WebDriverWait(DriverUlti.getDriver(),second);
        waitElement.until(ExpectedConditions.presenceOfElementLocated(by));
    }

}
