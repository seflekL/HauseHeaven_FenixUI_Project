package tests.US_007;

import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TeamPages.BunyaminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.time.Duration;

import static utilities.Driver.driver;
import static utilities.TestBaseRapor.extentReports;

public class TC_B005 extends TestBaseRapor {

    @Test
    public void test05(){

        extentTest = extentReports.createTest("Ziyaretçi olarak Listing sayfasindan bir ürüne tiklayip mesaj kutucuğunun görüntülenip, doldurulup gönderilme testi.");

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
        js.executeScript("window.scrollBy(0,700);");
        Assert.assertTrue(bunyaminPage.urunSahibiMesajKutusu.isDisplayed());
        extentTest.pass("Sayfada mesaj kismina inildi ve görüntülendi.");

        Faker faker = new Faker();

        bunyaminPage.mesajKutusuName.sendKeys(faker.name().fullName());
        bunyaminPage.mesajKutusuPhone.sendKeys(faker.phoneNumber().cellPhone());
        bunyaminPage.mesajKutusuEmail.sendKeys(faker.internet().emailAddress());
        bunyaminPage.mesajKutusuMessage.sendKeys("ilan icin son fiyat nedir ?");
        bunyaminPage.mesajSendButonu.click();
        extentTest.pass("Mesaj formu dolduruldu.");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(bunyaminPage.mesajGonderildiAlert));

        String exeptedAlert="Send consult successfully!";
        String actualAlert=bunyaminPage.mesajGonderildiAlert.getText();
        Assert.assertEquals(actualAlert,exeptedAlert);
        extentTest.pass("Mesaj gonderildi ve gonderildi bildirimi geldi.");

        Driver.quitDriver();
        extentTest.pass("Driver kapatıldı.");





    }


}
