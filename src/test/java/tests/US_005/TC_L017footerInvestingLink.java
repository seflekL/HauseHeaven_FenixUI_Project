package tests.US_005;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.*;

import java.util.List;

public class TC_L017footerInvestingLink extends TestBaseRapor {

    @Test

    public void TC017() {

        extentTest = extentReports.createTest("Footer Investing Link");


        //Ziyaretci ana sayfa yuklendikten sonra sayfa sonunda yer alan footer bolumune scroll yapar
        HomePage homePage = new HomePage();
        LeventMethods.footerhomepageScroll();

        extentTest.pass("Ziyaretci ana sayfa yuklendikten sonra sayfa sonunda yer alan footer bolumune scroll yapar");



        //Ziyaretci footer bolumunde yer alan "Investing in Vacation Rental Properties: A Lucrative Opportunity" tab'ina tiklar
        homePage.sefFooterRiseOfSustainebaleElementi.click();
        ReusableMethods.getFullScreenshot(Driver.getDriver());
        extentTest.pass("Ziyaretci footer bolumunde yer alan \"Investing in Vacation Rental Properties: A Lucrative Opportunity\" tab'ina tiklar");
        //Ziyaretci ayni sekmede "The Rise Of Sustainable Homes" sayfasinin acildigini kontrol eder
        int winHandleTimes = 1;
        Assert.assertEquals(Driver.getDriver().getWindowHandles().size(), winHandleTimes);
        extentTest.pass("Ziyaretci ayni sekmede \"The Rise Of Sustainable Homes\" sayfasinin acildigini kontrol eder");
        //Ziyaretci "Investing in Vacation Rental Properties: A Lucrative Opportunity" sayfasinda asagiya footer bolumune scroll yapar
        LeventMethods.footerhomepageScroll();
        extentTest.pass("Investing in Vacation Rental Properties: A Lucrative Opportunity\" sayfasinda asagiya footer bolumune scroll yapar");

        //Ziyaretci guideline da verilen footer ogelerinin "Investing in Vacation Rental Properties: A Lucrative Opportunity"sayfasinin altinda yer aldigini  kontrol eder
        LeventMethods.footerOgeKarsilastirma();
        extentTest.pass("ZZiyaretci guideline da verilen footer ogelerinin \"Investing in Vacation Rental Properties: A Lucrative Opportunity\"sayfasinin altinda yer aldigini  kontrol eder");
        //Ziyaretci halen  "Investing in Vacation Rental Properties: A Lucrative Opportunity" sayfasinda oldgunu dogrular

        String expectedUrl = "https://hauseheaven.com/news/investing-in-vacation";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl);
        extentTest.pass("Ziyaretci halen  \"Investing in Vacation Rental Properties: A Lucrative Opportunity\" sayfasinda oldgunu dogrular");
        //Ziyratci tarayiciyi kapatir

        Driver.quitDriver();
        extentTest.pass("Ziyratci tarayiciyi kapatir");
    }
}

