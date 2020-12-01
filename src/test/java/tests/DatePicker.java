package tests;

import com.DriverUlti;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.DatePickerPage;

public class DatePicker {

    DatePickerPage datePickerPage = new DatePickerPage();

    @BeforeMethod
    public static void runDriver() {
        DriverUlti.getDriverDatePicker();
    }

    @DataProvider(name = "dataTestDate")
    public Object[][] dpProvider1() {
        return new Object[][]{{4, 2, 2020, 0, 15}, {03, 15, 2001, 23, 0}, {05, 31, 1994, 2, 00}, {12, 5, 2013, 17, 30}};
    }

    @Test(dataProvider = "dataTestDate")
    public void selectDate(int month, int day, int year, int hour, int minute) {
        datePickerPage.setBtnSelectDate(month, day, year);
        String dateInput = String.format("%s/%s/%s", datePickerPage.convertMonth(month), datePickerPage.convertDay(day), year);
        Assert.assertEquals(dateInput, datePickerPage.getTxtDate());
        datePickerPage.setBtnSelectDateAndTime(month, day, year, hour, minute);
        String dateAndTimeInput = String.format("%s %s, %s %s", datePickerPage.getMonth(month), day, year, datePickerPage.getHour(hour, minute));
        Assert.assertEquals(dateAndTimeInput, datePickerPage.getTxtDateAndTime());
    }

//    @Test(dataProvider = "dataTestDate")
//    public void setDatePickerPage(int month, int day, int year, int hour, int minute) {
//        datePickerPage.setDay(month, day, year);
//        String dateInput = String.format("%s/%s/%s", datePickerPage.convertMonth(month), datePickerPage.convertDay(day), year);
//        Assert.assertEquals(dateInput, datePickerPage.getTxtDate());
//
//        datePickerPage.selectMonthTime(month);
//    }

    @AfterMethod
    public static void quitDriver() {
        DriverUlti.quit();
    }
}

