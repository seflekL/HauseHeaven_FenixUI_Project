package tests.US_036;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_010 extends TestBaseRapor {
    @Test
    public void varolanProjedeDegisiklikTesti(){
        extentTest=extentReports.createTest
                ("Adminin varolan projede değişiklik yapması testi");
        Driver.getDriver().get(ConfigReader.getProperty("hauseAdminUrl"));
        extentTest.pass("Hause Heaven Admin dashboarda gidildi.");

        AdminDashboard adminDashboard = new AdminDashboard();

        adminDashboard.usernameTextbox.sendKeys("dileksengul.admin@hauseheaven.com");
        adminDashboard.passwordAdminTextbox.sendKeys("Hven.150820");
        extentTest.pass("Admin Password textbox'a belirlenmis passwordu girer");
        adminDashboard.signInButonu.click();
        extentTest.pass("Admin Sign In Butonuna tiklar");

        adminDashboard.adminRealEstateButonu.click();
        extentTest.pass("Admin Realestete Butonuna tiklar");

        Assert.assertTrue(adminDashboard.adminRealEstateButonu.isDisplayed());
        extentTest.pass("Admin realestete butonunun oldugunu dogrular.");

        adminDashboard.adminProjectsLink.click();
        extentTest.pass("Admin project butonuna tiklar.");



        Driver.getDriver().quit();
        extentTest.pass("Admin browseri kapatir.");




    }
}
