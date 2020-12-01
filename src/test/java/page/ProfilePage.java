package page;

import com.DriverUlti;
import org.openqa.selenium.By;

public class ProfilePage {
    private int timeMode = 50;
    By userName = By.xpath("//input[@ng-model='formData.name']");
    By email = By.xpath("//input[@ng-model='formData.email']");
    By btnNext = By.xpath("//a[@class='btn btn-block btn-info']");
    By radioBtn = By.xpath("//div[@class='radio']//input");
    By btnSubmit = By.xpath("//button[@type='submit']");

    public void enterUserName(String name) {
        DriverUlti.sendKeys(userName, name);
    }

    public void enterEmail(String mail) {
        DriverUlti.sendKeys(email, mail);
    }

    public void clickBtnNext() {
        DriverUlti.click(btnNext);
    }

    public void clickRadioBtn(String value, String attribute) {
        DriverUlti.clickRadioBtn(radioBtn, value, attribute);
    }

    public void clickRadioBtn(String value) {
        DriverUlti.clickRadioBtn(radioBtn, value, "value");
    }

    public void clickBtnSubmit() {
        DriverUlti.click(btnSubmit);
    }

    public String txtInfoInput() {
        return DriverUlti.getText(By.xpath("//pre"));
    }

    public String txtSubmitPage() {
        DriverUlti.waitForElementVisibility(By.xpath("//h3"),timeMode);
        return DriverUlti.getText(By.xpath("//h3"));
    }

    public void infoPage(String name, String mail) {
        DriverUlti.waitForElementVisibility(userName, timeMode);
        enterUserName(name);
        enterEmail(mail);
        clickBtnNext();
    }

    public void interestPage(String value) {
        DriverUlti.waitForPositionNotChange(radioBtn, timeMode);
        clickRadioBtn(value);
        clickBtnNext();
    }

    public void submitPage() {
        DriverUlti.waitForPositionNotChange(btnSubmit, timeMode);
        clickBtnSubmit();
    }

    public String txtAlert() {
        DriverUlti.waitAlert(60);
         return DriverUlti.txtAlert();
    }

    public void acceptAlert(){
        DriverUlti.acceptAlert();
    }

}
