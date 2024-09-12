package java.tests.US_030;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_F013 extends TestBaseRapor {

    @Test
    public void test13(){

        extentTest = extentReports.createTest("Blog silebilme testi");
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


        //Admin Blog butonuna tiklar
        ReusableMethods.hover(adminDashboard.blog);
        adminDashboard.blog.click();
        extentTest.info("Admin Blog'a tiklar.");

        //Admin Blog butonuna tiklar
        ReusableMethods.hover(adminDashboard.posts);
        adminDashboard.posts.click();
        extentTest.info("Admin Posts'a tiklar ve gonderiler sayfasina ulasir.");

        ReusableMethods.hover(adminDashboard.PostsDelete);
        adminDashboard.PostsDelete.click();
        ReusableMethods.bekle(2);
        extentTest.info("Post silmek icin Delete ikonunu tiklar ve Confirm delete penceresi acilir.");

        ReusableMethods.hover(adminDashboard.ConfirmDelete);
        adminDashboard.ConfirmDelete.click();
        ReusableMethods.bekle(2);
        extentTest.info("Post silmek icin Delete ikonunu tiklar ve Confirm delete penceresi acilir.");


        Assert.assertTrue(adminDashboard.Success.isDisplayed());
        extentTest.pass("Post basariyla silinmistir mesajini goruntuler");

        Driver.quitDriver();


    }
}
