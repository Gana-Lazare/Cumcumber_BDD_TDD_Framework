package TD_Bank_StepDefinitions;

import WebElements.HomePageWebElements;
import common.WebAPI;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Td_HomePage_StepDefinitions extends WebAPI {
HomePageWebElements pathElements =new HomePageWebElements();
private String searchKey="helloTest";
    @Given("I nagivate to td bank website")
    public void i_nagivate_to_td_bank_website() throws Throwable {
        setup("chromebrowser","https://www.td.com/");
    }
    @When("I Click on smallBusiness")
    public void i_click_on_small_business() throws Exception {
        clickONElement("//*[contains(text(),'Small Business')]");
    }
    @Then(("I should see small business Banking"))
    public void I_should_see_small_business_Banking(){
        WebElement businessBanking = driver.findElement(By.xpath(pathElements.SmalBusinessBanking_xpath));
       // moveToAnElementAction(businessBanking);
        scrollIntoViewElement(businessBanking);
String ExpectedResult="Small Business Banking";
String ActualResult=businessBanking .getText();
        Assert.assertEquals("Small Business wrong page ",ExpectedResult,ActualResult);
    }

    /**
     * Scenario 2 Navigate to ONline Banking
     */

    @Given("I mouse Over Login")
    public void i_mouse_over_login() {
WebElement loginDropDownMenue_xpath = driver.findElement(By.xpath(pathElements.logInDropDownMenue_xpath));
moveToAnElementAction(loginDropDownMenue_xpath);
    }

    @When("i click on Online Banking")
    public void i_click_on_online_banking() {
List<String > listOfDropDownMenu= new ArrayList<>();
      listOfDropDownMenu=  elementsOndropDow(pathElements.Element_logIn_DropDownMenu_List,"No used");
        System.out.println(listOfDropDownMenu);
        if (listOfDropDownMenu.contains("Online Banking")){
            driver.findElement(By.xpath(pathElements.OnlineBanking_Xpath)).click();
          Set<String> windows =driver.getWindowHandles();
            Iterator<String> it = windows.iterator();
            String parentnWindow =it.next(); // parent
            String childWindow = it.next();
           // driver.navigate().to(childWindow);
            driver.switchTo().window(childWindow);
            System.out.println(childWindow+"       µ***µµµµµµµµµ*µ**");
            System.out.println(driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/div[1]/div/h1")).getText());
        }
    }


    @Then("I should see online banking url")
    public void i_should_see_online_banking_url() {
        System.out.println("Not Yet");
    }
    @Given("I send searchkey {string} on searchbare")
    public void i_send_searchkey_on_searchbare(String searchKey) throws InterruptedException {
        searchKey=this.searchKey;
        driver.findElement(By.xpath("//*[@class='td-desktop-search-show-btn']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/header[1]/div[3]/div/div[3]/div/header-search-input/form/input[1]")).
                sendKeys(searchKey);
    }

    @When("i submit my search")
    public void i_submit_my_search() {

    }

    @Then("i should see the keysearch n search page")
    public void i_should_see_the_keysearch_n_search_page() {

    }

    //Close Browser



}
