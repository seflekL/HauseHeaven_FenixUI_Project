package java.tests.US_002;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import static utilities.Driver.driver;

public class TC_M002 extends TestBaseRapor {

    @Test
    public void Test02(){

        extentTest = extentReports.createTest("HH Anasayfası'nda Header bölümünün görünür ve ulaşılabilir olması testi");

        //Ziyaretçi browser’ı açar, HauseHeaven URL’ini girer ve enter’a basar

        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Hause Heaven Anasayfası'na gidildi.");

        //HauseHeaven Anasayfada olduğunu doğrular.
        String expectedUrl="https://qa.hauseheaven.com/";
        String actualUrl= driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("Hause Heaven Anasayfa'da olduğu test edildi.");

        //Anasayfanın üst bölümündeki Header Menüsünün doğru bir şekilde göründüğünü test eder.
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.HeaderLinki.isDisplayed());
        extentTest.pass("Hause Heaven Anasayfa'da Header bölümünün görünür ve ulaşılabilir olduğu test edildi.");

        //Sayfayı kapatır
        Driver.quitDriver();
        extentTest.pass("Sayfa Kapatıldı.");

    }
}
