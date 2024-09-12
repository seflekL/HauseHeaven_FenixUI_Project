package java.tests.US_01;


import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import static utilities.Driver.driver;

public class D002 extends TestBaseRapor {


    @Test
    public void chromeSayfaErisimTesti() {

            extentTest = extentReports.createTest("Ziyaretçi olarak hause heaven a browser üzerinden ulaşabilme testi");

            Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
            extentTest.pass("Hause Heaven Anasayfası'na gidildi.");


            String expectedUrl="https://qa.hauseheaven.com/";
            String actualUrl= driver.getCurrentUrl();
            Assert.assertEquals(actualUrl,expectedUrl);
            extentTest.pass("Hause Heaven'ın anasayfasında olduğu test edildi.");

            Driver.quitDriver();
            extentTest.info("Sayfa kapatıldı.");}

    @Test
    public void edgeSayfaErisimTesti() {
            extentTest = extentReports.createTest("Ziyaretçi olarak hause heaven a browser üzerinden ulaşabilme testi");

            Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
            extentTest.pass("Hause Heaven Anasayfası'na gidildi.");


            String expectedUrl="https://qa.hauseheaven.com/";
            String actualUrl= driver.getCurrentUrl();
            Assert.assertEquals(actualUrl,expectedUrl);
            extentTest.pass("Hause Heaven'ın anasayfasında olduğu test edildi.");

            Driver.quitDriver();
            extentTest.info("Sayfa kapatıldı.");

    }
}