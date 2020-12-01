package page;

import com.DriverUlti;
import org.openqa.selenium.By;

public class LoginPage {
    private int timeMode = 60;
    private String iD = "angular";
    private String password = "password";

    By txtUserName = By.id("username");
    By txtPass = By.id("password");
    By txtNameDescription = By.id("formly_1_input_username_0");
    By btnLogin = By.xpath("//button[@class='btn btn-danger']");
    By txtLoginSuccess = By.xpath("//div[@class='container']//div/p[@class='ng-scope']");
    By txtLoginError = By.xpath("//div[@class='container']//div[@ng-if='Auth.error']");
    By txtIdError = By.xpath("//div[@ng-messages='form.username.$error']/div[@ng-message='minlength, maxlength']");
    By txtPassError = By.xpath("//div[@ng-messages='form.password.$error']/div[@ng-message='minlength, maxlength']");
    By txtDesError = By.xpath("//label[@for='formly_1_input_username_0']");

    public void enterId(String userID) {
        DriverUlti.sendKeys(txtUserName, userID);
    }

    public boolean checkEnterID(String userID) {
        if (userID.length() <= 2) {
            return DriverUlti.isDisplayed(txtIdError);
        }
        return true;
    }

    public void enterPass(String pass) {
        DriverUlti.sendKeys(txtPass, pass);
    }

    public boolean checkEnterPass(String pass) {
        if (pass.length() <= 2) {
            return DriverUlti.isDisplayed(txtPassError);
        }
        return true;
    }

    public void enterNameDes(String description) {
        DriverUlti.sendKeys(txtNameDescription, description);
    }

    public boolean checkEnterDes(String Des) {
        if (Des.length() <= 2) {
            return DriverUlti.isDisplayed(txtDesError);
        }
        return true;
    }

    public void clickBtnLogin() {
        DriverUlti.waitClick(btnLogin, timeMode);
        DriverUlti.click(btnLogin);
    }

    public Boolean checkLogin(String userId, String pass) {
        if (userId.equalsIgnoreCase(iD) && pass.equalsIgnoreCase(password)) {
            DriverUlti.waitForElementVisibility(txtLoginSuccess, timeMode);
            return DriverUlti.isDisplayed(txtLoginSuccess);
        } else {
            DriverUlti.waitForElementVisibility(txtLoginError, timeMode);
            return DriverUlti.isDisplayed(txtLoginError);
        }

    }

    public void Login(String userID, String pass, String nameDescription) {
        DriverUlti.waitForElementVisibility(txtUserName, timeMode);
        enterId(userID);
        enterPass(pass);
        enterNameDes(nameDescription);
    }


}
