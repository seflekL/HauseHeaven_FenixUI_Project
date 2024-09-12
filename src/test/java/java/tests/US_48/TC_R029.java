package java.tests.US_48;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_R029 extends TestBaseRapor {
    @Test
    public void Test01(){
        extentTest=extentReports.createTest
                ("Admin dashboardunda mesaj arama kutusuna gecersiz bilgi girildiginde No data displayed yazisinin gorulmesi testi ");
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

        adminDashboard.adminContactSeacrhKutusu.sendKeys("Namumkun");
        extentTest.pass("Admin siralanan mesajlar icinde arama yapmak icin Namumkun yazar");

        String expectedResult="No record";
        String actualResult=adminDashboard.adminContactNoRecordYazisi.getText();

        Assert.assertEquals(actualResult,expectedResult);
        extentTest.pass("Admin siralanan mesajlar icinde olmaya bir arama yaptiginda No record yazisinin oldugunu gorur.");
        ReusableMethods.bekle(3);

        Driver.getDriver().quit();
        extentTest.pass("Ziyaretci browseri kapatir.");

    }
}
