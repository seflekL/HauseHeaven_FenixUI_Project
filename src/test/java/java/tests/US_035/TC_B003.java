package java.tests.US_035;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import pages.TeamPages.BunyaminPage;
import utilities.BunyaminMethods;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.time.Duration;

public class TC_B003 extends TestBaseRapor {

    @Test
    public void Test16(){

        extentTest = extentReports.createTest("Admin sayfasina gidip, giriş yapıp, menuden Real Estate başlığı altındaki Properties başlığına tıklayıp ilanların görüntülenme testi.");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        AdminDashboard adminDashboard=new AdminDashboard();
        BunyaminPage bunyaminPage = new BunyaminPage();

        BunyaminMethods.adminGiris();
        extentTest.pass("HauseHeaven admin sayfasina giris yapildi.");

        adminDashboard.realEstateButonu.click();
        adminDashboard.propertiesButonu.click();

        String unExpectedSonucYazisi = "0";
        String actualSonucYazisi = bunyaminPage.propertiesSayisi
                .getText();
        Assert.assertNotEquals(actualSonucYazisi,unExpectedSonucYazisi);
        extentTest.pass("Properties'de urunler goruntulendi.");

        Driver.quitDriver();
        extentTest.pass("Driver kapatildi.");

    }

}
