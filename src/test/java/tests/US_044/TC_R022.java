package tests.US_044;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_R022 extends TestBaseRapor {
    @Test
    public void Test01(){
        extentTest=extentReports.createTest
                ("Admin dashboardda newsletterlar arasinda arama yapilabilmesi testi");
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

        adminDashboard.adminSearch.sendKeys("rana");
        extentTest.pass("Admin Search kutusuna rana yazar.");
        ReusableMethods.bekle(3);

        Assert.assertTrue(adminDashboard.showFromYazisi.isDisplayed());
        extentTest.pass("Admin arama sonuclarinin goruldugunu dogrular.");

        Driver.getDriver().quit();
        extentTest.pass("Kullanici browseri kapatir.");

    }
}
