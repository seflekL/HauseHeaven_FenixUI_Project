package tests.US_01;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import static utilities.Driver.driver;


public class D003 extends TestBaseRapor {

        @Test
        public void Test01(){

            extentTest = extentReports.createTest("Anasayfada blokların görünür olması testi");

            Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
            extentTest.pass("Hause Heaven Anasayfası'na gidildi.");


            String expectedUrl="https://qa.hauseheaven.com/";
            String actualUrl= driver.getCurrentUrl();

            Assert.assertEquals(actualUrl,expectedUrl);
            extentTest.pass("Hause Heaven Anasayfa'da olduğu test edildi.");


            HomePage homePage=new HomePage();
            homePage.listingButonu.click();
            extentTest.info("Her hangi bir linke tıklayarak başka bir sayfaya gidildi.");


            homePage.homeButonu.click();
            extentTest.info("Sayfada Home linkine tıklandı.");


            homePage.hauseheavenlogo.click();


            Driver.getDriver().quit();
            extentTest.pass("Ziyaretci browseri kapatir.");
        }
    }

