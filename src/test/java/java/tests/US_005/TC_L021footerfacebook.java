package java.tests.US_005;

import org.testng.annotations.Test;
import pages.HomePage;
import utilities.Driver;
import utilities.LeventMethods;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_L021footerfacebook extends TestBaseRapor {

    @Test
    public void TC021facebook() {
        extentTest = extentReports.createTest("Footer FacebookLink Testi");

        HomePage homePage = new HomePage();
        //Ziyaretci hausehaen Url'ine giris saglar ve footer bolumune scroll yapar
        extentTest.pass("Ziyaretci hausehaen Url'ine giris saglar ve footer bolumune scroll yapar");
        LeventMethods.footerhomepageScroll();
        //Ziyaretci footer bolumunde yer alan "FaceBook" logosuna  tiklar

        homePage.SeffooterfacebookBoxElementi.click();

        ReusableMethods.getFullScreenshot(Driver.getDriver());
        extentTest.pass("Ziyaretci footer bolumunde yer alan \"FaceBook\" logosuna  tiklar");
        //Ziyaretci yeni sekmede "Hauseheaven-Facebook" sayfasinin ayri sekmede acildigini kontrol eder
        ReusableMethods.wait(3);
        LeventMethods.windowsHanldes(2);
        extentTest.pass("Ziyaretci yeni sekmede \"Hauseheaven-Facebook\" sayfasinin ayri sekmede acildigini kontrol eder");
        //Ziyratci tarayiciyi kapatir
        Driver.quitDriver();
        extentTest.pass("Ziyratci tarayiciyi kapatir");


    }
}
