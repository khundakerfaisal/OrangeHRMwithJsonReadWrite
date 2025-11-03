package TestRunner;

import Config.SetupBrowser;
import Pages.LoginPage;
import Pages.PIMPages;
import com.github.javafaker.Faker;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import utils.UtilsFile;

import java.io.IOException;

public class PIMTest extends SetupBrowser {
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
    @Test(priority = 2)
    public void createEmployee() throws InterruptedException, IOException, ParseException {
        PIMPages pimPages=new PIMPages(driver);
        Faker faker=new Faker();
        String firstName=faker.name().firstName();
        String middleName=faker.name().nameWithMiddle();
        String lastName=faker.name().lastName();
        String userName=faker.name().username();
        String password="Ab@2025";
        String confirmPassword="Ab@2025";
        pimPages.pimMenuOperation(firstName,middleName,lastName,userName,password,confirmPassword);
        UtilsFile.saveEmployee(userName,password,confirmPassword);





//        Faker faker=new Faker();
//        String firstName=faker.name().firstName();
//        String middleName=faker.name().nameWithMiddle();
//        String lastName=faker.name().lastName();
//        String userName=faker.name().username();
//        String password="Pa@ssord123";
//        String confirmPassword="Pa@ssord123";
//        pimPages.pimMenuOperation(firstName,middleName,lastName,userName,password,confirmPassword);
//        Thread.sleep(1000);
//        Utils.saveEmployee(firstName,middleName,lastName,userName,password,confirmPassword);

    }
}
