package java.tests.US_044;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_R021 extends TestBaseRapor {
    @Test
    public void Test01(){
        extentTest=extentReports.createTest
                ("Ziyaretci anasayfada ayni mail ile kayit olamadigini gorur testi");
        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Tarayici acildi ve Hause Heaven sitesine gidildi.");

        HomePage homePage = new HomePage();
        ReusableMethods.hover(homePage.getSefFooterSubscribeBoxButtonElementi);
        extentTest.pass("Footerdaki newsletter abonelik kutusuna scroll yapildi.");

        homePage.sefFooterSubscribeBox.click();
        extentTest.pass("Footerdaki newsletter abonelik kutusuna click yapildi.");
        ReusableMethods.bekle(3);

        homePage.sefFooterSubscribeBox.sendKeys("rananurulker@gmail.com");
        extentTest.pass("Footerdaki newsletter abonelik kutusuna rananurulker@gmail.com mail adresi yazildi.");
        homePage.getSefFooterSubscribeBoxButtonElementi.click();
        ReusableMethods.bekle(5);
        extentTest.pass("Email bilgisi girildikten sonra subscribe butonuna tiklanildi.");

        Assert.assertTrue(homePage.theEmailHasAlreadyBeenTaken.isDisplayed());
        extentTest.pass("The email has Already been taken yazisi goruldu.");


        Driver.getDriver().quit();
        extentTest.pass("Ziyaretci browseri kapatir.");

    }
}
