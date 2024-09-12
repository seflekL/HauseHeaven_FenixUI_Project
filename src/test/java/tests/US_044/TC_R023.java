package tests.US_044;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_R023 extends TestBaseRapor { @Test
public void Test01(){
    extentTest=extentReports.createTest
            ("Admin dashboardda newsletterlar icinde delete butonunun calismasi testi");
    Driver.getDriver().get(ConfigReader.getProperty("hauseAdminUrl"));
    extentTest.pass("Hause Heaven Admin dashboarda gidildi.");

    AdminDashboard adminDashboard = new AdminDashboard();

    adminDashboard.usernameTextbox.sendKeys("rananurulker.admin@hauseheaven.com");
    extentTest.pass("Admin Email/Username textboxa belirlenmis emaili girer");
    adminDashboard.passwordAdminTextbox.sendKeys("Hven.150820");
    extentTest.pass("Admin Password textbox'a belirlenmis passwordu girer");
    adminDashboard.signInButonu.click();
    extentTest.pass("Admin Sign In Butonuna tiklar");

    adminDashboard.adminNewsletter.click();
    extentTest.pass("Admin Newsletter Butonuna tiklar");

    Assert.assertTrue(adminDashboard.adminDashboardNewsletterDeleteButonu.isDisplayed());
    extentTest.pass("Admin Newsletter sayfasinda delete butonunun oldugunu dogrular.");

    adminDashboard.adminDashboardNewsletterDeleteButonu.click();
    extentTest.pass("Admin Newsletterlardan birini silmek icin delete butonuna tiklar.");
    ReusableMethods.bekle(3);

    adminDashboard.newsletterDeleteConfirmButonu.click();
    extentTest.pass("Admin Newsletterlardan birini silmek icin delete butonuna tikladiktan sonra cikan confirmasyon sayfasinda delete butonuna tiklar.");
    ReusableMethods.bekle(3);

    Assert.assertTrue(adminDashboard.deleteSuccesfullyMessage.isDisplayed());
    ReusableMethods.bekle(2);
    extentTest.pass("Admin Deleted successfully mesajini gorur.");

    adminDashboard.sefadminHeaderUserNameButtonu.click();
    extentTest.pass("Admin username butonuna tiklar");

    adminDashboard.sefadminHeaderLogoutButtonu.click();
    extentTest.pass("Admin Logout butonuna tiklar ve logout olur");

    Driver.getDriver().quit();
    extentTest.pass("Kullanici browseri kapatir.");
}
}
