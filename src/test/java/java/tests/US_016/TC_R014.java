package java.tests.US_016;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_R014 extends TestBaseRapor {
    @Test
    public void Test01(){

        extentTest=extentReports.createTest
            ("Kayitli kullanicinin properties sayfasinda reload butonunun calismasi testi");
        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Tarayici acildi ve Hause Heaven sitesine gidildi.");

        HomePage homePage = new HomePage();
        homePage.signinButonu.click();
        extentTest.pass("Sign in butonuna tiklanilir.");

        homePage.emailTextbox.sendKeys("rananurulker@hauseheaven.com");
        extentTest.pass("Mail text boxa email girilir.");
        homePage.passwordTextbox.sendKeys("Hven.150820");
        extentTest.pass("Password text boxa password girilir.");

        homePage.loginButonu.click();
        extentTest.pass("Login butonu tiklanir ve giris yapildigi gorulur.");

        homePage.kayitliKullaniciUserLinki.click();

        ReusableMethods.hover(homePage.kayitlikullaniciPropertiesLinki);
        homePage.kayitlikullaniciPropertiesLinki.click();
        extentTest.pass("Submenudeki Properties linkine tiklanilir.");
        ReusableMethods.bekle(3);

        Assert.assertTrue(homePage.reloadButonu.isDisplayed());
        extentTest.pass("Reload butonunun gorunur oldugu test edilir.");
        homePage.reloadButonu.click();
        extentTest.pass("Reload butonuna tiklanilarak sayfa yenilenir.");


        Driver.getDriver().quit();
        extentTest.pass("Ziyaretci browseri kapatir.");
    }
}
