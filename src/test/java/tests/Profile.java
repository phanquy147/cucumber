package tests;

import com.DriverUlti;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.ProfilePage;


public class Profile {
    ProfilePage profile = new ProfilePage();


    @BeforeMethod
    public static void runDriver() {
        DriverUlti.getDriverProfile();
    }

    @DataProvider(name = "dataTest")
    public Object[][] dpProvider(){
        return new Object[][] {{"quy","quy@gmail.com","xbox"}, {"yen","yen@yahoo.com","ps"}, {"yen","yen@yahoo.com","xbox"}};
    }

    @Test (dataProvider = "dataTest", invocationCount = 5)
    public void updateFull01(String name, String email, String value) {
        profile.infoPage(name,email);
        profile.interestPage(value);

        String infoExpected = String.format("{\"name\":\"%s\",\"email\":\"%s\",\"type\":\"%s\"}", name, email, value);
        Assert.assertEquals(profile.txtInfoInput().trim(), infoExpected);

        String txtComplete = "Test Completed, WooHoo!";
        Assert.assertEquals(profile.txtSubmitPage(), txtComplete);
        profile.submitPage();

        profile.txtAlert();
        Assert.assertEquals(DriverUlti.txtAlert(), "awesome!");
        profile.acceptAlert();
    }

    @AfterMethod
    public static void quitDriver() {
        DriverUlti.quit();
    }
}
