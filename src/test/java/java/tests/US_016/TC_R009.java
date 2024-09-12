package java.tests.US_016;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC_R009 extends TestBaseRapor {
    @Test
    public void Test01(){

        extentTest=extentReports.createTest
                ("Kayitli kullanicinin account hesabina giris yapabilmesi testi");
        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Tarayici acildi ve Hause Heaven sitesine gidildi.");

        HomePage homePage = new HomePage();

        Assert.assertTrue(homePage.signinButonu.isDisplayed());
        extentTest.pass("Sign in butonunun gorunur oldugu test edilir.");

        homePage.signinButonu.click();
        extentTest.pass("Sign in butonuna tiklanilir.");

        Assert.assertTrue(homePage.emailTextbox.isDisplayed());
        extentTest.pass("Mail text box goruntulenir.");
        Assert.assertTrue(homePage.passwordTextbox.isDisplayed());
        extentTest.pass("Password text box goruntulenir.");

        homePage.emailTextbox.sendKeys("rananurulker@hauseheaven.com");
        extentTest.pass("Mail text boxa email girilir.");
        homePage.passwordTextbox.sendKeys("Hven.150820");
        extentTest.pass("Password text boxa password girilir.");

        homePage.loginButonu.click();
        extentTest.pass("Login butonu tiklanir ve giris yapildigi gorulur.");

        homePage.logoutButonu.click();
        extentTest.pass("Logout butonu tiklanir ve cikis yapildigi gorulur.");

        Driver.getDriver().quit();
        extentTest.pass("Ziyaretci browseri kapatir.");
    }
}
