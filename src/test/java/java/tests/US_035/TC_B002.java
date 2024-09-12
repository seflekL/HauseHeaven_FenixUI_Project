package java.tests.US_035;

import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.BunyaminMethods;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.time.Duration;

public class TC_B002 extends TestBaseRapor {

    @Test
    public void Test15(){

        extentTest = extentReports.createTest("Admin sayfasina gidip, giriş yapıp, menuden Real Estate başlığına tıklayıp açılan listeye erişip Properties başlığının görüntülenme testi.");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        AdminDashboard adminDashboard=new AdminDashboard();

        BunyaminMethods.adminGiris();
        extentTest.pass("HauseHeaven admin sayfasina giris yapildi.");

        adminDashboard.realEstateButonu.click();
        adminDashboard.propertiesButonu.isDisplayed();
        extentTest.pass("Real Estate basligina tiklanip Properties basligi goruntulendi.");

        Driver.quitDriver();
        extentTest.pass("Driver kapatildi.");

    }

}
