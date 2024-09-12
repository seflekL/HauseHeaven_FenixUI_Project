package tests.US_045;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC_ME03 extends TestBaseRapor {
    @Test
    public void test03(){
        HomePage homePage=new HomePage();
        extentTest=extentReports.createTest("email ve password ie admin sayfasına giriş yapabildiği testi ");

       extentTest.pass("Ziyaretçi hauseheaven.com/admin url girer ") ;
        Driver.getDriver().get(ConfigReader.getProperty("hauseAdminUrl"));

       extentTest.pass(" Login formunda kendi email ve password unu girer ve sing in butonuna tıklar") ;
        homePage.adminloginemailkutusu.click();
        homePage.adminloginemailkutusu.sendKeys("mervenurembel.admin@hauseheaven.com");
        homePage.adminloginpasswordkutusu.click();
        homePage.adminloginpasswordkutusu.sendKeys("Hven.150820");
        homePage.adminloginsigninbutonu.click();

        extentTest.pass("Ziyaretçi admin olarak sayfasına giriş yapabildiğini doğrular. ") ;

        Assert.assertTrue(homePage.admintestimonialselementi.isDisplayed());
              extentTest.pass(" Ziyaretçi açılan sekmeyi kapatır.") ;


              Driver.getDriver().quit();
    }
}
