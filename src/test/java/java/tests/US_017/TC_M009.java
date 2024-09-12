package java.tests.US_017;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import static utilities.Driver.driver;

public class TC_M009 extends TestBaseRapor {

    @Test
    public void Test09(){

        extentTest = extentReports.createTest("Ziyaretçi olarak Anasayfa’da " +
                "Sign In linkine tıklayarak Kayıtlı Kullanıcı giriş sayfasına ulaşma testi");

        //Ziyaretçi browser’ı açar, HauseHeaven URL’ini girer ve enter’a basar

        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Hause Heaven Anasayfası'na gidildi.");

        //HauseHeaven Anasayfada olduğunu doğrular.
        String expectedUrl="https://qa.hauseheaven.com/";
        String actualUrl= driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("Hause Heaven Anasayfa'da olduğu test edildi.");

        //Anasayfa’da sağ üst taraftaki Sign in linkine tıklar
        HomePage homePage=new HomePage();
        homePage.signinButonu.click();
        extentTest.info("Sign In linkine tıklandı.");

        //Açılan sayfanın Login (Kayıt ) sayfası olduğunu test eder.
        Assert.assertTrue(homePage.logInSayfasiKayitKutusu.isDisplayed());
        extentTest.pass("Açılan sayfanın Log In sayfası olduğu test edildi.");

        //Sayfayı kapatır
        Driver.quitDriver();
        extentTest.info("Sayfa kapatıldı.");
    }

}
