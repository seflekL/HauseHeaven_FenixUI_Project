package java.tests.US_037;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TeamPages.MustafaPage;
import utilities.*;

import java.time.Duration;

import static utilities.Driver.driver;

public class TC_MI013 extends TestBaseRapor {

    @Test
    public void test13(){

        extentTest = extentReports.createTest("Features sayfasında özellikleri görüntüleme ve yeni özellik ekleme testi");

        MustafaMethods.adminPageLogin(ConfigReader.getProperty("MIadminUsername"),ConfigReader.getProperty("MIadminPassword"));

        MustafaPage mustafaPage = new MustafaPage();

        mustafaPage.adRealEstateTitle.click();
        mustafaPage.adRealEstateFeatures.click();
        extentTest.pass("Features sayfasına gidildi.");

        Assert.assertTrue(mustafaPage.featuresTest.isDisplayed());
        extentTest.pass("Eklemiş olduğumuz Features Test isimli özellik görüntülendi.");

        Assert.assertFalse(mustafaPage.featuresEditButonuList.isEmpty());
        extentTest.pass("Özelliklerin yanlarındaki edit butonları görüntülendi");

        mustafaPage.featuresIlkOzellikEditButonu.click();
        extentTest.pass("Ilk özellik edit butonu tıklandı.");

        mustafaPage.featuresCreateTitleTextBox.clear();

        mustafaPage.featuresCreateTitleTextBox.sendKeys("Edited Title");
        extentTest.pass("Title değiştirildi.");

        Select select = new Select(mustafaPage.featuresCreateIconDropdownBox);
        select.selectByValue("ti-google");
        extentTest.pass("Yeni icon seçildi.");

        mustafaPage.featuresSaveExitButonu.click();
        extentTest.pass("Save & Exit butonu tıklandı.");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(mustafaPage.featuresAlertBox));

        String exceptedAlertText = "×\n" +
                "Success!\n" +
                "Updated successfully";
        String actualAlertText = mustafaPage.featuresAlertBox.getText();

        Assert.assertEquals(actualAlertText,exceptedAlertText);
        extentTest.pass("Özelliğin düzenlendiği alert üzerinden doğrulandı.");

        String exceptedUrl = "https://qa.hauseheaven.com/admin/real-estate/property-features";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl,exceptedUrl);
        extentTest.pass("Features sayfasına döndüğümüz url üzerinden doğrulandı.");

        Assert.assertTrue(mustafaPage.featuresIlkOzellikDeleteButonu.isDisplayed());
        extentTest.pass("Delete butonu görüntülendi.");

        mustafaPage.featuresIlkOzellikDeleteButonu.click();
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
