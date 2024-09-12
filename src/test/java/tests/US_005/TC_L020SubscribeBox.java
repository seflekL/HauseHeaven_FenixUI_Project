package tests.US_005;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.Driver;
import utilities.LeventMethods;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_L020SubscribeBox extends TestBaseRapor {

    @Test

    public void TC020Subscribe() {
        extentTest = extentReports.createTest("Subscribe Box Testi");

        HomePage homePage = new HomePage();
        Faker faker = new Faker();
        //Ziyaretci hausehaen Url'ine giris saglar ve footer bolumune scroll yapar
        LeventMethods.footerhomepageScroll();
        extentTest.pass("Ziyaretci hausehaen Url'ine giris saglar ve footer bolumune scroll yapar");
        //Ziyaretci anasayfa footer bolumunde yer alan   istedigi gecerli email adresini "Subscribe"box'in icine girer
        homePage.sefFooterSubscribeBox.sendKeys(faker.internet().emailAddress());
        extentTest.pass("Ziyaretci anasayfa footer bolumunde yer alan   istedigi gecerli email adresini \"Subscribe\"box'in icine girer");
        //Ziyaretci anasayfa footer bolumunde yer alan subsribe buttonu tiklar
        homePage.getSefFooterSubscribeBoxButtonElementi.click();
        extentTest.pass("Ziyaretci anasayfa footer bolumunde yer alan subsribe buttonu tiklarr");
        //Ziyaretci "Email adresinin basarali sekilde kaydedilgini dogrular"
         ReusableMethods.waitForVisibility(homePage.seffooterSubscribeConfirmYaziElementi,10);
        extentTest.pass("Email adresinin basarali sekilde kaydedilgini dogrular");
        //Ziyratci tarayiciyi kapatir
        Driver.quitDriver();
        extentTest.pass("iyratci tarayiciyi kapatir");

    }
}