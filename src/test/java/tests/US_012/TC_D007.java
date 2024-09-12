package tests.US_012;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_D007 extends TestBaseRapor {
    @Test
    public void gecersizBilgilerleKullaniciGirisiTesti(){
        extentTest = extentReports.createTest
                ("Siteye kayıtlı kullanıcı olarak giriş testi");
        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Tarayici acildi ve Hause Heaven sitesine gidildi.");
        HomePage homePage = new HomePage();

        Assert.assertTrue(homePage.signinButonu.isDisplayed());
        extentTest.pass("Sign in butonunun görünür olduğu test edildi.");
        homePage.signinButonu.click();
        extentTest.pass("Sign in butonuna tıklandı.");
        homePage.kullaniciGirisiSignInButonu.click();
        homePage.kullaniciGirisiEmailKutusu.sendKeys("dileksengul@hauseheaven.com");
        extentTest.pass("Geçerli e-posta adresi girildi.");

        homePage.KullaniciGirisiPasswordKutusu.sendKeys("Hven");
        extentTest.pass("Geçersiz şifre girildi.");
        homePage.sefUsercookies.click();
        ReusableMethods.hover(homePage.KullaniciGirisiLoginButonu);
        homePage.KullaniciGirisiLoginButonu.click();
        extentTest.pass("Log in butonuna tıklandı.");

        ReusableMethods.bekle(3);

        String expectesresualt="These credentials do not match our records.";
        String actualresualt=homePage.kullaniciYanlisGirisHataMesaji.getText();
        Assert.assertEquals(actualresualt,expectesresualt);
        extentTest.pass("Giriş yapılamadığı ve hata mesajının görüntülendiği doğrulandı.");


        Driver.quitDriver();
        extentTest.pass("Ziyaretci acilan  tarayici kapatir");


    }
}
