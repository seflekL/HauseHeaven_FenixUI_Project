package tests.US_003;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;
import pages.HomePage;

public class TC_001 extends TestBaseRapor {


    @Test
    public void test01() {

        extentTest = extentReports.createTest("Anasayfaya testi");
        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.info("Anasayfaya gider");

        HomePage homePage=new HomePage();

        ReusableMethods.hover(homePage.buyukResim);
        extentTest.pass("Ziyaretçi resmi test eder.");

        Assert.assertTrue(homePage.buyukResim.isDisplayed());
        extentTest.pass("Anasayfada buyuk resmin varligini test eder");

        Driver.quitDriver();


    }
}