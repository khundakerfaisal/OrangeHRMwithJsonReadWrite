package TestRunner;

import Config.SetupBrowser;
import Pages.LoginPage;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import utils.Utils;

import java.io.IOException;

public class loginWithJson extends SetupBrowser {
    @Test
    public void doLogin() throws InterruptedException, IOException, ParseException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        LoginPage loginPages=new LoginPage(driver);
        String userName= Utils.getEmployee().get("UserName").toString();
        String password= Utils.getEmployee().get("Password").toString();


        loginPages.hrmLoginPage(userName,password);
        Thread.sleep(1000);
    }
}
