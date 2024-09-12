package java.tests.US_015;

import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.*;

import java.time.Duration;

import static utilities.Driver.driver;

public class TC_MI007 extends TestBaseRapor {

    @Test
    public void test07(){

        extentTest = extentReports.createTest("Kullanıcı bilgileri güncelleme testi");

        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Tarayıcı açıldı ve hause heaven web sitesine gidildi.");

        MustafaMethods.hauseHeavenLogin(ConfigReader.getProperty("MIusername"),ConfigReader.getProperty("MIpassword"));

        HomePage homePage =new HomePage();

        homePage.accountDashboardButonu.click();
        extentTest.pass("Account dashboard butonu tıklandı.");

        Assert.assertTrue(homePage.accountDashboardSettingsButonu.isDisplayed());
        extentTest.pass("Settings butonu görüntülendi.");

        homePage.accountDashboardSettingsButonu.click();
        extentTest.pass("Settings butonu tıklandı.");

        String exceptedUrl = "https://qa.hauseheaven.com/account/settings";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl,exceptedUrl);
        extentTest.pass("Settings sayfasında olduğu URL üzerinden doğrulandı.");

        Faker faker = new Faker();

        homePage.adSettingsPhoneTextBox.clear();
        homePage.adSettingsPhoneTextBox.sendKeys(faker.phoneNumber().cellPhone());
        extentTest.pass("Phone text box'ı dolduruldu.");

        Assert.assertTrue(homePage.adSettingsSaveButonu.isEnabled());
        extentTest.pass("Save butonunun erişilir olduğu doğrulandı.");

        homePage.adSettingsSaveButonu.click();
        extentTest.pass("Save butonu tıklandı.");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(homePage.alert));

        String alertMessageText = homePage.alert.getText();
        String exceptedMessageText = "Update profile successfully!";


        Assert.assertEquals(alertMessageText,exceptedMessageText);


    }

}
