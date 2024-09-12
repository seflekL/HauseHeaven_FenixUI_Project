package java.tests.US_034;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TeamPages.IsmailPage;
import utilities.*;

public class TC_IK005 extends TestBaseRapor {

    @Test
    public void test01() {
        extentTest = extentReports.createTest("Admin olarak giriş yapıp Real Estate sayfasının altındaki başlıkların görüntülenmesini istiyorum");
        Driver.getDriver().get(ConfigReader.getProperty("hauseAdminUrl"));
        ReusableMethods.erisimTesti(ConfigReader.getProperty("hauseAdminUrl"));
        extentTest.pass("Admin admin sayfasına erişir");

        IsmailPage ismailPage = new IsmailPage();

        IsmailMethods.hauseHeavenAdminLogin(ismailPage, "ismailkaya.admin@hauseheaven.com", "Hven.150820");

        SoftAssert softAssert = new SoftAssert();

        ismailPage.realEstateButonu.click();
        extentTest.pass("Admin Real Estate Butonuna basar");

        softAssert.assertTrue(ismailPage.propertiesButonu.isDisplayed(), "Properties menüsü bulunamadı");
        softAssert.assertTrue(ismailPage.projectsButonu.isDisplayed(), "Projects menüsü bulunamadı");
        softAssert.assertTrue(ismailPage.featuresButonu.isDisplayed(), "Features menüsü bulunamadı");
        softAssert.assertTrue(ismailPage.facilitiesButonu.isDisplayed(), "Facilities menüsü bulunamadı");
        softAssert.assertTrue(ismailPage.investorsButonu.isDisplayed(), "Invertors menüsü bulunamadı");
        softAssert.assertTrue(ismailPage.categoriesButonu.isDisplayed(), "Categories menüsü bulunamadı");
        softAssert.assertTrue(ismailPage.typesButonu.isDisplayed(), "Types menüsü bulunamadı");
        softAssert.assertTrue(ismailPage.reviewsButonu.isDisplayed(), "Reviews menüsü bulunamadı");
        softAssert.assertTrue(ismailPage.settingsButonu.isDisplayed(), "Settings menüsü bulunamadı");

        softAssert.assertTrue(ismailPage.propertiesButonu.isEnabled(), "Properties menüsü bulunamadı");
        softAssert.assertTrue(ismailPage.projectsButonu.isEnabled(), "Projects menüsü bulunamadı");
        softAssert.assertTrue(ismailPage.featuresButonu.isEnabled(), "Features menüsü bulunamadı");
        softAssert.assertTrue(ismailPage.facilitiesButonu.isEnabled(), "Facilities menüsü bulunamadı");
        softAssert.assertTrue(ismailPage.investorsButonu.isEnabled(), "Invertors menüsü bulunamadı");
        softAssert.assertTrue(ismailPage.categoriesButonu.isEnabled(), "Categories menüsü bulunamadı");
        softAssert.assertTrue(ismailPage.typesButonu.isEnabled(), "Types menüsü bulunamadı");
        softAssert.assertTrue(ismailPage.reviewsButonu.isEnabled(), "Reviews menüsü bulunamadı");
        softAssert.assertTrue(ismailPage.settingsButonu.isEnabled(), "Settings menüsü bulunamadı");

        extentTest.pass("Admin Real Estate başlığının altındaki menüleri doğrular");

        softAssert.assertAll();

        Driver.quitDriver();
        extentTest.pass("Admin browser'ı kapatır.");
    }
}
