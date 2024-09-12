package java.tests.US_022;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_ME01 extends TestBaseRapor {
    @Test
    public void test01(){
        HomePage homePage=new HomePage();

       extentTest=extentReports.createTest("mülkü wishliste ekleyebıldiği testi ");
        extentTest .pass("Kayıtlı kullancı HauseHeaven url girer.");
        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));

        extentTest .pass(" Kayıtlı kullanıcı HauseHeaven anasayfa header a ulaşır.");
        Assert.assertTrue(homePage.hauseheavenlogo.isDisplayed());


        homePage.signinButonu.click();
        homePage.singinemailbutonu.sendKeys("elif@gmail.com");
        homePage.singinpasswordbutonu.sendKeys("123456789.elif");
        homePage.singinloginbutonu.click();




        extentTest .pass("Kayıtlı kullanıcı listing linkine tıklar.");
        homePage.listingButonu.click();

        extentTest .pass(" Kayıtlı kullanıcı listing sayfasına ulaşır.");
       Assert.assertTrue(homePage.listingfindbybutonu.isDisplayed());


        extentTest .pass(" Kayıtlı kullanıcı sayfada seçtiği mülk resminin sağ üst köşesindeki wishlist butonuna tıklar.");
        homePage.listingwishlistbutonu.click();

        extentTest .pass(" Kayıtlı kullanıcı added to wishlist succesfully penceresini görerek mülkü wishlist e ekleyebildiğini doğrular.");
        Assert.assertTrue(homePage.listingwislistaddbutonu.isDisplayed());

        extentTest .pass("Kayıtlı kullanıcı acilan sekmeyi kapatır.");
        Driver.getDriver().quit();

    }
}
