package tests.US_044;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_R020 extends TestBaseRapor {
    @Test
public void Test01(){
        extentTest=extentReports.createTest
            ("Ziyaretci anasayfada subscribe kutusuna mail girisi yapar testi");
        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Tarayici acildi ve Hause Heaven sitesine gidildi.");
        HomePage homePage = new HomePage();
        ReusableMethods.hover(homePage.getSefFooterSubscribeBoxButtonElementi);
            extentTest.pass("Footerdaki newsletter abonelik kutusuna scroll yapildi.");

        homePage.sefFooterSubscribeBox.click();
            extentTest.pass("Footerdaki newsletter abonelik kutusuna click yapildi.");


        Faker faker=new Faker();
        String fakeEmail=faker.internet().emailAddress();
        homePage.sefFooterSubscribeBox.sendKeys(fakeEmail);
            ReusableMethods.bekle(5);
            extentTest.pass("Faker class ile bir mail adresi girildi.");
        homePage.getSefFooterSubscribeBoxButtonElementi.click();
        ReusableMethods.bekle(5);
            extentTest.pass("Email bilgisi girildikten sonra subscribe butonuna tiklanildi.");

        Assert.assertTrue(homePage.newsletterSuccesfullAlert.isDisplayed());
            extentTest.pass("Kayidin basarili oldugunu dogrulamak icin cikan pop-upta Succesfully yazisi goruldu.");

        Driver.getDriver().quit();
        extentTest.pass("Ziyaretci browseri kapatir.");


    }
}
