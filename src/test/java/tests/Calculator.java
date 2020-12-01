package tests;

import com.DriverUlti;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.CalPage;

import java.text.DecimalFormat;
import java.util.Random;

public class Calculator {
    CalPage calPage = new CalPage();
    Random rd = new Random();
    int number1 = rd.nextInt(100);
    int number2 = rd.nextInt(100);

    @BeforeMethod
    public static void runDriver() {
        DriverUlti.getDriverCalculator();
    }

    @DataProvider(name = "keyMath")
    public Object[][] dpProvider1() {
        return new Object[][]{{number1,"ADDITION",number2},{number1,"DIVISION",number2},{number1,"MODULO",number2},{number1,"MULTIPLICATION",number2},{number1,"SUBTRACTION",number2}};
    }

    public String getOperator(String key) {
        String operator = null;
        switch (key) {
            case "ADDITION":
                operator = "+";
                break;
            case "DIVISION":
                operator = "/";
                break;
            case "MODULO":
                operator = "%";
                break;
            case "MULTIPLICATION":
                operator = "*";
                break;
            case "SUBTRACTION":
                operator = "-";
                break;
        }
        return operator;
    }

    public double resultCal (double nb1, double nb2, String key){
        double result = 0;
        switch (key){
            case "ADDITION":
                result = nb1 + nb2;
                break;
            case "DIVISION":
                result = nb1 / nb2;
                break;
            case "MODULO":
                result = nb1 % nb2;
                break;
            case "MULTIPLICATION":
                result = nb1 * nb2;
                break;
            case "SUBTRACTION":
                result = nb1 - nb2;
                break;
        }
          return result;

    }


    @Test(dataProvider = "keyMath")
    public void calculator(int number1,String key, int number2) {
        DecimalFormat format = new DecimalFormat();
        format.setMinimumFractionDigits(0);
        format.setMaximumFractionDigits(20);
        format.setGroupingUsed(false);
        calPage.enterValue(number1, number2, key);
        System.out.println(format.format(resultCal(number1,number2,key)));
        Assert.assertEquals(calPage.getTxtExpression(), String.format("%s %s %s", number1, getOperator(key), number2));
        Assert.assertEquals(calPage.getTxtResult(), String.valueOf(format.format(resultCal(number1,number2,key))));

    }

    @AfterMethod
    public static void quitDriver() {
        DriverUlti.quit();
    }
}
