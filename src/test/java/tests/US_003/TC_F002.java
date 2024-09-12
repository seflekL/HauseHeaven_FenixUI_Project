package tests.US_003;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_F002 extends TestBaseRapor {

    @Test
    public void test02(){

        extentTest = extentReports.createTest("Anasayfada Find Accessible Homes to Rent formu testi");
        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.info("Anasayfaya gider");
        HomePage homePage=new HomePage();


        // Anasayfada arama yapmak istedigi forma gelir
        ReusableMethods.hover(homePage.FindAccessibleHomesToRentFormu);
        extentTest.pass("Ziyaretçi anasayfada Search formuna gelir.");


        //Ziyaretçi Search formuna  Min Price, Max Price, Property Type, Bed Rooms degerlerini girer.
        homePage.formMinPrice.sendKeys("500");
        homePage.formMaxPrice.sendKeys("1000");
        homePage.formPropertyType.sendKeys("Apartment");
        homePage.formBedRooms.sendKeys("2");
        homePage.formSearchForALocation.sendKeys("new jersey");
        homePage.formPropertyLocation.sendKeys("Allen");
        extentTest.pass("Ziyaretçi Search formuna  Min Price, Max Price, Property Type, Bed Rooms degerlerini girer.");

        //Arama Sonucunu gormek icin Search Result butonuna basarak arama yapar
        homePage.formSearchResult.click();
        extentTest.info("Arama Sonucunu gormek icin Search Result butonuna basarak arama yapar");


        String ExceptedSonuc = "Found 1 - 15 Of 54 Results";
        String ActualSonuc = homePage.ActualSonuc.getText();

        Assert.assertEquals(ActualSonuc,ExceptedSonuc);


        ReusableMethods.wait(2);
        ReusableMethods.getFullScreenshot(Driver.getDriver());

    }
}
