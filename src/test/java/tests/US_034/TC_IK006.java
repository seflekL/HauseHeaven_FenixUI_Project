package tests.US_034;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TeamPages.IsmailPage;
import utilities.*;

public class TC_IK006 extends TestBaseRapor {

    @Test
    public void test02() {
        extentTest = extentReports.createTest("Admin olarak giriş yapıp Real Estate sayfasının altındaki başlıkların doğru sayfaya erişmesini istiyorum");
        Driver.getDriver().get(ConfigReader.getProperty("hauseAdminUrl"));
        ReusableMethods.erisimTesti(ConfigReader.getProperty("hauseAdminUrl"));
        extentTest.pass("Admin admin sayfasına erişir");

        IsmailPage ismailPage = new IsmailPage();

        IsmailMethods.hauseHeavenAdminLogin(ismailPage,"ismailkaya.admin@hauseheaven.com","Hven.150820");

        ismailPage.realEstateButonu.click();
        extentTest.pass("Admin Real Estate Butonuna basar");

        SoftAssert softAssert = new SoftAssert();

        extentTest.pass("Admin Real Estate başlığının altındaki herhangi bir menüye tıklar ve doğru sayfaya eriştiğini doğrular");

        IsmailMethods.sayfaDogrulama(ismailPage.propertiesButonu, "Properties", softAssert);
        IsmailMethods.sayfaDogrulama(ismailPage.projectsButonu, "Projects", softAssert);
        IsmailMethods.sayfaDogrulama(ismailPage.featuresButonu, "Features", softAssert);
        IsmailMethods.sayfaDogrulama(ismailPage.facilitiesButonu, "Facilities", softAssert);
        IsmailMethods.sayfaDogrulama(ismailPage.investorsButonu, "Investors", softAssert);
        IsmailMethods.sayfaDogrulama(ismailPage.categoriesButonu, "Categories", softAssert);
        IsmailMethods.sayfaDogrulama(ismailPage.typesButonu, "Types", softAssert);
        IsmailMethods.sayfaDogrulama(ismailPage.reviewsButonu, "Reviews", softAssert);

        ismailPage.settingsButonu.click();
        softAssert.assertEquals(ismailPage.settingsSayfaDogrulama.getText(),"Settings");

        softAssert.assertAll();

        Driver.quitDriver();
        extentTest.pass("Admin browser'ı kapatır.");
    }

}
