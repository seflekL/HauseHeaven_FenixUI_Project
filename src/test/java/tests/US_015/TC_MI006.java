package tests.US_015;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.MustafaMethods;
import utilities.TestBaseRapor;

public class TC_MI006 extends TestBaseRapor {

    @Test
    public void test06(){

        extentTest = extentReports.createTest("Account dashboard erişim testi");

        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Tarayıcı açıldı ve hause heaven web sitesine gidildi.");

        MustafaMethods.hauseHeavenLogin(ConfigReader.getProperty("MIusername"),ConfigReader.getProperty("MIpassword"));

        HomePage homePage = new HomePage();

        Assert.assertTrue(homePage.accountDashboardButonu.isDisplayed());
        extentTest.pass("Account dashboard butonu görüntülendi.");

        homePage.accountDashboardButonu.click();
        extentTest.pass("Account dashboard butonu tıklandı.");

        String exceptedUrl = "https://qa.hauseheaven.com/account/dashboard";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl,exceptedUrl);
        extentTest.pass("Url üzerinden account dashboard sayfasında olduğu doğrulandı.");

        Driver.getDriver().quit();
        extentTest.pass("Driver kapatıldı.");


    }

}
