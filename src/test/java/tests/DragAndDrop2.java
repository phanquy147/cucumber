package tests;

import com.DriverUlti;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.DragAndDropPage2;

public class DragAndDrop2 {
    DragAndDropPage2 dragAndDropPage2 = new DragAndDropPage2();
    @BeforeMethod
    public void getDriver(){
        DriverUlti.getDriverSelenium();
    }
    @Test
    public void dragAndDrop2() {
         dragAndDropPage2.dragAndDrop2("draggable 2");
    }

    @AfterMethod
    public void quitDriver(){
        DriverUlti.quit();
    }
}
