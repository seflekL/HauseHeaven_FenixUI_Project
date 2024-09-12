package java.tests.US_011;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_ME03 extends TestBaseRapor {

    @Test
    public void test03(){

        HomePage homePage=new HomePage();
        extentTest =extentReports.createTest("Mesaj gönderme formunda zorunlu alanlardan en az biri bos bırakıldığında yada yanlış giriş yapıldığında uyarı mesajının görüntülenmesi testi");

        extentTest .pass(" Ziyaretçi HauseHeaven url girer.");
        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));

        extentTest .pass(" Ziyaretçi HauseHeaven anasayfa header a ulaşır.");
        Assert.assertTrue(homePage.hauseheavenlogo.isDisplayed());

        extentTest .pass("Ziyaretçi Contact linkine tıklar.");
        homePage.contactlinkibutonu.click();

        extentTest .pass(" Ziyaretçi Contact sayfasına ulaşır.");
        ReusableMethods.hover(homePage.contactdırections);
        Assert.assertTrue(homePage.contactgetıntuchelementı.isDisplayed());

        extentTest .pass(" Ziyaretçi mesaj gönderebilmek için sadece name kutusuna isim , mesaj kuttusuna mesajını yazar ve emal kısmını yanlış girerek send messaje butonuna tıklar");
       homePage.contactnamekutusuElementi.sendKeys("sevde");
       homePage.contactemailkutusElementi.sendKeys("sevde.com");
       homePage.contactmesajkutusuElementi.sendKeys("ilanınız hakkında bilgi almak istiyorum");

        homePage.contactsendmeesagebutonu.click();
        ReusableMethods.bekle(10);
        extentTest .pass("Ziyaretçi The email address is not valid penseresini gordüğünde mesajın gonderilemediğini doğrular.");

        Assert.assertTrue(homePage.contactmessageerror.isDisplayed());

        extentTest .pass("Ziyaretçi açılan sekmeyi kapatır.");

        Driver.getDriver().quit();


    }

}
