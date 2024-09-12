package java.tests.US_006;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC_R002 extends TestBaseRapor {
    @Test
    public void Test01() {

        extentTest=extentReports.createTest("Listing sayfasinda mulklerin listelenmesi testi");

        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Tarayici acildi ve Hause Heaven sitesine gidildi.");

        HomePage homePage = new HomePage();
        homePage.HomePageListingLink.click();
        extentTest.pass("Headerdaki listing linkine tiklandi.");


        String expectedYazisiDegil="0 Results";
        String actualYazi=homePage.listingResultsYazisi.getText();
        Assert.assertNotEquals(actualYazi,expectedYazisiDegil);
        extentTest.pass("Properties yazisinin oldugu goruldu.");

        Driver.getDriver().quit();
        extentTest.pass("Ziyaretci browseri kapatir.");



    }
}