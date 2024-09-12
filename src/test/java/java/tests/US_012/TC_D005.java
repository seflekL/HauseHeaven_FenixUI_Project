package java.tests.US_012;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC_D005 extends TestBaseRapor {
    @Test
    public void singIntesti() {

        extentTest = extentReports.createTest("Kayıtlı Kullanıcı olarak giriş yapabilme testi");

        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Hause Heaven Anasayfası'na gidildi.");
        extentTest.pass("Tarayici acildi ve Hause Heaven sitesine gidildi.");
        HomePage homePage = new HomePage();

        Assert.assertTrue(homePage.signinButonu.isDisplayed());
        extentTest.pass("Sign in butonunun görünür olduğu test edildi.");
        homePage.signinButonu.click();
        extentTest.pass("Sign in butonuna tıklandı.");


        homePage.kullaniciGirisiEmailKutusu.sendKeys("dileksengul@hauseheaven.com");
        homePage.KullaniciGirisiPasswordKutusu.sendKeys("Hven.150820");


        homePage.sefUsercookies.click();

        homePage.KullaniciGirisiLoginButonu.click();
        extentTest.pass("Login butonu tiklanir ve giris yapildigi gorulur.");

        homePage.kayitliKullaniciUserLinki.click();
        extentTest.pass("Login olduktan sonra cikan kayitli kullanici isminin oldugu linke tiklanir.");

        String expectedresualt="Dashboard";
        String actualresualt=homePage.dashboardButonu.getText();
        Assert.assertEquals(actualresualt,expectedresualt);
        extentTest.pass("Login olduktan sonra dasborhda olduğunu doğrular.");


        homePage.logoutButonu.click();
        extentTest.pass("Logout butonu tiklanir ve cikis yapildigi gorulur.");

        Driver.getDriver().quit();
        extentTest.pass("Ziyaretci browseri kapatir.");

    }
}





