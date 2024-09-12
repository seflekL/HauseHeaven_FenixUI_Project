package java.tests.US_030;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_F011 extends TestBaseRapor {

    @Test
    public void test11(){

        extentTest = extentReports.createTest("Adminin admin sayfasina ulasabilmesi ve bir blog oluşturabilmesi testi");
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


        //Admin "+create" butonuna tiklar ve gonderi olusturma sayfasina ulasir
        ReusableMethods.hover(adminDashboard.create);
        adminDashboard.create.click();
        extentTest.info("Admin '+create' butonuna tiklar ve gonderi olusturma sayfasina ulasir");


        //Admin Create new post sayfasinda Name kutusuna adini girer
        ReusableMethods.hover(adminDashboard.createNewpostName);
        adminDashboard.createNewpostName.sendKeys("Fatma");
        extentTest.info("Admin Create new post sayfasinda Name kutusuna adini girer");


        //Admin Create new post sayfasinda 'House design' butonunu tiklar
        //ReusableMethods.hover(adminDashboard.createHousedesign);
        //adminDashboard.createHousedesign.click();
        //extentTest.info("Admin Create new post sayfasinda 'House design' butonunu tiklar");

        //Admin Create new post sayfasinda 'House design' butonunu tiklar
        ReusableMethods.hover(adminDashboard.createHouseArchitecture);

        ReusableMethods.bekle(2);
        adminDashboard.createHouseArchitecture.click();
        extentTest.info("Admin Create new post sayfasinda 'House design' butonunu tiklar");


        //Admin Create new post sayfasinda 'Save & Exit' butonunu tiklar
        ReusableMethods.hover(adminDashboard.createSaveExit);
        adminDashboard.createSaveExit.click();
        extentTest.info("Admin Create new post sayfasinda 'Save & Exit' butonunu tiklar");

        // Anasayfada buyuk resmi test eder
        Assert.assertTrue(adminDashboard.PostName.isDisplayed());
        extentTest.pass("Admin Post sayfasinda Blog olusturdugunu test eder");

        Driver.quitDriver();

    }

}
