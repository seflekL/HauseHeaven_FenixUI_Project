package java.tests.US_008;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TeamPages.IsmailPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.List;

public class TC_01 extends TestBaseRapor {

    @Test
    public void test01(){
        extentTest = extentReports.createTest("Ziyaretçi olarak Prejects sayfasındaki proje sayısını görüntüleyebilmek istiyorum");
        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Ziyaretçi Hause Heaven sayfasına erişir");

        IsmailPage ismailPage = new IsmailPage();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        ismailPage.allowCookies.click();
        extentTest.pass("Ziyaretçi sitede bulunan cookies'i kabul eder");
        ismailPage.homeProjectsButonu.click();
        extentTest.pass("Ziyaretçi header bölümünde yer alan Projects butonuna basar");

        String projeString = ismailPage.projeSayisiElementi.getText();

        projeString = projeString.replaceAll("\\D","");
        projeString = projeString.substring(projeString.length() - 1);
        int projeSayisi = Integer.parseInt(projeString);

        Assert.assertTrue(ismailPage.projeSayisiElementi.isDisplayed());

        js.executeScript("window.scrollBy(0, 300);");

        List<WebElement> projeIsimleriBasliklari = Driver.getDriver().findElements(By.xpath("//*[@class='prt-link-detail text-uppercase']"));
        List<String> stringList = ReusableMethods.getStringList(projeIsimleriBasliklari);

        int expectedSayi = projeSayisi;
        int actualSayi = stringList.size();

        Assert.assertEquals(actualSayi, expectedSayi);
        extentTest.pass("Ziyaretçi proje sayısını görüntüler ve doğrular");

        Driver.quitDriver();
        extentTest.pass("Ziyaretçi browser'ı kapatır.");
    }

}
