package java.tests.US_022;

import com.github.javafaker.Faker;
import org.bouncycastle.pqc.crypto.util.PQCOtherInfoGenerator;
import org.testng.Assert;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_ME07 extends TestBaseRapor {

      @Test
    public void test05(){
          HomePage homePage=new HomePage();

          extentTest=extentReports.createTest("yanlis giriş yapıldiginda uyari mesaji verilmesi testi ");
         extentTest.pass(" Kayıtlı kullancı HauseHeaven url girer.");
          Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));

            extentTest.pass("Kayıtlı kullanıcı HauseHeaven anasayfa header a ulaşır.");
          Assert.assertTrue(homePage.hauseheavenlogo.isDisplayed());

          homePage.signinButonu.click();
          homePage.singinemailbutonu.sendKeys("elif@gmail.com");
          homePage.singinpasswordbutonu.sendKeys("123456789.elif");
          homePage.singinloginbutonu.click();


            extentTest.pass("Kayıtlı kullanıcı listing linkine tıklar.");
          homePage.listingButonu.click();

            extentTest.pass("Kayıtlı kullanıcı listing sayfasına ulaşır.");
          Assert.assertTrue(homePage.listingfindbybutonu.isDisplayed());
            extentTest.pass("Kayıtlı kullanıcı sayfada seçtiği herhangi bir mülke tıklar.");
          homePage.listingseciliilan.click();
            extentTest.pass("Kayıtlı kullanıcı seçtiği mülkün detaylarına ulaşabilğini doğrular");
          ReusableMethods.hover(homePage.listingmesajkutususubmitbutonu);
          Assert.assertTrue(homePage.listingpuansevice.isDisplayed());

            extentTest.pass("Kayıtlı kullanıcı puanlamayı yapar ve mesaj kısmını boş bırakır ve submit review butonunu tıklar");
          homePage.listingpuansevice.click();
          homePage.listingpuancleanlines.click();
          homePage.listingpuanvalue.click();
          homePage.listingpuanlocation.click();
          homePage.listingmesajkutususubmitbutonu.click();
            extentTest.pass("Kayıtlı kullanıcı The comment field is required penceresini görür ve masajın gönderilmediğini doğrular");

          Assert.assertTrue(homePage.listingmesajuyarıelemnti.isDisplayed());

            extentTest.pass("kullanıcı sekmeyi kapatır");
          Driver.getDriver().quit();


      }
}
