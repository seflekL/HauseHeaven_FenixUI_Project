package java.tests.US_005;

import org.testng.annotations.Test;
import pages.HomePage;
import utilities.Driver;
import utilities.LeventMethods;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_L018googleAppWindowTest extends TestBaseRapor {


    @Test

    public void TC018googleAPPNewWindow(){
        extentTest = extentReports.createTest("HauseHeavanGoogle Page Testi");

        HomePage homePage=new HomePage();

        //Ziyaretci hausehaen Url'ine giris saglar ve footer bolumune scroll yapar
        LeventMethods.footerhomepageScroll();
        extentTest.pass("Ziyaretci hausehaen Url'ine giris saglar ve footer bolumune scroll yapar");
         //Ziyaretci footer bolumunde yer alan "Hauseheaven Google App" tab'ina tiklar
        homePage.sefFooterGoogleAPPelementi.click();
        extentTest.pass("Ziyaretci footer bolumunde yer alan \"Hauseheaven Google App\" tab'ina tiklar");

        //Ziyaretci farkli sekmede "Hauseheaven Google App" sayfasinin acildigini kontrol eder

        ReusableMethods.getFullScreenshot(Driver.getDriver());
        LeventMethods.windowsHanldes(2);
        extentTest.pass("Ziyaretci farkli sekmede \"Hauseheaven Google App\" sayfasinin acildigini kontrol eder");
        //Ziyratci tarayiciyi kapatir
        Driver.quitDriver();
        extentTest.pass("Ziyratci tarayiciyi kapatir");
    }


}
