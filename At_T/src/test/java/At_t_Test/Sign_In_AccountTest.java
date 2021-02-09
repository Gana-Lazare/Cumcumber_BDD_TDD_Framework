package At_t_Test;

import AT_T.AT_T_HomePage;
import AT_T.Sign_In_Account;
import common.WebAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Sign_In_AccountTest extends WebAPI {
    public static AT_T_HomePage at_t_homePage = new AT_T_HomePage();
    public static Sign_In_Account sign_in_account = new Sign_In_Account();
    public void initDriver(){
        sign_in_account=PageFactory.initElements(driver,Sign_In_Account.class);
    }
    @Test()
    public void  insertCredentials() throws Exception {
        at_t_homePage.clickONSignIn_Account();
        sign_in_account.insertUserId();
        sign_in_account.insertpassword();
    }
}
