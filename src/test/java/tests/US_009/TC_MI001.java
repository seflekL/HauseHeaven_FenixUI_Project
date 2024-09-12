package tests.US_009;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.time.Duration;

public class TC_MI001 extends TestBaseRapor {

    @Test
    public void test01(){
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        extentTest = extentReports.createTest("Ziyaretci olarak Agents başlığının görünür olması testi");


        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Hause Heaven ana sayfasına gidildi.");

        HomePage homePage = new HomePage();

        Assert.assertTrue(homePage.agentsButonu.isDisplayed());
        extentTest.pass("Agents başlığı görüntülendi");


        Driver.getDriver().quit();
        extentTest.pass("driver kapatıldı");
    }

}
