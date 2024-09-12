package tests.US_002;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import static utilities.Driver.driver;

public class TC_M004 extends TestBaseRapor {

    @Test
    public void Test04(){

        extentTest = extentReports.createTest(
                "HH Anasayfa’da Menü’nün en sol tarafında HH Logo'su olduğu ve tıklandığında anasayfaya gidildiği testi");

        //Ziyaretçi browser’ı açar, HauseHeaven URL’ini girer ve enter’a basar

        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Hause Heaven Anasayfası'na gidildi.");

        //HauseHeaven Anasayfada olduğunu doğrular.
        String expectedUrl="https://qa.hauseheaven.com/";
        String actualUrl= driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("Hause Heaven Anasayfa'da olduğu test edildi.");

        //Logoya tıklar ve yönlendildiği sayfanın yüklenmesini bekler.
        HomePage homePage=new HomePage();
        homePage.hauseheavenlogo.click();
        extentTest.info("Logoya tıklandı");

        //HauseHeaven Anasayfada olduğunu doğrular
        actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("HauseHeaven Anasayfası'nda olduğu test edildi.");

        //Sayfayı kapatır
        Driver.quitDriver();
        extentTest.info("Sayfa kapatıldı.");
    }
}
