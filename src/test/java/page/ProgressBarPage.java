package page;

import com.DriverUlti;
import org.openqa.selenium.By;

public class ProgressBarPage {
    By btnStartStop = By.id("startStopButton");
    By progressBar = By.xpath("//div[@id='progressBar']/div[@role='progressbar']");
    int time = 60;

    public void clickBtnToStartProgress() {
        DriverUlti.waitForElement(btnStartStop, time);
        DriverUlti.click(btnStartStop);
    }

    public void stopProgressBar(int number) {
        DriverUlti.waitForElement(progressBar, time);
        int value = 0;

        while (value <= number) {
            value = Integer.parseInt(DriverUlti.getAttribute(progressBar, "aria-valuenow"));
            value++;
        }
        DriverUlti.click(btnStartStop);

    }


    public String getValueProgressBar() {
        DriverUlti.waitForElementtNotChange(progressBar, time);
        return DriverUlti.getText(progressBar);
    }
}
