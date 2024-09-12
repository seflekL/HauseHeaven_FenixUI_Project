package java.tests.US_039;

import org.testng.annotations.Test;
import pages.TeamPages.IsmailPage;
import utilities.*;

public class TC_IK011 extends TestBaseRapor {

    @Test
    public void test06() {
        extentTest = extentReports.createTest("Admin olarak giriş yapıp Real Estate başlığının altındaki Investors sayfasında yeni bir yatırımcı eklerken, gerekli alanlar boş bırakıldığında herhangi bir işlem yapmamalı");
        Driver.getDriver().get(ConfigReader.getProperty("hauseAdminUrl"));
        ReusableMethods.erisimTesti(ConfigReader.getProperty("hauseAdminUrl"));
        extentTest.pass("Admin admin sayfasına erişir");

        IsmailPage ismailPage = new IsmailPage();
        IsmailMethods.hauseHeavenAdminLogin(ismailPage,"ismailkaya.admin@hauseheaven.com","Hven.150820");

        ismailPage.realEstateButonu.click();
        extentTest.pass("Admin Real Estate Butonuna basar");
        ismailPage.investorsButonu.click();
        extentTest.pass("Admin açılan menüdeki Investors Butonuna basar");
        ReusableMethods.erisimTesti("https://qa.hauseheaven.com/admin/real-estate/investors");

        IsmailMethods.getYatirimciEkleme();

        Driver.quitDriver();
        extentTest.pass("Admin browser'ı kapatır.");
    }
}