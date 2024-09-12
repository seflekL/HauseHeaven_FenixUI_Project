package tests.US_008;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TeamPages.IsmailPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.time.Duration;
import java.util.List;

public class TC_04 extends TestBaseRapor {

    @Test
    public void test03() {
        extentTest = extentReports.createTest("Ziyaretçi olarak Prejects sayfasındaki ilgili projete ulaşmak için filtreleme yapmala");
        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Ziyaretçi Hause Heaven sayfasına erişir");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        IsmailPage ismailPage = new IsmailPage();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        ismailPage.allowCookies.click();
        extentTest.pass("Ziyaretçi sitede bulunan cookies'i kabul eder");
        ismailPage.homeProjectsButonu.click();
        extentTest.pass("Ziyaretçi header bölümünde yer alan Projects butonuna basar");


        Select select =new Select(ismailPage.countryDropbox);
        select.selectByVisibleText("Azerbaycann");
        extentTest.pass("Ziyaretçi filtreleme kısmından Country seçer ");

        ismailPage.stateDropbox.click();
        String stateIsmi = "No results found";
        String actualIsim = ismailPage.elementBulunmuyor.getText();
        Assert.assertEquals(stateIsmi,actualIsim);
        extentTest.pass("Ziyaretçi filtreleme kısmından State seçer ");

        wait.until(ExpectedConditions.visibilityOf(ismailPage.categoryDropbox));
        ismailPage.cityDropbox.click();
        String cityIsmi = "No results found";
        String actualCityIsim = ismailPage.elementBulunmuyor.getText();
        Assert.assertEquals(cityIsmi,actualCityIsim);
        extentTest.pass("Ziyaretçi filtreleme kısmından City seçer ");

        Select categorySelect = new Select(ismailPage.categoryDropbox);
        categorySelect.selectByIndex(4);
        extentTest.pass("Ziyaretçi filtreleme kısmından Category seçer ");

        ismailPage.searchButonu.click();
        extentTest.pass("Ziyaretçi Search butonuna basar");

        js.executeScript("window.scrollBy(0, 300);");

        List<WebElement> sonucProjeListi = Driver.getDriver().findElements(By.className("prt-types"));
        List<String> sonucIsimleri = ReusableMethods.getStringList(sonucProjeListi);

        for (String each : sonucIsimleri){
            each.equals("House");
        }

        WebElement element = Driver.driver.findElement(By.xpath("(//*[@class='foot-location d-flex'])[1]"));
        Assert.assertEquals(element,"Azerbaycann");
        extentTest.pass("Ziyaretçi filtrelediği ile çıkan sonucu karşılaştırır");

        Driver.quitDriver();
        extentTest.pass("Ziyaretçi browser'ı kapatır.");
    }

}
