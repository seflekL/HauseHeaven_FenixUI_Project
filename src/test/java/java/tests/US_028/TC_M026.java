package java.tests.US_028;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import static utilities.Driver.driver;

public class TC_M026 extends TestBaseRapor {

    @Test
    public void Test26 (){

        extentTest = extentReports.createTest("Admin giriş sayfasından " +
                "Admin Dashboard sayfasına girildiğinde Profil ismine tıklandığında " +
                "Log 0ut linkinin dropdown olarak görünür ve aktif olduğu testi");

        //Ziyaretçi browser’ı açar, HauseHeaven Admin giriş URL’ini girer ve enter’a basar

        Driver.getDriver().get(ConfigReader.getProperty("hauseAdminUrl"));
        extentTest.info("Hause Heaven Admin giriş sayfasına gidildi.");


        //HauseHeaven Admin giriş sayfasında olduğunu doğrular.
        String expectedUrl="https://qa.hauseheaven.com/admin/login";
        String actualUrl= driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("Hause Heaven Admin giriş sayfasında olduğu test edildi.");

        //Admin Login sayfasında geçerli giriş bilgilerini girer ve Log in linkine tıklar
        AdminDashboard adminDashboard = new AdminDashboard();
        adminDashboard.usernameTextbox.sendKeys("mehmetyilmaz.admin@hauseheaven.com");
        adminDashboard.passwordAdminTextbox.sendKeys("Hven.150820");
        adminDashboard.signInButonu.click();
        extentTest.info("Admin Login sayfasında geçerli giriş bilgileri girildi ve Log in linkine tıklandı.");

        //Admin Dashboard sayfasında Kullanıcı adına tıklar.
        adminDashboard.sefadminHeaderUserNameButtonu.click();
        extentTest.info("Admin Dashboard sayfasında Kullanıcı adına tıklandı.");

        //Kullanıcı adının altında Log out linkinin dropdown olarak görünür olduğunu doğrular
        Assert.assertTrue(adminDashboard.sefadminHeaderLogoutButtonu.isDisplayed());
        extentTest.pass("Kullanıcı adının altında Log out linkinin dropdown olarak görünür olduğu test edildi.");

        //Admin Dashboard sayfasında Log out linkine tıklar.
        adminDashboard.sefadminHeaderLogoutButtonu.click();
        extentTest.info("Admin Dashboard sayfasında Log out linkine tıklandı.");

        //Admin Dashboard sayfasından çıkış yapıldığını test eder.
        Assert.assertTrue(adminDashboard.signInButonu.isDisplayed());
        extentTest.pass("Admin Dashboard sayfasından çıkış yapıldığı test edildi.");


        //Sayfayı kapatır
        Driver.quitDriver();
        extentTest.info("Sayfa kapatıldı.");

    }
}
