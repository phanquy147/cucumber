package tests;

import com.DriverUlti;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.SlidePage;

public class Slide {
    SlidePage slidePage = new SlidePage();

    @BeforeMethod
    public void runDriver() {
        DriverUlti.getDriverSlider();
    }

    @Test
    public void slide() {
        slidePage.selectBtnSlide();
        slidePage.slideToBeginPoint();
        slidePage.slideToPoint();
        String valueAfterSlide = slidePage.getValueSlide();
        Assert.assertEquals(Integer.parseInt(valueAfterSlide),77);
    }

    @AfterMethod
    public void quitDriver() {
        DriverUlti.quit();
    }
}
