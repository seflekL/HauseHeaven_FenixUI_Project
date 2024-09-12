package tests.US_037;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TeamPages.MustafaPage;
import utilities.*;

import java.time.Duration;

import static utilities.Driver.driver;

public class TC_MI012 extends TestBaseRapor {

    @Test
    public void test12(){

        extentTest = extentReports.createTest("Features sayfasında özellikleri görüntüleme ve yeni özellik ekleme testi");

        MustafaMethods.adminPageLogin(ConfigReader.getProperty("MIadminUsername"),ConfigReader.getProperty("MIadminPassword"));

        MustafaPage mustafaPage = new MustafaPage();

        mustafaPage.adRealEstateTitle.click();
        mustafaPage.adRealEstateFeatures.click();
        extentTest.pass("Features sayfasına gidildi.");

        Assert.assertFalse(mustafaPage.featuresPageFeaturesList.isEmpty());
        extentTest.pass("Özellikler görüntülendi.");
        Assert.assertTrue(mustafaPage.featuresCreateButonu.isDisplayed());
        extentTest.pass("Create butonu görüntülendi.");

        mustafaPage.featuresCreateButonu.click();
        extentTest.pass("Create butonu tıklandı.");

        Assert.assertTrue(mustafaPage.featuresCreateTitleTextBox.isDisplayed());
        extentTest.pass("Title text box görüntülendi.");

        mustafaPage.featuresCreateTitleTextBox.sendKeys("Features Test");
        extentTest.pass("Features başlığı girildi.");

        Assert.assertTrue(mustafaPage.featuresCreateIconDropdownBox.isDisplayed());
        extentTest.pass("Icon dropdown kutusu görüntülendi.");

        Select select = new Select(mustafaPage.featuresCreateIconDropdownBox);
        select.selectByValue("ti-github");
        extentTest.pass("Github iconu seçildi.");

        Assert.assertTrue(mustafaPage.featuresSaveExitButonu.isDisplayed());
        extentTest.pass("Save & Exit butonu görüntülendi.");

        mustafaPage.featuresSaveExitButonu.click();
        extentTest.pass("Save & Exit butonu tıklandı.");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(mustafaPage.featuresAlertBox));

        String exceptedAlertText = "×\n" +
                "Success!\n" +
                "Created successfully";
        String actualAlertText = mustafaPage.featuresAlertBox.getText();

        Assert.assertEquals(actualAlertText,exceptedAlertText);
        extentTest.pass("Yeni bir özellik oluşturulduğu alert üzerinden doğrulandı.");

        String exceptedUrl = "https://qa.hauseheaven.com/admin/real-estate/property-features";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl,exceptedUrl);
        extentTest.pass("Features sayfasına döndüğümüz url üzerinden doğrulandı.");

        Driver.getDriver().quit();
        extentTest.pass("Driver kapatıldı.");






    }
}
