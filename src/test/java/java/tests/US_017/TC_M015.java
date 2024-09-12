package java.tests.US_017;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import static utilities.Driver.driver;

public class TC_M015 extends TestBaseRapor {

    @Test
    public void Test15 (){

        extentTest = extentReports.createTest("KK olarak Header’daki Menü’de " +
                "Kayıtlı Kullanıcı ismine tıklandığında KK Dashboard açıldığı testi.");

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

        //Header bölümünde Menü'de Kayıtlı Kullanıcı ismine tıklar.
        homePage.HeaderKKIsmi.click();
        extentTest.info("Header bölümünde Kayıtlı Kullanıcı ismine tıklandı");

        //Açılan sayfanın Kayıtlı Kullanıcı Dashboard olduğunu test eder.
        String expectedUrl="https://qa.hauseheaven.com/account/dashboard";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("Açılan sayfanın Kayıtlı Kullanıcı Dashboard olduğu test edildi.");

        //Daha sonra Log out linkine tıklar
        homePage.logoutButonu.click();
        extentTest.info("Log out linkine tıklandı.");

        //Sayfayı kapatır
        Driver.quitDriver();
        extentTest.info("Sayfa kapatıldı.");
    }
}
