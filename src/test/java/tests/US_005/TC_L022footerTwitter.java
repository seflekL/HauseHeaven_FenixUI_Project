package tests.US_005;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.Driver;
import utilities.LeventMethods;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_L022footerTwitter extends TestBaseRapor {

    @Test
    public void TC022twitter() {
        extentTest = extentReports.createTest("Twitter Testi");

        HomePage homePage = new HomePage();
        //Ziyaretci hausehaen Url'ine giris saglar ve footer bolumune scroll yapar
        LeventMethods.footerhomepageScroll();
        extentTest.pass("Ziyaretci hausehaen Url'ine giris saglar ve footer bolumune scroll yapar");
        //Ziyaretci footer bolumunde yer alan "Twitter" logosuna  tiklar
        homePage.SeftwitterBoxButtonElementi.click();
        extentTest.pass("Ziyaretci footer bolumunde yer alan \"Twitter\" logosuna  tiklar");
        //Ziyaretci yeni sekmede "Hauseheaven-Twitter" sayfasinin ayri sekmede acildigini kontrol eder
        LeventMethods.windowsHanldes(2);
        extentTest.pass("Ziyaretci yeni sekmede \"Hauseheaven-Twitter\" sayfasinin ayri sekmede acildigini kontrol eder");
        //Ziyaretci Twitter'in resmi websitesine gittigini onaylar
        String expectedUrL="https://www.twitter.com/";
        String actualurl=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualurl,expectedUrL);
        ReusableMethods.getFullScreenshot(Driver.getDriver());
        extentTest.pass("Ziyaretci Twitter'in resmi websitesine gittigini onaylar");
        //Ziyaretci tarayiciyi kapatir
        Driver.quitDriver();
        extentTest.pass("Ziyaretci tarayiciyi kapatir");


    }
}
