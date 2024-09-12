package tests.US_007;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TeamPages.BunyaminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.time.Duration;

public class TC_B003 extends TestBaseRapor {

    @Test
    public void test03(){

        extentTest = extentReports.createTest("Ziyaretçi olarak Listing sayfasindan bir ürüne tıklayıp Save butonuna basıp Wishlist'te görüntülenme testi.");

        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Hause Heaven ana sayfasına gidildi.");

        BunyaminPage bunyaminPage = new BunyaminPage();
        HomePage homePage=new HomePage();

        homePage.listingButonu.click();
        ReusableMethods.wait(1);
        extentTest.pass("Listing basligina tiklandi.");

        bunyaminPage.listingUrunIsim.click();
        extentTest.pass("Listing'de urune tiklandi.");

        bunyaminPage.urunSaveButton.click();
        extentTest.pass("Save butonuna tiklandi.");

        bunyaminPage.wishlistButton.click();
        extentTest.pass("Wishlist butonuna tiklandi.");

        Assert.assertTrue(bunyaminPage.wishlistUrunIsim.isDisplayed());
        extentTest.pass("Urun wishlist sayfasinda goruntulendi.");

        Driver.quitDriver();
        extentTest.pass("Driver kapatildi.");



    }

}
