package tests.US_010;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.TeamPages.BunyaminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.time.Duration;

public class TC_B001 extends TestBaseRapor {

    @Test
    public void Test06(){

        extentTest = extentReports.createTest("Ziyaretçi olarak siteye girip header kisminda Blog başlığının erişilebilir ve tiklandiğinda yönlendirebilir olmasi testi.");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Hause Heaven ana sayfasına gidildi.");

        HomePage homePage = new HomePage();

        homePage.blogButonu.isDisplayed();
        homePage.blogButonu.click();
        ReusableMethods.wait(1);
        extentTest.pass("Blog başlıgına erişilip tıklandı.");

        Driver.quitDriver();
        extentTest.pass("Driver kapatildi.");


    }

}
