package tests.US_016;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_R011 extends TestBaseRapor {
    @Test
    public void Test01() {

        //Failed oluyor

        extentTest = extentReports.createTest
                ("Kayitli kullanicinin zorunlu alanlardan Property location kutusu bos birakildiginda kayit yapamamasi testi");
        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Tarayici acildi ve Hause Heaven sitesine gidildi.");

        HomePage homePage = new HomePage();

        Assert.assertTrue(homePage.signinButonu.isDisplayed());
        extentTest.pass("Sign in butonunun gorunur oldugu test edilir.");

        homePage.signinButonu.click();
        extentTest.pass("Sign in butonuna tiklanilir.");

        homePage.emailTextbox.sendKeys("rananurulker@hauseheaven.com");
        extentTest.pass("Mail text boxa email girilir.");
        homePage.passwordTextbox.sendKeys("Hven.150820");
        extentTest.pass("Password text boxa password girilir.");

        homePage.loginButonu.click();
        extentTest.pass("Login butonu tiklanir ve giris yapildigi gorulur.");

        homePage.kayitliKullaniciUserLinki.click();
        extentTest.pass("Login olduktan sonra cikan kayitli kullanici isminin oldugu linke tiklanir.");

        String unexpectedCreditBilgisi = "0 credits";
        String actualCreditBilgisi = homePage.ilanGirmeBuyCreditsKrediBilgisi.getText();
        extentTest.pass("Eger bakiyede kredi yoksa kredi yuklemek icin Buy credits linkine tiklanilir. ");
        if (unexpectedCreditBilgisi.equalsIgnoreCase(actualCreditBilgisi)) {
            homePage.ilanGirmeBuyCreditsLinki.click();
            homePage.ilanGirmeBuyCreditSinglePostPurchase.click();
            extentTest.pass("Single post buy credit linkine tiklanilir");
            ReusableMethods.bekle(3);
            homePage.krediKartiCardNumberKutusu.click();
            homePage.krediKartiCardNumberKutusu.sendKeys("4242 4242 4242 4242");
            extentTest.pass("Kredi karti numara kutusuna kredi karti numara bilgileri girilir.");
            homePage.krediKartiAyGunButonu.click();
            homePage.krediKartiAyGunButonu.sendKeys("1224");
            extentTest.pass("Kredi karti tarih kutusuna tarih bilgileri girilir.");
            homePage.krediKartiAdSoyadButonu.click();
            homePage.krediKartiAdSoyadButonu.sendKeys("Rana nur Ülker");
            extentTest.pass("Kredi karti ad soyad isim bilgileri girilir.");
            homePage.krediKartiGuvenlikBilgisiButonu.click();
            homePage.krediKartiGuvenlikBilgisiButonu.sendKeys("456");
            extentTest.pass("Kredi karti guvenlik numarasi kutusuna guvenlik numarasi girilir.");
            ReusableMethods.hover(homePage.krediKartiPurchasebutonu);
            homePage.krediKartiPurchasebutonu.click();
            extentTest.pass("Kredi karti ile satin alma islemi yapilir.");
        }
        ReusableMethods.hover(homePage.ilanGirmeWriteaPropertyLinki);
        homePage.ilanGirmeWriteaPropertyLinki.click();

        extentTest.pass("Ilan girmek icin submenudeki Write a property linkine tiklanilir");


        homePage.ilanYayinlamaFormuTitleKutusu.sendKeys("Manisa");
        extentTest.pass("Title kutusuna Manisa yazilir.");
        homePage.ilanYayinlamaFormuContentKutusu.click();
        ReusableMethods.getFullScreenshot(Driver.getDriver());
        homePage.ilanYayinlamaFormuContentKutusu.sendKeys("Dag manzarali,merkezde 3+1 daire");
        extentTest.pass("Content kutusuna Dag manzarali,merkezde 3+1 daire yazilir.");
        ReusableMethods.hover(homePage.ilanYayinlamaFormuSaveAndExitButonu);
        homePage.ilanYayinlamaFormuSaveAndExitButonu.click();
        extentTest.pass("Ilan yayinlanmak icin save&exit butonuna tiklanilir.");

        String actualmessage=homePage.ilanCreatedSuccesfuly.getText();
        ReusableMethods.getFullScreenshot(Driver.getDriver());
        if (actualmessage.equalsIgnoreCase("Created successfully")){
            Assert.fail("Ilanda zorunlu birakilan alan olmasina ragmen kayit yapildi.");
        }



        Driver.getDriver().quit();
        extentTest.pass("Ziyaretci browseri kapatir.");
    }
}

