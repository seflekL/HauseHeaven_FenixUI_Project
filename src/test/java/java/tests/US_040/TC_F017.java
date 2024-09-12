package java.tests.US_040;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_F017 extends TestBaseRapor {

    @Test
    public void test17(){



        extentTest = extentReports.createTest(" Kategoriler sayfasında kategorileri silme testi ");
        Driver.getDriver().get(ConfigReader.getProperty("hauseAdminUrl"));
        extentTest.info("Admin Login sayfasina gider");

        AdminDashboard adminDashboard=new AdminDashboard();

        ReusableMethods.hover(adminDashboard.adminUsername);
        adminDashboard.adminUsername.sendKeys(ConfigReader.getProperty("gecerliAdminUsername"));

        ReusableMethods.hover(adminDashboard.adminPassword);
        adminDashboard.adminPassword.sendKeys(ConfigReader.getProperty("gecerliPassword"));


        ReusableMethods.hover(adminDashboard.adminSignin);
        adminDashboard.adminSignin.click();
        extentTest.info("Admin Login sayfasinda Username, Password girer ve Admin Dashboard sayfasina gider");


        //Admin Real Estate butonuna tiklar
        ReusableMethods.hover(adminDashboard.RealEstate);
        adminDashboard.RealEstate.click();
        ReusableMethods.bekle(2);
        extentTest.info("Admin Real Estate butonuna tiklar.");

        //Admin Categories butonuna tiklar
        ReusableMethods.hover(adminDashboard.Categories);
        adminDashboard.Categories.click();
        ReusableMethods.bekle(2);
        extentTest.info("Admin Categories butonuna tiklar.");

        //Admin Categories butonuna tiklar
        ReusableMethods.hover(adminDashboard.RealEstateDelete);
        adminDashboard.RealEstateDelete.click();
        ReusableMethods.bekle(2);

        ReusableMethods.hover(adminDashboard.RealEstateConfirmDelete);
        adminDashboard.RealEstateConfirmDelete.click();
        ReusableMethods.bekle(2);
        extentTest.info("Admin silmek istedigi kategoriyi siler");

        Assert.assertTrue(adminDashboard.RealEstateSuccess.isDisplayed());
        extentTest.pass("Admin kategiyi basariyla sildigini test eder");

        Driver.quitDriver();
    }
}
