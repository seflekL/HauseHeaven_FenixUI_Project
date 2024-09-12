package java.tests.US_002;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import javax.swing.*;

import static utilities.Driver.driver;

public class TC_M007 extends TestBaseRapor {

    @Test
    public void Test07(){

        extentTest = extentReports.createTest(
                "HH Anasayfa’da aşağı doğru inildiğinde Header Menüsünün dropdown olarak  geldiği testi");

        //Ziyaretçi browser’ı açar, HauseHeaven URL’ini girer ve enter’a basar

        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Hause Heaven Anasayfası'na gidildi.");

        //HauseHeaven Anasayfada olduğunu doğrular.
        String expectedUrl="https://qa.hauseheaven.com/";
        String actualUrl= driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("Hause Heaven Anasayfa'da olduğu test edildi.");


        //Anasayfa'da aşağı doğru skrol yapar
        HomePage homePage=new HomePage();
        ReusableMethods.hover(homePage.SefFooterElementi);
        extentTest.info("Anasayfa'da aşağı doğru skrol yapıldı");


        //Header Menüsünün Dropdown olarak geldiğini doğrular.
        Assert.assertTrue(homePage.HeaderLinki.isDisplayed());
        extentTest.pass("Header Menüsünün Dropdown olarak geldiğini test edildi.");

        //Sayfayı kapatır
        Driver.quitDriver();
        extentTest.info("Sayfa kapatıldı.");
    }
}
