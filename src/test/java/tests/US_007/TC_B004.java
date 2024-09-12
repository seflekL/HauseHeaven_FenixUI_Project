package tests.US_007;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.TeamPages.BunyaminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.time.Duration;
import java.util.NoSuchElementException;

public class TC_B004 extends TestBaseRapor {

    @Test
    public void test04() {

        extentTest = extentReports.createTest("Ziyaretçi olarak Listing sayfasindan bir ürüne tiklayip ürün sayfasinin alt kisminda bulunan yorum kismi doldurulup gönderilebilmesi testi.");

        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Hause Heaven ana sayfasına gidildi.");

        BunyaminPage bunyaminPage = new BunyaminPage();
        HomePage homePage = new HomePage();

        homePage.listingButonu.click();
        ReusableMethods.wait(1);
        extentTest.pass("Listing basligina tiklandi.");

        bunyaminPage.listingUrunIsim.click();
        extentTest.pass("Listing'de urune tiklandi.");

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,3200);");
        extentTest.pass("Sayfada yorum kismina inildi.");

        SoftAssert softAssert=new SoftAssert();

        try { bunyaminPage.urunYorumMesajKutusu.sendKeys("Yorum Mesaji");
        } catch (ElementNotInteractableException e) {
            System.out.println("Mesaj yazilamadi: " + e.getMessage());
        }
        extentTest.fail("Yorum mesaji yazilamadi.");

        bunyaminPage.yorumMesajKutusuSubmitButonu.click();
        extentTest.fail("Yorum mesaji gonderilemedi.");

        softAssert.assertAll();

        Driver.quitDriver();
        extentTest.pass("Driver kapatildi.");



    }
}
