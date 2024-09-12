package java.tests.US_008;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TeamPages.IsmailPage;
import utilities.*;

import java.time.Duration;
import java.util.List;

public class TC_03 extends TestBaseRapor {

    @Test
    public void test01() {
        extentTest = extentReports.createTest("Ziyaretçi olarak Prejects sayfasındaki proje detaylarını görüntüleyebilmek istiyorum");
        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Ziyaretçi Hause Heaven sayfasına erişir");

        IsmailPage ismailPage = new IsmailPage();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        Actions actions = new Actions(Driver.getDriver());

        ismailPage.allowCookies.click();
        extentTest.pass("Ziyaretçi sitede bulunan cookies'i kabul eder");
        ismailPage.homeProjectsButonu.click();
        extentTest.pass("Ziyaretçi header bölümünde yer alan Projects butonuna basar");

        js.executeScript("window.scrollBy(0, 500);");
        ReusableMethods.bekle(1);

        extentTest.pass("Ziyaretçi açılan proje sayfasında herhangi bir projeye tıklar");
        List<WebElement> projelerinDescription = Driver.getDriver().findElements(By.xpath("//*[@class='listing-short-description']"));
        extentTest.pass("Ziyaretçi projenin ismini doğrular");
        List<WebElement> projelerinLocation = Driver.getDriver().findElements(By.xpath("//*[@class='foot-location d-flex']"));
        extentTest.pass("Ziyaretçi projenin description'u doğrular;");
        List<WebElement> projeIsimleriBasliklari = Driver.getDriver().findElements(By.xpath("//*[@class='prt-link-detail text-uppercase']"));
        extentTest.pass("Ziyaretçi location'u doğrular;");
        extentTest.pass("Ziyaretçi diğer bilgileri doğrular");

        for (int i = 0; i < projeIsimleriBasliklari.size(); i++) {
            IsmailMethods.checkElementVisibility(projeIsimleriBasliklari, i);
            IsmailMethods.checkElementVisibility(projelerinDescription, i);
            IsmailMethods.checkElementVisibility(projelerinLocation, i);

            IsmailMethods.clickAndVerifyDetails(projeIsimleriBasliklari, i);

            if (i == 2 || i == 5 || i == 8) {  // 3'erli gruplarda kaydır
                actions.sendKeys(Keys.PAGE_DOWN).perform();
                ReusableMethods.bekle(1);
            }
        }

        Driver.quitDriver();
        extentTest.pass("Ziyaretçi browser'ı kapatır.");
    }

}
