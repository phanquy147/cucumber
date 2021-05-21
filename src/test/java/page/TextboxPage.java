package page;

import com.DriverUlti;
import com.Label;
import com.Textbox;
import org.openqa.selenium.By;


public class TextboxPage {
    By txtPath = By.id("user-message");
    By lblMsgPath = By.xpath("//div[@id='user-message']/span[@id='display']");
    By btnShowMsgPath = By.xpath("//button[contains(@onclick,'showInput')]");
    By turnOffPopupPath = By.xpath("//div[contains(@class,'at4win')]/a[@title='Close']");
    int time = 60;

    Textbox textbox = null;
    Label label = null;

    public void turnOffPopup() {
        textbox = new Textbox(turnOffPopupPath);
        textbox.waitForElement(turnOffPopupPath, time);
        textbox.click();
    }

    public void inputTxt(String text) {
        textbox = new Textbox(txtPath);
        textbox.waitForElement(txtPath, time);
        textbox.click();
        textbox.clear();
        textbox.sendKeys(text);
    }

    public void clickButtonShowMsg() {
        textbox.waitForElement(btnShowMsgPath, time);
        label = new Label(btnShowMsgPath);
        label.click();
    }

    public String getTextAfterInput() {
        clickButtonShowMsg();
        DriverUlti.waitForElementtNotChange(lblMsgPath, time);
        label = new Label(lblMsgPath);
        String textAfter = label.getText();
        return textAfter;
    }
}
