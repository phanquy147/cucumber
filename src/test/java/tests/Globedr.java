package tests;

import com.DriverUlti;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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

    @DataProvider(name = "dataTest")
    public Object[][] dpProvider() throws Exception {
        return new Object[][]{{"0392345678", "123456", globedrInfoPage.randomName(), globedrInfoPage.randomTitle(), globedrInfoPage.randomEmail(),
                globedrInfoPage.randomDob(), globedrInfoPage.randomGender(), globedrInfoPage.randomValueOfFile("data/visitCountry.json"),
                globedrInfoPage.randomValueOfFile("data/visitCountry.json")}};
    }

    @Test(dataProvider = "dataTest")
//    (invocationCount = 5)
    public void updateInfo(String ID, String password, String name, String title, String email, String dOB, String gender, String visitCountry, String country) throws Exception {
//        DriverUlti.getWebInfo();
//        DriverUlti.refreshPage();
//        DriverUlti.backPage();
        globedrLoginPage.loginUser(ID, password);
        globedrInfoPage.goToAccountInfoPage();
        globedrInfoPage.updateInfo(name, title, email, dOB, gender, visitCountry, country);
        globedrInfoPage.checkInfoAfterUpdate();
        globedrInfoPage.downloadImg();
        globedrInfoPage.compareImg();
    }

    @AfterMethod
    public static void quitDriver() {
        DriverUlti.quit();
    }
}
