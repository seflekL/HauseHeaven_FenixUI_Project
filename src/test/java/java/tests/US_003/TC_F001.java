package java.tests.US_003;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import static utilities.TestBaseRapor.extentReports;

public class TC_F001 extends TestBaseRapor {


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