package tests;

import com.DriverUlti;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.ProgressBarPage;

public class ProgressBar {
    ProgressBarPage progressBarPage = new ProgressBarPage();

    @BeforeMethod
    public static void runDriver() {
        DriverUlti.getDriverProgressBar();
    }

    @Test
    public void runProgressBar(){
        progressBarPage.clickBtnToStartProgress();
        progressBarPage.stopProgressBar(54);
        System.out.println(progressBarPage.getValueProgressBar());
    }


    @AfterMethod
    public static void quitDriver() {
        DriverUlti.quit();
    }
}
