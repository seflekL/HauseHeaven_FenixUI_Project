package tests.US_013;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_F009 extends TestBaseRapor {

    @Test
    public void test09(){


        extentTest = extentReports.createTest("Kayıtlı kullanıcı oturumu kapatabilmesi ve ana sayfaya dönebilmesi testi");
        Driver.getDriver().get(ConfigReader.getProperty("hauseKaytKullUrl"));
        extentTest.info("Kullanici login sayfasina gider");

        HomePage homePage=new HomePage();
        UserDashboard userDashboard=new UserDashboard();
        // Kullanici login olur
        homePage.emailTextbox.sendKeys(ConfigReader.getProperty("gecerliUsername"));
        homePage.passwordTextbox.sendKeys(ConfigReader.getProperty("gecerliPassword"));
        ReusableMethods.wait(2);
        userDashboard.KayitliKullaniciLoginButonu.click();
        extentTest.pass("Ziyaretçi login olur.");

        ReusableMethods.hover(userDashboard.Logout);
        userDashboard.Logout.click();
        extentTest.pass("Kayitli kullanici Logout olur.");

        Assert.assertTrue(userDashboard.SignIn.isDisplayed());
        extentTest.pass("Kayitli kullanici artik adinin Header'da adinin gorulmedigini test eder");

        Driver.quitDriver();

    }

}
