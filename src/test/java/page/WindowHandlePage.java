package page;

import com.DriverUlti;
import org.openqa.selenium.By;

public class WindowHandlePage {
    int time = 60;
    By btnNewTab = By.id("tabButton");
    By txtNewTab = By.id("sampleHeading");
    By btnNewWindow = By.id("windowButton");
    By txtNewWindow = By.id("sampleHeading");

    public void openNewtab() {
        DriverUlti.waitForElementVisibility(btnNewTab, time);
        DriverUlti.click(btnNewTab);
    }

    public static void switchToLastTab() {
        DriverUlti.waitMinus(3000);
        DriverUlti.switchToWindow(DriverUlti.getLastedWindow());
    }

    public static void closeLastTab() {
        DriverUlti.close();
    }

    public void switchToFirstWindow() {
        closeLastTab();
        DriverUlti.switchToWindow(DriverUlti.getFirstWindow());
        DriverUlti.waitMinus(3000);
    }

    public String txtNewWindowTab() {
        switchToLastTab();
        DriverUlti.waitForElementVisibility(txtNewTab, time);
        return DriverUlti.getText(txtNewTab);
    }

    public void openNewWindow() {
        switchToFirstWindow();
        DriverUlti.waitForElementVisibility(btnNewWindow, time);
        DriverUlti.click(btnNewWindow);
        DriverUlti.waitMinus(3000);
    }

    public String txtNewWindow() {
        switchToLastTab();
        DriverUlti.waitForElementVisibility(txtNewWindow, time);
        return DriverUlti.getText(txtNewWindow);
    }

}
