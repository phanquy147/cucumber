package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import page.MenuQAPage;
import page.TextboxPage;

public class TextboxSteps {
    MenuQAPage menuQAPage = new MenuQAPage();
    TextboxPage textboxPage = new TextboxPage();

    @And("I turn off Popup")
    public void iTurnOffPopup() {
        textboxPage.turnOffPopup();
    }

    @And("Move to textbox page with main menu {string} and sub menu {string}")
    public void moveToTextboxPageWithMainMenuAndSubMenu(String mainMenu, String subMenu) {
        menuQAPage.selectGroupMenu(mainMenu);
        menuQAPage.selectSubMenu(subMenu);
    }

    @When("I input with below {string}")
    public void iInputWithBelow(String value) {
        textboxPage.inputTxt(value);
    }

    @And("I click button show messenger")
    public void iClickButtonShowMessenger() {
        textboxPage.clickButtonShowMsg();
    }

    @Then("The respone return should be like {string}")
    public void theResponeReturnShouldBe(String value) {
        Assert.assertEquals(textboxPage.getTextAfterInput(), value);
    }
}
