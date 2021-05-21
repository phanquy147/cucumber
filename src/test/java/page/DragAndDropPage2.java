package page;

import com.DriverUlti;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import java.awt.*;
import java.awt.event.InputEvent;
import java.util.List;

public class DragAndDropPage2 {
    By dragElement = By.xpath("//div[@id='todrag']/span[@draggable='true']");
    By dropZoneElement = By.id("mydropzone");
    By dropElement = By.xpath("//div[@id='droppedlist']/span");
    By logoElement = By.xpath("//div[@class='logo']//img");
    int time = 60;

    public int getXStart(String text) {
        int xStart = 0;
        DriverUlti.waitForElement(dragElement, time);
        List<WebElement> listDrag = DriverUlti.findElements(dragElement);
        for (int i = 0; i < listDrag.size(); i++) {
            if (listDrag.get(i).getText().equalsIgnoreCase(text)) {
                Point drag = listDrag.get(i).getLocation();
                xStart = drag.getX();
            }
        }
        return xStart;
    }

    public int getYStart(String text) {
        DriverUlti.waitForElement(dragElement, time);
        int yStart = 0;
        List<WebElement> listDrag = DriverUlti.findElements(dragElement);
        for (int i = 0; i < listDrag.size(); i++) {
            if (listDrag.get(i).getText().equalsIgnoreCase(text)) {
                Point drag = listDrag.get(i).getLocation();
                yStart = drag.getY();
            }
        }
        return yStart;
    }

    public int getXEnd() {
        DriverUlti.waitForElement(dropZoneElement, time);
        Point drop = DriverUlti.findElement(dropZoneElement).getLocation();
        int xEnd = drop.getX();
        return xEnd;
    }

    public int getYEnd() {
        DriverUlti.waitForElement(dropZoneElement, time);
        Point drop = DriverUlti.findElement(dropZoneElement).getLocation();
        int yEnd = drop.getY();
        return yEnd;
    }

    public void clickLogo(){
        DriverUlti.waitForElement(logoElement,time);
        DriverUlti.click(logoElement);
    }

    public void dragAndDrop2(String text) {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.mouseMove((int) (getXStart(text) + DriverUlti.jsWidth())+12, (int) (getYStart(text) + DriverUlti.jsHeight()));
        DriverUlti.waitMinus(1000);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        DriverUlti.waitMinus(1000);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        DriverUlti.waitMinus(1000);
        robot.mouseMove((int) (getXEnd() + DriverUlti.jsWidth()), (int) (getYEnd() + DriverUlti.jsHeight()));
        DriverUlti.waitMinus(1000);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        DriverUlti.waitMinus(3000);
    }

    public String txtAfterDrop() {
        String dropText = null;
        DriverUlti.waitMinus(5000);
        DriverUlti.waitForElementVisibility(dropElement, time);
        List<WebElement> listDrop = DriverUlti.findElements(dropElement);
        for (int i = 0; i < listDrop.size(); i++) {
            dropText = listDrop.get(i).getText().toLowerCase();
        }
        return dropText;
    }
}