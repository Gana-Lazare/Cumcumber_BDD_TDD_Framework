package unitedHealthTest;

import Utility.ConnectToDB;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AmazonTest {

    @Test
     public void connecttodb() throws Exception {
        List<String > data = new ArrayList<>();
        ConnectToDB ctoDB = new ConnectToDB();
       data= ctoDB.readDataFromDB("jetblue","emails");
        System.out.println(data.get(0));
    }

}
