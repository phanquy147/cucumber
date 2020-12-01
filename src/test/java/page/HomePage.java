package page;

import Enums.DemoMenu;
import Enums.MainMenu;
import Enums.TesthubMenu;
import com.DriverUlti;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
    String menuXpath = "//a[contains(@href,'%s')]";
    int time = 60;

    public static void moveToElements(By by1, By by2, By by3) {
        Actions actions = new Actions(DriverUlti.getDriver());
        actions.moveToElement(DriverUlti.findElement(by1)).moveToElement(DriverUlti.findElement(by2)).moveToElement(DriverUlti.findElement(by3)).click(DriverUlti.findElement(by3)).build().perform();
    }

    public void openMenu(MainMenu mainMenu, TesthubMenu testhubMenu, DemoMenu demoMenu) {

//        DriverUlti.waitForElementVisibility(By.xpath(String.format(menuXpath, homeMenu)), time);

//        DriverUlti.waitForElementVisibility(By.xpath(String.format(menuXpath,homeMenu)),time);
//        DriverUlti.moveToElement(By.xpath(String.format(menuXpath,homeMenu)));

        String testHubMenu ="";
        switch (testhubMenu) {
            case DEMO_SITE:
                testHubMenu = "demo-site";
                break;
            case ANGULARJS:
                testHubMenu = "angularjs";
                break;
            case SAMPLEPAGETEST:
                testHubMenu = "samplepagetest";
                break;
            case WEBSITE:
                testHubMenu = "website.html";
                break;
        }
//        DriverUlti.waitForElementVisibility(By.xpath(String.format(menuXpath,testHubMenu)),time);
//        DriverUlti.moveToElement(By.xpath(String.format(menuXpath,testHubMenu)));

        String demoSite ="";
        switch (demoMenu) {
            case TOOLTIP:
                demoSite = "tooltip";
                break;
            case DRAGANDDROP:
                demoSite = "draganddrop";
        }

        moveToElements(By.xpath(String.format(menuXpath, mainMenu.value())), By.xpath(String.format(menuXpath, testHubMenu)), By.xpath(String.format(menuXpath, demoSite)));

//        DriverUlti.waitForElementVisibility(By.xpath(String.format(menuXpath,demoSite)),time);
//        DriverUlti.moveToElement(By.xpath(String.format(menuXpath,demoSite)));
//        DriverUlti.click(By.xpath(String.format(menuXpath,demoSite)));
    }
}
