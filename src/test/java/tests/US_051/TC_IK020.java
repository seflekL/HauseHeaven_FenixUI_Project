package tests.US_051;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TeamPages.IsmailPage;
import utilities.*;

import java.time.Duration;

public class TC_IK020 extends TestBaseRapor {

    @Test
    public void test05() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

        extentTest = extentReports.createTest("Kullanıcı olarak siteye giriş yapıp kendi sayfam üzerinden credi satın alma sayfasına bir kaç gerekli alanı boş bıraktığımda hata mesajı almalıyım");
        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Kullanıcı Hause Heaven sayfasına erişir");

        IsmailPage ismailPage = new IsmailPage();

        if (ismailPage.allowCookies.isDisplayed()) {
            ismailPage.allowCookies.click();
            extentTest.pass("Ziyaretçi sitede bulunan cookies'i kabul eder");
        }
        ismailPage.signInButonu.click();
        extentTest.pass("Kullanıcı header bölümünde yer alan Sign In butonuna basar");

        IsmailMethods.hauseHeavenLogin(ismailPage,"ismailkaya@hauseheaven.com","Hven.150820");

        ismailPage.usernamePage.click();
        extentTest.pass("Kullanıcı kendi profil sayfasına erişir");
        ismailPage.buyCredit.click();
        extentTest.pass("Kullanıcı yan menüde bulunan Buy credits butonuna basar");
        ismailPage.besPostsCell.click();
        ReusableMethods.bekle(2);
        ReusableMethods.erisimTesti("https://qa.hauseheaven.com/account/packages/3/subscribe");
        extentTest.pass("Kullanıcı Ödeme sayfasına eriştiğini doğrular");

        String name = "İsmail Kaya";

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("stripe-number")));

        jse.executeScript("window.scrollTo(0, 100);");

        ismailPage.cardNumber.sendKeys("4242424242424242");
        extentTest.pass("Kullanıcı Card number textbox'a belirlenmiş kart numarasını girer");
        extentTest.info("4242 4242 4242 4242");
        ismailPage.ayYil.sendKeys("0229");
        extentTest.pass("Kullanıcı MM/YY textbox'a belirlenmiş tarih numarasını girer");
        extentTest.info("02/29");
        ismailPage.checkoutButonu.click();
        extentTest.pass("Kullanıcı Checkout butonuna basarak işlemi onaylar");

        WebElement alertMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alert-container")));

        String expectedMessage = "You must collect the security code (CVC) for this card from the cardholder before you can use it." +
                " For more information, see https://support.stripe.com/questions/cvc-collection-requirements";
        String actualMessage = alertMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage);
        extentTest.pass("Kullanıcı hata mesajının oldugu alert'te çıkan yazıyı doğrular");
    }
}
