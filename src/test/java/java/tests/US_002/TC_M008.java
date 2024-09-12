package java.tests.US_002;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import static utilities.Driver.driver;

public class TC_M008 extends TestBaseRapor {

    @Test
    public void Test08(){

        extentTest = extentReports.createTest(
                "HH Anasayfa’da Header Menü’nün sol tarafında " +
                        "Logoya bitişik linklere tıklandığında doğru sayfaya gidildiği testi");

        //Ziyaretçi browser’ı açar, HauseHeaven URL’ini girer ve enter’a basar

        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Hause Heaven Anasayfası'na gidildi.");

        //HauseHeaven Anasayfada olduğunu doğrular.
        String expectedUrl="https://qa.hauseheaven.com/";
        String actualUrl= driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("Hause Heaven Anasayfa'da olduğu test edildi.");

        //Daha sonra Header’daki Logo ve Home’linklerinin sağındaki Listing linkine tıklar
        HomePage homePage=new HomePage();
        homePage.listingButonu.click();
        extentTest.info("Anasayfa'da Listing linkine tıklandı.");

        //Açılan sayfanın Properties sayfası olduğunu test eder.
        expectedUrl="https://qa.hauseheaven.com/properties?layout=sidebar";
        actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("Açılan sayfanın Properties sayfası olduğu test edildi.");

        //Home linkine tıklayarak anasayfaya döner.
        homePage.homeButonu.click();
        extentTest.info("Home linkine tıklayarak anasayfaya dönüldü.");

        //Daha sonra Header’daki Projects linkine tıklar
        homePage.projectsButonu.click();
        extentTest.info("Anasayfa'da Projects linkine tıklandı.");

        //Açılan sayfanın Projects sayfası olduğunu test eder.
        expectedUrl="https://qa.hauseheaven.com/projects";
        actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("Açılan sayfanın Projects sayfası olduğu test edildi.");

        //Home linkine tıklayarak anasayfaya döner.
        homePage.homeButonu.click();
        extentTest.info("Home linkine tıklayarak anasayfaya dönüldü.");

        //Daha sonra Header’daki Agents linkine tıklar
        homePage.agentsButonu.click();
        extentTest.info("Anasayfa'da Agents linkine tıklandı.");

        //Açılan sayfanın Agents sayfası olduğunu test eder.
        expectedUrl="https://qa.hauseheaven.com/agents";
        actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("Açılan sayfanın Agents sayfası olduğu test edildi.");

        //Home linkine tıklayarak anasayfaya döner.
        homePage.homeButonu.click();
        extentTest.info("Home linkine tıklayarak anasayfaya dönüldü.");

        //Daha sonra Header’daki Blog linkine tıklar
        homePage.blogButonu.click();
        extentTest.info("Anasayfa'da Blog linkine tıklandı.");

        //Açılan sayfanın Blog sayfası olduğunu test eder.
        expectedUrl="https://qa.hauseheaven.com/blog";
        actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("Açılan sayfanın Blog sayfası olduğu test edildi.");

        //Home linkine tıklayarak anasayfaya döner.
        homePage.homeButonu.click();
        extentTest.info("Home linkine tıklayarak anasayfaya dönüldü.");

        //Daha sonra Header’daki Contact linkine tıklar
        homePage.contactButonu.click();
        extentTest.info("Anasayfa'da Contact linkine tıklandı.");

        //Açılan sayfanın Contact sayfası olduğunu test eder.
        expectedUrl="https://qa.hauseheaven.com/contact";
        actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("Açılan sayfanın Contact sayfası olduğu test edildi.");

        //Home linkine tıklayarak anasayfaya döner.
        homePage.homeButonu.click();
        extentTest.info("Home linkine tıklayarak anasayfaya dönüldü.");

        //Daha sonra Header’daki Sign Up linkine tıklar
        homePage.signupButonu.click();
        extentTest.info("Anasayfa'da Sign Up linkine tıklandı.");

        //Açılan sayfanın Sign Up sayfası olduğunu test eder.
        expectedUrl="https://qa.hauseheaven.com/register";
        actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("Açılan sayfanın Sign Up sayfası olduğu test edildi.");

        //Home linkine tıklayarak anasayfaya döner.
        homePage.homeButonu.click();
        extentTest.info("Home linkine tıklayarak anasayfaya dönüldü.");

        //Sayfayı kapatır
        Driver.quitDriver();
        extentTest.info("Sayfa kapatıldı.");
    }
}
