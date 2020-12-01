package tests;

import Enums.DemoMenu;
import Enums.MainMenu;
import Enums.TesthubMenu;
import com.DriverUlti;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;
import page.MousePage;

public class Mouse {
    MousePage mousePage = new MousePage();
    HomePage homePage = new HomePage();
    @BeforeMethod
    public void runDriver(){
        DriverUlti.getDriverGlobal();
    }

    @Test
    public void selectTooltipElement(){
        homePage.openMenu(MainMenu.TESTERS, TesthubMenu.DEMO_SITE, DemoMenu.TOOLTIP);
        Assert.assertEquals(mousePage.getTxtHeaderTooltip().toUpperCase(),"TOOLTIP");
        mousePage.moveMouseToBtnLike();
    }

    @Test
    public void movePictureInDragAndDropPage(){
        homePage.openMenu(MainMenu.TESTERS, TesthubMenu.DEMO_SITE, DemoMenu.DRAGANDDROP);
        mousePage.movePictureToTrash("tatras2");
        Assert.assertEquals(mousePage.isDisplayedPhotoIntoList("high tatras 2"),false);
        Assert.assertEquals(mousePage.isDisplayPhotoIntoListTrash("high tatras 2"),true);

    }

    @AfterMethod
    public void quitDriver(){
        DriverUlti.quit();
    }
}
