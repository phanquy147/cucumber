package tests;

import com.CalenderUlti;
import com.DriverUlti;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.PracticePage;
import page.SelectMenuPage;

public class Practice {
    PracticePage practicePage = new PracticePage();
    SelectMenuPage selectMenuPage = new SelectMenuPage();
    CalenderUlti calenderUlti = new CalenderUlti();
    String iconTick = "url(\"data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8' viewBox='0 0 8 8'%3e%3cpath fill='%2328a745' d='M2.3 6.73L.6 4.53c-.4-1.04.46-1.4 1.1-.8l1.1 1.4 3.4-3.8c.6-.63 1.6-.27 1.2.7l-4 4.6c-.43.5-.8.4-1.1.1z'/%3e%3c/svg%3e\")";
    String iconWarning = "url(\"data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' width='12' height='12' fill='none' stroke='%23dc3545' viewBox='0 0 12 12'%3e%3ccircle cx='6' cy='6' r='4.5'/%3e%3cpath stroke-linejoin='round' d='M5.8 3.6h.4L6 6.5z'/%3e%3ccircle cx='6' cy='8.2' r='.6' fill='%23dc3545' stroke='none'/%3e%3c/svg%3e\")";
    String borderColorGreen = "rgb(40, 167, 69)";
    String borderColorRed = "rgb(220, 53, 69)";

    @BeforeMethod
    public void runDriver() {
        DriverUlti.getDriverDemoQa();
        selectMenuPage.selectMainMenuPage("forms");
        selectMenuPage.selectSubMenu("practice form");
    }

    @DataProvider(name = "dataTrue")
    public Object[][] dpProvider1() {
        return new Object[][]{{"phan", "Quy", "abc@gmail.com", "Male", "0392777320", "23 Dec 2012", new String[]{"Computer Science", "History"}, new String[]{"Sports", "Music"}, "oke.jpeg", "173 Nguyen van troi", "Uttar Pradesh", "Agra"}};
    }

    @DataProvider(name = "dataFail")
    public Object[][] dpProvider2() {
        return new Object[][]{{"", "", "aaa", "","", "31 May 1994", new String[]{"Computer Science", "History"}, new String[]{"Music"}, "oke.jpeg", "", "Uttar Pradesh", "Agra"}};
    }

    @Test(dataProvider = "dataTrue")
    public void fillProfileForm(String firstName, String lastName, String email, String gender, String phone, String date, String[] subjects, String[] hobbies, String fileName, String address, String state, String city) throws Exception {
        practicePage.fillPracticeForm(firstName, lastName, email, gender, phone, date, subjects, hobbies, fileName, address, state, city);
        practicePage.submit();
        Assert.assertEquals(practicePage.getBorderFirstNameColor(), borderColorGreen);
        Assert.assertEquals(practicePage.getFirstNameIcon(), iconTick);
        Assert.assertEquals(practicePage.getBorderFirstNameColor(), borderColorGreen);
        Assert.assertEquals(practicePage.getFirstNameIcon(), iconTick);
        Assert.assertEquals(practicePage.getBorderLastNameColor(), borderColorGreen);
        Assert.assertEquals(practicePage.getLastNameIcon(), iconTick);
        Assert.assertEquals(practicePage.getBorderMailColor(), borderColorGreen);
        Assert.assertEquals(practicePage.getMailIcon(), iconTick);
        Assert.assertEquals(practicePage.getBorderPhoneColor(), borderColorGreen);
        Assert.assertEquals(practicePage.getPhoneIcon(), iconTick);
        Assert.assertEquals(practicePage.getProfile("name"), String.format("%s %s", firstName, lastName));
        Assert.assertEquals(practicePage.getProfile("email"), email);
        Assert.assertEquals(practicePage.getProfile("gender"), gender);
        Assert.assertEquals(practicePage.getProfile("mobile"), phone);
        Assert.assertEquals(practicePage.getProfile("birth"), calenderUlti.convertToDatePickerFormat(date));
        Assert.assertEquals(practicePage.getProfile("subjects"), practicePage.convertStringFormat(subjects));
        Assert.assertEquals(practicePage.getProfile("hobbies"), practicePage.convertStringFormat(hobbies));
        Assert.assertEquals(practicePage.getProfile("picture"), fileName);
        Assert.assertEquals(practicePage.getProfile("address"), address);
        Assert.assertEquals(practicePage.getProfile("state and city"), String.format("%s %s", state, city));
        practicePage.close();
    }

    @Test(dataProvider = "dataFail")
    public void fillProfileForm2(String firstName, String lastName, String email, String gender, String phone, String date, String[] subjects, String[] hobbies, String fileName, String address, String state, String city) {
        practicePage.fillPracticeForm(firstName, lastName, email, gender, phone, date, subjects, hobbies, fileName, address, state, city);
        practicePage.submit();
        Assert.assertEquals(practicePage.getBorderFirstNameColor(), borderColorRed);
        Assert.assertEquals(practicePage.getFirstNameIcon(), iconWarning);
        Assert.assertEquals(practicePage.getBorderLastNameColor(), borderColorRed);
        Assert.assertEquals(practicePage.getLastNameIcon(), iconWarning);
        Assert.assertEquals(practicePage.getBorderMailColor(), borderColorRed);
        Assert.assertEquals(practicePage.getMailIcon(), iconWarning);
        Assert.assertEquals(practicePage.getGenderColor(), borderColorRed);
        Assert.assertEquals(practicePage.getBorderPhoneColor(), borderColorRed);
        Assert.assertEquals(practicePage.getPhoneIcon(), iconWarning);
    }

    @AfterMethod
    public void quitDriver() {
        DriverUlti.quit();
    }

}
