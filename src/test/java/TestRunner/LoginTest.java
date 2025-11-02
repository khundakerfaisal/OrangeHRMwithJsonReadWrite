package TestRunner;

import Config.SetupBrowser;
import Pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends SetupBrowser {
   @Test
    public void doLogin() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        LoginPage loginPages=new LoginPage(driver);
        loginPages.hrmLoginPage("Admin","admin123");
        Thread.sleep(1000);
    }
}
