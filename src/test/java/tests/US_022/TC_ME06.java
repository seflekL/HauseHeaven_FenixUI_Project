package tests.US_022;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.javafaker.Faker;
import org.bouncycastle.pqc.crypto.util.PQCOtherInfoGenerator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_ME06 extends TestBaseRapor {

    @Test
    public void test04() {
        HomePage homePage = new HomePage();
        extentTest = extentReports.createTest(" mulk sayfasinda punlama ve mesaj gonderildigi testi");
        extentTest.pass("Kayıtlı kullancı HauseHeaven url girer.");
        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("  Kayıtlı kullanıcı HauseHeaven anasayfa header a ulaşır.");
        Assert.assertTrue(homePage.hauseheavenlogo.isDisplayed());
        homePage.signinButonu.click();
        homePage.singinemailbutonu.sendKeys("elif@gmail.com");
        homePage.singinpasswordbutonu.sendKeys("123456789.elif");
        homePage.singinloginbutonu.click();
        // ReusableMethods.bekle(2);
        homePage.kayitliKullaniciUserLinki.click();
        extentTest.pass("Login olduktan sonra cikan kayitli kullanici isminin oldugu linke tiklanir.");
        String unexpectedCreditBilgisi = "0 credits";
        String actualCreditBilgisi = homePage.ilanGirmeBuyCreditsKrediBilgisi.getText();
        if (unexpectedCreditBilgisi.equalsIgnoreCase(actualCreditBilgisi)) {
            homePage.ilanGirmeBuyCreditsLinki.click();
            homePage.ilanGirmeBuyCreditSinglePostPurchase.click();
            //homePage.krediKartiCardNumberKutusu.click();
            ReusableMethods.bekle(2);
            homePage.krediKartiCardNumberKutusu.sendKeys("4242 4242 4242 4242");
            //homePage.krediKartiAyGunButonu.click();
            homePage.krediKartiAyGunButonu.sendKeys("1224");
            //homePage.krediKartiAdSoyadButonu.click();
            homePage.krediKartiAdSoyadButonu.sendKeys("Rana nur Ülker");
            // homePage.krediKartiGuvenlikBilgisiButonu.click();
            homePage.krediKartiGuvenlikBilgisiButonu.sendKeys("456");
            ReusableMethods.hover(homePage.krediKartiPurchasebutonu);
            homePage.krediKartiPurchasebutonu.click();
            ReusableMethods.bekle(2);
            Actions action=new Actions(Driver.getDriver());
            action.sendKeys(Keys.ESCAPE).perform();
            ReusableMethods.bekle(2);

            ReusableMethods.hover(homePage.ilanGirmeWriteaPropertyLinki);
        } else {
            ReusableMethods.hover(homePage.ilanGirmeWriteaPropertyLinki);
            homePage.ilanGirmeWriteaPropertyLinki.click();
            extentTest.pass("Ilan girmek icin submenudeki Write a property linkine tiklanilir");
            homePage.ilanYayinlamaFormuTitleKutusu.sendKeys("Manisa");
            extentTest.pass("Title kutusuna Manisa yazilir.");
            homePage.ilanYayinlamaFormuContentKutusu.click();
            homePage.ilanYayinlamaFormuContentKutusu.sendKeys("Dag manzarali,merkezde 3+1 daire");
            extentTest.pass("Content kutusuna Dag manzarali,merkezde 3+1 daire yazilir.");
            ReusableMethods.hover(homePage.ilanYayinlamaFormuPropertyLocationKutusu);
            homePage.ilanYayinlamaFormuPropertyLocationKutusu.sendKeys("Manisa Merkez");
            extentTest.pass("Property location kutusuna Manisa Merkez yazilir.");
            ReusableMethods.bekle(3);
            ReusableMethods.hover(homePage.ilanYayinlamaFormuSaveAndExitButonu);
            ReusableMethods.bekle(3);
            homePage.ilanYayinlamaFormuSaveAndExitButonu.click();
            extentTest.pass("Ilan yayinlanmak icin save&exit butonuna tiklanilir.");
            extentTest.pass(" Kayıtlı kullanıcı listing linkine tıklar.");
            homePage.listingButonu.click();
            extentTest.pass(" Kayıtlı kullanıcı listing sayfasına ulaşır.");
            homePage.listingButonu.click();
            extentTest.pass("Kayıtlı kullanıcı sayfada seçtiği herhangi bir mülke tıklar.");
            homePage.listingseciliilan.click();
            extentTest.pass(" Kayıtlı kullanıcı seçtiği mülkün detaylarına ulaşabilğini doğrular");
            ReusableMethods.hover(homePage.listingmesajkutususubmitbutonu);
            ReusableMethods.bekle(2);
            Assert.assertTrue(homePage.listingmesajkutususubmitbutonu.isDisplayed());
            extentTest.pass(" Kayıtlı kullanıcı sevice,value for money,location,cleanlines alanlarında puanlama yapar.");
            ReusableMethods.bekle(2);
            homePage.listingpuansevice.click();
            homePage.listingpuancleanlines.click();
            homePage.listingpuanvalue.click();
            homePage.listingpuanlocation.click();
            ReusableMethods.bekle(2);
            extentTest.pass("Kayıtlı kullanıcı mesaj alanına mesajı yazar ve send message butonuna basar");
            homePage.listingmesajkutusuElementi.click();
            ReusableMethods.bekle(2);
            homePage.listingmesajkutusuElementi.sendKeys("ilanınız hakkında bilgi almak istiyorum");
            ReusableMethods.bekle(2);
            ReusableMethods.hover(homePage.listingmesajkutususubmitbutonu);
            homePage.listingmesajkutususubmitbutonu.click();
            extentTest.pass(" Kayıtlı kullanıcı added review successfully penceresını gorerek puan ve mesajın gonderıldıgını doğrular");
            ReusableMethods.bekle(2);
            Assert.assertTrue(homePage.listingmesajgonderildielemnti.isDisplayed());
            extentTest.pass(" Kayıtlı kullanıcı açılan sekmeyi kapatır.");
            Driver.getDriver().quit();
        }
    }
}
