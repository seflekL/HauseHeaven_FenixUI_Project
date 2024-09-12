package java.tests.US_012;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import static utilities.Driver.driver;

public class TC_D006 extends TestBaseRapor {
    @Test
    public void hauseHevenGirisTesti(){
    extentTest = extentReports.createTest("Kullanıcı giriş butonlarının aktifliği testi");

        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Hause Heaven Anasayfası'na gidildi.");

        String expectedUrl="https://qa.hauseheaven.com/";
        String actualUrl= driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("Hause heaven da olduğunu test etti.");

        HomePage homePage=new HomePage();
        homePage.listingButonu.click();
        extentTest.info("Her hangi bir linke tıklayarak başka bir sayfaya gitti.");

         actualUrl= driver.getCurrentUrl();
        Assert.assertNotEquals(actualUrl,expectedUrl);
        extentTest.pass("HauseHeaven anasayfası dışında olduğunu test edildi.");


        Driver.getDriver().quit();
        extentTest.pass("Kullanıcı browseri kapatir.");
}
}
