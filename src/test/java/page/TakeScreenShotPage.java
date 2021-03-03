package page;

import com.DriverUlti;
import org.openqa.selenium.By;

public class TakeScreenShotPage {
    By topXpath = By.xpath("//div[@id='navbar-collapse']/ul/li/a/span");
    int time = 60;

    public void takeAScreenShot(String filePath) {
        DriverUlti.waitForElement(topXpath, time);
        DriverUlti.takeShot(filePath);
    }

    public String checkLogin(){
        DriverUlti.waitForElement(topXpath,time);
        String a = DriverUlti.getText(topXpath);
        return a;
    }
}
