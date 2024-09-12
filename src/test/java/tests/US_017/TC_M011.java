package tests.US_017;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC_M011 extends TestBaseRapor {

    @Test
    public void Test11 (){

        extentTest = extentReports.createTest("KK Anasayfa " +
                "Header’daki Menü’de en sağ tarafta ‘Log Out’ linkinin görünür ve aktif olmalı testi.");

        //Ziyaretçi browser’ı açar, HauseHeaven URL’ini girer ve enter’a basar

        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Hause Heaven Anasayfası'na gidildi.");

        //Anasayfa’da sağ üst taraftaki Sign in linkine tıklar
        HomePage homePage=new HomePage();
        homePage.signinButonu.click();
        extentTest.info("Anasayfa’da Sign In linkine tıklandı.");

        //Açılan Login sayfasında üyelik bilgilerini girer ve Log in linkine tıklar
        homePage.emailTextbox.sendKeys("mehmetyilmaz@hauseheaven.com");
        homePage.passwordTextbox.sendKeys("Hven.150820"+ Keys.ENTER);
        //homePage.logInSayfasiLogInLinki.click();
        extentTest.info("Login sayfasında üyelik bilgileri girildi ve Log in linkine tıklandı.");

        //Açılan KK Anasayfası'nda Log Out linkinin görünürlüğünü doğrular
        Assert.assertTrue(homePage.logoutButonu.isDisplayed());
        extentTest.pass("Açılan KK Anasayfası'nda Log Out linkinin görünür olduğu test edildi.");

        //Daha sonra Log out linkine tıklar
        homePage.logoutButonu.click();
        extentTest.info("Log out linkine tıklandı.");

        //KK olarak çıkış yaptığını test eder
        Assert.assertTrue(homePage.signinButonu.isDisplayed());
        extentTest.pass("Kayıtlı Kullanıcı olarak Log out olunduğu test edildi.");

        //Sayfayı kapatır
        Driver.quitDriver();
        extentTest.info("Sayfa kapatıldı.");
    }
}
