package java.tests.US_48;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_R027 extends TestBaseRapor {
    @Test
    public void Test01(){
        extentTest=extentReports.createTest
                ("Contact formunun doldurulup yanlis bir bilgi girildiginde uyari mesaji ciktiginin gorulmesi testi ");
        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Tarayici acildi ve Hause Heaven sitesine gidildi.");

        HomePage homePage = new HomePage();

        extentTest .pass(" Ziyaretci Hause Heaven sitesinde ana sayfa headera ulasir. " );
        Assert.assertTrue(homePage.hauseheavenlogo.isDisplayed());

        extentTest .pass ("Ziyaretci Contact linkine tiklar");
        homePage.contactlinkibutonu.click();

        extentTest .pass(" Ziyaretci Contact sayfasina ulasir.");
        Assert.assertTrue(homePage.contactgetıntuchelementı.isDisplayed());

        Assert.assertTrue(homePage.contactSayfasiContactYazisi.isDisplayed());
        extentTest .pass(" Ziyaretcinin contact sayfasinda olup olmaidgi dogrulanir.");

        homePage.contactSayfasiFormName.sendKeys("Rana Nur");
        extentTest .pass("Contact sayfasindaki formda name kutusuna Rana Nur yazilir.");
        ReusableMethods.bekle(3);

        homePage.contactSayfasiFormEmail.sendKeys("rananurulker");
        extentTest .pass("Contact sayfasindaki formda email kutusuna rananurulker yazilir.");
        ReusableMethods.bekle(3);

        homePage.contactSayfasiFormSubject.sendKeys("Ev hakkinda");
        ReusableMethods.bekle(3);
        extentTest .pass("Contact sayfasindaki formda subject kutusuna Ev hakkinda yazilir.");

        homePage.contactSayfasiFormPhone.sendKeys("25219963");
        extentTest .pass("Contact sayfasindaki formda phone kutusuna 25219963 yazilir.");
        ReusableMethods.bekle(3);

        homePage.contactSayfasiFormMessage.sendKeys("Bir ev almak istiyorum bu konu hakkinda danismanlik alabilecegim bir emlakciya yonlendirir misiniz?");
        extentTest .pass("Contact sayfasindaki formda message kutusuna Bir ev almak istiyorum bu konu hakkinda danismanlik alabilecegim bir emlakciya yonlendirir misiniz? yazilir.");
        ReusableMethods.bekle(3);

        homePage.contactSayfasiSendMessageButonu.click();
        extentTest .pass("Contact sayfasindaki formun sonundaki send message butonuna tiklanilir.");
        ReusableMethods.bekle(7);

        String expectedMessage="The email address is not valid";
        String actualMessage=homePage.contactSayfasiHataMesaji.getText();

        Assert.assertEquals(actualMessage,expectedMessage);
        extentTest .pass("Hatali giris yapildiginda cikan uyari beklenen ile ayni oldugu gorulur.");



        Driver.getDriver().quit();
        extentTest.pass("Ziyaretci browseri kapatir.");

    }
}
