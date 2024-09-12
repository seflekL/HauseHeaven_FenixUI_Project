package tests.US_045;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_ME06 extends TestBaseRapor {

    @Test
    public void test06(){
        HomePage homePage=new HomePage();
        extentTest=extentReports.createTest("Gelen consults'un delete butonuna tıklayarak confirm delete penceresındensilinebildiğinin doğrulandığı testi. ");

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

        extentTest.pass("Admin consults sayfasındaki silmek istediği maillerden birtanesinin delete butonuna tıklar ");
        homePage.daosboardconsultdeletebutonu.click();
        ReusableMethods.bekle(2);

       extentTest.pass("  Admin confirm delete penceresini görür ve tekrar delete buronuna tıklar");
        Assert.assertTrue(homePage.doasboardconfirmpenceresi.isDisplayed());
        homePage.doasboardconfirmdeletebutonu.click();

       extentTest.pass("Admin deleted successfully penceresini gördüğünde mailin silindiğini doğrular ");
        Assert.assertTrue(homePage.daosboarddeletedsuccessfullybutonu.isDisplayed());
       extentTest.pass("  Admin açtığı sayfayı kapatır.") ;
       Driver.getDriver().quit();

    }
}
