package java.tests.US_48;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC_R028 extends TestBaseRapor {
    @Test
    public void Test01(){
        extentTest=extentReports.createTest
                ("Admin dashboardunda mesajlarin listelenmesi testi ");
        Driver.getDriver().get(ConfigReader.getProperty("hauseAdminUrl"));
        extentTest.pass("Hause Heaven Admin dashboarda gidildi.");

        AdminDashboard adminDashboard = new AdminDashboard();
        adminDashboard.usernameTextbox.sendKeys("rananurulker.admin@hauseheaven.com");
        extentTest.pass("Admin Email/Username textboxa belirlenmis emaili girer");
        adminDashboard.passwordAdminTextbox.sendKeys("Hven.150820");
        extentTest.pass("Admin Password textbox'a belirlenmis passwordu girer");
        adminDashboard.signInButonu.click();
        extentTest.pass("Admin Sign In Butonuna tiklar");

        adminDashboard.adminContactLink.click();
        extentTest.pass("Admin Contact linkine tiklar");

        Assert.assertTrue(adminDashboard.adminContactYazisiDogrulama.isDisplayed());
        extentTest.pass("Admin Contact yazisinin gorunur oldugunu dogrulayarak, mesajlarin listelendigi sayfada oldugunu gorur");

        Driver.getDriver().quit();
        extentTest.pass("Ziyaretci browseri kapatir.");

    }
}
