package tests.US_005;

import org.testng.annotations.Test;
import pages.HomePage;
import utilities.Driver;
import utilities.LeventMethods;
import utilities.TestBaseRapor;

public class TC_L024footerlinkedintesti extends TestBaseRapor {

    @Test
    public void TC021footerLinkedin() {
        HomePage homePage = new HomePage();
        extentTest = extentReports.createTest("Footer All Properties Testi");

        //Ziyaretci hausehaen Url'ine giris saglar ve footer bolumune scroll yapar
        LeventMethods.footerhomepageScroll();
        extentTest.pass("Ziyaretci hausehaen Url'ine giris saglar ve footer bolumune scroll yapar");
        //Ziyaretci footer bolumunde yer alan "Linkedin" logosuna  tiklar
        homePage.SefFooterLinkedinButtonElementi.click();
        extentTest.pass("Ziyaretci footer bolumunde yer alan \"Linkedin\" logosuna  tiklar");

        //Ziyaretci yeni sekmede "Hauseheaven-Linkedin" sayfasinin ayri sekmede acildigini kontrol eder
        LeventMethods.windowsHanldes(2);
        extentTest.pass("Ziyaretci yeni sekmede \"Hauseheaven-Linkedin\" sayfasinin ayri sekmede acildigini kontrol eder");

        //Ziyaretci tarayiciyi kapatir
        Driver.quitDriver();
        extentTest.pass("Ziyrateci tarayiciyi kapatir");

    }

}
