package java.tests.US_026;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TeamPages.BunyaminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.time.Duration;

public class TC_B004 extends TestBaseRapor {

    @Test
    public void Test12(){

        extentTest = extentReports.createTest("Kullanıcı ana sayfaya gidip kullanıcı girişi yapıp header kısmındaki Contact başlığına tıklayıp mesaj şablonunu doldurup, gönderme testi.");
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
        extentTest.pass("header kısmına inilip contact us başlığı görüntülendi ve tıklandı.");

        Faker faker = new Faker();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,300);");
        bunyaminPage.contactMesajSablon.isDisplayed();
        extentTest.pass("Mesaj sablonu goruntulendi.");

        bunyaminPage.contactMesajName.sendKeys(faker.name().fullName());
        bunyaminPage.contactMesajEmail.sendKeys(faker.internet().emailAddress());
        bunyaminPage.contactMesajSubject.sendKeys("Subject");
        bunyaminPage.contactMesajPhone.sendKeys(faker.phoneNumber().cellPhone());
        bunyaminPage.contactMesajMessage.sendKeys("Message");
        bunyaminPage.contactSendMessage.click();
        extentTest.pass("Mesaj sablonu doldurup gonderildi.");

        Driver.quitDriver();
        extentTest.pass("Driver kapatildi.");

    }

}
