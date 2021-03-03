package page;

import com.DriverUlti;
import javafx.scene.input.MouseDragEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.InputMethodEvent;
import java.awt.event.MouseEvent;
import java.util.List;

public class DragAndDropPage2 {
    By dragElement = By.xpath("//div[@id='todrag']/span[@draggable='true']");
    By dropZone = By.id("mydropzone");

    public void dragAndDrop2(String ok) {
        Point drop = DriverUlti.findElement(dropZone).getLocation();
        int x = drop.getX();
        int y = drop.getY();
        List<WebElement> listDrag = DriverUlti.findElements(dragElement);
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < listDrag.size(); i++) {
            if (listDrag.get(i).getText().equalsIgnoreCase(ok)) {
                Point drag = listDrag.get(i).getLocation();
                int x1 = drag.getX();
                int y1 = drag.getY();
                robot.mouseMove(x1 + 100, y1 + 120);
                DriverUlti.waitMinus(3000);
                robot.mousePress(InputEvent.BUTTON1_MASK);
                DriverUlti.waitMinus(3000);
                robot.mouseMove(x + 160, y + 180);
                DriverUlti.waitMinus(3000);
                robot.mouseRelease(InputEvent.BUTTON1_MASK);
//                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                DriverUlti.waitMinus(3000);
            }
        }
    }
}