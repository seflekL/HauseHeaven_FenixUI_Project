package tests.US_024;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import static utilities.Driver.driver;

public class TC_M022 extends TestBaseRapor {

    @Test
    public void Test22 (){

        extentTest = extentReports.createTest("Kayıtlı Kullanıcı olarak " +
                "Kayıtlı Emlakçıların sayfasında Emlakçı ilanında emlakçının fotoğrafı veya View linkine tıklandığında " +
                "Emlakçının ilan sayfasının açıldığı testi");

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

        //KK anasayfasında Header bölümünde Agents linkine tıklar
        homePage.agentsButonu.click();
        extentTest.info("Anasayfada Agents linkine tıklandı.");

        //Açılan sayfanın Kayıtlı Emlakçılar sayfası olduğunu test eder.
        String expectedUrl="https://qa.hauseheaven.com/agents";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("Açılan sayfanın Kayıtlı Emlakçılar sayfası olduğu test edildi.");

        //Açılan sayfada Emlakçı ilanında fotoğrafa tıklar.
        homePage.agentsPageIlkAgentFoto.click();
        extentTest.info("Emlakçı ilanındaki fotoğrafa tıklandı.");

        //Daha sonra Açılan sayfanın emlakçının ilan sayfası olduğunu test der.
        Assert.assertTrue(homePage.agentsDetailPageTitleLinki.isDisplayed());
        extentTest.pass("Açılan sayfanın emlakçının ilan sayfası olduğu test edildi.");

        //Tekrar Agents sayfasına geri dönüldü
        homePage.agentsButonu.click();
        extentTest.info("Kayıtlı Emlakçılar sayfasına geri dönüldü.");

        //Sayfada Emlakçı ilanında View linkine tıklar.
        ReusableMethods.hover(homePage.agentsPageIlkAgentViewLinki);
        homePage.agentsPageIlkAgentViewLinki.click();
        extentTest.info("Emlakçı ilanındaki View linkine tıklandı.");

        //Sonra tekrar Açılan sayfanın emlakçının ilan sayfası olduğunu test der.
        Assert.assertTrue(homePage.agentsDetailPageTitleLinki.isDisplayed());
        extentTest.pass("Açılan sayfanın emlakçının ilan sayfası olduğu test edildi.");


        //Daha sonra Log out linkine tıklar
        homePage.logoutButonu.click();
        extentTest.info("Log out linkine tıklandı.");

        //Sayfayı kapatır
        Driver.quitDriver();
        extentTest.info("Sayfa kapatıldı.");
    }
}
