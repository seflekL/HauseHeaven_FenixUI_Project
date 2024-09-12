package tests.US_006;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_R006 extends TestBaseRapor {
    @Test
    public void Test01(){

        extentTest=extentReports.createTest("Listing sayfasindaki sort butonu testi");

        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Tarayici acildi ve Hause Heaven sitesine gidildi.");

        HomePage homePage = new HomePage();
        homePage.HomePageListingLink.click();
        extentTest.pass("Headerdaki listing linkine tiklandi.");

        homePage.listingSayfasiSortButonu.click();
        extentTest.pass("Listing sayfasindaki sort butonuna tiklandi.");

        Select sortSelect = new Select(homePage.sortSelect);
        sortSelect.selectByVisibleText("Oldest");
        ReusableMethods.bekle(2);
        extentTest.pass("Sort icinde oldest secildi.");

        homePage.sortSiralamaSilme.click();
        extentTest.pass("Oldest siralamasi temizlenir");

        sortSelect.selectByVisibleText("Newest");
        ReusableMethods.bekle(2);
        extentTest.pass("Sort icinde Newest secildi.");

        homePage.sortSiralamaSilme.click();
        extentTest.pass("Newest siralamasi temizlenir");

        sortSelect.selectByVisibleText("Price: Low to high");
        ReusableMethods.bekle(2);
        extentTest.pass("Sort icinde Price: Low to high secildi");


        homePage.sortSiralamaSilme.click();
        extentTest.pass("Price: Low to high siralamasi temizlenir");

        sortSelect.selectByVisibleText("Price: High to low");
        ReusableMethods.bekle(2);
        extentTest.pass("Sort icinde Price: High to low secildi");

        homePage.sortSiralamaSilme.click();
        extentTest.pass("Price: Low to high siralamasi temizlenir");

        sortSelect.selectByVisibleText("Name: A-Z");
        ReusableMethods.bekle(2);
        extentTest.pass("Sort icinde Name: A-Z secildi");

        homePage.sortSiralamaSilme.click();
        extentTest.pass("Name: A-Z siralamasi temizlenir");

        sortSelect.selectByVisibleText("Name: Z-A");
        ReusableMethods.bekle(2);
        extentTest.pass("Sort icinde Name: Z-A secildi");

        homePage.sortSiralamaSilme.click();
        extentTest.pass("Name: Z-A siralamasi temizlenir");

        Driver.getDriver().quit();
        extentTest.pass("Ziyaretci browseri kapatir.");
    }
}
