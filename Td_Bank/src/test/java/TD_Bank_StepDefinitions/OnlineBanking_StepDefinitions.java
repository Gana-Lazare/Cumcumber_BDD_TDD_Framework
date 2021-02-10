package TD_Bank_StepDefinitions;

import Td_BankHomePage.LoginPage;
import WebElements.LoginPageWebElements;
import common.WebAPI;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;

public class OnlineBanking_StepDefinitions extends WebAPI {
    LoginPage loginPage;
    LoginPageWebElements  loginPageWebElements= new LoginPageWebElements();
    private String user=null;
    private String password = null;
    @Given("I search  for my data corresponding")
    public void i_search_for_my_data_corresponding() {
         loginPage =new LoginPage("test1","123test1");
         if (loginPage.getuserPasswordList().contains(loginPage.getPassword())){
             if (loginPage.getuserNameList().contains(loginPage.getUserName())){
                 this.user=loginPage.getUserName();
                 this.password=loginPage.getPassword();
             }
         }

    }
    @Given("I enter {string} and {string}")
    public void i_enter_and(String userName, String password) {
if (this.user !=null && this.password!=null){
    userName=this.user;
    password=this.password;
driver.findElement(By.xpath(loginPageWebElements.userField)).sendKeys(userName);
driver.findElement(By.xpath(loginPageWebElements.userPassword)).sendKeys(password);
    System.out.println("user"+userName+"\npassword:"+password);
}
    }

    @When("I click on log in")
    public void i_click_on_log_in() {
        System.out.println("clicklogin");
    }

    @Then("message incorrect credentials should apear")
    public void message_incorrect_credentials_should_apear() {
        System.out.println("incorrect");
    }
}
