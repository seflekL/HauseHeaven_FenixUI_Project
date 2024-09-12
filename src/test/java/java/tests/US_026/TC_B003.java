package java.tests.US_026;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TeamPages.BunyaminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.time.Duration;

public class TC_B003 extends TestBaseRapor {

    @Test
    public void Test11(){

        extentTest = extentReports.createTest("Kullanıcı ana sayfaya gidip kullanıcı girişi yapıp header kısmındaki Contact başlığına tıklayıp iletişim bilgilerine erişim testi.");
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

        bunyaminPage.contactGetInTouch.isDisplayed();
        extentTest.pass("iletişim bilgileri görüntülendi.");

        Driver.quitDriver();
        extentTest.pass("Driver kapatildi.");

    }

}
