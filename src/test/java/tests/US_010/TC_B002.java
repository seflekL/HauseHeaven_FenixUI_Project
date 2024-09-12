package tests.US_010;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TeamPages.BunyaminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.time.Duration;

public class TC_B002 extends TestBaseRapor {

    @Test
    public void Test07(){

        extentTest = extentReports.createTest("Ziyaretçi olarak siteye girip header kisminda Blog başlığına tıklanıp kaydedilmiş blogların görüntülenme testi.");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Hause Heaven ana sayfasına gidildi.");

        HomePage homePage = new HomePage();
        BunyaminPage bunyaminPage = new BunyaminPage();

        homePage.blogButonu.click();
        ReusableMethods.wait(1);

        String unExpectedSonucYazisi = "0";
        String actualSonucYazisi = bunyaminPage.blogUrunBody.getText();
        Assert.assertNotEquals(actualSonucYazisi,unExpectedSonucYazisi);
        extentTest.pass("Blog'da urunler goruntulendi.");

        Driver.quitDriver();
        extentTest.pass("Driver kapatildi.");

    }
}
