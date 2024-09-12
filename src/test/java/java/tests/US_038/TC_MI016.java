package java.tests.US_038;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TeamPages.MustafaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.MustafaMethods;
import utilities.TestBaseRapor;

import java.time.Duration;

import static utilities.Driver.driver;

public class TC_MI016 extends TestBaseRapor {

    @Test
    public void test16(){

        extentTest = extentReports.createTest("Facilities sayfasında özellikleri görüntüleme ve yeni özellik ekleme testi");

        MustafaMethods.adminPageLogin(ConfigReader.getProperty("MIadminUsername"),ConfigReader.getProperty("MIadminPassword"));

        MustafaPage mustafaPage = new MustafaPage();

        mustafaPage.adRealEstateTitle.click();
        mustafaPage.adRealEstateFacilities.click();
        extentTest.pass("Facilities sayfasına gidildi.");

        Assert.assertFalse(mustafaPage.facilitiesPageFacilitiesList.isEmpty());
        extentTest.pass("Özellikler görüntülendi.");
        Assert.assertTrue(mustafaPage.facilitiesCreateButonu.isDisplayed());
        extentTest.pass("Create butonu görüntülendi.");

        mustafaPage.facilitiesCreateButonu.click();
        extentTest.pass("Create butonu tıklandı.");

        Assert.assertTrue(mustafaPage.facilitiesCreateTitleTextBox.isDisplayed());
        extentTest.pass("Title text box görüntülendi.");

        mustafaPage.facilitiesCreateTitleTextBox.sendKeys("Facilities Test");
        extentTest.pass("Facilities başlığı girildi.");

        Assert.assertTrue(mustafaPage.facilitiesCreateIconDropdownBox.isDisplayed());
        extentTest.pass("Icon dropdown kutusu görüntülendi.");

        Select select = new Select(mustafaPage.facilitiesCreateIconDropdownBox);
        select.selectByValue("fa fa-american-sign-language-interpreting");
        extentTest.pass("fa fa-american-sign-language-interpreting iconu seçildi.");

        Assert.assertTrue(mustafaPage.facilitiesSaveExitButonu.isDisplayed());
        extentTest.pass("Save & Exit butonu görüntülendi.");

        mustafaPage.facilitiesSaveExitButonu.click();
        extentTest.pass("Save & Exit butonu tıklandı.");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(mustafaPage.facilitiesAlertBox));

        String exceptedAlertText = "×\n" +
                "Success!\n" +
                "Created successfully";
        String actualAlertText = mustafaPage.facilitiesAlertBox.getText();

        Assert.assertEquals(actualAlertText,exceptedAlertText);
        extentTest.pass("Yeni bir özellik oluşturulduğu alert üzerinden doğrulandı.");

        String exceptedUrl = "https://qa.hauseheaven.com/admin/real-estate/facilities";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl,exceptedUrl);
        extentTest.pass("Facilities sayfasına döndüğümüz url üzerinden doğrulandı.");

        Driver.getDriver().quit();
        extentTest.pass("Driver kapatıldı.");






    }
}
