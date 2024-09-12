package tests.US_003;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_F007 extends TestBaseRapor {

    @Test
    public void test07(){


        extentTest = extentReports.createTest(" “See Our Packages bolumunde reklam paketi fiyatlarını gösteren küçük öğelerin dogrulanmasi testi");
        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.info("Ziyaretci anasayfaya gider");

        HomePage homePage=new HomePage();

        ReusableMethods.hover(homePage.SeeOurPackages);
        Assert.assertTrue(homePage.SeeOurPackages.isDisplayed());
        extentTest.pass("See Our Packages bolumunun varligini test eder");

        int expectedPostPlanList = 3;
        int actualPostPlanList = homePage.PostPlanList.size();
        Assert.assertEquals(actualPostPlanList, expectedPostPlanList);
        extentTest.pass("See Our Packages bolumunde reklam paketi fiyatları Postlarinin dogrulanmasini test eder.");

        ReusableMethods.hover(homePage.ChoosePlan);
        homePage.ChoosePlan.click();
        ReusableMethods.bekle(1);
        extentTest.info("Paket fiyat ayrintilari icin tiklar.");

        UserDashboard userDashboard=new UserDashboard();
        // Kullanici login olur
        homePage.emailTextbox.sendKeys(ConfigReader.getProperty("gecerliUsername"));
        homePage.passwordTextbox.sendKeys(ConfigReader.getProperty("gecerliPassword"));
        ReusableMethods.wait(2);
        userDashboard.KayitliKullaniciLoginButonu.click();
        extentTest.pass("Ziyaretçi login olur.");


        ReusableMethods.hover(userDashboard.Logout);
        Assert.assertTrue(userDashboard.Logout.isDisplayed());
        extentTest.info("Choose butonunun kullanici Dashboard sayfasina gittigini goruntuler.");

        Driver.quitDriver();

    }
}
