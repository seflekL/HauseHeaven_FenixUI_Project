package tests.US_038;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TeamPages.MustafaPage;
import utilities.*;

import java.time.Duration;

import static utilities.Driver.driver;

public class TC_MI017 extends TestBaseRapor {

    @Test
    public void test17(){

        extentTest = extentReports.createTest("Facilities sayfasında özellikleri görüntüleme ve yeni özellik ekleme testi");

        MustafaMethods.adminPageLogin(ConfigReader.getProperty("MIadminUsername"),ConfigReader.getProperty("MIadminPassword"));

        MustafaPage mustafaPage = new MustafaPage();

        mustafaPage.adRealEstateTitle.click();
        mustafaPage.adRealEstateFacilities.click();
        extentTest.pass("Facilities sayfasına gidildi.");

        Assert.assertTrue(mustafaPage.facilitiesTest.isDisplayed());
        extentTest.pass("Eklemiş olduğumuz Facilities Test isimli özellik görüntülendi.");

        Assert.assertFalse(mustafaPage.facilitiesEditButonuList.isEmpty());
        extentTest.pass("Özelliklerin yanlarındaki edit butonları görüntülendi");

        mustafaPage.facilitiesIlkOzellikEditButonu.click();
        extentTest.pass("Ilk özellik edit butonu tıklandı.");

        mustafaPage.facilitiesCreateTitleTextBox.clear();

        mustafaPage.facilitiesCreateTitleTextBox.sendKeys("Edited Title");
        extentTest.pass("Title değiştirildi.");

        Select select = new Select(mustafaPage.facilitiesCreateIconDropdownBox);
        select.selectByValue("ti-google");
        extentTest.pass("Yeni icon seçildi.");

        mustafaPage.facilitiesSaveExitButonu.click();
        extentTest.pass("Save & Exit butonu tıklandı.");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(mustafaPage.facilitiesAlertBox));

        String exceptedAlertText = "×\n" +
                "Success!\n" +
                "Updated successfully";
        String actualAlertText = mustafaPage.facilitiesAlertBox.getText();

        Assert.assertEquals(actualAlertText,exceptedAlertText);
        extentTest.pass("Özelliğin düzenlendiği alert üzerinden doğrulandı.");

        String exceptedUrl = "https://qa.hauseheaven.com/admin/real-estate/facilities";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl,exceptedUrl);
        extentTest.pass("Facilities sayfasına döndüğümüz url üzerinden doğrulandı.");

        Assert.assertTrue(mustafaPage.facilitiesIlkOzellikDeleteButonu.isDisplayed());
        extentTest.pass("Delete butonu görüntülendi.");

        mustafaPage.facilitiesIlkOzellikDeleteButonu.click();
        extentTest.pass("Düzenlenen özelliğin satırındaki delete butonuna tıklandı.");

        Assert.assertTrue(mustafaPage.alertDeleteButonu.isEnabled());
        extentTest.pass("Çıkan alertte delete butonu görüntülendi.");

        mustafaPage.alertDeleteButonu.click();
        extentTest.pass("Alert üzerindeki delete butonu tıklandı.");

        ReusableMethods.wait(1);

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait2.until(ExpectedConditions.visibilityOf(mustafaPage.alertDeleteText));

        String exceptedDeleteAlertText = "×\n" +
                "Success!\n" +
                "Deleted successfully";
        String actualDeleteAlertText = mustafaPage.alertDeleteText.getText();

        Assert.assertEquals(actualDeleteAlertText,exceptedDeleteAlertText);
        extentTest.pass("Alert üzerinden silindiği doğrulandı.");

        Driver.getDriver().quit();
        extentTest.pass("Driver kapatıldı.");

    }
}
