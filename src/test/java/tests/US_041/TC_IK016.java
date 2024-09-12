package tests.US_041;

import org.testng.annotations.Test;
import pages.TeamPages.IsmailPage;
import utilities.*;

public class TC_IK016 extends TestBaseRapor {

    @Test
    public void test04(){

        extentTest = extentReports.createTest("Admin olarak giriş yapıp Real Estate başlığının altındaki Types sayfasında herhangi bir türü silmek istiyorum");
        Driver.getDriver().get(ConfigReader.getProperty("hauseAdminUrl"));
        ReusableMethods.erisimTesti(ConfigReader.getProperty("hauseAdminUrl"));
        extentTest.pass("Admin admin sayfasına erişir");

        IsmailPage ismailPage = new IsmailPage();
        IsmailMethods.hauseHeavenAdminLogin(ismailPage, "ismailkaya.admin@hauseheaven.com", "Hven.150820");

        ismailPage.realEstateButonu.click();
        extentTest.pass("Admin Real Estate Butonuna basar");
        ismailPage.typesButonu.click();
        extentTest.pass("Admin açılan menüdeki Types Butonuna basar");
        ReusableMethods.erisimTesti("https://qa.hauseheaven.com/admin/real-estate/types");

        IsmailMethods.getTurSilme(1);

        Driver.quitDriver();
        extentTest.pass("Admin browser'ı kapatır.");
    }

}
