package java.tests.US_017;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import static utilities.Driver.driver;

public class TC_M016 extends TestBaseRapor {

    @Test
    public void Test16 (){

        extentTest = extentReports.createTest("Kayıtlı Kullanıcı olarak Anasayfa'da " +
                "aşağı doğru skrol yapıldığında Header'ın dropdown olarak gelmesi testi.");

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

        //Anasayfa'da aşağı doğru skrol yapar
        ReusableMethods.hover(homePage.SefFooterElementi);
        extentTest.info("Anasayfa'da aşağı doğru skrol yapıldı");

        //Header Menüsünün Dropdown olarak geldiğini doğrular.
        Assert.assertTrue(homePage.HeaderLinki.isDisplayed());
        extentTest.pass("Header Menüsünün Dropdown olarak geldiğini test edildi.");

        //Daha sonra Log out linkine tıklar
        homePage.logoutButonu.click();
        extentTest.info("Log out linkine tıklandı.");

        //Sayfayı kapatır
        Driver.quitDriver();
        extentTest.info("Sayfa kapatıldı.");
    }
}
