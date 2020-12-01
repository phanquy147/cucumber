package page;

import com.DriverUlti;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SelectMenuPage {
    By boxMenu = By.xpath("//div[@class='category-cards']//div[@class='card-body']/h5");
    By txtSubMenu = By.xpath("//div[@class='element-list collapse show']//li[contains(@id,'item')]");
    int time = 60;
    //span[@class='text']

    public void selectMainMenuPage(String menu) {
        DriverUlti.waitForElement(boxMenu, time);
        DriverUlti.scrollToViewJs(boxMenu);
        List<WebElement> listMainMenu = DriverUlti.findElements(boxMenu);
        for (int i = 0; i < listMainMenu.size(); i++) {
            String txtMainMenu = listMainMenu.get(i).getText();
            if (txtMainMenu.equalsIgnoreCase(menu)) {
                listMainMenu.get(i).click();
                break;
            }
        }
    }

    public void selectSubMenu(String subMenu) {
        DriverUlti.waitForElement(txtSubMenu, time);
        DriverUlti.scrollToViewJs(txtSubMenu);
        List<WebElement> listSubMenu = DriverUlti.findElements(txtSubMenu);
        for (int i = 0; i < listSubMenu.size(); i++) {
            String txtSubMenu = listSubMenu.get(i).getText();
            if (txtSubMenu.equalsIgnoreCase(subMenu)) {
                listSubMenu.get(i).click();
                break;
            }
        }
        DriverUlti.waitMinus(3000);
    }

}