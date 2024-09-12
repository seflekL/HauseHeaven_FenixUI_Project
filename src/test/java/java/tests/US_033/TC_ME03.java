package java.tests.US_033;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_ME03 extends TestBaseRapor {

    @Test
    public void test03(){

        HomePage homePage=new HomePage();
        extentTest=extentReports.createTest("Testimonials sayfasında  save butonuyla yorum düzenlenebildiği testi");


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


       extentTest.pass("Admin sayfada yorum listesinin göründüğünü doğrular. ") ;
        Assert.assertTrue(homePage.admintestimonialscreatebutonu.isDisplayed());
        homePage.admintestimonialselementi.click();
        ReusableMethods.bekle(2);

       extentTest.pass("  Admin yorumu düzenlemek için edit butonuna tıklar.");

        homePage.admintestimonialseditbutonu.click();


        extentTest.pass("Admin gerekli düzenlemeleri yaptıktan sonra save butonuna tıklar .update successfully penceresı göründüğünde yapılan değişikliklerin kaydedildiğini doğrular. ");

        homePage.admintestimonialssavebutonu.click();
        Assert.assertTrue(homePage.admindeletesuccess.isDisplayed());

      extentTest.pass("  Admin açılan sekmeyi kapatır.") ;

        Driver.getDriver().quit();

    }
}
