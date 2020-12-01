package tests;

import com.DriverUlti;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.GlobedrInfoPage;
import page.GlobedrLoginPage;

public class Globedr {
    GlobedrLoginPage globedrLoginPage = new GlobedrLoginPage();
    GlobedrInfoPage globedrInfoPage = new GlobedrInfoPage();

    @BeforeMethod
    public static void runDriver() {
        DriverUlti.getDriverGlobeDr();
    }

    @Test
//            (invocationCount = 5)
    public void updateInfo() throws Exception {
        DriverUlti.getWebInfo();
        globedrLoginPage.loginUser("0392345678", "123456");
        globedrInfoPage.updateInfo();
        DriverUlti.refreshPage();
        globedrInfoPage.checkInfoAfterUpdate();
    }

    @AfterMethod
    public static void quitDriver() {
        DriverUlti.quit();
    }
}
