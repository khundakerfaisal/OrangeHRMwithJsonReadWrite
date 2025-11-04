package TestRunner;

import Config.SetupBrowser;
import Pages.LoginPage;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import utils.UtilsFile;

import java.io.IOException;

public class loginWithJson extends SetupBrowser {
    @Test(priority = 1,groups = "smoke",enabled = false)
    public void doLogin() throws InterruptedException, IOException, ParseException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        LoginPage loginPages=new LoginPage(driver);
        String userName=UtilsFile.getEmployee().get("UserName").toString();
        String password=UtilsFile.getEmployee().get("Password").toString();
//        String userName= UtilsFile.getEmployee().get("UserName").toString();
//        String password= UtilsFile.getEmployee().get("Password").toString();
        loginPages.hrmLoginPage(userName,password);
        Thread.sleep(1000);
    }
}
