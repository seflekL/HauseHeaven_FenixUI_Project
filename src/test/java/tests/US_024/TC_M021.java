package tests.US_024;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import static utilities.Driver.driver;

public class TC_M021 extends TestBaseRapor {

    @Test
    public void Test21 (){

        extentTest = extentReports.createTest("Kayıtlı Kullanıcı olarak Kayıtlı Emlakçıların sayfasında iken " +
                "Emlakçı ilanında emlakçının fotoğrafı, ismi, telefon numarası, e-mail adresi, ilan sayısı ve View linki " +
                "olduğu testi");

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

        //Emlakçı ilanında emlakçının fotoğrafı, ismi, telefon numarası, e-mail adresi, ilan sayısı ve
        // View linki olduğunu test eder.
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.agentsPageIlkAgentFoto.isDisplayed(), "Emlakçı Fotoğrafı bulunamadı");
        softAssert.assertTrue(homePage.agentsPageIlkAgentIsim.isDisplayed(), "Emlakçı İsmi bulunamadı");
        softAssert.assertTrue(homePage.agentsPageIlkAgentTel.isDisplayed(), "Emlakçı Telefon numarası bulunamadı");
        softAssert.assertTrue(homePage.agentsPageIlkAgentEmail.isDisplayed(), "Emlakçı Email adresi bulunamadı");
        softAssert.assertTrue(homePage.agentsPageIlkAgentIlanSayisi.isDisplayed(), "Emlakçı İlan sayısı bulunamadı");
        softAssert.assertTrue(homePage.agentsPageIlkAgentViewLinki.isDisplayed(), "Contacts Linki bulunamadı");

        extentTest.pass("Emlakçı ilanında emlakçının fotoğrafı, ismi, telefon numarası, e-mail adresi, " +
                "ilan sayısı ve View linki olduğu test edildi. ");

        softAssert.assertAll();


        //Daha sonra Log out linkine tıklar
        homePage.logoutButonu.click();
        extentTest.info("Log out linkine tıklandı.");

        //Sayfayı kapatır
        Driver.quitDriver();
        extentTest.info("Sayfa kapatıldı.");
    }
}
