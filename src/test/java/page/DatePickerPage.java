package page;

import com.DriverUlti;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DatePickerPage {
    By btnSelectDate = By.id("datePickerMonthYearInput");
    By dropDownSelectMonth = By.xpath("//select[contains(@class,'datepicker__month-select')]/option");
    By dropDownSelectYear = By.xpath("//select[contains(@class,'datepicker__year-select')]/option");
    By btnSelectDateAndTime = By.id("dateAndTimePickerInput");
    By listDayAndTimeXpath = By.xpath("//div[@id='dateAndTimePicker']//div[@role='listbox']/div/div[not(contains(@class,'outside-month'))]");
    By iconMonthDropdown = By.xpath("//div[contains(@class,'month-dropdown-container--scroll')]");
    By iconYearDropdown = By.xpath("//div[@class='react-datepicker__year-read-view']/span[contains(@class,'down-arrow')]");
    By dropDownSelectMonthOnTime = By.xpath("//div[@class='react-datepicker__month-read-view']/preceding-sibling::div[@class='react-datepicker__month-dropdown']/div[contains(@class,'option')]");
    By dropDownSelectYearOnTime = By.xpath("//div[@class='react-datepicker__year-read-view']/preceding-sibling::div[@class='react-datepicker__year-dropdown']");
    By listTime = By.xpath("//div[@class='react-datepicker__time-box']/ul[@class='react-datepicker__time-list']/li");

    int time = 60;

    public String getMonth(int month) {
        String txtMonth = null;
        switch (month) {
            case 1:
                txtMonth = "January";
                break;
            case 2:
                txtMonth = "February";
                break;
            case 3:
                txtMonth = "March";
                break;
            case 4:
                txtMonth = "April";
                break;
            case 5:
                txtMonth = "May";
                break;
            case 6:
                txtMonth = "June";
                break;
            case 7:
                txtMonth = "July";
                break;
            case 8:
                txtMonth = "August";
                break;
            case 9:
                txtMonth = "September";
                break;
            case 10:
                txtMonth = "October";
                break;
            case 11:
                txtMonth = "November";
                break;
            case 12:
                txtMonth = "December";
                break;
        }
        return txtMonth;
    }

    public String getHour(int hour, int minute) {
        String exacHour = null;
        String mn;
        int hh;
        if (minute == 0) {
            mn = String.format("0%s", minute);
        } else {
            mn = String.valueOf(minute);
        }

        if (hour == 0) {
            hh = 12;
        } else if (hour == 24) {
            hh = 12;
        } else {
            hh = hour;
        }

        if (hour > 12) {
            switch (hour) {
                case 13:
                    exacHour = String.format("1:%s PM", mn);
                    break;
                case 14:
                    exacHour = String.format("2:%s PM", mn);
                    break;
                case 15:
                    exacHour = String.format("3:%s PM", mn);
                    break;
                case 16:
                    exacHour = String.format("4:%s PM", mn);
                    break;
                case 17:
                    exacHour = String.format("5:%s PM", mn);
                    break;
                case 18:
                    exacHour = String.format("6:%s PM", mn);
                    break;
                case 19:
                    exacHour = String.format("7:%s PM", mn);
                    break;
                case 20:
                    exacHour = String.format("8:%s PM", mn);
                    break;
                case 21:
                    exacHour = String.format("9:%s PM", mn);
                    break;
                case 22:
                    exacHour = String.format("10:%s PM", mn);
                    break;
                case 23:
                    exacHour = String.format("11:%s PM", mn);
                    break;
            }
        } else {
            exacHour = String.format("%s:%s AM", hh, mn);
        }
        return exacHour;
    }

    public String convertMonth(int month) {
        String mm = String.valueOf(month);
        if (month < 10) {
            mm = String.format("0%s", month);
        }
        return mm;
    }

    public String convertDay(int day) {
        String dd = String.valueOf(day);
        if (day < 10) {
            dd = String.format("0%s", day);
        }
        return dd;
    }

    public void setBtnSelectDate(int month, int day, int year) {
        DriverUlti.waitForElement(btnSelectDate, time);
        DriverUlti.click(btnSelectDate);
        DriverUlti.executeJS(btnSelectDate);
        DriverUlti.sendKeys(btnSelectDate, String.format("%s/%s/%s", month, day, year));
        DriverUlti.sendKeys(btnSelectDate, Keys.RETURN);
        DriverUlti.waitMinus(3000);
    }

    public void setBtnSelectDateAndTime(int month, int day, int year, int hour, int minute) {
        DriverUlti.waitForElement(btnSelectDateAndTime, time);
        DriverUlti.click(btnSelectDateAndTime);
        DriverUlti.executeJS(btnSelectDateAndTime);
        DriverUlti.sendKeys(btnSelectDateAndTime, String.format("%s/%s/%s %s:%s", month, day, year, hour, minute));
        DriverUlti.sendKeys(btnSelectDateAndTime, Keys.RETURN);
        DriverUlti.waitMinus(3000);
    }

    public String getTxtDate() {
        DriverUlti.waitForElement(btnSelectDate, time);
        return DriverUlti.getAttribute(btnSelectDate, "value");
    }

    public String getTxtDateAndTime() {
        DriverUlti.waitForElement(btnSelectDateAndTime, time);
        return DriverUlti.getAttribute(btnSelectDateAndTime, "value");
    }

// cach 2

    public void clickBoxDate() {
        DriverUlti.waitForElement(btnSelectDate, time);
        DriverUlti.click(btnSelectDate);
        DriverUlti.waitMinus(3000);
    }

    public void chooseYear(int year) {
        List<WebElement> listYear = DriverUlti.findElements(dropDownSelectYear);
        for (int i = 0; i < listYear.size(); i++) {
            if (listYear.get(i).getText().equalsIgnoreCase(String.valueOf(year))) {
                listYear.get(i).click();
            }
        }
    }

    public void chooseMonth(int month) {
        List<WebElement> listMonth = DriverUlti.findElements(dropDownSelectMonth);
        for (int i = 0; i < listMonth.size(); i++) {
            if (listMonth.get(i).getText().equalsIgnoreCase(getMonth(month))) {
                listMonth.get(i).click();
            }
        }
    }

    public void chooseDate(int day) {
        By listDay = By.xpath(String.format("(//div[@id='datePickerMonthYear']//div[@role='listbox']/div/div[contains(.,'%s') and not(contains(@class,'outside-month'))])[1]", day));
        DriverUlti.waitForElementVisibility(listDay, time);
        DriverUlti.click(listDay);
        DriverUlti.waitMinus(2000);
    }

    public void selectYear(int year) {
        DriverUlti.waitForElement(dropDownSelectYear, time);
        DriverUlti.click(dropDownSelectYear);
        chooseYear(year);
        DriverUlti.waitMinus(2000);
    }

    public void selectMonth(int month) {
        DriverUlti.waitForElement(dropDownSelectMonth, time);
        DriverUlti.click(dropDownSelectMonth);
        chooseMonth(month);
        DriverUlti.waitMinus(2000);
    }

    public void selectDay(int day) {
        chooseDate(day);
        DriverUlti.waitMinus(2000);
    }

    public void setDay(int month, int day, int year) {
        clickBoxDate();
        selectYear(year);
        selectMonth(month);
        selectDay(day);
    }

    public void clickBoxDateAndTime(){
        DriverUlti.waitForElement(btnSelectDateAndTime,time);
        DriverUlti.click(btnSelectDateAndTime);
        DriverUlti.waitMinus(2000);
    }

    public void chooseMonthTime(int month) {
        DriverUlti.waitForElement(dropDownSelectMonthOnTime,time);
        List<WebElement> listMonth = DriverUlti.findElements(dropDownSelectMonthOnTime);
        for (int i = 0; i < listMonth.size(); i++) {
            if (listMonth.get(i).getText().equalsIgnoreCase(getMonth(month))) {
                listMonth.get(i).click();
            }
        }
        DriverUlti.waitMinus(2000);
    }

    public void selectMonthTime(int month){
        clickBoxDateAndTime();
        DriverUlti.waitForElement(iconMonthDropdown,time);
        DriverUlti.click(iconMonthDropdown);
        DriverUlti.waitMinus(2000);
        chooseMonthTime(month);
        DriverUlti.waitMinus(2000);
    }
}
