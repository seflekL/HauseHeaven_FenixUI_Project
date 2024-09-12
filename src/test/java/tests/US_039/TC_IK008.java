package tests.US_039;

import org.testng.annotations.Test;
import pages.TeamPages.IsmailPage;
import utilities.*;

public class TC_IK008 extends TestBaseRapor {


    @Test
    public void test02() {
        extentTest = extentReports.createTest("Admin olarak giriş yapıp Real Estate başlığının altındaki Investors sayfasında yeni yatırımcı eklemek istiyorum");
        Driver.getDriver().get(ConfigReader.getProperty("hauseAdminUrl"));
        ReusableMethods.erisimTesti(ConfigReader.getProperty("hauseAdminUrl"));
        extentTest.pass("Admin admin sayfasına erişir");
        IsmailPage ismailPage = new IsmailPage();

        IsmailMethods.hauseHeavenAdminLogin(ismailPage, "ismailkaya.admin@hauseheaven.com", "Hven.150820");

        ismailPage.realEstateButonu.click();
        extentTest.pass("Admin Real Estate Butonuna basar");
        ismailPage.investorsButonu.click();
        extentTest.pass("Admin açılan menüdeki Investors Butonuna basar");
        ReusableMethods.erisimTesti("https://qa.hauseheaven.com/admin/real-estate/investors");

        IsmailMethods.getYatirimciEkleme("Emlak Kapısı",
                "EmlakKapısı, hayalinizdeki evi bulmanızı kolaylaştıran kullanıcı dostu bir platformdur.",
                "Published");

        Driver.quitDriver();
        extentTest.pass("Admin browser'ı kapatır.");
    }
}