package tests;

import com.CalenderUlti;
import com.DriverUlti;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.DatePickerPage;
import page.SelectMenuPage;

public class DatePicker2 {
    DatePickerPage datePickerPage = new DatePickerPage();
    SelectMenuPage selectMenuPage = new SelectMenuPage();
    CalenderUlti calenderUlti = new CalenderUlti();

    @BeforeMethod
    public void runDriver() {
        DriverUlti.getDriverDemoQa();
        selectMenuPage.selectMainMenuPage("widgets");
        selectMenuPage.selectSubMenu("date picker");
    }

    @DataProvider(name = "dataTestDate")
    public Object[][] dpProvider1() {
        return new Object[][]{{4, 2, 2020, 0, 15}, {03, 15, 2001, 23, 0}, {05, 31, 1994, 2, 00}, {12, 5, 2013, 17, 30}};
    }

    @Test (dataProvider = "dataTestDate")
    public void selectDate2(int month, int day, int year, int hour, int minute) {
        datePickerPage.setBtnSelectDate(month, day, year);
        String dateInput = String.format("%s/%s/%s", datePickerPage.convertMonth(month), datePickerPage.convertDay(day), year);
        Assert.assertEquals(dateInput, datePickerPage.getTxtDate());
        datePickerPage.setBtnSelectDateAndTime(month, day, year, hour, minute);
        String dateAndTimeInput = String.format("%s %s, %s %s", datePickerPage.getMonth(month), day, year, datePickerPage.getHour(hour, minute));
        Assert.assertEquals(dateAndTimeInput, datePickerPage.getTxtDateAndTime());
    }

    @AfterMethod
    public static void quitDriver(){
        DriverUlti.quit();
    }
}
