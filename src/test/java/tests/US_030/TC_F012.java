package tests.US_030;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.List;

public class TC_F012 extends TestBaseRapor {

    @Test
    public void test12(){

        extentTest = extentReports.createTest("Bolg'un yeniden duzenlenebilmesi testi");
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

        //Admin Create new post sayfasinda duzenlemek istedigi Blog uzerinde 'Edit'butonuna tiklar
        ReusableMethods.hover(adminDashboard.PostEdit);
        adminDashboard.PostEdit.click();
        extentTest.info("Admin duzenlemek istedigi Blog bilgilerine ulasir.");

        //Admin Create new post sayfasinda zorunlu alanlari doldurmadan 'Save & Exit' butonunu tiklar
       // ReusableMethods.hover(adminDashboard.createSaveExit);
        //adminDashboard.createSaveExit.click();
       // extentTest.info("Admin Create new post sayfasinda zorunlu alanlari doldurmadan 'Save & Exit' butonunu tiklar");

        //Zorunlu alanlari doldurmadigi icin hata mesaji alir
        ReusableMethods.hover(adminDashboard.PostNameError);
        adminDashboard.PostNameError.getText();
        extentTest.info("Zorunlu alanlari doldurmadigi icin hata mesaji alir");

        //Zorunlu alanlari doldurmadigi icin hata mesaji alir
        ReusableMethods.hover(adminDashboard.elemTexts);
        adminDashboard.elemTexts.getText();
        extentTest.info("Zorunlu alanlari doldurmadigi icin hata mesaji alir");


        //Admin Create new post sayfasinda Name kutusuna adini girer
        ReusableMethods.hover(adminDashboard.createNewpostName);
        adminDashboard.createNewpostName.sendKeys("Fatma");
        extentTest.info("Admin Create new post sayfasinda Name kutusuna adini girer");


        //Admin Create new post sayfasinda 'House design' 'House architecture' olarak degistirir
        ReusableMethods.hover(adminDashboard.createHousedesign);
        adminDashboard.createHousedesign.click();

        ReusableMethods.hover(adminDashboard.createHousedesign);
        adminDashboard.createHousedesign.click();

        ReusableMethods.hover(adminDashboard.createHouseArchitecture);
        adminDashboard.createHouseArchitecture.click();
        extentTest.info("Admin Create new post sayfasinda 'House design' 'House architecture' olarak degistirir");


        //Admin Create new post sayfasinda 'Save & Exit' butonunu tiklar
        ReusableMethods.hover(adminDashboard.createSaveExit);
        adminDashboard.createSaveExit.click();
        extentTest.info("Admin Create new post sayfasinda 'Save & Exit' butonunu tiklar");

        // Anasayfada buyuk resmi test eder
        Assert.assertFalse(adminDashboard.PostName.isDisplayed());
        extentTest.pass("Admin Post sayfasinda Blog olusturdugunu test eder");

        Driver.quitDriver();

    }
}
