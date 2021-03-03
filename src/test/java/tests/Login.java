package tests;

import com.DriverUlti;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.LoginPage;


public class Login {

    LoginPage login = new LoginPage();

    @BeforeMethod
    public static void runDriver() {
        DriverUlti.getDriverLogin();
    }

    @DataProvider(name = "dataTestClickLogin")
    public Object[][] dpProvider1(){
        return new Object[][] {{"angular","password","quy quy "}, {"angular","aaaaaa","psaaa"}, {"aaaaa","password","xbox"}, {"aaaaa", "aaaaaaa", "quy nho"}};
    }

    @DataProvider(name = "dataTestSort")
    public Object[][] dpProvider2(){
        return new Object[][] {{"aa","password","xbox", false, true}, {"angular","aa","psfaf", true, false}};
    }

    @Test (dataProvider = "dataTestClickLogin")
    public void login(String userID, String pass, String userName) {
        login.Login(userID,pass,userName);
        login.clickBtnLogin();
        login.checkLogin(userID,pass);
    }

    @Test (dataProvider = "dataTestSort")
    public void loginWithSortID(String userID, String pass, String userName, boolean expectedUserId, boolean expectedPass) {
        login.Login(userID,pass,userName);
//        Assert.assertTrue(Login, expectedUserId);

        login.checkEnterID(userID);
        login.checkEnterPass(pass);
        login.checkEnterDes(userName);
    }

//    @Test
//    public static void getColor() {
//        String backgroundColor = DriverUlti.findElement(By.xpath("//div[@class='alert alert-info ng-scope']")).getCssValue("background-color");
//        String color = DriverUlti.findElement(By.xpath("//div[@class='alert alert-info ng-scope']")).getCssValue("color");
//        String boderColor = DriverUlti.findElement(By.xpath("//div[@class='alert alert-info ng-scope']")).getCssValue("border-color");
//        Assert.assertEquals(backgroundColor,"rgba(217, 237, 247, 1)");
//        Assert.assertEquals(color,"rgba(49, 112, 143, 1)");
//        Assert.assertEquals(boderColor,"rgb(188, 232, 241)");
//
//
//        String btnLoginBGColor = DriverUlti.findElement(By.xpath("//button[@class='btn btn-danger']")).getCssValue("background-color");
//        String btnLoginBDColor = DriverUlti.findElement(By.xpath("//button[@class='btn btn-danger']")).getCssValue("border-color");
//        String btnLoginColor = DriverUlti.findElement(By.xpath("//button[@class='btn btn-danger']")).getCssValue("color");
//        Assert.assertEquals(btnLoginBGColor,"rgba(217, 83, 79, 1)");
//        Assert.assertEquals(btnLoginColor,"rgba(255, 255, 255, 1)");
//        Assert.assertEquals(btnLoginBDColor,"rgb(212, 63, 58)");
//
//
//        String btnLoginPadding = DriverUlti.findElement(By.xpath("//button[@class='btn btn-danger']")).getCssValue("padding");
//        System.out.println(btnLoginPadding);
//
//    }

    @AfterMethod
    public static void quitDriver() {
        DriverUlti.quit();
    }
}
