package tests.US_033;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_ME06 extends TestBaseRapor {
    @Test
    public void test05(){
        HomePage homePage=new HomePage();

        extentTest=extentReports.createTest(" Testimonials sayfasına yorum ekleyebildiğinin save butonu ile doğrulanması testi");

        extentTest.pass("Admin email ve password girerek admin sayfasına giriş yapabildiğini doğrular .");
        Driver.getDriver().get(ConfigReader.getProperty("hauseAdminUrl"));
        homePage.adminloginemailkutusu.click();
        homePage.adminloginemailkutusu.sendKeys("mervenurembel.admin@hauseheaven.com");
        homePage.adminloginpasswordkutusu.click();
        homePage.adminloginpasswordkutusu.sendKeys("Hven.150820");
        homePage.adminloginsigninbutonu.click();
        Assert.assertTrue(homePage.admintestimonialselementi.isDisplayed());
        extentTest.pass(" Admin Testimonial sayfasına ulaşır.");

        homePage.admintestimonialselementi.click();
        ReusableMethods.bekle(2);
        homePage.admintestimonialselementi.click();
        ReusableMethods.bekle(2);

        extentTest.pass("Admin sayfada yorum listesinin göründüğünü doğrular. ") ;
        Assert.assertTrue(homePage.admintestimonialscreatebutonu.isDisplayed());
        homePage.admintestimonialselementi.click();
        ReusableMethods.bekle(2);

        extentTest.pass(" Admin create butonuna tıklar");
        homePage.admintestimonialscreatebutonu.click();

        extentTest.pass("Admin create/show/hide editör butonuna tıklayarak yazı stili ıle alakalı özelliklerin görünüp kaybolduğunu doğrular ") ;
        homePage.admintestimonialscreateshowhidebutonu.click();
        ReusableMethods.bekle(1);
        homePage.admintestimonialscreateshowhidebutonu.click();

        extentTest.pass("  Admin create/add media butonuyla görsellerden bir tanesini secip insert butonuna tıklayarak yorumuna görsel ekleyebildiğini doğrular ") ;
        homePage.createaddmediabutonu.click();
        homePage.addmediaresim.click();
        ReusableMethods.bekle(2);
        homePage.createaddmediainserbutonu.click();

        ReusableMethods.bekle(2);
        extentTest.pass(" Admin name , position, ve content alanlarını doldurur ");
        homePage.admintestimonialscreatenamekutusu.click();
        homePage.admintestimonialscreatenamekutusu.sendKeys("nur");
        homePage.admintestimonialscreatepositionkutusu.click();
        homePage.admintestimonialscreatepositionkutusu.sendKeys("wise");
        homePage.admintestimonialscreatemesajkutusu.click();
        homePage.admintestimonialscreatemesajkutusu.sendKeys("İlanınız hakkında bilgi almak istiyorum.");

        extentTest.pass("Admin gerekli alanları doldurduktan sonra save butonuna tıklar.sayfada created successfully penceresini görunce eklediği yorumu kaydedebidiğini doğrular.") ;
        homePage.admintestimonialssaveexitbutonu.click();

        extentTest.pass(" Admin açılan sekmeyi kapatır.");
        Driver.getDriver().quit();

    }

}
