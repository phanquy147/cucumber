package tests;

import com.DriverUlti;
import org.testng.Assert;
import org.testng.annotations.*;
import page.GlobedrLoginPage;
import page.TakeScreenShotPage;

import java.util.Locale;

//@Listeners(com.ListenerTest.class)
public class TakeScreenShot {
    GlobedrLoginPage globedrLogin = new GlobedrLoginPage();
    TakeScreenShotPage takeScreenShot = new TakeScreenShotPage();
    int time = 5000;

    @BeforeMethod
    public static void runDriver() {
        DriverUlti.getDriverGlobeDr();
    }

    @DataProvider(name = "dataTest")
    public Object[][] dpProvider2() {
        return new Object[][]{{"0392123456", "123456", "/Users/apple/Desktop/hinh_chup1.png","tien"}};
    }
//    {"0392123456", "123456", "/Users/apple/Desktop/hinh_chup.png","quy"},

    @Test(dataProvider = "dataTest",successPercentage = 90, invocationCount = 3)
    public void loginAndTakeShot(String userName, String pass, String filePath,String name) {
        globedrLogin.loginUser(userName, pass);
        DriverUlti.waitMinus(time);
        Assert.assertEquals(takeScreenShot.checkLogin().toLowerCase(),name);
        takeScreenShot.takeAScreenShot(filePath);
//        DriverUlti.quit();
    }

    @AfterMethod
    public static void quitDriver() {
        DriverUlti.quit();
    }
}
