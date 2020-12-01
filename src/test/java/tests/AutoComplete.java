package tests;

import com.DriverUlti;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.AutoCompletePage;

public class AutoComplete {

    AutoCompletePage autoCompletePage = new AutoCompletePage();

    @BeforeMethod
    public static void runDriver(){
        DriverUlti.getDriverAutoComplete();
    }

    @Test
    public void autoComplete (){
        autoCompletePage.inputMultiColor("red","green","black");
        Assert.assertEquals(autoCompletePage.isDisplayedColorIntoList("Red"),true);
        Assert.assertEquals(autoCompletePage.isDisplayedColorIntoList("Green"),true);
        Assert.assertEquals(autoCompletePage.isDisplayedColorIntoList("Black"),true);
        autoCompletePage.inputSingleColor("blue");
        Assert.assertEquals(autoCompletePage.getTxtSingleColor(),"Blue");
        autoCompletePage.removeColor("red");
        Assert.assertEquals(autoCompletePage.isDisplayedColorIntoList("Red"),false);
    }

    @AfterMethod
    public static void quitDriver (){
        DriverUlti.quit();
    }
}
