package java.tests.US_006;

import org.testng.Assert;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import org.testng.annotations.Test;
import utilities.TestBaseRapor;

public class TC_R001 extends TestBaseRapor {
    @Test
    public void Test01(){
        extentTest=extentReports.createTest
                ("Home page Listing linkininin calistigina dair test");

        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Tarayici acildi ve Hause Heaven sitesine gidildi.");

        HomePage homePage=new HomePage();
        homePage.HomePageListingLink.click();
        extentTest.pass("Headerdaki listing linkine tiklandi.");


        String expectedYazi="Properties";
        String actualYazi=homePage.listingPropertiesYazisi.getText();
        Assert.assertEquals(actualYazi,expectedYazi);
        extentTest.pass("Mulk sayisinin listelendigi goruldu.");

        Driver.getDriver().quit();
        extentTest.pass("Ziyaretci browseri kapatir.");


    }
}
