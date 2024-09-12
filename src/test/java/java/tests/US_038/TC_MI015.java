package java.tests.US_038;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TeamPages.MustafaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.MustafaMethods;
import utilities.TestBaseRapor;

public class TC_MI015 extends TestBaseRapor {

    @Test
    public void test15(){

        extentTest = extentReports.createTest("Facilities sayfasına gidiş yolu testi");

        MustafaMethods.adminPageLogin(ConfigReader.getProperty("MIadminUsername")
                ,ConfigReader.getProperty("MIadminPassword"));

        MustafaPage mustafaPage = new MustafaPage();

        Assert.assertTrue(mustafaPage.adRealEstateTitle.isDisplayed());
        extentTest.pass("Real Estate başlığı görüntülendi.");

        mustafaPage.adRealEstateTitle.click();
        extentTest.pass("Real Estate başlığı tıklandı.");

        Assert.assertTrue(mustafaPage.adRealEstateFacilities.isEnabled());
        extentTest.pass("Real Estate başlığı altında Facilities başlığı görüntülendi.");

        mustafaPage.adRealEstateFacilities.click();
        extentTest.pass("Facilities başlığı tıklandı.");

        String exceptedUrl = "https://qa.hauseheaven.com/admin/real-estate/facilities";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl,exceptedUrl);
        extentTest.pass("Url üzerinden doğru sayfada olduğu doğrulandı.");

        Driver.getDriver().quit();
        extentTest.pass("Driver kapatıldı.");
    }
}
