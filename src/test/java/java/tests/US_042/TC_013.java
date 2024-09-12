package java.tests.US_042;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_013 extends TestBaseRapor {
    @Test
    public void incelemeleriListelemeTesti(){
        extentTest=extentReports.createTest
                ("Adminin incelemeleri listelemesi testi");
        Driver.getDriver().get(ConfigReader.getProperty("hauseAdminUrl"));
        extentTest.pass("Hause Heaven Admin dashboarda gidildi.");

        AdminDashboard adminDashboard = new AdminDashboard();
        adminDashboard.usernameTextbox.sendKeys("dileksengul.admin@hauseheaven.com");
        extentTest.pass("Admin Email/Username textboxa belirlenmis emaili girer");
        adminDashboard.passwordAdminTextbox.sendKeys("Hven.150820");
        extentTest.pass("Admin Password textbox'a belirlenmis passwordu girer");
        adminDashboard.signInButonu.click();
        extentTest.pass("Admin Sign In Butonuna tiklar");

        adminDashboard.realEstateButonu.click();
        extentTest.pass("Admin realEstate butonuna tıkladı.");
        adminDashboard.reviewLinki.click();
        extentTest.pass("Admin rewiev linkine tıklar.");
        ReusableMethods.bekle(3);
        String expectedresualt="Reviews";
        String actualresualt= adminDashboard.reviewSayfasiReviewYazisi.getText();
        Assert.assertEquals(actualresualt,expectedresualt);
        extentTest.pass("Admin rewiev sayfasında olduğunu doğrular.");

        adminDashboard.reviewSayfasiIDButonu.click();
        extentTest.pass("Admin rewiev ID linkine tıklar.");

        adminDashboard.reviewSayfasiProductButonu.click();
        extentTest.pass("Admin product butonuna tıklar.");
        adminDashboard.reviewSayfasiUserYazisi.click();
        extentTest.pass("Admin user linkine tıklar.");
        adminDashboard.reviewSayfasiStarYazisi.click();
        extentTest.pass("Admin  star linkine tıklar.");
        adminDashboard.reviewSayfasiCommetnYazisi.click();
        extentTest.pass("Admin  comment linkine tıklar.");
        adminDashboard.reviewSayfasiCreatedAtYazisi.click();
        extentTest.pass("Admin created at linkine tıklar.");
        adminDashboard.reviewSayfasiOperationsYazisi.click();
        extentTest.pass("Admin operations linkine tıklar.");



        Driver.getDriver().quit();
        extentTest.pass("Ziyaretci browseri kapatir.");



    }
}
