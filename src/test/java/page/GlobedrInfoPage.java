package page;

import com.CalenderUlti;
import com.DriverUlti;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GlobedrInfoPage {
    CalenderUlti calenderUlti = new CalenderUlti();

    By btnAccount = By.xpath("//a[@href='/profile/info']");
    By txtName = By.xpath("//label[@translate='yourName']/preceding-sibling::input");
    By txtTitle = By.xpath("//label[@translate='title']/preceding-sibling::input");
    By txtEmail = By.xpath("//label[@translate='email']/preceding-sibling::input");
    By txtPhone = By.xpath("//label[@translate='phoneNumber']/preceding-sibling::input");
    By txtWorkPhone = By.xpath("//label[@translate='workPhone']/preceding-sibling::input");
    By txtAddress = By.id("address");
    By autoAddress = By.xpath("//div[@class='pac-item']");
    By txtDOB = By.xpath("//div[@class='ui-datepicker']/input[1]");
    By dropDownGender = By.xpath("//label[@translate='gender']/preceding-sibling::select");
    By dropDownVisitCountry = By.xpath("//label[@translate='visitCountry']/preceding-sibling::select");
    By dropDownCountry = By.xpath("//label[@translate='country']/preceding-sibling::select");
    By btnSave = By.xpath("//a[@translate='save']");
    By iconCamera = By.xpath("//div[contains(@class,'btn-file')]");
    By btnOk = By.xpath("//button[contains(@class,'btn-gdr')]");
    By label = By.xpath("//label");

    int time = 60;
    String value = "value";
    String nameInput;
    String titleInput;
    String emailInput;
    String phoneInput;
    String workPhoneInput;
    String dOBInput;
    String regionSelect;
    String genderSelect;
    String countrySelect;
    String visitCountrySelect;
    String addressInput;
    String citySelect;
    int numberRandom;

    public void goToAccountInfoPage() {
        DriverUlti.waitForElement(btnAccount, time);
        DriverUlti.click(btnAccount);
        DriverUlti.waitMinus(3000);
    }

    public String randomName() {
        return nameInput = RandomStringUtils.randomAlphabetic(1, 10);
    }

    public void inputName(String name) {
        DriverUlti.waitForElement(txtName, time);
        DriverUlti.clear(txtName);
        DriverUlti.sendKeys(txtName, name);
    }

    public String randomTitle() {
        return titleInput = RandomStringUtils.randomAlphabetic(8);
    }

    public void inputTitle(String title) {
        DriverUlti.waitForElement(txtTitle, time);
        DriverUlti.clear(txtTitle);
        DriverUlti.sendKeys(txtTitle, title);
    }

    public String randomEmail (){
        String firstEmail = RandomStringUtils.randomAlphabetic(1, 15);
        String[] arrMail = {"@gmail.com", "@yahoo.com", "@bacsitoancau.com", "@outlook.vn"};
        Random ran = new Random();
        String lastEmail = arrMail[ran.nextInt(arrMail.length)];
        return  emailInput = firstEmail + lastEmail;
    }


    public void inputEmail(String email) {
        DriverUlti.waitForElement(txtEmail, time);
        DriverUlti.clear(txtEmail);
        DriverUlti.sendKeys(txtEmail, email);
    }

    public void inputPhone() {
        phoneInput = "0" + RandomStringUtils.randomNumeric(9);
        DriverUlti.waitForElement(txtPhone, time);
        DriverUlti.clear(txtPhone);
        DriverUlti.sendKeys(txtPhone, phoneInput);
    }

    public void inputWorkPhone() {
        workPhoneInput = "0" + RandomStringUtils.randomNumeric(9);
        DriverUlti.waitForElement(txtWorkPhone, time);
        DriverUlti.clear(txtWorkPhone);
        DriverUlti.sendKeys(txtWorkPhone, workPhoneInput);
    }

    public void inputAddress() {
        String numberAddress = RandomStringUtils.randomNumeric(1, 3);
        String[] arrAddress = {"a", "b", "c", "d"};
        Random ran = new Random();
        String street = arrAddress[ran.nextInt(arrAddress.length)];
        DriverUlti.waitForElement(txtAddress, time);
        DriverUlti.clear(txtAddress);
        DriverUlti.sendKeys(txtAddress, numberAddress + street);
        DriverUlti.waitForElement(autoAddress, time);
        DriverUlti.waitMinus(5000);
        List<WebElement> listAddress = DriverUlti.findElements(autoAddress);
        numberRandom = randomIntegerInRange(0, listAddress.size() - 1);
        addressInput = listAddress.get(numberRandom).getText();
        listAddress.get(numberRandom).click();
    }

    public String randomDob() throws Exception {
        int date = randomIntegerInRange(1, 31);
        int month = randomIntegerInRange(1, 12);
        int year = randomIntegerInRange(1900, 2020);
       return dOBInput = calenderUlti.convertDate(String.format("%s/%s/%s", date, month, year));
    }

    public void inputDateOfBirth(String dOB){
        DriverUlti.waitForElement(txtDOB, time);
        DriverUlti.executeJS(txtDOB);
        DriverUlti.sendKeys(txtDOB, dOB);
    }

    public static int randomIntegerInRange(int min, int max) {
        if (min > max) {
            throw new IllegalStateException("MIN should be < MAX");
        } else {
            return ThreadLocalRandom.current().nextInt(min, max + 1);
        }
    }

    public String randomGender(){
        String[] arrGender = {"male", "female"};
        Random ran = new Random();
        return genderSelect = arrGender[ran.nextInt(arrGender.length)];
    }

    public void selectGender(String gender) {
        DriverUlti.waitForElement(dropDownGender, time);
        DriverUlti.click(dropDownGender);
        List<WebElement> listGender = DriverUlti.findElements(By.xpath("//label[@translate='gender']/preceding-sibling::select/option"));
        for (int i = 0; i < listGender.size(); i++) {
            if (listGender.get(i).getText().equalsIgnoreCase(gender)) {
                listGender.get(i).click();
            }
        }
    }

    public void selectVisitCountry() {
        DriverUlti.waitForElement(dropDownVisitCountry, time);
        DriverUlti.click(dropDownVisitCountry);
        List<WebElement> listVisitCountry = DriverUlti.findElements(By.xpath("//label[@translate='visitCountry']/preceding-sibling::select/option"));
        numberRandom = randomIntegerInRange(0, listVisitCountry.size() - 1);
        listVisitCountry.get(numberRandom).click();
        visitCountrySelect = listVisitCountry.get(numberRandom).getText();
    }

    public void selectCountry() {
        DriverUlti.waitForElement(dropDownCountry, time);
        DriverUlti.click(dropDownCountry);
        List<WebElement> listCountry = DriverUlti.findElements(By.xpath("//label[@translate='country']/preceding-sibling::select/option"));
        numberRandom = randomIntegerInRange(0, listCountry.size() - 1);
        listCountry.get(numberRandom).click();
        countrySelect = listCountry.get(numberRandom).getText();
    }

    public void selectRegion() {
        List<WebElement> listLabel = DriverUlti.findElements(label);
        for (int i = 0; i < listLabel.size(); i++) {
            if (listLabel.get(i).getText().equalsIgnoreCase("region/sate")) {
                WebElement region = listLabel.get(i).findElement(By.xpath("./preceding-sibling::select"));
                region.click();
                List<WebElement> listRegion = region.findElements(By.xpath("./option"));
                if (listRegion.size() > 1) {
                    numberRandom = randomIntegerInRange(0, listRegion.size() - 1);
                    listRegion.get(numberRandom).click();
                    regionSelect = listRegion.get(numberRandom).getText();
                } else {
                    listRegion.get(0).click();
                    regionSelect = listRegion.get(0).getText();
                }
            }
        }
    }


    public String getRegion() {
        String regionAtual = null;
        List<WebElement> listLabel = DriverUlti.findElements(label);
        for (int i = 0; i < listLabel.size(); i++) {
            if (listLabel.get(i).getText().equalsIgnoreCase("region/sate")) {
                WebElement region = listLabel.get(i).findElement(By.xpath("./preceding-sibling::select"));
                regionAtual = region.getAttribute(value);
            }
        }
        return regionAtual;
    }

    public void selectCity() {
        List<WebElement> listLabel = DriverUlti.findElements(label);
        for (int i = 0; i < listLabel.size(); i++) {
            if (listLabel.get(i).getText().equalsIgnoreCase("city")) {
                WebElement city = listLabel.get(i).findElement(By.xpath("./preceding-sibling::select"));
                city.click();
                List<WebElement> listCity = city.findElements(By.xpath("./option"));
                if (listCity.size() > 1) {
                    numberRandom = randomIntegerInRange(0, listCity.size() - 1);
                    listCity.get(numberRandom).click();
                    citySelect = listCity.get(numberRandom).getText();
                } else {
                    listCity.get(0).click();
                    citySelect = listCity.get(0).getText();
                }
            }
        }
    }

    public String getCity() {
        String cityAtual = null;
        List<WebElement> listLabel = DriverUlti.findElements(label);
        for (int i = 0; i < listLabel.size(); i++) {
            if (listLabel.get(i).getText().equalsIgnoreCase("city")) {
                WebElement region = listLabel.get(i).findElement(By.xpath("./preceding-sibling::select"));
                cityAtual = region.getAttribute(value);
            }
        }
        return cityAtual;
    }


    public void save() {
        DriverUlti.waitForElement(btnSave, time);
        DriverUlti.click(btnSave);
    }

    public void updateImage() throws IOException {
        DriverUlti.waitForElement(iconCamera, time);
        DriverUlti.click(iconCamera);

//        File file = new File("/Users/apple/Desktop/QUYCANGKHON-01.png");
//
//        StringSelection stringSelection = new StringSelection(file.getAbsolutePath());
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
//
//        Robot robot = new Robot();
////        // Cmd + Tab is needed since it launches a Java app and the browser looses focus
//        robot.keyPress(KeyEvent.VK_META);
//        robot.keyPress(KeyEvent.VK_TAB);
//        robot.keyRelease(KeyEvent.VK_META);
//        robot.keyRelease(KeyEvent.VK_TAB);
//        DriverUlti.waitMinus(5000);

////Open Goto window
//        robot.keyPress(KeyEvent.VK_META);
//        robot.keyPress(KeyEvent.VK_SHIFT);
//        robot.keyPress(KeyEvent.VK_G);
//        robot.keyRelease(KeyEvent.VK_META);
//        robot.keyRelease(KeyEvent.VK_SHIFT);
//        robot.keyRelease(KeyEvent.VK_G);
//        DriverUlti.waitMinus(3000);

////Paste the clipboard value
//        robot.keyPress(KeyEvent.VK_META);
//        robot.keyPress(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_META);
//        robot.keyRelease(KeyEvent.VK_V);
//        robot.delay(500);

//Press Enter key to close the Goto window and Upload window
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
//        DriverUlti.waitMinus(1000);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
//        robot.delay(500);
        Runtime.getRuntime().exec("osascript " + "/Users/apple/Desktop/upload.scpt");
//        upImage();
        DriverUlti.waitForElementVisibility(btnOk, time);
        DriverUlti.click(btnOk);
    }

//    public void upImage() throws IOException {
//        String filePath = "/Users/apple/Desktop/QUYCANGKHON-01.png";
//        Runtime runtime = Runtime.getRuntime();
//        String appleScrip = "tell application \"System Events\"\n" +
//                "keystroke \"G\" using {command down, shift down}\n" +
//                "delay 2\n" +
//                "keystroke \"" + filePath + "\"\n" +
//                "delay 1\n" +
//                "keystroke return\n" +
//                "delay 1\n" +
//                "keystroke return\n" +
//                "end tell";
//        String[] args = { "osascript", "-e", appleScrip };
//        Process process = runtime.exec(args);
//    }

//    public String getNameValue() {
//        String name = DriverUlti.getAttribute(txtName, "value");
//        return name;
//    }

    public boolean equalValue(String input, String actual) {
        boolean isExis = false;
        if (input.equalsIgnoreCase(actual)) {
            isExis = true;
        }
        return isExis;
    }


    public void updateInfo(String name, String title,String email,String dOB,String gender) throws Exception {
        fillInfo(name, title,email,dOB,gender);
        save();
        DriverUlti.waitMinus(5000);
    }

    public void fillInfo(String name, String title,String email,String dOB,String gender) throws Exception {
        updateImage();
        inputName(name);
        inputTitle(title);
        inputEmail(email);
        inputDateOfBirth(dOB);
        selectGender(gender);
        selectVisitCountry();
        selectCountry();
        selectRegion();
        selectCity();
        inputAddress();
        inputPhone();
        inputWorkPhone();
    }

    public void checkInfoAfterUpdate() {
        equalValue(nameInput, DriverUlti.getAttribute(txtName, value));
        equalValue(titleInput, DriverUlti.getAttribute(txtTitle, value));
        equalValue(emailInput, DriverUlti.getAttribute(txtEmail, value));
        equalValue(phoneInput, DriverUlti.getAttribute(txtPhone, value));
        equalValue(workPhoneInput, DriverUlti.getAttribute(txtWorkPhone, value));
        equalValue(dOBInput, DriverUlti.getAttribute(txtDOB, value));
        equalValue(genderSelect, DriverUlti.getAttribute(dropDownGender, value));
        equalValue(visitCountrySelect, DriverUlti.getAttribute(dropDownVisitCountry, value));
        equalValue(countrySelect, DriverUlti.getAttribute(dropDownCountry, value));
        equalValue(addressInput, DriverUlti.getAttribute(txtAddress, value));
        equalValue(regionSelect, getRegion());
        equalValue(citySelect, getCity());
        System.out.println("name: " + nameInput);
        System.out.println("title: " + titleInput);
        System.out.println("email: " + emailInput);
        System.out.println("phone: " + phoneInput);
        System.out.println("work phone: " + workPhoneInput);
        System.out.println("Date of birth: " + dOBInput);
        System.out.println("gender: " + genderSelect);
        System.out.println("visiting country: " + visitCountrySelect);
        System.out.println("country: " + countrySelect);
        System.out.println("city: " + citySelect);
        System.out.println("region: " + regionSelect);
        System.out.println("address: " + addressInput);
    }

}
