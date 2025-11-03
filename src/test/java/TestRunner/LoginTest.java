package TestRunner;

import Config.SetupBrowser;
import Pages.LoginPage;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class LoginTest extends SetupBrowser {
   @Test(priority = 1)
    public void doLogin() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        LoginPage loginPages=new LoginPage(driver);
//        loginPages.hrmLoginPage("Admin","admin123");
        String username=System.getProperty("username");
        String password=System.getProperty("password");
        loginPages.hrmLoginPage(username,password);
        Thread.sleep(1000);
    }
}
