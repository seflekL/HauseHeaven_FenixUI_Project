package tests.US_045;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_ME01 extends TestBaseRapor {
    @Test

    public  void test01(){
        HomePage homePage=new HomePage();
        extentTest=extentReports.createTest(" consults kısmında mesaj göderilebildiği testi");

        extentTest .pass ("Ziyaretçi HauseHeaven url girer.");
        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));


        extentTest .pass(" Ziyaretçi HauseHeaven anasayfaya eriştiğini görür. header da listing linkini tıklar. " );
        Assert.assertTrue(homePage.hauseheavenlogo.isDisplayed());
        homePage.listingButonu.click();

      extentTest.pass(" Ziyaretçi listing sayfasına ulaşır ");
      Assert.assertTrue(homePage.listingseciliilan.isDisplayed());

        extentTest.pass("Ziyaretçi mülk listesinden birini seçer ve tıklar.");
        homePage.listingseciliilan.click();

        extentTest.pass("Ziyaretçi mülk ayrıntılarını görür ve consults kısmına gelir . ");
        ReusableMethods.hover(homePage.listinglocation);
        Assert.assertTrue(homePage.listingconsultnamekutusu.isDisplayed());
        extentTest.pass("Ziyaretçi consults kısmında name kutusuna isim , email kutusuna email,phone kutusuna telefon numarsası ve message kısmına  da gondermek istedediği mesaja yazar . ");

        homePage.listingconsultnamekutusu.sendKeys("naci");
        homePage.listingphonebutonu.sendKeys("05554443322");
        homePage.listingemailbutonu.sendKeys("naci@gmail.com ");
        homePage.listingmesajkutusu.sendKeys("ilaniniz hakkinda bilgi almak istiyorum");


             extentTest.pass(" Ziyaretçi send message butonuna tıklar") ;
        homePage.listingsendmesajbutonu.click();
        ReusableMethods.bekle(7);
       extentTest.pass(" Ziyaretçi send consult successfully penceresini gördüğünde mesajın gonderildiğini doğrular") ;


       //ReusableMethods.waitForVisibility(homePage.listingsuccessfully,10);
        ReusableMethods.bekle(3);
        Assert.assertTrue(homePage.listingsuccessfully.isDisplayed());
      extentTest.pass(" Ziyaretçi açılan sekmeyi kapatır.");
      Driver.getDriver().quit();

    }
}
