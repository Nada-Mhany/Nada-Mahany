package LoginTestCases;

import Screens.LoginScreen;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class VerifyLoginWithValidData extends LoginScreen {


    @BeforeMethod
    public void openFacebook() {

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.facebook.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    //This case will fail because i haven't a real account
    @Test()
    public void CheckLogin_validData() throws IOException, ParseException {

        LoginScreen loginScreen = new LoginScreen();
        String assertError = loginScreen.validLogin();


        assertEquals(assertError,"What's on your mind","Test Case failed: What's in you mind text hasn't appeared");

        Reporter.log( "Verify login with valid data passed", true );

    }
    //Closing the browser after each test case
    @AfterTest
    public void QuitBrowser(){
        driver.quit();
    }
}
