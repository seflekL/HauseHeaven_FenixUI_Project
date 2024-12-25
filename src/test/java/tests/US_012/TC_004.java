package tests.US_012;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.time.Duration;

public class TC_004 extends TestBaseRapor {

    @Test
    public void registerNewUserTest() {

        extentTest = extentReports.createTest
                ("Siteye kayıt olma testi");
        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Tarayici acildi ve Hause Heaven sitesine gidildi.");
        HomePage homePage = new HomePage();
        homePage.signupButonu.click();
        extentTest.pass("Kullanıcı sign up butonuna tıklar.");

      homePage.registerSayfasiFirstNameKutusu.sendKeys("Dilek");
      homePage.registerSayfasiLastNameKutusu.sendKeys("Şengül");
      homePage.registerSayfasiEmailKutusu.sendKeys("dileksengul@hauseheaven.com");
      homePage.registerSayfasiUsernameKutusu.sendKeys("Dilek Şengül ");
      homePage.registerSayfasiPasswordKutusu.sendKeys("Hven.150820");
      homePage.registerSayfasiConfirmPasswordKutusu.sendKeys("Hven.150820");

        extentTest.pass("Kayıt formu dolduruldu.");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

       homePage.registerSayfasiRegisterButonu.click();

       homePage.loginButonu.click();
        extentTest.pass("Login butonu tıklandı.");

        Assert.assertTrue(homePage.logoutButonu.isDisplayed());
        extentTest.pass("Logout butonu görüntülenerek giriş yapıldığı doğrulandı.");
        homePage.kulaniciLogoutButonu.click();
        extentTest.pass("Logout butonu tıklandı.");
        extentTest.pass("Logout butonu tıklanarak çıkış yapıldığı doğrulandı.");

        Driver.getDriver().quit();
        extentTest.pass("Tarayıcı kapatıldı.");
    }
}