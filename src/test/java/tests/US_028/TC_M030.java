package tests.US_028;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.time.Duration;

import static utilities.Driver.driver;

public class TC_M030 extends TestBaseRapor {

    @Test
    public void Test30() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        extentTest = extentReports.createTest("Admin Dashboard sayfasına girildiğinde Header'daki " +
                "Notifikasyonlar, Mesajlar, Consultlar linklerinin görünür ve aktif olduğunun " +
                "ve tıklanınca dropdown olarak açıldığının testi");

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

        wait.until(ExpectedConditions.visibilityOf(adminDashboard.sefadminHeaderUserNameButtonu));
        //Açılan sayfanın Admin Dashboard sayfasında olduğunu test eder.
        Assert.assertTrue(adminDashboard.sefadminHeaderUserNameButtonu.isDisplayed());
        extentTest.pass("Açılan sayfanın Admin Dashboard sayfası olduğu test edildi.");

        wait.until(ExpectedConditions.visibilityOf(adminDashboard.adminHeaderNotificationsLinki));
        //Header'daki Notifikasyonlar linkinin görünür olduğunu test eder
        Assert.assertTrue(adminDashboard.adminHeaderNotificationsLinki.isDisplayed());
        extentTest.pass("Header bölümündeki Notifications linkinin görünür olduğu test edildi");

        //Notifications linkinin görünür olduğunu ve tıklandığında dropdown olarak açıldığını test eder
        adminDashboard.adminHeaderNotificationsLinki.click();
        Assert.assertTrue(adminDashboard.adminDashboardNotificationsLinki.isDisplayed());
        extentTest.pass("Notifikasyonlar linkinin görünür olduğu ve tıklandığında dropdown olarak açıldığı test edildi.");

        //Notifications Tab'ını kapatır
        adminDashboard.adminDashboardNotificationsCloseButtonLinki.click();
        extentTest.info("Admin Dashboard Notifications Tab'ı kapatıldı.");

        wait.until(ExpectedConditions.visibilityOf(adminDashboard.adminDashboardNewMessagesLinki));
        //Header'daki New Messages linkinin görünür olduğunu test eder
        Assert.assertTrue(adminDashboard.adminDashboardNewMessagesLinki.isDisplayed());
        extentTest.pass("Header bölümündeki New Messages linkinin görünür olduğu test edildi");

        //New Messages linkinin tıklandığında dropdown olarak açıldığını test eder
        adminDashboard.adminDashboardNewMessagesLinki.click();
        Assert.assertTrue(adminDashboard.adminDashboardNewMessagesDropdownLinki.isDisplayed());
        extentTest.pass("New Messages linkinin tıklandığında dropdown olarak açıldığı test edildi.");

        wait.until(ExpectedConditions.visibilityOf(adminDashboard.adminDashboardNewConsultsLinki));
        //Header'daki New Consults linkinin görünür olduğunu test eder
        Assert.assertTrue(adminDashboard.adminDashboardNewConsultsLinki.isDisplayed());
        extentTest.pass("Header bölümündeki New Consults linkinin görünür olduğu test edildi");

        //New Consults linkinin tıklandığında dropdown olarak açıldığını test eder
        adminDashboard.adminDashboardNewConsultsLinki.click();
        Assert.assertTrue(adminDashboard.adminDashboardNewConsultsDropdownLinki.isDisplayed());
        extentTest.pass("New Consults linkinin tıklandığında dropdown olarak açıldığı test edildi.");

        wait.until(ExpectedConditions.visibilityOf(adminDashboard.sefadminHeaderUserNameButtonu));
        //Admin Dashboard sayfasında Kullanıcı adına tıklar.
        adminDashboard.sefadminHeaderUserNameButtonu.click();
        extentTest.info("Admin Dashboard sayfasında Kullanıcı adına tıklandı.");

        wait.until(ExpectedConditions.visibilityOf(adminDashboard.sefadminHeaderLogoutButtonu));
        //Admin Dashboard sayfasında Log out linkine tıklar.
        adminDashboard.sefadminHeaderLogoutButtonu.click();
        extentTest.info("Admin Dashboard sayfasında Log out linkine tıklandı.");

        //Sayfayı kapatır
        Driver.quitDriver();
        extentTest.info("Sayfa kapatıldı.");

    }
}
