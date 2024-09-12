package java.tests.US_002;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import static utilities.Driver.driver;

public class TC_M006 extends TestBaseRapor {

    @Test
    public void Test06(){

        extentTest = extentReports.createTest(
                "HH Anasayfa’da Menü’de en sağ tarafta Sign in linki olduğu testi");

        //Ziyaretçi browser’ı açar, HauseHeaven URL’ini girer ve enter’a basar

        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Hause Heaven Anasayfası'na gidildi.");

        //HauseHeaven Anasayfada olduğunu doğrular.
        String expectedUrl="https://qa.hauseheaven.com/";
        String actualUrl= driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("Hause Heaven Anasayfa'da olduğu test edildi.");

        //Menü'nün en sağında Sign in linki olduğunu gözlemler.
        HomePage homePage=new HomePage();

        Assert.assertTrue(homePage.signinButonu.isDisplayed());
        extentTest.pass("Menü'nün en sağında Sign in linki olduğu test edildi.");

        //Sayfayı kapatır
        Driver.quitDriver();
        extentTest.info("Sayfa kapatıldı.");
    }
}
