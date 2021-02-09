package unitedHealth;

import common.WebAPI;
import org.openqa.selenium.WebElement;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Amazon extends WebAPI {
    public static void main(String[] args) throws Throwable {

        openBrowser("chromebrowser","https://www.amazon.com/");
        List<WebElement> linksAvailable =getLinksAsString(driver);
        List<WebElement> linkswithHref =new ArrayList<>();
        Iterator<WebElement> iterator = linksAvailable.iterator();
        int count=0;
        int countactivelinks=0;

        while (iterator.hasNext()){
            count++;
            if (iterator.next().getAttribute("href")!=null) {
                linkswithHref.add(iterator.next());
                countactivelinks++;}
        }
        Iterator<WebElement> hrefLInks = linkswithHref.iterator();
       while (hrefLInks.hasNext()) {
           HttpURLConnection connectionhttp=(HttpURLConnection)new URL(hrefLInks.next().getAttribute("href")).openConnection();
       connectionhttp.connect();
       String answer =connectionhttp.getResponseMessage();

           System.out.println(hrefLInks.next().getAttribute("href")+"--->" +answer);
       }
       driver.quit();
    }
}
