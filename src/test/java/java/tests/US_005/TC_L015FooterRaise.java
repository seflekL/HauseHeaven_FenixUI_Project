package java.tests.US_005;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.List;

public class TC_L015FooterRaise extends TestBaseRapor {

    @Test

    public void  TC015 (){

        extentTest = extentReports.createTest("Footer A Rise Page Testi");

        HomePage homePage=new HomePage();

        //Ziyaretci hausehaen Url'ine giris saglar
        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Ziyaretci hausehaen Url'ine giris saglar");

        //Ziyaretci ana sayfa yuklendikten sonra sayfa sonunda yer alan footer bolumune scroll yapar
        ReusableMethods.hover(homePage.SefFooterElementi);
        homePage.sefUsercookies.click();
        extentTest.pass("Ziyaretci ana sayfa yuklendikten sonra sayfa sonunda yer alan footer bolumune scroll yapar");
        //Ziyaretci footer bolumunde yer alan "The Rise Of Sustainable Homes" tab'ina tiklar
        homePage.sefFooterRiseOfSustainebaleElementi.click();
        ReusableMethods.getFullScreenshot(Driver.getDriver());
        extentTest.pass("Ziyaretci footer bolumunde yer alan \"The Rise Of Sustainable Homes\" tab'ina tiklar");

        //Ziyaretci ayni sekmede "The Rise Of Sustainable Homes" sayfasinin acildigini kontrol eder
        int winHandleTimes = 1;
        Assert.assertEquals(Driver.getDriver().getWindowHandles().size(), winHandleTimes);
        extentTest.pass("Ziyaretci ayni sekmede \"The Rise Of Sustainable Homes\" sayfasinin acildigini kontrol eder");
        //Ziyaretci "The Rise Of Sustainable Homes" sayfasinda asagiya footer bolumune scroll yapar
        ReusableMethods.hover(homePage.SefFooterElementi);
        ReusableMethods.wait(2);
        extentTest.pass("Ziyaretci \"The Rise Of Sustainable Homes\" sayfasinda asagiya footer bolumune scroll yapar");
        //Ziyaretci guideline da verilen footer ogelerinin "The Rise Of Sustainable Homes"sayfasinin altinda yer aldigini  kontrol eder
        List<String> footerAltUstDizinList = ReusableMethods.getStringList(homePage.sefFooterGenelList);
        System.out.println(footerAltUstDizinList);
        String expetedFooterElements = "[4655 Wild Indigo St Houston Tx 77027-7080 Usa\n" +
                "+1 246-345-0695\n" +
                "info@hauseheaven.com, About\n" +
                "About us\n" +
                "Contact us\n" +
                "Terms & Conditions, More Information\n" +
                "All properties\n" +
                "Houses for sale\n" +
                "Houses for rent, News\n" +
                "The Benefits Of Investing In Emerging Real Estate Markets\n" +
                "A Guide To Negotiating The Best Deal On Your Dream Home\n" +
                "The Rise Of Sustainable Homes: Building For A Greener Future\n" +
                "How to Stage Your Home for a Quick and Profitable Sale\n" +
                "Investing in Vacation Rental Properties: A Lucrative Opportunity, Download Apps\n" +
                "Google Play\n" +
                "Get It Now\n" +
                "App Store\n" +
                "Now it Available]";
        for (String eachelements : footerAltUstDizinList) {
            Assert.assertTrue(expetedFooterElements.contains(eachelements));
        }
        extentTest.pass("Ziyaretci guideline da verilen footer ogelerinin \"The Rise Of Sustainable Homes\"sayfasinin altinda yer aldigini  kontrol eder");
        //Ziyaretci halen  "The Rise Of Sustainable Homes" sayfasinda oldgunu dogrular

        String expectedUrl="https://hauseheaven.com/news/the-rise-of-sutainable-homes";
        String actualUrl=Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("Ziyaretci halen  \"The Rise Of Sustainable Homes\" sayfasinda oldgunu dogrular");

        //Ziyratci tarayiciyi kapatir

        Driver.quitDriver();
        extentTest.pass("Ziyratci tarayiciyi kapatir");
    }

}
