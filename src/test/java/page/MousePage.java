package page;

import com.DriverUlti;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MousePage {
    int timemode = 60;
    By header = By.xpath("//div[@class='page_heading']");
    By btnVideoBase = By.id("Video Based");
    By btnLike = By.xpath("//div[@class='tools']/span[@role='toolbar']/button[contains(@class,'left')]");
    By frame = By.xpath("//iframe[contains(@data-src,'video-player')]");
    By txtLike = By.xpath("//div[contains(@class,'ui-tooltip-content')]");
    By framePhotoManager = By.xpath("//iframe[contains(@data-src,'photo-manager')]");
    By trash = By.id("trash");
    String photoXpath = "//img[contains(@src,'%s')]";
    By listPhoto = By.xpath("//ul[@id='gallery']/li");
    By listTrashPhoto = By.xpath("//div[@id='trash']//li");

    public String getTxtHeaderTooltip() {
        DriverUlti.waitForElementVisibility(header, timemode);
        return DriverUlti.getText(header);
    }

    public void waitFrameVideoIsSwitch() {
        DriverUlti.waitForElementVisibility(btnVideoBase, timemode);
        DriverUlti.click(btnVideoBase);
        DriverUlti.waitForFrameSwitch(frame, 500);
    }

    public void moveMouseToBtnLike() {
        waitFrameVideoIsSwitch();
        DriverUlti.waitForElementVisibility(btnLike, timemode);
        DriverUlti.moveToElement(btnLike);
        DriverUlti.waitForElementVisibility(txtLike, timemode);
        System.out.println(DriverUlti.getText(txtLike));
    }

    public void switchToFramePhotoManager() {
        DriverUlti.waitForElementVisibility(framePhotoManager, timemode);
        DriverUlti.switchToFrame(framePhotoManager);
    }

    public boolean isDisplayedPhotoIntoList(String name) {
        switchToFramePhotoManager();
        boolean isExisted = false;
        List<WebElement> listPhotoManager = DriverUlti.findElements(listPhoto);
        for (int i = 0; i < listPhotoManager.size(); i++) {
            WebElement txtNamePhoto = listPhotoManager.get(i).findElement(By.xpath("./h5"));
            if (txtNamePhoto.getText().equalsIgnoreCase(name)) {
                isExisted = true;
            }
        }
        DriverUlti.switchToDefaultFrame();
        return isExisted;
    }

    public boolean isDisplayPhotoIntoListTrash(String name) {
        switchToFramePhotoManager();
        boolean isExisted = false;
        List<WebElement> listTrashPhotos = DriverUlti.findElements(listTrashPhoto);
        for (int i = 0; i < listTrashPhotos.size(); i++) {
            WebElement txtNameTrashPhoto = listTrashPhotos.get(i).findElement(By.xpath(".//h5"));
            System.out.println();
            if (txtNameTrashPhoto.getAttribute("innerHTML").equalsIgnoreCase(name)) {
                isExisted = true;
            }
        }
        DriverUlti.switchToDefaultFrame();
        return isExisted;
    }


    public void movePictureToTrash(String name) {
        switchToFramePhotoManager();
        DriverUlti.waitForElementVisibility(By.xpath(String.format(photoXpath, name)), timemode);
        DriverUlti.dragAndDrop(By.xpath(String.format(photoXpath, name)), trash);
        DriverUlti.waitForElementVisibility(listPhoto, timemode);
        DriverUlti.waitForElementVisibility(listTrashPhoto, timemode);
        DriverUlti.switchToDefaultFrame();
    }

}
