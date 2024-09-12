package tests.US_037;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TeamPages.MustafaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.MustafaMethods;
import utilities.TestBaseRapor;

public class TC_MI011 extends TestBaseRapor {

    @Test
    public void test11(){

        extentTest = extentReports.createTest("Features sayfasına gidiş yolu testi");

        MustafaMethods.adminPageLogin(ConfigReader.getProperty("MIadminUsername")
                ,ConfigReader.getProperty("MIadminPassword"));

        MustafaPage mustafaPage = new MustafaPage();

        Assert.assertTrue(mustafaPage.adRealEstateTitle.isDisplayed());
        extentTest.pass("Real Estate başlığı görüntülendi.");

        mustafaPage.adRealEstateTitle.click();
        extentTest.pass("Real Estate başlığı tıklandı.");

        Assert.assertTrue(mustafaPage.adRealEstateFeatures.isEnabled());
        extentTest.pass("Real Estate başlığı altında Features başlığı görüntülendi.");

        mustafaPage.adRealEstateFeatures.click();
        extentTest.pass("Features başlığı tıklandı.");

        String exceptedUrl = "https://qa.hauseheaven.com/admin/real-estate/property-features";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl,exceptedUrl);
        extentTest.pass("Url üzerinden doğru sayfada olduğu doğrulandı.");

        Driver.getDriver().quit();
        extentTest.pass("Driver kapatıldı.");
    }

}
