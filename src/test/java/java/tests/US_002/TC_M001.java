package java.tests.US_002;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import static utilities.Driver.driver;

public class TC_M001 extends TestBaseRapor {

    @Test
    public void Test01(){

        extentTest = extentReports.createTest("Ziyaretçi olarak HH Anasayfası'nın ulaşılabilir olması testi");

        //Ziyaretçi browser’ı açar, HauseHeaven URL’ini girer ve enter’a basar

        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Hause Heaven Anasayfası'na gidildi.");

        //HauseHeaven Anasayfada olduğunu doğrular.
        String expectedUrl="https://qa.hauseheaven.com/";
        String actualUrl= driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("Hause Heaven Anasayfa'da olduğu test edildi.");

        //Daha sonra her hangi bir linke tıklayarak başka bir sayfaya geçer.
        HomePage homePage=new HomePage();
        homePage.listingButonu.click();
        extentTest.info("Her hangi bir linke tıklayarak başka bir sayfaya gidildi.");

        //HauseHeaven Anasayfası dışında olduğunu test eder.
        actualUrl= driver.getCurrentUrl();
        Assert.assertNotEquals(actualUrl,expectedUrl);
        extentTest.pass("HauseHeaven Anasayfası dışında olduğunu test edildi.");

        //Bulunduğu sayfada Home linkine tıklar.
        homePage.homeButonu.click();
        extentTest.info("Sayfada Home linkine tıklandı.");

        //Tekrar HauseHeaven Anasayfaya geldiğini doğrular
        actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("Tekrar HauseHeaven Anasayfası'na gelindiği test edildi.");

        //Sayfayı kapatır
        Driver.quitDriver();
        extentTest.info("Sayfa kapatıldı.");
    }
}
