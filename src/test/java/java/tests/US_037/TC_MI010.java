package java.tests.US_037;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TeamPages.MustafaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC_MI010 extends TestBaseRapor {

    @Test
    public void test10(){

        extentTest = extentReports.createTest("Admin dashboard erişim testi.");

        Driver.getDriver().get(ConfigReader.getProperty("hauseAdminUrl"));
        extentTest.pass("Hause Heaven admin sayfasına gidildi.");

        MustafaPage mustafaPage = new MustafaPage();

        Assert.assertTrue(mustafaPage.adminEmailTextBox.isDisplayed());
        extentTest.pass("Email kutusu görüntülendi");

        Assert.assertTrue(mustafaPage.adminPasswordTextBox.isDisplayed());
        extentTest.pass("Password kutusu görüntülendi");

        mustafaPage.adminEmailTextBox.sendKeys(ConfigReader.getProperty("MIadminUsername"));
        mustafaPage.adminPasswordTextBox.sendKeys(ConfigReader.getProperty("MIadminPassword"));
        extentTest.pass("Email ve password bilgileri girildi.");

        mustafaPage.adminSigninButonu.click();
        extentTest.pass("Sign in butonu tıklandı.");

        String expectedText = "Dashboard";
        String actualText = mustafaPage.adminDashboardText.getText();

        Assert.assertEquals(actualText,expectedText);
        extentTest.pass("Dashboard yazısı görüntülendi ve giriş yapıldığı doğrulandı.");

        Driver.getDriver().quit();
        extentTest.pass("Driver kapatıldı.");






    }
}
