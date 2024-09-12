package java.tests.US_007;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TeamPages.BunyaminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.time.Duration;

public class TC_B001 extends TestBaseRapor {



    @Test
    public void test01(){

        extentTest = extentReports.createTest("Ziyaretçi olarak ana sayfadan header kısmında bulunan Listing'e tıklama ve ürünlerin görüntülenip tıklanabilirliği testi.");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Hause Heaven ana sayfasına gidildi.");

        HomePage homePage = new HomePage();
        BunyaminPage bunyaminPage = new BunyaminPage();

        homePage.listingButonu.click();
        ReusableMethods.wait(1);
        extentTest.pass("Listing basligina tiklandi.");

        String unExpectedSonucYazisi = "0 results";
        String actualSonucYazisi = bunyaminPage.listingUrunSayisi
                .getText();
        extentTest.pass("Listing'de urunler goruntulendi.");

        Assert.assertNotEquals(actualSonucYazisi,unExpectedSonucYazisi);

        bunyaminPage.listingUrunIsim.click();
        extentTest.pass("Listing'de urune tiklandi.");

        Driver.quitDriver();
        extentTest.pass("Driver kapatildi.");


    }

}
