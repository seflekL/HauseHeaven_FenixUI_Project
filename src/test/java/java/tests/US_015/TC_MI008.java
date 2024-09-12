package java.tests.US_015;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TeamPages.MustafaPage;
import utilities.*;

public class TC_MI008 extends TestBaseRapor {

    @Test
    public void test08(){

        extentTest = extentReports.createTest("Kredi satın alma testi");

        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Tarayıcı açıldı ve hause heaven web sitesine gidildi.");

        MustafaMethods.hauseHeavenLogin(ConfigReader.getProperty("MIusername"),ConfigReader.getProperty("MIpassword"));

        HomePage homePage =new HomePage();
        MustafaPage mustafaPage = new MustafaPage();

        homePage.accountDashboardButonu.click();
        extentTest.pass("Account dashboard butonu tıklandı.");

        Assert.assertTrue(mustafaPage.buyCreditsButonu.isDisplayed());
        extentTest.pass("Buy Credits butonu görüntülendi.");

        mustafaPage.buyCreditsButonu.click();
        extentTest.pass("Buy Credits butonu tıklandı");

        String krediYazisi = mustafaPage.yourCreditsText.getText();
        krediYazisi = krediYazisi.replaceAll("\\D", "");
        int krediSayisi = Integer.parseInt(krediYazisi);
        System.out.println(krediSayisi);
        extentTest.info("Sahip olunan kredi sayısı kaydedildi.");

        Assert.assertTrue(mustafaPage.singlePostPurchaseButonu.isDisplayed());
        extentTest.pass("Single Post kutusndaki Purshase butonu görüntülendi.");

        mustafaPage.singlePostPurchaseButonu.click();
        extentTest.pass("Single Post kutusndaki Purshase butonu tıklandı.");


        ReusableMethods.wait(3);

        String exceptedText = "Pay online via Stripe";
        String actualText = mustafaPage.payOnlineviaStripeText.getText();

        Assert.assertEquals(actualText,exceptedText);
        extentTest.pass("'Pay online via Stripe' yazısının görüntülendiği doğrulandı.");

        Assert.assertTrue(mustafaPage.cardNumberTextBox.isDisplayed());
        Assert.assertTrue(mustafaPage.mmYYTextBox.isDisplayed());
        Assert.assertTrue(mustafaPage.fullNameTextBox.isDisplayed());
        Assert.assertTrue(mustafaPage.cvcTextBox.isDisplayed());
        extentTest.pass("Card number text box, MM/YY text box, Full name text box ve CVC text box görüntülendi.");

        mustafaPage.cardNumberTextBox.sendKeys("4242 4242 4242 4242");
        extentTest.pass("Card number text box verilen bilgilerle dolduruldu.");
        extentTest.info("4242 4242 4242 4242");
        mustafaPage.mmYYTextBox.sendKeys("1228");
        extentTest.pass("MM/YY text box verilen bilgilerle dolduruldu.");
        extentTest.info("1228");
        mustafaPage.fullNameTextBox.sendKeys("Full name");
        extentTest.pass("Full name text box verilen bilgilerle dolduruldu.");
        extentTest.info("Full name");
        mustafaPage.cvcTextBox.sendKeys("123");
        extentTest.pass("CVC text box verilen bilgilerle dolduruldu.");
        extentTest.info("123");

        Assert.assertTrue(mustafaPage.buyCreditsCheckoutButonu.isEnabled());
        extentTest.pass("Checkout butonu görüntülendi.");

        mustafaPage.buyCreditsCheckoutButonu.click();
        extentTest.pass("Checkout butonu tıklandı.");

        ReusableMethods.wait(1);

        String yeniKrediYazisi = mustafaPage.yourCreditsText.getText();
        yeniKrediYazisi = yeniKrediYazisi.replaceAll("\\D", "");
        int yeniKrediSayisi = Integer.parseInt(yeniKrediYazisi);
        System.out.println(yeniKrediSayisi);
        extentTest.info("Yeni kredi sayısı kaydedildi.");

        Assert.assertTrue(yeniKrediSayisi>krediSayisi);
        extentTest.pass("Eski ve yeni kredi sayıları karşılaştırıldı ve kredi satın alımı doğrulandı.");

        Assert.assertTrue(mustafaPage.fivePostPurchaseButonu.isDisplayed());
        extentTest.pass("5 Posts kutusndaki Purshase butonu görüntülendi.");

        mustafaPage.fivePostPurchaseButonu.click();
        extentTest.pass("5 Posts kutusndaki Purshase butonu tıklandı.");

        mustafaPage.cardNumberTextBox.sendKeys("4242 4242 4242 4242");
        extentTest.pass("Card number text box verilen bilgilerle dolduruldu.");
        extentTest.info("4242 4242 4242 4242");
        mustafaPage.mmYYTextBox.sendKeys("1228");
        extentTest.pass("MM/YY text box verilen bilgilerle dolduruldu.");
        extentTest.info("1228");
        mustafaPage.fullNameTextBox.sendKeys("Full name");
        extentTest.pass("Full name text box verilen bilgilerle dolduruldu.");
        extentTest.info("Full name");
        mustafaPage.cvcTextBox.sendKeys("123");
        extentTest.pass("CVC text box verilen bilgilerle dolduruldu.");
        extentTest.info("123");

        mustafaPage.buyCreditsCheckoutButonu.click();
        extentTest.pass("Checkout butonu tıklandı.");

        ReusableMethods.wait(1);

        String enYeniKrediYazisi = mustafaPage.yourCreditsText.getText();
        enYeniKrediYazisi = enYeniKrediYazisi.replaceAll("\\D", "");
        int enYeniKrediSayisi = Integer.parseInt(enYeniKrediYazisi);
        System.out.println(enYeniKrediSayisi);
        extentTest.info("En yeni kredi sayısı kaydedildi.");

        Assert.assertTrue(enYeniKrediSayisi>yeniKrediSayisi);
        extentTest.pass("Eski ve yeni kredi sayıları karşılaştırıldı ve kredi satın alımı doğrulandı.");

        Driver.getDriver().quit();

    }

}
