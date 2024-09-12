package java.tests.US_013;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_F010 extends TestBaseRapor {


    @Test
    public void test10(){

        extentTest = extentReports.createTest("Oturumu kapatılmış kayıtlı kullanıcının yeniden girebilmesi ve doğrulayabilmesi testi");
        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.info("Kullanici anasayfaya gider");

        HomePage homePage=new HomePage();
        UserDashboard userDashboard=new UserDashboard();

        // Anasayfada Sign In butonuna gelir
        ReusableMethods.hover(homePage.signinButonu);
        homePage.signinButonu.click();
        extentTest.info("Ziyaretçi Login sayfasina gelir.");
        homePage.emailTextbox.sendKeys(ConfigReader.getProperty("gecerliUsername"));
        homePage.passwordTextbox.sendKeys(ConfigReader.getProperty("gecerliPassword"));
        homePage.loginButonu.click();
        ReusableMethods.wait(2);


        //Anasayfada header'da adinin gorundugunu test eder
        Assert.assertTrue(homePage.anasayfaIsim.isDisplayed());
        extentTest.pass("Anasayfada header'da adinin gorundugunu test eder");

        // Sayfayi kapatir
        Driver.quitDriver();

    }
}
