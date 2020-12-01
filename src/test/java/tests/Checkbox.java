package tests;

import com.DriverUlti;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.CheckboxPage;


public class Checkbox {
    CheckboxPage checkbox = new CheckboxPage();

    @BeforeMethod
    public void runDriver() {
        DriverUlti.getDriverCheckbox();
    }

    @DataProvider(name = "dataTest")
    public Object[][] dpProvider() {
        return new Object[][]{{"Garage Improvement"}};
    }

    @Test(dataProvider = "dataTest")
    public void checkCheckBox(String content) {
        checkbox.action(content);
        Assert.assertEquals(checkbox.isSelectedChk("Axe"), true);
        Assert.assertEquals(checkbox.isSelectedChk("Chainsaw"), true);
        Assert.assertEquals(checkbox.isSelectedChk("Leaf Blower"), true);
    }

    @AfterMethod
    public void quitDriver() {
        DriverUlti.quit();
    }
}
