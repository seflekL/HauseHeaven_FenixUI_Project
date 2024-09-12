package tests.US_006;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_R007 extends TestBaseRapor {
    @Test
    public void Test01() {

        extentTest = extentReports.createTest("Listingde 0 results yazisinin gorulmesi testi");

        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Tarayici acildi ve Hause Heaven sitesine gidildi.");

        HomePage homePage = new HomePage();
        homePage.HomePageListingLink.click();
        extentTest.pass("Headerdaki listing linkine tiklandi.");

        homePage.listingSayfasiSearchForALocationKutusu.sendKeys("Tekirdag");
        extentTest.pass("Listingde locationa Tekirdag kelimesi girildi.");

        ReusableMethods.hover(homePage.findNewHomeButonu);
        extentTest.info("Listing sayfasinda find new home butonuna dogru scroll yapildi.");

        homePage.findNewHomeButonu.click();
        extentTest.pass("Listing sayfasinda Find New Home butonuna click yapildi.");

        Driver.getDriver().navigate().refresh();
        ReusableMethods.bekle(3);
        extentTest.pass("Testin surdurulebilmesi icin sayfa refresh edildi.");

        String expectedResult="0 Results";
        String actualResult=homePage.listingde0ResultYazisi.getText();
        Assert.assertEquals(actualResult,expectedResult);
        extentTest.pass("Sonuclarin birbirleriyle esit oldugu goruldu");


        Driver.getDriver().quit();
        extentTest.pass("Ziyaretci browseri kapatir.");
    }
}
