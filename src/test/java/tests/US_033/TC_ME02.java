package tests.US_033;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_ME02 extends TestBaseRapor {

    @Test
    public  void test2(){
        HomePage homePage=new HomePage();
        extentTest=extentReports.createTest(" Testimonials sayfasında yorum silebilme testi");

        extentTest.pass("Admin email ve password girerek admin sayfasına giriş yapabildiğini doğrular .");
        Driver.getDriver().get(ConfigReader.getProperty("hauseAdminUrl"));
        homePage.adminloginemailkutusu.click();
        homePage.adminloginemailkutusu.sendKeys("mervenurembel.admin@hauseheaven.com");
        homePage.adminloginpasswordkutusu.click();
        homePage.adminloginpasswordkutusu.sendKeys("Hven.150820");
        homePage.adminloginsigninbutonu.click();

        Assert.assertTrue(homePage.admintestimonialselementi.isDisplayed());


        extentTest.pass(" Admin Testimonial sayfasına ulaşır.");

        homePage.admintestimonialselementi.click();
        ReusableMethods.bekle(2);
        homePage.admintestimonialselementi.click();
        ReusableMethods.bekle(2);

       extentTest.pass("Admin yorumu silmek için delete butonuna tıkladığında confirm delete penceresinin açıldıgını görür ve delete butonuna basar ve delete penceresinin açıldıgını görür ve delete butonuna basar ve deleted successfully penceresni görür.");

        homePage.admintestimonialsdeletebutonu.click();
        homePage.admintestimonialsconfirmdeletebutonu.click();
        homePage.adminconfirmpenceresideletebutonu.click();

        Assert.assertTrue(homePage.admindeletesuccess.isDisplayed());
        extentTest.pass(" Admin açılan sekmeyi kapatır.");
        Driver.getDriver().quit();

    }
}
