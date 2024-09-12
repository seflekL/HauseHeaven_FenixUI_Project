package java.tests.US_006;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_R003 extends TestBaseRapor {
    @Test
    public void Test01() throws InterruptedException {

        extentTest=extentReports.createTest
                ("Listing sayfasindaki mulklerin bilgilerinin dogrulanmasi testi");

        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Tarayici acildi ve Hause Heaven sitesine gidildi.");

        HomePage homePage = new HomePage();
        homePage.HomePageListingLink.click();
        extentTest.pass("Headerdaki listing linkine tiklandi.");

        ReusableMethods.hover(homePage.listingPageDigerSayfayaGecmeButonu);
        homePage.listingPageDigerSayfayaGecmeButonu.click();
        extentTest.pass("Diger sayfaya gecmek icin, sayfanin altina scroll yapildi ve diger sayfaya gecildi.");

        ReusableMethods.hover(homePage.listingUcuncuSayfaIlanYaziElementi);
        Assert.assertTrue(homePage.listingUcuncuSayfaIlanYaziElementi.isDisplayed());
        extentTest.pass("3. sayfada bir ilanda, ilanin yazi elementinin olup olmadigi kontrol edildi.");

        Assert.assertTrue(homePage.listingUcuncuSayfaFiyatElementi.isDisplayed());
        extentTest.pass("3. sayfada bir ilanda, ilanin fiyat elementinin olup olmadigi kontrol edildi.");

        Assert.assertTrue(homePage.listingUcuncuSayfaFotografElementi.isDisplayed());
        extentTest.pass("3. sayfada bir ilanda, ilanin fotograf elementinin olup olmadigi kontrol edildi.");

        Driver.getDriver().quit();
        extentTest.pass("Ziyaretci browseri kapatir.");


    }
}
