package java.tests.US_033;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_ME01 extends TestBaseRapor {

    @Test
     public  void test01(){

        HomePage homePage=new HomePage();

        extentTest=extentReports.createTest("testimonialssayfasınaulastığıtesti");

         extentTest.pass("Admin email ve password girerek admin sayfasına giriş yapabildiğini doğrular .");
        Driver.getDriver().get(ConfigReader.getProperty("hauseAdminUrl"));
        homePage.adminloginemailkutusu.click();
        homePage.adminloginemailkutusu.sendKeys("mervenurembel.admin@hauseheaven.com");
        homePage.adminloginpasswordkutusu.click();
        homePage.adminloginpasswordkutusu.sendKeys("Hven.150820");
        homePage.adminloginsigninbutonu.click();

        Assert.assertTrue(homePage.admintestimonialselementi.isDisplayed());

       extentTest.pass(" Admin Testimonial linkine tıklar. ");
        homePage.admintestimonialselementi.click();
       ReusableMethods.bekle(2);
        extentTest.pass(" Admin Testimonial sayfasına ulaşır.");
        Assert.assertTrue(homePage.admintestimonialscreatebutonu.isDisplayed());
        homePage.admintestimonialselementi.click();
        ReusableMethods.bekle(2);
       extentTest.pass(" Admin açılan sekmeyi kapatır.") ;

        Driver.getDriver().quit();

    }
}
