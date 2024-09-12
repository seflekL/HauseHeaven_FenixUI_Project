package tests.US_016;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_R010 extends TestBaseRapor {
    @Test
    public void Test01(){
        extentTest=extentReports.createTest
                ("Kayitli kullanicinin yeni bir ilan girebilmesi testi");
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

        String unexpectedCreditBilgisi="0 credits";
        String actualCreditBilgisi=homePage.ilanGirmeBuyCreditsKrediBilgisi.getText();

        if (unexpectedCreditBilgisi.equalsIgnoreCase(actualCreditBilgisi)) {
            homePage.ilanGirmeBuyCreditsLinki.click();
            homePage.ilanGirmeBuyCreditSinglePostPurchase.click();
            ReusableMethods.bekle(3);
            homePage.krediKartiCardNumberKutusu.sendKeys("4242 4242 4242 4242");

            homePage.krediKartiAyGunButonu.sendKeys("1224");

            homePage.krediKartiAdSoyadButonu.sendKeys("Rana nur Ülker");

            homePage.krediKartiGuvenlikBilgisiButonu.sendKeys("456");
            homePage.krediKartiPurchasebutonu.click();
        }
        else {
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
            ReusableMethods.hover(homePage.ilanYayinlamaFormuSaveAndExitButonu);
            homePage.ilanYayinlamaFormuSaveAndExitButonu.click();
            extentTest.pass("Ilan yayinlanmak icin save&exit butonuna tiklanilir.");

            homePage.logoutButonu.click();
            extentTest.pass("Logout butonu tiklanir ve cikis yapildigi gorulur.");


        }


       Driver.getDriver().quit();
       extentTest.pass("Ziyaretci browseri kapatir.");
    }
}
