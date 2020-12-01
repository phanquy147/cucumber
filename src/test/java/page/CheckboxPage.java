package page;

import com.DriverUlti;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckboxPage {
    int timeMode = 60;
    By checkbox = By.xpath("//input[@parent-model='cat.included']");
    By txtCheckbox = By.xpath("//input[@type='checkbox']/ancestor::li[@ng-repeat='prod in cat.products']");
    By liTxt = By.xpath("//li[contains(@ng-repeat,'cat')]");
    By liGroupName = By.xpath("//li[@ng-repeat='cat in division.categories']/h3");

    public void checkCheckBoxIsSelected() {
        List<WebElement> listCheckbox = DriverUlti.findElements(checkbox);
        List<WebElement> listCheckboxTxt = DriverUlti.findElements(txtCheckbox);
        for (int i = 0; i < listCheckbox.size(); i++) {
            if (listCheckbox.get(i).isSelected()) {
                System.out.println("Selected: " + listCheckboxTxt.get(i).getText());
            }
        }
    }

    public void checkCheckBoxIsSelected2() {
        List<WebElement> liCheckbox = DriverUlti.findElements(liTxt);
        for (int i = 0; i < liCheckbox.size(); i++) {
            WebElement ip = liCheckbox.get(i).findElement(By.xpath(".//input"));
            if (ip.isSelected()) {
                System.out.println("Selected: " + liCheckbox.get(i).getText());
            }
        }
    }

    public void checkCheckBoxNonSelected() {
        List<WebElement> listCheckbox = DriverUlti.findElements(checkbox);
        List<WebElement> listCheckboxTxt = DriverUlti.findElements(txtCheckbox);
        for (int i = 0; i < listCheckbox.size(); i++) {
            if (!(listCheckbox.get(i).isSelected())) {
                System.out.println("Non Selected: " + listCheckboxTxt.get(i).getText());
            }
        }
    }

    public void checkCheckBoxIsDisable() {
        List<WebElement> listCheckbox = DriverUlti.findElements(checkbox);
        List<WebElement> listCheckboxTxt = DriverUlti.findElements(txtCheckbox);
        for (int i = 0; i < listCheckbox.size(); i++) {
            if (!(listCheckbox.get(i).isEnabled())) {
                System.out.println("Disable: " + listCheckboxTxt.get(i).getText());
            }
        }
    }

    public void action(String content) {
        DriverUlti.waitForElementVisibility(checkbox, timeMode);
        checkCheckBoxIsSelected();
        checkCheckBoxNonSelected();
        checkCheckBoxIsDisable();
        clickCheckboxWithKey(content);
        checkGroupHaveTwoCkBIsSelected();
    }

    public void clickCheckboxWithKey(String content) {
        DriverUlti.clickChB(By.xpath(String.format("//h3[contains(.,'%s')]/following-sibling::ul//input", content)));
    }

    public boolean isSelectedChk(String content) {
        DriverUlti.waitForElementVisibility(By.xpath(String.format("//h4[contains(.,'%s')]/input", content)), timeMode);
        return DriverUlti.isSelected(By.xpath(String.format("//h4[contains(.,'%s')]/input", content)));
    }

    public void checkGroupHaveTwoCkBIsSelected() {
        List<WebElement> listGroup = DriverUlti.findElements(liGroupName);
        for (int i = 0; i < listGroup.size(); i++) {
            List<WebElement> numberCkb = listGroup.get(i).findElements(By.xpath("./following-sibling::ul//input"));
            int count = 0;
            for (int j = 0; j < numberCkb.size(); j++) {
                    if (numberCkb.get(j).isSelected()) {
                        count++;
                    }
                }
            if (count >= 2) {
                System.out.println("group name is: "+listGroup.get(i).getText());
            }
        }
    }
}