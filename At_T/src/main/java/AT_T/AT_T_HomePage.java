package AT_T;

import Utility.ConnectToDB;
import common.WebAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.util.Iterator;
import java.util.List;

public class AT_T_HomePage extends WebAPI {
    AT_T_HomePage at_t_homePage;
    ConnectToDB connectToDB = new ConnectToDB();


    public DealsPage clickOnDealsPage() throws Exception {
        clickONElement("HEADBAND00");
        return new  DealsPage();
    }
    public static final String Account_Xpath="//*[@id=\"z1-profile-text\"]";
    @FindBy(how = How.XPATH,using= Account_Xpath)
    WebElement account;
    public void clickOnAccount() throws Exception {
        clickONElement("z1-profile-text");
    }

    public  static final String signIN_Xpath="//*[contains(text(),'Sign in')]";
    @FindBy(how = How.XPATH, using = signIN_Xpath)
    WebElement SignInWebElement;
    public  Sign_In_Account clickONSignIn_Account() throws Exception {
        clickOnAccount();
       waitExplicitly(10,signIN_Xpath);
        System.out.println(elementsOndropDow("//*[@class='show-unauth']/li/a",signIN_Xpath));
       clickOnelementsOfDropDownMenu("//*[@class='show-unauth']/li/a",signIN_Xpath,"Sign in");
      // SignInWebElement.click();
        return new Sign_In_Account();
    }
    public static final String searchBare_Xpath="//*[@id=\"z1-searchfield\"]";
    @FindBy(how =How.XPATH,using = searchBare_Xpath)
    WebElement searchBare;
    public SearchPage searchOnSearchBare(){
        //searchBare.sendKeys("Iphone for sale ");
        List<String> passwordlist =connectToDB.readDataFromDB("AT_T","userpsw");
        Iterator<String> iteratorPsw= passwordlist.iterator();
        while(iteratorPsw.hasNext()){
            driver.findElement(By.xpath(searchBare_Xpath)).sendKeys(iteratorPsw.next());
        }
        return new SearchPage();
    }

}
