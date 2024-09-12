package tests.US_009;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.time.Duration;

public class TC_MI002 extends TestBaseRapor {

    @Test
            public void test02(){
        extentTest = extentReports.createTest("Agents sayfasında emlakçıların listelenmesi testi");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Tarayıcı açıldı ve hause heaven web sitesine gidildi.");
        HomePage homePage = new HomePage();

        homePage.agentsButonu.click();
        extentTest.pass("Agents başlığına tıklandı ve gidildi");

        String ExceptedAgentsUrl = "https://qa.hauseheaven.com/agents";
        String ActualAgentsUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(ActualAgentsUrl,ExceptedAgentsUrl);
        extentTest.pass("Agents sayfasında olduğu doğrulandı");

        Driver.getDriver().quit();
        extentTest.pass("Driver kapatıldı");

    }

}
