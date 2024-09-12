package tests.US_005;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.Driver;
import utilities.LeventMethods;
import utilities.TestBaseRapor;

public class TC_L027footerPinterst extends TestBaseRapor {

    @Test
    public void TC027footerPinterst() {
         HomePage homePage = new HomePage();
        extentTest = extentReports.createTest("Footer Pinterst Page Testi");

        //Ziyaretci hausehaen Url'ine giris saglar ve footer bolumune scroll yapar
        LeventMethods.footerhomepageScroll();
        extentTest.pass("Ziyaretci hausehaen Url'ine giris saglar ve footer bolumune scroll yapar");
        //Ziyaretci footer bolumunde yer alan "Linkedin" logosuna  tiklar
       homePage.SefFooterPintestButtonElementi.click();
        extentTest.pass("Ziyaretci footer bolumunde yer alan \"Linkedin\" logosuna  tiklar");
        //Ziyaretci yeni sekmede "Hauseheaven-Pinterst" sayfasinin ayri sekmede acildigini kontrol eder
        LeventMethods.windowsHanldes(2);
        extentTest.pass("Ziyaretci yeni sekmede \"Hauseheaven-Pinterst\" sayfasinin ayri sekmede acildigini kontrol eder");
        //Ziyratci tarayiciyi kapatir
        Driver.quitDriver();
        extentTest.pass("Ziyratci tarayiciyi kapatir");


    }
}
