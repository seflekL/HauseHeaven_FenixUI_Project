package tests.US_028;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import static utilities.Driver.driver;

public class TC_M023 extends TestBaseRapor {

    @Test
    public void Test23 (){

        extentTest = extentReports.createTest("Ziyaretçi olarak tarayıcıda " +
                "Admin giriş Url’i girildiğinde Admin Log in sayfası açıldığı testi");

        //Ziyaretçi browser’ı açar, HauseHeaven Admin giriş URL’ini girer ve enter’a basar

        Driver.getDriver().get(ConfigReader.getProperty("hauseAdminUrl"));
        extentTest.info("Hause Heaven Admin giriş sayfasına gidildi.");


        //HauseHeaven Anasayfada olduğunu doğrular.
        String expectedUrl="https://qa.hauseheaven.com/admin/login";
        String actualUrl= driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("Hause Heaven Admin giriş sayfasında olduğu test edildi.");

        //Sayfayı kapatır
        Driver.quitDriver();
        extentTest.info("Sayfa kapatıldı.");

}
}

