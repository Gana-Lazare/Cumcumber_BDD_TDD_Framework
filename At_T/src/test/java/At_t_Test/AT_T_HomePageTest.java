package At_t_Test;

import AT_T.AT_T_HomePage;
import common.WebAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AT_T_HomePageTest extends WebAPI {
    AT_T_HomePage  at_t_homePage = new AT_T_HomePage();

    public void initDriver(){
        at_t_homePage = PageFactory.initElements(driver,AT_T_HomePage.class);
    }
@Test(enabled = false)
    public void clickOnDealsTest() throws Exception {
        at_t_homePage.clickOnDealsPage();
        String expectedResult = "https://www.att.com/deals/";
        String actualResult = driver.getCurrentUrl();
    Assert.assertEquals(actualResult,expectedResult,"Test Not Match");
}
@Test(enabled = false)
    public void SignIN_Account_Test() throws Exception {
        at_t_homePage.clickONSignIn_Account();
       // String ExpecteedResult=""
}
@Test
    public void sendKeyWordSearch() {
        at_t_homePage.searchOnSearchBare();
}
}
