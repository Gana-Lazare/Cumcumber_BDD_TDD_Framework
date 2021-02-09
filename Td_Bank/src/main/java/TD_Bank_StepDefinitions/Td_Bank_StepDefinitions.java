package TD_Bank_StepDefinitions;

import common.WebAPI;
import io.cucumber.java.en.*;

public class Td_Bank_StepDefinitions extends WebAPI {
    @Given("I nagivate to td bank website")
    public void i_nagivate_to_td_bank_website() throws Throwable {
        setup("chromebrowser","https://www.td.com/");
    }

}
