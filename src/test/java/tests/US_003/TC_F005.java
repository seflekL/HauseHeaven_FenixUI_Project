package tests.US_003;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_F005 extends TestBaseRapor {

    @Test
    public void test05(){


        extentTest = extentReports.createTest(" “Find By Locations” blogunda lokasyonlara gore mulklerin görünürlüğünün doğrulanması testi");
        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.info("Ziyaretci anasayfaya gider");

        HomePage homePage=new HomePage();

        ReusableMethods.hover(homePage.FindByLocations);
        Assert.assertTrue(homePage.FindByLocations.isDisplayed());
        extentTest.pass("Find By Locations bolumunun varligini varligini test eder");

        SoftAssert softAssert = new SoftAssert();

        int expectedFindByList = 8;
        int actualFindByList = homePage.FindByLocationsList.size();
        softAssert.assertEquals(actualFindByList, expectedFindByList);
        extentTest.pass("Find By Locations bolumunde ilanlarin listesini test eder.");

        int expectedFindByLocTitleList = 8;
        int actualFindByLocTitleList = homePage.FindByLocTitleList.size();
        softAssert.assertEquals(actualFindByLocTitleList, expectedFindByLocTitleList);
        extentTest.pass("Find By Locations bolumunde ilanlardaki lokasyonlarinin gorunurlugunu test eder.");

        int expectedProperties = 6;
        int actualProperties = homePage.LosAngelesPropertiesList.size();
        Assert.assertEquals(actualFindByList, expectedFindByList);
        extentTest.pass("Find By Locations bolumunde Los Angeles ilanindaki ozelliklerinin dogrulanmasini test eder.");

        ReusableMethods.hover(homePage.BrowseByLocations);
        homePage.BrowseByLocations.click();
        ReusableMethods.bekle(1);
        extentTest.info("Diger mulkleri arar.");

        ReusableMethods.hover(homePage.PropertiesSayfasi);
        Assert.assertTrue(homePage.PropertiesSayfasi.isDisplayed());
        extentTest.pass("View butonunun aciklama sayfasina gittigini goruntuler.");

        Driver.getDriver();

    }
}
