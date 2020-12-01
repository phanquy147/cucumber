package page;

import com.DriverUlti;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AutoCompletePage {
    By btnMultipleColor = By.id("autoCompleteMultipleInput");
    By btnSingleColor = By.id("autoCompleteSingleInput");
    By listColor = By.xpath("//div[@id='autoCompleteMultipleContainer']//div[contains(@class,'value__label')]");
    By txtSingleColor = By.xpath("//div[@id='autoCompleteSingleContainer']//div[contains(@class,'singleValue')]");
    int time = 60;

    public void inputMultiColor(String color1,String color2, String color3) {
        DriverUlti.waitClick(btnMultipleColor, time);
        DriverUlti.click(btnMultipleColor);
        DriverUlti.sendKeys(btnMultipleColor,color1);
        DriverUlti.sendKeys(btnMultipleColor, Keys.RETURN);
        DriverUlti.sendKeys(btnMultipleColor,color2);
        DriverUlti.sendKeys(btnMultipleColor, Keys.RETURN);
        DriverUlti.sendKeys(btnMultipleColor,color3);
        DriverUlti.sendKeys(btnMultipleColor, Keys.RETURN);
        DriverUlti.waitMinus(2000);
    }

//    public void inputMultiColor(String color) {
//        DriverUlti.waitForElement(btnMultipleColor, time);
//        DriverUlti.autoCompleteMultiTxt(btnMultipleColor, color);
//        DriverUlti.waitMinus(2000);
//    }

//    public String getTxtMultiColor() {
//        DriverUlti.waitForElement(listColor, time);
//        List<WebElement> list = DriverUlti.findElements(listColor);
//        for (int i = 0; i < list.size(); i++) {
//            a = list.get(i).getText();
//        }
//        return a;
//    }

    public boolean isDisplayedColorIntoList(String color) {
        boolean isExisted = false;
        List<WebElement> list = DriverUlti.findElements(listColor);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getText().equalsIgnoreCase(color)) {
                isExisted = true;
            }
        }
        return isExisted;
    }

    public String getTxtSingleColor() {
        DriverUlti.waitForElement(txtSingleColor, time);
        return DriverUlti.getText(txtSingleColor);
    }

    public void inputSingleColor(String color) {
        DriverUlti.waitForElement(btnSingleColor, time);
        DriverUlti.sendKeys(btnSingleColor,color);
        DriverUlti.sendKeys(btnSingleColor,Keys.RETURN);
        DriverUlti.waitMinus(2000);
    }

    public void removeColor(String color) {
        DriverUlti.waitForElement(listColor, time);
        List<WebElement> list = DriverUlti.findElements(listColor);
        for (int i = 0; i < list.size(); i++) {
            WebElement btnRemoveColor = list.get(i).findElement(By.xpath("./following-sibling::div[contains(@class,'remove')]")) ;
            if (list.get(i).getText().equalsIgnoreCase(color)) {
                btnRemoveColor.click();
            }
        }
        DriverUlti.waitMinus(2000);
    }
}