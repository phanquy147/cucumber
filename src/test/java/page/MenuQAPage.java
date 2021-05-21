package page;

import com.DriverUlti;
import com.Element;
import org.openqa.selenium.By;

public class MenuQAPage {

    String groupMenuElements = "//li/ul/li[@class='tree-branch']/a[contains(text(),'%s')]";
    String subMenuElements = "//ul/li[contains(@style,'list-item')]/a[contains(text(),'%s')]";
    int time = 60;

    Element element = null;

//    public void selectGroupMenu(String groupMenuName) {
//        DriverUlti.scrollToViewJs(groupMenuElements);
//        DriverUlti.waitMinus(3000);
//        for ( int i = 0; i < element.findElements(groupMenuElements).size(); i++ ) {
//            if (element.findElements(groupMenuElements).get(i).getText().equalsIgnoreCase(groupMenuName)) {
//                element.findElements(groupMenuElements).get(i).click();
//            }
//        }
//    }

    public void selectGroupMenu(String mainName) {
        By mainMenu = By.xpath(String.format(groupMenuElements, mainName));
        element = new Element(mainMenu);
        DriverUlti.scrollToViewJs(mainMenu);
        element.waitForElement(mainMenu,time);
        element.findElement(mainMenu);
        element.click();
    }

//    public void selectSubMenu(String subMenuName) {
//        for ( int i = 0; i < element.findElements(listSubMenuElements).size(); i++ ) {
//            if (element.findElements(listSubMenuElements).get(i).getText().equalsIgnoreCase(subMenuName)) {
//                element.findElements(listSubMenuElements).get(i).click();
//            }
//        }
//    }

    public void selectSubMenu(String subName) {
        By subMenu = By.xpath(String.format(subMenuElements, subName));
        element = new Element(subMenu);
        element.waitForElement(subMenu,time);
        element.findElement(subMenu);
        element.click();
    }

    public void openPageWantMatch(String mainMenu, String subMenu) {
        selectGroupMenu(mainMenu);
        selectSubMenu(subMenu);
    }

}