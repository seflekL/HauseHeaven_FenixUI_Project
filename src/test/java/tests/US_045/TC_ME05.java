package tests.US_045;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC_ME05 extends TestBaseRapor {

    @Test
    public void test05(){
        HomePage homePage=new HomePage();
        extentTest=extentReports.createTest(" Dashboard /Consults sayfasından consults listesinin görünür olduğunun doğruluğu testi.");

        extentTest.pass("Ziyaretçi hauseheaven.com/admin url girer ") ;
        Driver.getDriver().get(ConfigReader.getProperty("hauseAdminUrl"));

        extentTest.pass(" Login formunda kendi email ve password unu girer ve sing in butonuna tıklar") ;
        homePage.adminloginemailkutusu.click();
        homePage.adminloginemailkutusu.sendKeys("mervenurembel.admin@hauseheaven.com");
        homePage.adminloginpasswordkutusu.click();
        homePage.adminloginpasswordkutusu.sendKeys("Hven.150820");
        homePage.adminloginsigninbutonu.click();

        extentTest.pass(" Admin sayfasından dasboard linkini tıklar.") ;

        homePage.admindaosboardlinki.click();

              extentTest.pass("  Admin dashboard sayfasında olduğunu doğrular ve consults linkine tıklar");
        Assert.assertTrue(homePage.admindaosboardconsultbutonu.isDisplayed());
        homePage.admindaosboardconsultbutonu.click();

       extentTest.pass(" Admin consults listenin göröründüğünü doğrular") ;
        Assert.assertTrue(homePage.daosboardconsultdeletebutonu.isDisplayed());

       extentTest.pass("Admin sayfasını kapatır. ") ;
       Driver.getDriver().quit();

    }
}
