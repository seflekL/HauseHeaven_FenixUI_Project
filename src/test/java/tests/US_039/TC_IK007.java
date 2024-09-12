package tests.US_039;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import pages.TeamPages.IsmailPage;
import utilities.*;

import java.time.Duration;
import java.util.List;

public class TC_IK007 extends TestBaseRapor {

    @Test
    public void test01() {
        extentTest = extentReports.createTest("Admin olarak giriş yapıp Real Estate başlığının altındaki Investors sayfasında mevcut yatırımcıları görüntülemek istiyorum");
        Driver.getDriver().get(ConfigReader.getProperty("hauseAdminUrl"));
        ReusableMethods.erisimTesti(ConfigReader.getProperty("hauseAdminUrl"));
        extentTest.pass("Admin admin sayfasına erişir");
        IsmailPage ismailPage = new IsmailPage();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        IsmailMethods.hauseHeavenAdminLogin(ismailPage,"ismailkaya.admin@hauseheaven.com","Hven.150820");

        /*
        adminDashboard.usernameTextbox.sendKeys("ismailkaya.admin@hauseheaven.com");
        extentTest.pass("Admin Email/Username textbox'a belirlenmiş email'i girer");
        extentTest.info("ismailkaya.admin@hauseheaven.com");
        adminDashboard.passwordAdminTextbox.sendKeys("Hven.150820");
        extentTest.pass("Admin Password textbox'a belirlenmiş password girer");
        extentTest.info("Hven.150820");
        adminDashboard.signInButonu.click();
        extentTest.pass("Admin Sign In Butonuna basar");
         */

        ismailPage.realEstateButonu.click();
        extentTest.pass("Admin Real Estate Butonuna basar");
        ismailPage.investorsButonu.click();
        extentTest.pass("Admin açılan menüdeki Investors Butonuna basar");
        ReusableMethods.erisimTesti("https://qa.hauseheaven.com/admin/real-estate/investors");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]")));
        List<WebElement> yatirimcilar = Driver.getDriver().findElements(By.xpath("//tbody/tr[*]"));

        for (WebElement each : yatirimcilar){
            Assert.assertTrue(each.isDisplayed());
        }

        extentTest.pass("Admin mevcut yatırımcıları görüntüler");

        Driver.quitDriver();
        extentTest.pass("Admin browser'ı kapatır.");
    }

}

