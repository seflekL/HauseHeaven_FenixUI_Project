package tests.US_036;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_008 extends TestBaseRapor {
    @Test
    public void admingirisTesti(){
        extentTest=extentReports.createTest
                ("Admin giriş testi");
        Driver.getDriver().get(ConfigReader.getProperty("hauseAdminUrl"));
        extentTest.pass("Hause Heaven Admin dashboarda gidildi.");

        AdminDashboard adminDashboard = new AdminDashboard();

        adminDashboard.usernameTextbox.sendKeys("dileksengul.admin@hauseheaven.com");
        adminDashboard.passwordAdminTextbox.sendKeys("Hven.150820");
        extentTest.pass("Admin Password textbox'a belirlenmis passwordu girer");
        adminDashboard.signInButonu.click();
        extentTest.pass("Admin Sign In Butonuna tiklar");
        extentTest.pass("Başarılı şekilde siteye girer.");
        adminDashboard.sefadminsideDashBlogButtonElementi.click();
        Driver.getDriver().quit();
        extentTest.pass("Tarayıcı kapatıldı");
    }
}
