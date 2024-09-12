package tests.US_005;

import org.testng.annotations.Test;
import pages.HomePage;
import utilities.Driver;
import utilities.LeventMethods;
import utilities.TestBaseRapor;

public class TC_L023footerintagramUrlTest extends TestBaseRapor {

    @Test
    public void TC021InstagramPageTesti() {
        extentTest = extentReports.createTest("InstagramPage Testi");

        HomePage homePage = new HomePage();
        //Ziyaretci hausehaen Url'ine giris saglar ve footer bolumune scroll yapar
        extentTest.pass("Ziyaretci hausehaen Url'ine giris saglar ve footer bolumune scroll yapar");
        LeventMethods.footerhomepageScroll();
        //Ziyaretci footer bolumunde yer alan "Instagram" logosuna  tiklar
       homePage.SefFooterInstagramButtonElementi.click();
        extentTest.pass("Ziyaretci footer bolumunde yer alan \"Instagram\" logosuna  tiklar");
       //Ziyaretci yeni sekmede "Hauseheaven-Facebook" sayfasinin ayri sekmede acildigini kontrol eder
        LeventMethods.windowsHanldes(2);
        extentTest.pass("Ziyaretci yeni sekmede \"Hauseheaven-Facebook\" sayfasinin ayri sekmede acildigini kontrol eder");
        //Ziyratci tarayiciyi kapatir
        Driver.quitDriver();
        extentTest.pass("//Ziyratci tarayiciyi kapatir");
    }
}
