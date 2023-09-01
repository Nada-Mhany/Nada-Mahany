package Screens;


import Helpers.ReadJson;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.time.Duration;


public class CreateAccountScreen {


   public static WebDriver driver;

    By createAccountBtn = By.xpath("//a[contains(@id,'u_0')]");
    By firstName = By.xpath("//input[contains(@name,'firstname')]");
    By signupBtn = By.xpath("//button[contains(@name,'websubmit')]");
    By surName = By.xpath("//input[contains(@name,'lastname')]");
    By email_phoneNumber = By.xpath("//input[contains(@name,'reg_email__')]");
    By reenter_email = By.xpath("//input[contains(@name,'reg_email_confirmation__')]");
    By password = By.xpath("//input[contains(@name,'reg_passwd__')]");
    By dateOfBirth_day = By.xpath("//select[contains(@name,'birthday_day')]");
    By dateOfBirthay_month = By.xpath("//select[contains(@name,'birthday_month')]");
    By dateOfBirthday_year = By.xpath("//select[contains(@name,'birthday_year')]");
    By gender = By.xpath("//input[contains(@name,'sex')]");
    By assertGenderValue = By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[7]/span/span[1]/label");
    By WrongPhone = By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[2]/div/i[1]");

    By errorMessagePhone = By.xpath("//div[contains(@id,'js_tt')]");

    public CreateAccountScreen() {
    CreateAccountScreen.driver=driver;

    }


    public void selectValueFromDropdown(By locator, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(locator));
        Select select = new Select(dropdown);
        select.selectByVisibleText(value);
    }

    public String createEmailAccount() throws IOException, ParseException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(createAccountBtn)).click();
        ReadJson object = new ReadJson();
        wait.until(ExpectedConditions.elementToBeClickable(firstName)).sendKeys(object.firstName);

        wait.until(ExpectedConditions.elementToBeClickable(surName)).sendKeys(object.surName);
        wait.until(ExpectedConditions.elementToBeClickable(email_phoneNumber)).sendKeys(object.email);
        wait.until(ExpectedConditions.elementToBeClickable(reenter_email)).sendKeys(object.reenteremail);
        wait.until(ExpectedConditions.elementToBeClickable(password)).sendKeys(object.password);

        selectValueFromDropdown(dateOfBirth_day, object.dateDay);
        selectValueFromDropdown(dateOfBirthay_month,object.dateMonth);
        selectValueFromDropdown(dateOfBirthday_year,object.dateYear);
        wait.until(ExpectedConditions.elementToBeClickable(gender)).click();
        String genderText = wait.until(ExpectedConditions.elementToBeClickable(assertGenderValue)).getText();
        System.out.println(genderText);
        //wait.until(ExpectedConditions.elementToBeClickable(signupBtn)).click();
        return
        genderText;
    }
    public String createPhoneAccount() throws IOException, ParseException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(createAccountBtn)).click();
        ReadJson object = new ReadJson();
        wait.until(ExpectedConditions.elementToBeClickable(firstName)).sendKeys(object.firstName);

        wait.until(ExpectedConditions.elementToBeClickable(surName)).sendKeys(object.surName);
        wait.until(ExpectedConditions.elementToBeClickable(email_phoneNumber)).sendKeys(object.phoneNumber);
        wait.until(ExpectedConditions.elementToBeClickable(password)).sendKeys(object.password);

        selectValueFromDropdown(dateOfBirth_day, object.dateDay);
        selectValueFromDropdown(dateOfBirthay_month,object.dateMonth);
        selectValueFromDropdown(dateOfBirthday_year,object.dateYear);
        String genderText = wait.until(ExpectedConditions.elementToBeClickable(assertGenderValue)).getText();
        System.out.println(genderText);
        //wait.until(ExpectedConditions.elementToBeClickable(signupBtn)).click();

        return genderText;
    }
    public void createAccountwithInvalidEmail() throws IOException, ParseException {

        //This method makes user add wrong email then click on submit and ensures that the error icon doesn't appear anymore after clicking on it.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(createAccountBtn)).click();
        ReadJson object = new ReadJson();
        wait.until(ExpectedConditions.elementToBeClickable(firstName)).sendKeys(object.firstName);

        wait.until(ExpectedConditions.elementToBeClickable(surName)).sendKeys(object.surName);
        wait.until(ExpectedConditions.elementToBeClickable(email_phoneNumber)).sendKeys("nada@");

        wait.until(ExpectedConditions.elementToBeClickable(signupBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(WrongPhone)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(WrongPhone));


    }
    public void createAccountwithInvalidPhone() throws IOException, ParseException {

        //This method makes user add wrong phone then click on submit and ensures that the error icon doesn't appear anymore after clicking on it.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(createAccountBtn)).click();
        ReadJson object = new ReadJson();
        wait.until(ExpectedConditions.elementToBeClickable(firstName)).sendKeys(object.firstName);

        wait.until(ExpectedConditions.elementToBeClickable(surName)).sendKeys(object.surName);
        wait.until(ExpectedConditions.elementToBeClickable(email_phoneNumber)).sendKeys("0114");
        wait.until(ExpectedConditions.elementToBeClickable(signupBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(WrongPhone)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(WrongPhone));


    }



}
