package java.tests.US_053;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.Driver;
import utilities.LeventMethods;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.security.Key;

import static utilities.TestBaseRapor.extentReports;

public class TC_L038CountiresPageEditTest extends TestBaseRapor {

    @Test
    public void Test038adminLocationEditTestPage() {
        extentTest = extentReports.createTest("Admin Lcaiton Edit Test Page");

        Faker faker = new Faker();
        AdminDashboard adminDashboard = new AdminDashboard();
        //Admin hauseheaven Admin sayfasina onceden verilmis Username ve Password Ile basarili sekilde giris saglar
        LeventMethods.admingirisDashboard();
        extentTest.pass("Admin hauseheaven Admin sayfasina onceden verilmis Username ve Password Ile basarili sekilde giris saglar");
        //Admin sayfasinda SideNavigation da yer alan "Location" basliginat tiklar
        adminDashboard.sefadminLocationButtonElementi.click();
        extentTest.pass("Admin sayfasinda SideNavigation da yer alan \"Location\" basliginat tiklar");

        //Admin sayfasinda SideNavigation da yer alan Location basliginin altinda ki "Countires" tiklar
        adminDashboard.sefadminCountiresButtonElementi.click();
        extentTest.pass("Admin sayfasinda SideNavigation da yer alan Location basliginin altinda ki \"Countires\" tiklar");

        //Ayni sekmede acildigini   kontrol eder
        LeventMethods.windowsHanldes(1);
        extentTest.pass("Ayni sekmede acildigini   kontrol eder");

        //Admin  sayfasinda Countiries  Url'sinin dogru Url oldugunu test eder

        LeventMethods.urlTest("https://qa.hauseheaven.com/admin/countries");
        extentTest.pass("Admin  sayfasinda Countiries  Url'sinin dogru Url oldugunu test eder");


        //Admin sayfa da "sideNavigationoldugunu test eder

        Assert.assertTrue(adminDashboard.sefadminSidedDashElementi.isDisplayed());
        extentTest.pass("Admin sayfa da \"sideNavigationoldugunu test eder");

        //Admin SearchBox dah daha onceden Create etti "Konyali"ulkesini aratir
        adminDashboard.sefadminSearchboxElementi.sendKeys("Konyali");
        extentTest.pass("Admin SearchBox dah daha onceden Create etti \"Konyali\"ulkesini aratir");

        //Admin "Countires" sayfasinda yer olusturdugu ulkenin son colum'unda yer alan "Edit" butonuna tiklar
        adminDashboard.sefadminCountiresEditButtonElementi.click();
        extentTest.pass("Admin \"Countires\" sayfasinda yer olusturdugu ulkenin son colum'unda yer alan \"Edit\" butonuna tiklar");

        //Admin "Edit" sayfasinda yer alan "Name Box" Test ulke ismi girer
        adminDashboard.sefadminCountiresNameBoxElementi.sendKeys(Keys.BACK_SPACE);
        adminDashboard.sefadminCountiresNameBoxElementi.sendKeys("PlatiniumKonyali");
        extentTest.pass("Admin \"Edit\" sayfasinda yer alan \"Name Box\" Test ulke ismi girer");


        //Admin "Edit" sayfasinda yer alan "Nationality Box" Test Nationality ismi girer
        adminDashboard.sefadminCountiresNationalityElementi.sendKeys(faker.backToTheFuture().character());
        //Admin "Edit" sayfasinda "Country ISO Code Box"  harf girer
        adminDashboard.sefadminCountiresISOBoxElementi.sendKeys("ET");
        extentTest.pass("Admin \"Edit\" sayfasinda yer alan \"Nationality Box\" Test Nationality ismi girer");


        //Admin "Edit" sayfasinda yer alan "Dial Code"  kisminda rakami siler
        adminDashboard.sefadminCountiresOrderBoxElementi.sendKeys(Keys.BACK_SPACE);
        adminDashboard.sefadminCountiresDialCodeBoxElementi.sendKeys("4242");
        extentTest.pass("Admin \"Edit\" sayfasinda yer alan \"Dial Code\"  kisminda rakami siler");

        //Admin "Edit" sayfasinda yer alan "Order Box"kismina "6" rakamani girer
        adminDashboard.sefadminCountiresOrderBoxElementi.clear();
        adminDashboard.sefadminCountiresOrderBoxElementi.sendKeys("6");
        extentTest.pass("Admin \"Edit\" sayfasinda yer alan \"Order Box\"kismina \"6\" rakamani girer");


        //Admin "Edit" sayfasinda yer alan "StatusBox" dropdown menusenden  "Draft" secer
        adminDashboard.sefadminCountiresStatusBoxElementi.click();
        ReusableMethods.waitForVisibility(adminDashboard.sefadminCountiresPublishedselectElementi, 10);
        Select selectpublishedStatus = new Select(adminDashboard.sefadminCountiresPublishedselectElementi);
        selectpublishedStatus.selectByValue("draft");
        adminDashboard.sefadminCountiresStatusBoxElementi.click();
          ReusableMethods.wait(2);
        extentTest.pass("Admin \"Edit\" sayfasinda yer alan \"StatusBox\" dropdown menusenden  \"Draft\" secer");

        //Admin "Edit" sayfasinda yer alan "Save"butonuna tiklar
        adminDashboard.sefadminCountiresSaveElementi.click();
        ReusableMethods.wait(2);
        extentTest.pass("Admin \"Edit\" sayfasinda yer alan \"Save\"butonuna tiklar");

        //Admin basarli sekilde ulkenin kayit oldugunu dogrular
        ReusableMethods.waitForVisibility(adminDashboard.sefadminCreateEditPageKayyitMSGElementi,10);
        Assert.assertTrue(adminDashboard.sefadminCreateEditPageKayyitMSGElementi.isDisplayed());
        extentTest.pass("Admin basarli sekilde ulkenin kayit oldugunu dogrular");

        //Admin "Edit" sayfasinda yer alan "Save & Exit" butonunu tiklar
        adminDashboard.sefadminCountiresSaveExitElementi.click();
        adminDashboard.sefadminSearchboxElementi.sendKeys(Keys.BACK_SPACE);
        adminDashboard.sefadminCountiresReloadButtonElementi.click();
        extentTest.pass("Admin \"Edit\" sayfasinda yer alan \"Save & Exit\" butonunu tiklar");

        //Admin basarli sekilde cikis yapar
        LeventMethods.adminLogoutTesti();
        extentTest.pass("Admin basarli sekilde cikis yapar");

    }

}

