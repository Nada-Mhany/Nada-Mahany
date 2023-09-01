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


public class CheckLoginWithInvalidData extends LoginScreen{

    @BeforeMethod
    public void openFacebook() {

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.facebook.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    LoginScreen loginScreen = new LoginScreen();

    //Login to facebook using invalid email
    @Test(priority = 1)
        public void CheckLogin_invalidEmail() throws IOException, ParseException {

        String assertError = loginScreen.invalidLoginEmail();


        assertEquals(assertError,"The email address you entered isn't connected to an account. Find your account and log in.","Test Case failed: Error message doesn't appear");

        Reporter.log( "Verify login with invalid email passed", true );

    }
    //Login to facebook using invalid phone
    @Test(priority = 2)
    public void CheckLogin_invalidPhone() throws IOException, ParseException {

        String assertError = loginScreen.invalidLoginPhone();


        assertEquals(assertError,"The email address you entered isn't connected to an account. Find your account and log in.","Test Case failed: Error message doesn't appear");
        Reporter.log( "Verify login with invalid phone passed", true );


    }
    //Closing the browser after each test case
    @AfterTest
    public void QuitBrowser(){
        driver.quit();
    }

}
