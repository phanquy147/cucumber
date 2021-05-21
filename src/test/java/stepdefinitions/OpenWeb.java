package stepdefinitions;

import com.DriverUlti;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class OpenWeb {
    @Given("I open chrome")
    public void iOpenChrome() {
        DriverUlti.setDriver("chromed");
        DriverUlti.manageDriver();
    }

    @When("I connect to website with link {string}")
    public void iConnectToWebsiteWithLink(String webLink) {
        DriverUlti.getDriver().get(webLink);
        DriverUlti.waitMinus(3000);
    }


    @And("I close browser")
    public void iCloseBrowser() {
        DriverUlti.waitMinus(3000);
        DriverUlti.quit();
    }
}
