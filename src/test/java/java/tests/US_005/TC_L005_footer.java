package java.tests.US_005;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.List;

public class TC_L005_footer extends TestBaseRapor {
    @Test
    public void TC_L005footerTest(){
        extentTest = extentReports.createTest("Footer Ogeleri Testi");

        UserDashboard userDashboard=new UserDashboard();
        HomePage homePage=new HomePage();

        //Ziyaretci hausehaen Url'ine giris saglar
        Driver.getDriver().get("https://qa.hauseheaven.com/");
        extentTest.pass("Ziyaretci hausehaen Url'ine giris saglar");
         //Ziyaretci ana sayfa yuklendikten sonra sayfa sonunda yer alan footer bolumune scroll yapar
        ReusableMethods.hover(homePage.SefFooterElementi);
        homePage.sefUsercookies.click();
        ReusableMethods.wait(2);
        extentTest.pass("iyaretci ana sayfa yuklendikten sonra sayfa sonunda yer alan footer bolumune scroll yapar");
        //Ziyaretci test object de bahsedilen ogelerin footer da ust basliklarin ve alt dizinlinlerin footer icinde goruntulendigini test eder.
        List <String> footerAltUstDizinList=ReusableMethods.getStringList(homePage.sefFooterGenelList);
        System.out.println(footerAltUstDizinList);
        String expetedFooterElements="[4655 Wild Indigo St Houston Tx 77027-7080 Usa\n" +
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
            extentTest.pass("Ziyaretci test object de bahsedilen ogelerin footer da ust basliklarin ve alt dizinlinlerin footer icinde goruntulendigini test eder");
        }
        //Ziyaretci acilan  tarayici kapatir
        Driver.quitDriver();
        extentTest.pass("Ziyaretci acilan  tarayici kapatir");

    }
}
