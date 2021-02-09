package unitedHealthTest;

import common.WebAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.IExpectedExceptionsHolder;
import org.testng.annotations.*;
import unitedHealth.UnitedHealth;

public class UnitedHealthTest extends WebAPI {
    UnitedHealth unitedHealth;

    @BeforeSuite
    public void launchbrowser(){
        System.out.println("Launch Browser");
    }

    @BeforeClass
    public void geturl(){
        System.out.println("Navigate to url");
    }
    @BeforeMethod
    public void clickonlogin(){
        System.out.println("click");
    }
    @BeforeTest
    public void getusers(){
        System.out.println("getusers");
    }
    @Test
    public void test() throws Throwable {
        openBrowser("ChromeDriver","http://www.youtube.com");;
       // unitedHealth = PageFactory.initElements(driver, UnitedHealth.class);
        // registrationPage = PageFactory.initElements(driver,SignUpPage.class);
        System.out.println("testt");
    }
    @Test
    public void test2(){
        System.out.println(9/0);
        System.out.println("Test22");

    }
    @AfterMethod
    public void generateHtml(){
        System.out.println("HTML Report");
    }
    @AfterClass
    public void getErrors(){
        System.out.println("Get Errors");
    }
    @AfterTest
    public void TakeScreenShoot(){
        System.out.println("Screen SHOOT");
    }
    @AfterSuite
    public void ExtentReport(){
        System.out.println("Extent Report");
    }

}
