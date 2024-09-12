package java.tests.US_002;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import static utilities.Driver.driver;

public class TC_M005 extends TestBaseRapor {

    @Test
    public void Test05(){

        extentTest = extentReports.createTest(
                "HH Anasayfa’da Header Menü’de sol tarafta Logoya bitişik " +
                        "7 adet link (Home, Listings, Projects, Agents, Blog, Contacts, Sign Up) olduğu testitesti");

        //Ziyaretçi browser’ı açar, HauseHeaven URL’ini girer ve enter’a basar

        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Hause Heaven Anasayfası'na gidildi.");

        //HauseHeaven Anasayfada olduğunu doğrular.
        String expectedUrl="https://qa.hauseheaven.com/";
        String actualUrl= driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("Hause Heaven Anasayfa'da olduğu test edildi.");

        HomePage homePage=new HomePage();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(homePage.homeButonu.isDisplayed(), "Home Linki bulunamadı");
        softAssert.assertTrue(homePage.listingButonu.isDisplayed(), "Listing Linki bulunamadı");
        softAssert.assertTrue(homePage.projectsButonu.isDisplayed(), "Projects Linki bulunamadı");
        softAssert.assertTrue(homePage.agentsButonu.isDisplayed(), "Agents Linki bulunamadı");
        softAssert.assertTrue(homePage.blogButonu.isDisplayed(), "Blog Linki bulunamadı");
        softAssert.assertTrue(homePage.contactButonu.isDisplayed(), "Contacts Linki bulunamadı");
        softAssert.assertTrue(homePage.signupButonu.isDisplayed(), "Sign Up Linki bulunamadı");

        extentTest.pass("HH Header’daki Menü’nün solundaki Logoya bitişik 7 adet link olduğunu test edildi. ");

        softAssert.assertAll();

        //Sayfayı kapatır
        Driver.quitDriver();
        extentTest.info("Sayfa kapatıldı.");
    }




}
