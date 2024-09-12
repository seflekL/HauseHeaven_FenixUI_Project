package tests.US_026;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TeamPages.BunyaminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.time.Duration;

public class TC_B002 extends TestBaseRapor {

    @Test
    public void Test10(){

        extentTest = extentReports.createTest("Kullanıcı ana sayfaya gidip kullanıcı girişi yapıp footer kısmına erişip Contact us bağlantısına tıklayıp iletişim bilgilerine erişim testi.");
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

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,10000);");
        bunyaminPage.footerContactUs.isDisplayed();
        bunyaminPage.footerContactUs.click();
        extentTest.pass("footer kısmına inilip contact us başlığı görüntülendi ve tıklandı.");

        bunyaminPage.contactGetInTouch.isDisplayed();
        extentTest.pass("iletişim bilgileri görüntülendi.");

        Driver.quitDriver();
        extentTest.pass("Driver kapatildi.");

    }

}
