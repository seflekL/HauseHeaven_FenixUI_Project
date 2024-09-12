package java.tests.US_01;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;


import static utilities.Driver.driver;

public class D001  extends TestBaseRapor {
    @Test
    public void sayfanınErisimTesti(){
    extentTest = extentReports.createTest("Ziyaretçi olarak hause heaven a browser üzerinden ulaşabilme testi");

        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Hause Heaven Anasayfası'na gidildi.");


         String expectedUrl="https://qa.hauseheaven.com/";
         String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("Hause Heaven'ın anasayfasında olduğu test edildi.");

        Driver.getDriver().quit();
        extentTest.pass("Ziyaretci browseri kapatir.");
    }
    }



