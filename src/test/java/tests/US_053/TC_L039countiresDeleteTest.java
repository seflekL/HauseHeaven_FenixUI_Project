package tests.US_053;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.Driver;
import utilities.LeventMethods;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.ResourceBundle;

public class TC_L039countiresDeleteTest extends TestBaseRapor {

    @Test
    public  void TC_039UlkeDeleteTest(){
        extentTest = extentReports.createTest("UlkeDeleteTesti");

        Faker faker = new Faker();
        AdminDashboard adminDashboard = new AdminDashboard();
        //Admin hauseheaven Admin sayfasina onceden verilmis Username ve Password Ile basarili sekilde giris saglar
        LeventMethods.admingirisDashboard();
        extentTest.pass("Admin hauseheaven Admin sayfasina onceden verilmis Username ve Password Ile basarili sekilde giris saglarr");

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
        //Admin SearchBox dah daha onceden Create etti "Konyali"ulkesini aratir
        adminDashboard.sefadminSearchboxElementi.sendKeys("Konyali");
        extentTest.pass("Admin sayfa da \"sideNavigationoldugunu test eder\n");

        //Admin arattigi ullkeinin "Operations" colum altinda yer alan "Remove" butonunua tiklar
        adminDashboard.sefadminDeleteButton.click();
        ReusableMethods.wait(1);
        extentTest.pass("Admin arattigi ullkeinin \"Operations\" colum altinda yer alan \"Remove\" butonunua tiklar");
        //Admin acilan"Remove Button" box'inda delete basarak test ulkenin silinmesini onaylar
        adminDashboard.sefadminDeleteConfirmMsg.click();
        extentTest.pass("Admin acilan\"Remove Button\" box'inda delete basarak test ulkenin silinmesini onaylar");
        //Admin test ulkenin admin "Location/Countires" daki ulkleler listesinden silindigini kontrol eder
        Assert.assertTrue(adminDashboard.sefadminCreateEditPageKayyitMSGElementi.isDisplayed());
        ReusableMethods.wait(1);
        adminDashboard.sefadminSearchboxElementi.click();
        adminDashboard.sefadminSearchboxElementi.sendKeys(Keys.BACK_SPACE);
        adminDashboard.sefadminSearchboxElementi.sendKeys(Keys.BACK_SPACE);
        adminDashboard.sefadminSearchboxElementi.sendKeys(Keys.BACK_SPACE);
        adminDashboard.sefadminSearchboxElementi.sendKeys(Keys.BACK_SPACE);
        adminDashboard.sefadminSearchboxElementi.sendKeys(Keys.BACK_SPACE);
        adminDashboard.sefadminSearchboxElementi.sendKeys(Keys.BACK_SPACE);
        adminDashboard.sefadminSearchboxElementi.sendKeys(Keys.BACK_SPACE);
        ReusableMethods.wait(1);
        extentTest.pass("dmin test ulkenin admin \"Location/Countires\" daki ulkleler listesinden silindigini kontrol eder");

        //Admin Sayfayi basarli sekilde Logout yapar
        LeventMethods.adminLogoutTesti();
        extentTest.pass("Admin Sayfayi basarli sekilde Logout yapar");




    }
}
