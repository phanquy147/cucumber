package tests;

import com.DriverUlti;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.DragAndDropPage2;

public class DragAndDrop2 {
    DragAndDropPage2 dragAndDropPage2 = new DragAndDropPage2();
    @BeforeMethod
    public void getDriver(){

        DriverUlti.getDriverSelenium();
//        DriverUlti.getaaa();
    }
    @Test
    public void dragAndDrop2() {
        dragAndDropPage2.dragAndDrop2("draggable 1");
        Assert.assertEquals(dragAndDropPage2.txtAfterDrop(),"draggable 1");
        dragAndDropPage2.clickLogo();
    }

    @AfterMethod
    public void quitDriver(){
        DriverUlti.quit();
    }
}
