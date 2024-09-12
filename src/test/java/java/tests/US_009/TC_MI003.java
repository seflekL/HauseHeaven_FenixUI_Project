package java.tests.US_009;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.time.Duration;

public class TC_MI003 extends TestBaseRapor {

    @Test
    public void test03(){

        extentTest = extentReports.createTest("Kayıtlı emlakçıların kutularında bilgileri görüntülenmesi testi");

        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Tarayıcı açıldı ve hause heaven web sitesine gidildi.");

        HomePage homePage = new HomePage();
        homePage.agentsButonu.click();
        extentTest.pass("Agents başlığına tıklandı ve gidildi");

        Assert.assertNotNull(homePage.agentsPageAllAgentsList);
        extentTest.pass("Kayıtlı emlakçılar listelendi");

        Assert.assertTrue(homePage.agentsPropertiesTextsList.isDisplayed());
        extentTest.pass("Emlakçıların ilan sayıları görüntülendi");

        Assert.assertTrue(homePage.agentsPhotoElementList.isDisplayed());
        extentTest.pass("Emlakçıların fotoğrafları görüntülendi");

        Assert.assertTrue(homePage.agentsPhoneNumberTextsList.isDisplayed());
        extentTest.pass("Telefon numaraları görüntülendi");

        Assert.assertTrue(homePage.agentsEmailTextsList.isDisplayed());
        extentTest.pass("Mail adresleri görüntülendi");

        Driver.getDriver().quit();
        extentTest.pass("Driver kapatıldı");
    }
}
