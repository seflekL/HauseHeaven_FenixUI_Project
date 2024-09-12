package tests.US_006;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_R005 extends TestBaseRapor {
    @Test
    public void Test01(){

        extentTest=extentReports.createTest
                ("Listing sayfasindaki ilanlardan herhangi birinin tiklanabiliyor olmasi testi");

        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Tarayici acildi ve Hause Heaven sitesine gidildi.");

        HomePage homePage = new HomePage();
        homePage.HomePageListingLink.click();
        extentTest.pass("Headerdaki listing linkine tiklandi.");

        ReusableMethods.hover(homePage.listingSayfasiBakuMulku);
        extentTest.info("Baku mulkune dogru scroll yapildi.");

        homePage.listingSayfasiBakuMulku.click();
        extentTest.pass("Listingdeki listelenen bir ilana tiklanildi");

        String expectedBakuMulku="Baku";
        String actualBakuMulku=homePage.listingSayfasiBakuMulku.getText();

        Assert.assertEquals(actualBakuMulku,expectedBakuMulku);
        extentTest.pass("Baku mulkunun yazisinin olup olmadigi dogrulanir.");


        Driver.getDriver().navigate().back();
        extentTest.pass("Listingdeki listelenen bir ilandan ana sayfaya geri donuldu");


        Driver.getDriver().quit();
        extentTest.pass("Ziyaretci browseri kapatir.");
    }
}
