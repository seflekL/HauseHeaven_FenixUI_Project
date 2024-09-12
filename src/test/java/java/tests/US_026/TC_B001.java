package java.tests.US_026;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TeamPages.BunyaminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.time.Duration;

public class TC_B001 extends TestBaseRapor {

    @Test
    public void Test09(){

        extentTest = extentReports.createTest("Kullanici ana sayfaya gidip Sign In butonunu erişim sağlayıp kullanıcı girişi yapabilme testi.");
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

        Driver.quitDriver();
        extentTest.pass("Driver kapatildi.");

    }

}
