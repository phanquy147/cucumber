package tests;

import com.DriverUlti;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.WindowHandlePage;

public class WindowHandle {
    WindowHandlePage windowHandlePage = new WindowHandlePage();

    @BeforeMethod
    public void runDriver() {
        DriverUlti.getDriverWindowHandle();
    }

    @Test
    public void newTabHandle() {
        windowHandlePage.openNewtab();
        String expect = "This is a sample page";
        Assert.assertEquals(windowHandlePage.txtNewWindowTab(), expect);
        windowHandlePage.openNewWindow();
        Assert.assertEquals(windowHandlePage.txtNewWindow(), expect);
        windowHandlePage.switchToFirstWindow();
    }

    @AfterMethod
    public void quitDriver() {
        DriverUlti.quit();
    }
}
