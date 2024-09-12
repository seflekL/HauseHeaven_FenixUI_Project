package java.tests.US_004;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.List;

public class TC_01_searchboxSonucKarsilastirma extends TestBaseRapor {

    @Test
    public void TC01searchBoxaramaTesti() {
       HomePage homePage=new HomePage();
       UserDashboard userDashboard=new UserDashboard();
        extentTest = extentReports.createTest("Ziyaretçi olarak, ana sayfanın body bölümünde arama yapıp sonuç sayısını görüntüleyebilmem için arama fonksiyonunun çalışıyor olmasını istiyorum.");


        //Ziyaretçi hausehaen URL'sine erişim sağlar
        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Ziyaretçi hausehaen URL'sine erişim sağlar");
        //Ziyaretçi ana sayfanın Gövde bölümüne erişir
        ReusableMethods.hover(homePage.sefUserBodysearchButtonElementi);
        extentTest.pass("Ziyaretçi ana sayfanın Gövde bölümüne erişir ");

        homePage.sefUsercookies.click();
        extentTest.pass("Ziyaretçi Cokkies kapatir ");


        //Ziyaretçi konum arama kutusuna tıklar
        homePage.sefUserSearhforloactionboxElementi.click();
        extentTest.pass("Ziyaretçi konum arama kutusuna tıklar");

        //Ziyaretçi arama kutusuna istediği ülkenin veya şehrin adını yazar
        homePage.sefUserSearhforloactionboxElementi.sendKeys("Miami");
        //Arama Sonucu düğmesine basarak arama yapar
        homePage.sefUserBodysearchButtonElementi.click();
        extentTest.pass("Arama Sonucu düğmesine basarak arama yapar ");
        ReusableMethods.wait(2);
        ReusableMethods.getFullScreenshot(Driver.getDriver());


        //Döndürülen sonuçların arama kutusundaki ülke/şehir adıyla aynı olduğunu onaylar

        List <String> searchedResultList=ReusableMethods.getElementsText(userDashboard.sefUsersearchedList);
        String aranacakKelime="Miami";
        System.out.println(searchedResultList);
        Assert.assertTrue(searchedResultList.contains("Miami"));
        extentTest.pass("Sonuc Listesis'nde Miami Location yer almamaktadir");

        //Ziyaretçi açılan sekmeyi kapatır
        Driver.quitDriver();


    }

}
