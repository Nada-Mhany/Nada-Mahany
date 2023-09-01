package CreateAccountTestCases;

import Screens.CreateAccountScreen;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;


public class VerifyCreateAccountWithValidData extends CreateAccountScreen{

    @BeforeMethod
    public void openFacebook() {

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.facebook.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    CreateAccountScreen register = new CreateAccountScreen();

        //Creating account with valid data using email
        @Test
        public void VerifyCreateNewAccount_validEmail() throws IOException, ParseException {

            String genderAssert = register.createEmailAccount();
            assertEquals(genderAssert,"Female","Test Case failed: The gender is not Female");
        }
        //Creating account with valid data using phone number
        @Test
        public void VerifyCreateNewAccount_validPhone() throws IOException, ParseException {

            String genderAssert = register.createPhoneAccount();
            assertEquals(genderAssert,"Female","Test Case failed: The gender is not Female");

        }
        //Closing the browser after the test case is done
        @AfterMethod
        public void QuitDriver(){

            driver.quit();

        }


    }

