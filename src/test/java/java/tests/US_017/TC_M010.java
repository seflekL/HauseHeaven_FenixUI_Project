package java.tests.US_017;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import static utilities.Driver.driver;

public class TC_M010 extends TestBaseRapor {

    @Test
    public void Test10 (){

        extentTest = extentReports.createTest("KK üyelik bilgileri girilip " +
                "Login’e tıklandığında KK ana sayfasına ulaşma testi");

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

        //Açılan sayfanın KK anasayfası olduğunu test eder.
        Assert.assertTrue(homePage.logoutButonu.isDisplayed());
        extentTest.pass("Açılan sayfanın KK Anasayfa'sı olduğu test edildi.");

        //Sayfayı kapatır
        Driver.quitDriver();
        extentTest.info("Sayfa kapatıldı.");
    }

}
