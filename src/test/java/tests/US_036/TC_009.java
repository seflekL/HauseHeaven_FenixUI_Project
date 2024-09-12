package tests.US_036;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_009 extends TestBaseRapor {
    @Test
    public void yeniProjeEklemeTesti(){

        extentTest=extentReports.createTest
                ("Adminin yeni proje ekleme testi");
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
        ReusableMethods.bekle(3);

        adminDashboard.projectCreateButonu.click();
        extentTest.pass(" Proje eklemek için create butonuna basar.");
        ReusableMethods.bekle(3);

        adminDashboard.projectFOrmuNameKutusu.sendKeys("Dilek'in evi");
        adminDashboard.projectFormuContentKutusu.sendKeys("3+1 ev");
        adminDashboard.projectFOrmulocationKutusu.sendKeys("İzmir");
        extentTest.pass("Admin proje bilgilerini girer");

        adminDashboard.projectFormuSaveExitButonu.click();
        ReusableMethods.bekle(3);


        Assert.assertTrue(adminDashboard.projectFormUpdatesSuccessfullyYazisi.isDisplayed());
        ReusableMethods.bekle(2);
        extentTest.pass("Başarılı successfully mesajini gorur.");


        Driver.getDriver().quit();
        extentTest.pass("Tarayıcı kapatıldı");
    }
}
