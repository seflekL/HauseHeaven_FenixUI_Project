package tests.US_042;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_014 extends TestBaseRapor {
    @Test
    public void yeniincelemeEklemeTesti(){

            extentTest=extentReports.createTest
                    (" varolan projeyi silme testi");
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

            String expectedresualt="Create new review";
            String actualresualt= adminDashboard.reviewSayfasiOperationsYazisi.getText();
             Assert.assertEquals(actualresualt,expectedresualt);
            extentTest.pass("Admin rewiev eklemek ister ama ekleyemez");
            ReusableMethods.getFullScreenshot(Driver.getDriver());



        Driver.getDriver().quit();
        extentTest.pass("Ziyaretci browseri kapatir.");

    }
}
