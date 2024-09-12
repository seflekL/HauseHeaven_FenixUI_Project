package java.tests.US_026;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TeamPages.BunyaminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.time.Duration;

import static utilities.Driver.driver;

public class TC_B005 extends TestBaseRapor {

    @Test
    public void Test13(){

        extentTest = extentReports.createTest("Kullanıcı ana sayfaya gidip kullanıcı girişi yapıp header kısmındaki Contact başlığına tıklayıp Reach Us kısmındaki adres ile Directions kısmındaki adresin aynı olması testi.");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Hause Heaven ana sayfasına gidildi.");

        HomePage homePage = new HomePage();
        BunyaminPage bunyaminPage = new BunyaminPage();

        homePage.signinButonu.click();
        extentTest.pass("Ana sayfada sign in butonuna tıklandı.");

        homePage.emailTextbox.sendKeys("bunyaminsait");
        homePage.passwordTextbox.sendKeys("Hven.150820");
        homePage.loginButonu.click();
        extentTest.pass("email ve password doldurulup login butonuna basılarak giriş yapıldı.");

        homePage.contactButonu.isDisplayed();
        homePage.contactButonu.click();
        extentTest.pass("header kısmında contact başlığı görüntülendi ve tıklandı.");

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,450);");

        String actualAdres = bunyaminPage.contactReachUsAdres.getText();


        Driver.getDriver().switchTo().frame(0);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(bunyaminPage.contactHaritaUzeriAdres));

        String expectedAdres = bunyaminPage.contactHaritaUzeriAdres.getText();

        Assert.assertTrue(actualAdres.contains(expectedAdres));
        extentTest.pass("Harita adresi ve ReachUs Adresi eşleşiyor.");

        Driver.quitDriver();
        extentTest.pass("Driver kapatildi.");

    }

}
