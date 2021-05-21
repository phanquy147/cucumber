package tests;

import com.DriverUlti;
import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.MenuQAPage;
import page.TextboxPage;

public class checkTBAndLBTest {
    TextboxPage textboxPage = new TextboxPage();
    MenuQAPage menuQAPage = new MenuQAPage();

    @DataProvider(name = "dataTestTB")
    public Object[][] dpProvider() {
        return new Object[][]{{"Input Forms", "Simple Form Demo", "Quy"},{"Date pickers","Bootstrap Date Picker","oke"}};
    }

    @BeforeMethod
    public static void runDriver() {
        DriverUlti.setDriver("chromed");
        DriverUlti.manageDriver();
        DriverUlti.getDriver().get("https://www.seleniumeasy.com/test/");
        DriverUlti.waitMinus(3000);
    }

    @Test(dataProvider = "dataTestTB")
    public void checkTb(String groupMenuName, String subMenuName, String txtInput) {
        textboxPage.turnOffPopup();
        menuQAPage.openPageWantMatch(groupMenuName, subMenuName);
        textboxPage.inputTxt(txtInput);
//        Assert.assertEquals(txtInput, textboxPage.getTextAfterInput());
    }

    @AfterMethod
    public void quitDriver() {
        DriverUlti.waitMinus(3000);
        DriverUlti.quit();
    }
}
