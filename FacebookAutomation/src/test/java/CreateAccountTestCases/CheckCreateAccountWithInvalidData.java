package CreateAccountTestCases;
import Screens.CreateAccountScreen;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class CheckCreateAccountWithInvalidData extends CreateAccountScreen{

    //Open facebook before each test case
    @BeforeMethod
    public void openFacebook() {

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.facebook.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    CreateAccountScreen register = new CreateAccountScreen();
    //Creating account using invalid email
    @Test
    public void VerifyCreateNewAccount_invalidEmail() throws IOException, ParseException {

        register.createAccountwithInvalidEmail();


    }
    //Creating account using invalid phone number
    @Test (enabled = false)
    public void VerifyCreateNewAccount_invalidPhone() throws IOException, ParseException {

        register.createAccountwithInvalidPhone();

    }
    //Closing the browser after each test case
    @AfterTest
    public void QuitBrowser(){
        driver.quit();
    }

}
