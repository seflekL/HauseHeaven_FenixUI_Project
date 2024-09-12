package java.tests.US_017;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import static utilities.Driver.driver;

public class TC_M017 extends TestBaseRapor {

    @Test
    public void Test17 (){

        extentTest = extentReports.createTest("Kayıtlı Kullanıcı olarak Header’daki " +
                "Menü’de linklere (Home, Listings, Projects, Agents, Blog, Contacts) tıklandığında " +
                "doğru sayfaya gidilmesi testi.");

        //Ziyaretçi browser’ı açar, HauseHeaven URL’ini girer ve enter’a basar

        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Hause Heaven Anasayfası'na gidildi.");

        //Anasayfa’da sağ üst taraftaki Sign in linkine tıklar
        HomePage homePage=new HomePage();
        homePage.signinButonu.click();
        extentTest.info("Anasayfa’da Sign In linkine tıklandı.");

        //Açılan Login sayfasında üyelik bilgilerini girer ve Log in linkine tıklar
        homePage.emailTextbox.sendKeys("mehmetyilmaz@hauseheaven.com");
        homePage.passwordTextbox.sendKeys("Hven.150820"+ Keys.ENTER);
        //homePage.logInSayfasiLogInLinki.click();
        extentTest.info("Login sayfasında üyelik bilgileri girildi ve Log in linkine tıklandı.");

        //Açılan sayfanın KK Anasayfa'sı olduğunu doğrular.
        String expectedUrl="https://qa.hauseheaven.com/";
        String actualUrl= driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("Açılan sayfanın KK Anasayfası  olduğu test edildi.");

        //Daha sonra Header’daki Logo ve Home’linklerinin sağındaki Listing linkine tıklar
        homePage.listingButonu.click();
        extentTest.info("Anasayfa'da Listing linkine tıklandı.");

        //Açılan sayfanın Properties sayfası olduğunu test eder.
        expectedUrl="https://qa.hauseheaven.com/properties?layout=sidebar";
        actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("Açılan sayfanın Properties sayfası olduğu test edildi.");

        //Home linkine tıklayarak anasayfaya döner.
        homePage.homeButonu.click();
        extentTest.info("Home linkine tıklayarak anasayfaya dönüldü.");

        //Daha sonra Header’daki Projects linkine tıklar
        homePage.projectsButonu.click();
        extentTest.info("Anasayfa'da Projects linkine tıklandı.");

        //Açılan sayfanın Projects sayfası olduğunu test eder.
        expectedUrl="https://qa.hauseheaven.com/projects";
        actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("Açılan sayfanın Projects sayfası olduğu test edildi.");

        //Home linkine tıklayarak anasayfaya döner.
        homePage.homeButonu.click();
        extentTest.info("Home linkine tıklayarak anasayfaya dönüldü.");

        //Daha sonra Header’daki Agents linkine tıklar
        homePage.agentsButonu.click();
        extentTest.info("Anasayfa'da Agents linkine tıklandı.");

        //Açılan sayfanın Agents sayfası olduğunu test eder.
        expectedUrl="https://qa.hauseheaven.com/agents";
        actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("Açılan sayfanın Agents sayfası olduğu test edildi.");

        //Home linkine tıklayarak anasayfaya döner.
        homePage.homeButonu.click();
        extentTest.info("Home linkine tıklayarak anasayfaya dönüldü.");

        //Daha sonra Header’daki Blog linkine tıklar
        homePage.blogButonu.click();
        extentTest.info("Anasayfa'da Blog linkine tıklandı.");

        //Açılan sayfanın Blog sayfası olduğunu test eder.
        expectedUrl="https://qa.hauseheaven.com/blog";
        actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("Açılan sayfanın Blog sayfası olduğu test edildi.");

        //Home linkine tıklayarak anasayfaya döner.
        homePage.homeButonu.click();
        extentTest.info("Home linkine tıklayarak anasayfaya dönüldü.");

        //Daha sonra Header’daki Contact linkine tıklar
        homePage.contactButonu.click();
        extentTest.info("Anasayfa'da Contact linkine tıklandı.");

        //Açılan sayfanın Contact sayfası olduğunu test eder.
        expectedUrl="https://qa.hauseheaven.com/contact";
        actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("Açılan sayfanın Contact sayfası olduğu test edildi.");

        //Home linkine tıklayarak anasayfaya döner.
        homePage.homeButonu.click();
        extentTest.info("Home linkine tıklayarak anasayfaya dönüldü.");

        //Daha sonra KK Header’da Sign Up linkinin olmadığını doğrular
        Assert.assertFalse(homePage.signupButonu.isDisplayed());
        extentTest.info("KK Header'da Sign Up linkinin olmadığı test edildi.");

        //Home linkine tıklayarak anasayfaya döner.
        homePage.homeButonu.click();
        extentTest.info("Home linkine tıklayarak anasayfaya dönüldü.");

        //Daha sonra Log out linkine tıklar
        homePage.logoutButonu.click();
        extentTest.info("Log out linkine tıklandı.");

        //Sayfayı kapatır
        Driver.quitDriver();
        extentTest.info("Sayfa kapatıldı.");
    }
}
