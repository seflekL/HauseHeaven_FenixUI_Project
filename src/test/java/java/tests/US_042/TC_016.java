package java.tests.US_042;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_016 extends TestBaseRapor {
    @Test
    public void projearamatesti() {
        extentTest = extentReports.createTest
                (" varolan projeyi arama testi");
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
        adminDashboard.dilekSearchKutusu.click();
        extentTest.pass("Admin search kutusu linkine tıklar.");
        adminDashboard.dilekSearchKutusu.sendKeys("great");
        extentTest.pass("Admin great araması yapar.");
        ReusableMethods.bekle(3);

        String expectedresualt="Show from";
        String actualresualt=adminDashboard.dilekShovFromYazisi.getText();
        Assert.assertEquals(actualresualt,expectedresualt);



        Driver.getDriver().quit();
        extentTest.pass("Ziyaretci browseri kapatir.");
    }
    }
