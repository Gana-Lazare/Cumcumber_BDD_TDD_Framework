package common;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.apache.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebAPI {
    //public static WebDriver driver = new ChromeDriver();
   public static WebDriver driver;
    @Parameters({"BrowserName","url"})
@BeforeMethod
    public static void setup(@Optional("chromebrowser") String BrowserName,@Optional("http://www.google.com") String url) throws Throwable {
       if (BrowserName.equalsIgnoreCase("chromebrowser")){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\micromedia\\IdeaProjects\\SeleniumFrameWorkGana\\Generic\\BrowserDriver\\windows\\chromedriver.exe");
        driver =new ChromeDriver();
       // driver.navigate().to("https://www.youtube.com/watch?v=DWpYniQAVyI&list=PLFGoYjJG_fqqyIj2ht0aHMx_HnGX3ZFEx&index=14");
     driver.get(url);
        System.out.println(driver.getTitle());}
       else System.out.println("Not Correct");

}

public static void clickONElement(String locator) throws Exception {
        try {
            driver.findElement(By.xpath(locator)).click();
        }catch (Exception e1){
           try {
               driver.findElement(By.cssSelector(locator)).click();
           }catch (Exception e2){}
           try {
               driver.findElement(By.id(locator)).click();
           }catch (Exception e3){
               try {
                   driver.findElement(By.tagName(locator)).click();
               }catch (Exception e4){
                   try {
                       driver.findElement(By.linkText(locator)).click();
                   }catch (Exception e5){
                       try {
                           driver.findElement(By.partialLinkText(locator)).click();
                       }catch (Exception e6){
                           try {
                               driver.findElement(By.name(locator)).click();
                           }
                           catch (Exception e7){
                               try {
                                   driver.findElement(By.className(locator)).click();
                               }
                               catch (Exception e8){
                                   throw new Exception("Element NOt found");
                               }
                           }
                       }
                   }
               }
           }
        }
}
public static void waitExplicitly(long seconds,String locator){
    WebDriverWait wait = new WebDriverWait(driver,seconds);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
}
public static List<WebElement> locateONFindWebElementsDropDown(String Container,String locator){
        List<WebElement> elements = new ArrayList<>();
        elements=driver.findElements(By.xpath(Container));
        return elements;
}
public static List<String> elementsOndropDow(String container,String locator){
List<WebElement> elements = new ArrayList<>();
    List<String> elementsToString = new ArrayList<>();
elements=locateONFindWebElementsDropDown(container,locator);
Iterator<WebElement> it = elements.iterator();
while (it.hasNext()){
    elementsToString.add(it.next().getText());
}
return elementsToString;
}
public static  void clickOnelementsOfDropDownMenu(String container,String locator,String NameOFElement){
    List<WebElement> elements = new ArrayList<>();
    List<String> elementsToString = new ArrayList<>();
    elements=locateONFindWebElementsDropDown(container,locator);
    Iterator<WebElement> it = elements.iterator();
    while (it.hasNext()){
       if (it.next().getText().equalsIgnoreCase(NameOFElement)) {
           driver.findElement(By.xpath("//*[contains(text(),'"+NameOFElement+")]"));
           System.out.println("Element Drop Down clicked");}
       }
    }

public static List<WebElement> getListLinks(WebDriver driver){
        List<WebElement> links = new ArrayList<WebElement>();
        links = driver.findElements(By.tagName("a"));
        links.addAll(driver.findElements(By.tagName("img")));
        return links;
}
public static  List<WebElement> getLinksAsString(WebDriver driver){
        List<WebElement> mylinks = new ArrayList<WebElement>();
        List<WebElement> links = getListLinks(driver);
    Iterator<WebElement> it = links.iterator();
    while (it.hasNext()){
        mylinks.add(it.next());

    }
    return mylinks;
}

@AfterMethod
    public static void closeBrowser(){
       driver.quit();
}
}
