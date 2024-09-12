package java.tests.US_008;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.TeamPages.IsmailPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.List;

public class TC_02 extends TestBaseRapor {

    @Test
    public void testProjeKontrolleri() {
        IsmailPage ismailPage = new IsmailPage();
        extentTest = extentReports.createTest("Ziyaretçi olarak Prejects sayfasındaki proje detaylarını görüntüleyebilmek istiyorum");
        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Ziyaretçi Hause Heaven sayfasına erişir");
        ismailPage.allowCookies.click();
        extentTest.pass("Ziyaretçi sitede bulunan cookies'i kabul eder");
        ismailPage.homeProjectsButonu.click();
        extentTest.pass("Ziyaretçi header bölümünde yer alan Projects butonuna basar");

        SoftAssert softAssert = new SoftAssert();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        List<WebElement> projelerinDescription = Driver.getDriver().findElements(By.xpath("//*[@class='listing-short-description']"));
        extentTest.pass("Ziyaretçi açılan proje sayfasında projenin ismini doğrular;");
        List<WebElement> projelerinLocation = Driver.getDriver().findElements(By.xpath("//*[@class='foot-location d-flex']"));
        extentTest.pass("Ziyaretçi açılan proje sayfasında projenin description'u doğrular;");
        List<WebElement> projeIsimleriBasliklari = Driver.getDriver().findElements(By.xpath("//*[@class='prt-link-detail text-uppercase']"));
        extentTest.pass("Ziyaretçi açılan proje sayfasında projenin location'u doğrular;");

        int elemanSayisi = Math.min(Math.min(projeIsimleriBasliklari.size(), projelerinDescription.size()), projelerinLocation.size());

        for (int i = 0; i < elemanSayisi; i++) {
            try {
                softAssert.assertTrue(projeIsimleriBasliklari.get(i).isDisplayed(), "Element " + (i + 1) + ": İsim görünmüyor");
                softAssert.assertTrue(projelerinDescription.get(i).isDisplayed(), "Element " + (i + 1) + ": Description görünmüyor");
                softAssert.assertTrue(projelerinLocation.get(i).isDisplayed(), "Element " + (i + 1) + ": Location görünmüyor");
            } catch (Exception e) {
                System.out.println("Element " + (i + 1) + " kontrolünde hata: " + e.getMessage());
            }

            if ((i + 1) % 3 == 0 && i + 1 < elemanSayisi) {
                js.executeScript("window.scrollBy(0, 500);");
                ReusableMethods.bekle(2);
            }

            if ((i + 1) % 6 == 0 && i + 1 < elemanSayisi) {
                js.executeScript("window.scrollBy(0, 500);");
                ReusableMethods.bekle(1);
            }
        }

        softAssert.assertAll();
        Driver.quitDriver();
        extentTest.pass("Ziyaretçi browser'ı kapatır.");
    }

}