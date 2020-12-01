package tests;

import com.DriverUlti;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.DragAndDropPage;

public class DragAndDrop {
    DragAndDropPage dragAndDropPage = new DragAndDropPage();
    @BeforeMethod
    public void runDriver(){
        DriverUlti.getDriverDragAndDrop();
    }

    @Test
    public void dragAndDropPrice(){
        dragAndDropPage.dragAndDropElement();
        Assert.assertEquals(dragAndDropPage.getTxtResult(),"5000");
    }

    @AfterMethod
    public void quitDriver(){
        DriverUlti.quit();
    }
}
