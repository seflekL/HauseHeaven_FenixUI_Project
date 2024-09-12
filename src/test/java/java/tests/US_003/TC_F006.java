package java.tests.US_003;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_F006 extends TestBaseRapor {

    @Test
    public void test06(){


        extentTest = extentReports.createTest(" “Good Reviews By Customers bolumunun varliginin dogrulanmasi testi");
        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.info("Ziyaretci anasayfaya gider");

        HomePage homePage=new HomePage();

        ReusableMethods.hover(homePage.GoodReviews);
        Assert.assertTrue(homePage.GoodReviews.isDisplayed());
        extentTest.pass("Good Reviews By Customers bolumunun varligini test eder");

        Driver.quitDriver();





    }
}
