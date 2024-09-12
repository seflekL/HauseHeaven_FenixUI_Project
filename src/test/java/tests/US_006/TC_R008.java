package tests.US_006;

import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_R008 extends TestBaseRapor {
    @Test
    public void Test01() {

        extentTest = extentReports.createTest
                ("Listing sayfasinda en alttaki yonlendirme butonlarinin tiklanilmasi testi");

        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Tarayici acildi ve Hause Heaven sitesine gidildi.");

        HomePage homePage = new HomePage();
        homePage.HomePageListingLink.click();
        extentTest.pass("Headerdaki listing linkine tiklandi.");

        ReusableMethods.hover(homePage.listingPageDigerSayfayaGecmeButonu);
        homePage.sayfaDegistirmeButonu2.click();

        ReusableMethods.hover(homePage.listingPageDigerSayfayaGecmeButonu);
        homePage.sayfaDegistirmeButonu3.click();

        ReusableMethods.hover(homePage.listingPageDigerSayfayaGecmeButonu);
        homePage.sayfaDegistirmeButonuSagaOk.click();

        ReusableMethods.hover(homePage.listingPageDigerSayfayaGecmeButonu);
        homePage.sayfaDegistirmeButonu4.click();



        ReusableMethods.hover(homePage.listingPageDigerSayfayaGecmeButonu);
        homePage.sayfaDegistirmeButonuSolaOk.click();






        Driver.getDriver().quit();
        extentTest.pass("Ziyaretci browseri kapatir.");
    }
}
