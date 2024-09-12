package java.tests.US_011;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_ME02CrossBrowser extends TestBaseRapor {
    @Test
    public void test02(){

        HomePage homePage=new HomePage();
        extentTest =extentReports.createTest("Mesaj gönderebilmek için gereklı alanları doldurup mesaj göndermenin başarılı oldugu testi.");

        extentTest .pass(" Ziyaretçi HauseHeaven url girer.");

        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest .pass(" Ziyaretçi HauseHeaven anasayfa header a ulaşır");
        Assert.assertTrue(homePage.hauseheavenlogo.isDisplayed());

        extentTest .pass("Ziyaretçi Contact likine tıklar .");
        homePage.contactlinkibutonu.click();

        extentTest .pass("Ziyaretçi Contact sayfasına ulaşır.");
        ReusableMethods.hover(homePage.contactdırections);
        extentTest .pass ("Ziyaretçi mesaj gönderebilmek için name kutusuna isim ,subject kutusuna soyisim , email kutusuna email,phone kutusuna telefon numarası ve mesaj alanına göndermek istediği mesajı girer.");
        homePage.contactnamekutusuElementi.sendKeys("elif");
        homePage.contactemailkutusElementi.sendKeys("elif@gmail.com");
        homePage.contactphonekutusuElementi.sendKeys("05554443322");
        homePage.contactsubjectkutusuElementi.sendKeys("demir");
        homePage.contactmesajkutusuElementi.sendKeys("ilanınız hakkında bilgi almak istiyorum");
        extentTest .pass(" Ziyaretçi mesajı göndermek için send message butonuna tıklar.");
        homePage.contactsendmeesagebutonu.click();
        ReusableMethods.bekle(10);

        extentTest .pass(" ziyaretçi send mesaage succezfully penceresini görmesiyle mesajının gönderildiğini doğrular.");
        Assert.assertTrue(homePage.contactmessagesuccessfully.isDisplayed());

        extentTest .pass(" Ziyaretçi açilan sekmeyi kapatır.");
        Driver.getDriver().quit();

    }
}
