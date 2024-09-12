package java.tests.US_010;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.TeamPages.BunyaminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.time.Duration;
import java.util.Set;

public class TC_B003 extends TestBaseRapor {

    @Test
    public void Test08(){

        extentTest = extentReports.createTest("Ziyaretçi olarak siteye girip header kisminda Blog başlığına tiklanip görüntülenen bloglara tiklayip içeriğine ulaşma testi.");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Hause Heaven ana sayfasına gidildi.");

        HomePage homePage = new HomePage();
        BunyaminPage bunyaminPage = new BunyaminPage();

        homePage.blogButonu.click();
        extentTest.pass("Blog basligina tiklandi.");

        bunyaminPage.blogUrunResim.click();
        extentTest.pass("Blog basliginda goruntulenen urune tıklandı.");

        Driver.quitDriver();
        extentTest.pass("Driver kapatildi.");


    }

}
