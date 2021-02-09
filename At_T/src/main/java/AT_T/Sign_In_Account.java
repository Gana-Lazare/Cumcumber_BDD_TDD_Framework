package AT_T;

import Utility.ConnectToDB;
import common.WebAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.Iterator;
import java.util.List;

public class Sign_In_Account extends WebAPI {
    public static ConnectToDB connectToDB;

    public static final String userid="//*[@id=\"userID\"]";
    @FindBy(how = How.XPATH,using =userid)
    public static  WebElement user_Id_Input;
    public static void insertUserId() throws Exception {
        List<String> users =connectToDB.readDataFromDB("AT_T","userID");
        Iterator<String> iteratorUser= users.iterator();
        while(iteratorUser.hasNext()){
driver.findElement(By.xpath(userid)).sendKeys("iteratorUser.next()");}
    }

    public static final String password="//*[@id=\"password\"]";
    @FindBy(how = How.XPATH,using =password)
    public static WebElement password_Input;
    public static void insertpassword(){
        List<String> passwordlist =connectToDB.readDataFromDB("AT_T","userpsw");
        Iterator<String> iteratorPsw= passwordlist.iterator();
        while(iteratorPsw.hasNext()){
            driver.findElement(By.xpath(password)).sendKeys(iteratorPsw.next());
        }
    }
}
