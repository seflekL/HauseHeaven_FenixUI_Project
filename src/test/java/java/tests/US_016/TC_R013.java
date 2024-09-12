package java.tests.US_016;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_R013 extends TestBaseRapor {
    @Test
    public void Test01(){

        extentTest=extentReports.createTest
                ("Kayitli kullanicinin search butonunu kullanarak ilanlarin icinde arama yapar");
        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Tarayici acildi ve Hause Heaven sitesine gidildi.");

        HomePage homePage = new HomePage();
        homePage.signinButonu.click();
        extentTest.pass("Sign in butonuna tiklanilir.");

        homePage.emailTextbox.sendKeys("rananurulker@hauseheaven.com");
        extentTest.pass("Mail text boxa email girilir.");
        homePage.passwordTextbox.sendKeys("Hven.150820");
        extentTest.pass("Password text boxa password girilir.");

        homePage.loginButonu.click();
        extentTest.pass("Login butonu tiklanir ve giris yapildigi gorulur.");

        homePage.kayitliKullaniciUserLinki.click();

        ReusableMethods.hover(homePage.kayitlikullaniciPropertiesLinki);
        homePage.kayitlikullaniciPropertiesLinki.click();
        extentTest.pass("Submenudeki Properties linkine tiklanilir.");
        ReusableMethods.bekle(3);

        homePage.kayitlikullaniciSearchKutusu.sendKeys("Manisa");
        extentTest.pass("Kayitli kullanici, kayitli mulkeri icinde arama yapar, search kutusuna Manisa yazar");

        Assert.assertTrue(homePage.showFromYazisi.isDisplayed());
        extentTest.pass("Kayitli kullanici, kayitli mulkeri icinde arama yapar ve ilanlarinin siralandigini gorur.");


        homePage.logoutButonu.click();
        extentTest.pass("Logout butonu tiklanir ve cikis yapildigi gorulur.");

        Driver.getDriver().quit();
        extentTest.pass("Ziyaretci browseri kapatir.");
    }
}
