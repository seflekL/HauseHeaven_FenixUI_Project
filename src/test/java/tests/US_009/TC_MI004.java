package tests.US_009;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.time.Duration;

import static utilities.Driver.driver;

public class TC_MI004 extends TestBaseRapor {

    @Test
    public void test04(){
        extentTest = extentReports.createTest("Kayıtlı emlakçıların profillerine erişim testi");

        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Tarayıcı açıldı ve hause heaven web sitesine gidildi.");

        HomePage homePage = new HomePage();
        homePage.agentsButonu.click();
        extentTest.pass("Agents başlığına tıklandı ve gidildi");

        homePage.agentsPhotoElementList.click();
        extentTest.pass("Agent fotoğrafına tıklandı ve profiline gidildi");

        Assert.assertTrue(homePage.agentDetailTitle.isDisplayed());
        extentTest.pass("Agent profilinde olduğu doğrulandı");

        Driver.getDriver().navigate().back();
        extentTest.pass("Agents sayfasına geri dönüldü.");

        Assert.assertTrue(homePage.agentViewButonuList.get(1).isDisplayed());
        extentTest.pass("Agent box'ları içerisinde View butonu olduğu doğrulandı.");

        ReusableMethods.hover(homePage.agentViewButonuList.get(1));

        if (!homePage.agentViewButonuList.isEmpty()) {
           WebElement ilkView = homePage.agentViewButonuList.get(0);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", ilkView);
        }
        extentTest.pass("View butonu tıklandı ve agent profiline gidildi");

        Assert.assertTrue(homePage.agentDetailTitle.isDisplayed());
        extentTest.pass("Agent profilinde olduğu doğrulandı");

        Driver.getDriver().quit();
        extentTest.pass("Driver kapatıldı");


    }
}
