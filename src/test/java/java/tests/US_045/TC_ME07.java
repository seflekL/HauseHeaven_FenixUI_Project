package java.tests.US_045;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_ME07 extends TestBaseRapor {
    @Test
    public void test07(){
        HomePage homePage=new HomePage();
        AdminDashboard adminDashboard=new AdminDashboard();
        extentTest=extentReports.createTest("Gelen consults' un edit butonuna tıklayarak gerekli düzenlemelerden sonra save&edit butonuna tıklayarak değişikliklerin kaydedildiğinin doğrulanması testi. ");

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

        extentTest.pass("Admin consults sayfasında düzenlemek istediği yorumun edit butonona tıklar. ");
        homePage.dasboardeditbutonu.click();
        extentTest.pass("Admine bu sayfada sadece yorumun okunup okunmadığı konusunda değişiklik yapılmasına izin veriliyor. ");

        extentTest.pass("admin yorumu düzenlemek için details kısmına tıklar. ") ;
        homePage.daosboarddetailsbutonu.click();

        String expectedresult="edit successfully";
        String actualresult= adminDashboard.adminconsults.getText();

        ReusableMethods.getFullScreenshot(Driver.getDriver());
        Assert.assertEquals(actualresult,expectedresult);






               extentTest.pass(" Admin açtığı sayfayı kapatır.") ;

        Driver.getDriver().quit();



    }
}
