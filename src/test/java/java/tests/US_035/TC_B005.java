package java.tests.US_035;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import pages.TeamPages.BunyaminPage;
import utilities.BunyaminMethods;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.time.Duration;

public class TC_B005 extends TestBaseRapor {

    @Test
    public void Test18(){

        extentTest = extentReports.createTest("Admin sayfasina gidip, giriş yapıp, menuden Real Estate başlığı altındaki Properties başlığına tıklayıp eklenilen ilanın Edit butonu ile düzenlenebilmesi ve Delete butonu ile silinebilmesi testi.");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        AdminDashboard adminDashboard=new AdminDashboard();
        BunyaminPage bunyaminPage = new BunyaminPage();

        BunyaminMethods.adminGiris();
        extentTest.pass("HauseHeaven admin sayfasina giris yapildi.");

        adminDashboard.realEstateButonu.click();
        adminDashboard.propertiesButonu.click();
        extentTest.pass("Properties sayfasina erişildi.");

        Faker faker = new Faker();

        bunyaminPage.propertiesCreate.click();
        extentTest.pass("ilan ekleme sayfasina girildi.");

        bunyaminPage.propertiesCreateTitle.sendKeys("ilan basligi");
        bunyaminPage.propertiesCreateContent.sendKeys("ilan icerigi");
        bunyaminPage.propertiesCreatePropertyLocation.sendKeys(faker.address().fullAddress());
        bunyaminPage.propertiesCreateType.click();
        bunyaminPage.propertiesCreateTypeForSale.click();
        extentTest.pass("Zorunlu alanlar dolduruldu.");

        bunyaminPage.propertiesCreateSaveExit.click();
        extentTest.pass("ilan kaydedilip properties sayfasina gelindi.");

        bunyaminPage.sonEklenenPropertiesIlanEdit.click();
        extentTest.pass("Ilanin edit sayfasina erisim sagladi.");
        bunyaminPage.propertiesCreateSaveExit.click();
        extentTest.pass("Editledigi ilani kaydedip tekrar properties sayfasina gelindi.");

        bunyaminPage.sonEklenenPropertiesIlanDelete.click();
        bunyaminPage.confirmDeleteDelete.click();
        extentTest.pass("Ekledigi ilani basarili bir sekilde sildi.");

        Driver.quitDriver();
        extentTest.pass("Driver kapatildi.");

    }

}
