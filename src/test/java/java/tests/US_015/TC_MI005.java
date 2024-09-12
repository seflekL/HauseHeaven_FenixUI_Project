package java.tests.US_015;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.time.Duration;

public class TC_MI005 extends TestBaseRapor {

    @Test
    public void test05(){

        extentTest = extentReports.createTest("asd");

        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Tarayıcı açıldı ve hause heaven web sitesine gidildi.");

        HomePage homePage = new HomePage();

        Assert.assertTrue(homePage.signinButonu.isDisplayed());
        extentTest.pass("Sign in butonunun görünür olduğu test edildi");

        homePage.signinButonu.click();
        extentTest.pass("Sign in butonuna tıklandı.");

        Assert.assertTrue(homePage.emailTextbox.isDisplayed());
        extentTest.pass("Mail text box görüntülendi.");
        Assert.assertTrue(homePage.passwordTextbox.isDisplayed());
        extentTest.pass("Password text box görüntülendi.");

        homePage.emailTextbox.sendKeys("mustafaismail@hauseheaven.com");
        extentTest.pass("Mail text box'a mail girildi.");
        homePage.passwordTextbox.sendKeys("Hven.150820");
        extentTest.pass("Password text box'a password girildi.");

        homePage.loginButonu.click();
        extentTest.pass("Login butonu tıklandı.");

        Assert.assertTrue(homePage.logoutButonu.isDisplayed());
        extentTest.pass("Logout butonu görüntülenerek giriş yapıldığı doğrulandı.");

        Driver.getDriver().quit();
        extentTest.pass("Driver kapatıldı.");

    }

}
