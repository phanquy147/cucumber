package tests;

import com.DriverUlti;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.SwitchFramePage;

public class SwitchFrame {
    SwitchFramePage switchFramePage= new SwitchFramePage();
    @BeforeMethod
    public void runDriver(){
        DriverUlti.getDriverSwitchFrame();
    }

    @Test
    public void getTxtFrameOldCp(){
        switchFramePage.getTxtFrameOldCouple();
    }

    @AfterMethod
    public void quitDriver(){
        DriverUlti.quit();
    }
}
