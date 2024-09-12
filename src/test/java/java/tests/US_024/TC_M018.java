package java.tests.US_024;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import static utilities.Driver.driver;

public class TC_M018 extends TestBaseRapor {

    @Test
    public void Test18 (){

        extentTest = extentReports.createTest("Kayıtlı Kullanıcı olarak HH websitesinde gezinirken" +
                " Header bölümünde Agents linkinin görünür olduğu testi");

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

        //KK anasayfasında Header bölümünde Agents linki olduğunu görüntüler ve test eder
        Assert.assertTrue(homePage.agentsButonu.isDisplayed());
        extentTest.pass("KK anasayfasında Header bölümünde Agents linki olduğu test edildi.");

        //Daha sonra her hangi bir linke tıklayarak başka bir sayfaya geçer.
        homePage.blogButonu.click();
        extentTest.info("Anasayfa'da her hangi bir linke tıklayarak başka bir sayfaya geçildi.");

        //Anasayfa dışında olduğunu test eder.
        String expectedUrl="https://qa.hauseheaven.com/";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertNotEquals(actualUrl,expectedUrl);
        extentTest.pass("Anasayfa dışında olunduğu test edildi.");

        //Açılan sayfada Header bölümünde Agents linki olduğunu görüntüler ve test eder
        Assert.assertTrue(homePage.agentsButonu.isDisplayed());
        extentTest.pass("Açılan Sayfada Header bölümünde Agents linki olduğu test edildi.");

        //Daha sonra Log out linkine tıklar
        homePage.logoutButonu.click();
        extentTest.info("Log out linkine tıklandı.");

        //Sayfayı kapatır
        Driver.quitDriver();
        extentTest.info("Sayfa kapatıldı.");
    }
}