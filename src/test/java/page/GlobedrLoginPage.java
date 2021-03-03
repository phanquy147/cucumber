package page;

import com.DriverUlti;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GlobedrLoginPage {
    By userName = By.id("UserName");
    By password = By.id("Password");
    By btnSignIn2 = By.xpath("//button[@translate='signIn']");
    By btnSignIn = By.xpath("//a[@translate='signIn']");
    By dropCountry = By.xpath("//select");
    int time = 60;

    public void goToLoginPage() {
        DriverUlti.waitForElement(btnSignIn, time);
        DriverUlti.click(btnSignIn);
    }

    public void inputUserLogin(String userLogin) {
        DriverUlti.waitForElement(userName, time);
        DriverUlti.clear(userName);
        DriverUlti.sendKeys(userName, userLogin);
    }

    public void inputPassLogin(String passLogin) {
        DriverUlti.waitForElement(password, time);
        DriverUlti.clear(password);
        DriverUlti.sendKeys(password, passLogin);
    }

    public void selectCountry() {
        DriverUlti.waitForElementVisibility(dropCountry, time);
        DriverUlti.click(dropCountry);
        List<WebElement> listCountry = DriverUlti.findElements(By.xpath("//select/option"));
        for (int i = 0; i < listCountry.size(); i++) {
            if (listCountry.get(i).getText().contains("viet nam")) {
                listCountry.get(i).click();
            }
        }
    }

    public void signIn() {
        DriverUlti.waitForElement(btnSignIn2, time);
        DriverUlti.click(btnSignIn2);
    }


    public void loginUser(String user, String pass) {
        goToLoginPage();
        inputUserLogin(user);
        inputPassLogin(pass);
        selectCountry();
        signIn();
    }
}
