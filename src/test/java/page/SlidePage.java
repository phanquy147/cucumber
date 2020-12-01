package page;

import com.DriverUlti;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;

public class SlidePage {
    int time = 60;
    int xSlideBar;
    int ySlideBar;
    int xLbBtnSlide;
    int x = 77;
    String atribute = "value";
    By slideBarXpath = By.xpath("//span[contains(@class,'slider')]/input");
    By valueOfSlider = By.id("sliderValue");
    By lableBtnSlide = By.xpath("//div[@class='range-slider__tooltip__label']");

    public void getSlideBarLocator() {
        Point slideBar = DriverUlti.findElement(slideBarXpath).getLocation();
        xSlideBar = slideBar.getX();
        ySlideBar = slideBar.getY();
    }

    public void getLbBtnLocator() {
        Point lbBtnSlide = DriverUlti.findElement(lableBtnSlide).getLocation();
        xLbBtnSlide = lbBtnSlide.getX();
    }

    public void selectBtnSlide() {
        DriverUlti.waitForElement(lableBtnSlide, time);
        getSlideBarLocator();
        getLbBtnLocator();
        DriverUlti.moveToLocator(xLbBtnSlide + 15, ySlideBar);
        DriverUlti.waitMinus(3000);
    }

    public void slideToBeginPoint() {
        DriverUlti.sliderToStartPoint(valueOfSlider, atribute);
        DriverUlti.waitMinus(2000);
    }


    public void slideToPoint() {
        DriverUlti.slideToPoint(valueOfSlider, atribute, x);
        DriverUlti.waitMinus(2000);
    }

    public String getValueSlide() {
        return DriverUlti.getAttribute(valueOfSlider, "value");
    }
}
