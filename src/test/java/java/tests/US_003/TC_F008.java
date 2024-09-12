package java.tests.US_003;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_F008 extends TestBaseRapor {

    @Test
    public void test08(){


        extentTest = extentReports.createTest("Recently Viewed Properties” basligi altında sayfada tiklanan mulklerin görüntulenmesi testi");
        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.info("Ziyaretci anasayfaya gider");

        HomePage homePage=new HomePage();
        SoftAssert softAssert = new SoftAssert();

        ReusableMethods.hover(homePage.RecentlyViewed);
        softAssert.assertTrue(homePage.RecentlyViewed.isDisplayed());
        extentTest.pass("Recently Viewed Properties'de onceden 'Explore Good Places'de goruntulenen mulk varsa eger mulklerin goruntuledigini test eder");


    }
}
