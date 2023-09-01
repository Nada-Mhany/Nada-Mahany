package Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginScreen {
    public static WebDriver driver;


    By emailField = By.xpath("//input[contains(@id,'email')]");
    By password = By.xpath("//input[contains(@id,'pass')]");
    By loginBtn = By.xpath("//button[contains(@id,'u_0_5')]");
    By errorMessage = By.xpath("//div[contains(@class,'_9ay7')]");
    By homeField = By.xpath("//span[contains(@class,'x1lliihq')]");

    public LoginScreen() {
        LoginScreen.driver = driver;
    }

    //Login with valid email and password, as if this email is real.
    public String validLogin()  {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(emailField)).sendKeys("jerry33@gmail.com");
        //ReadJson object = new ReadJson();
        wait.until(ExpectedConditions.elementToBeClickable(password)).sendKeys("1238y76128@3#");
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
        String passedMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(homeField)).getText();
        return passedMessage;
    }
    //
    public String invalidLoginEmail(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(emailField)).sendKeys("tdshxbdgvs@jabsjha.ckmd");
        wait.until(ExpectedConditions.elementToBeClickable(password)).sendKeys("1238y76128@3#");
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
        String error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();

        return error;
    }
    public String invalidLoginPhone(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(emailField)).sendKeys("0557488");
        wait.until(ExpectedConditions.elementToBeClickable(password)).sendKeys("1238y76128@3#");
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
        String error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();

        return error;
    }

}
