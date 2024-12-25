package tests.US_053;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.LeventMethods;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_040 extends TestBaseRapor {

    @Test
    public  void TC_039UlkeDeleteTest(){
        extentTest = extentReports.createTest("Country Deletion Testi");

        Faker faker = new Faker();
        AdminDashboard adminDashboard = new AdminDashboard();
        //Admin hauseheaven Admin sayfasina onceden verilmis Username ve Password Ile basarili sekilde giris saglar
        LeventMethods.admingirisDashboard();
        extentTest.pass("Admin belirtilen Admin sayfasina onceden tanimlanmis Username ve Password ile basarili sekilde giris yapar.");

        //Admin sayfasinda SideNavigation da yer alan "Location" basliginat tiklar
        adminDashboard.sefadminLocationButtonElementi.click();
        extentTest.pass("Admin sayfasinda side navigation'da yer alan 'Location' basligi altindaki 'Countries' secenegine tiklar.");
        //Admin sayfasinda SideNavigation da yer alan Location basliginin altinda ki "Countires" tiklar
        adminDashboard.sefadminCountiresButtonElementi.click();
        extentTest.pass("Admin, side navigation'da 'Location' altindaki 'Countries' secenegine tiklar.");
        //Ayni sekmede acildigini   kontrol eder
        LeventMethods.windowsHanldes(1);
        extentTest.pass("Ayni sekmede acildigini kontrol eder.");
        //Admin  sayfasinda Countiries  Url'sinin dogru Url oldugunu test eder

        LeventMethods.urlTest("https://qa.hauseheaven.com/admin/countries");
        extentTest.pass("Countries URL'sinin dogru oldugunu test eder.");

        //Admin sayfa da "sideNavigationoldugunu test eder

        Assert.assertTrue(adminDashboard.sefadminSidedDashElementi.isDisplayed());
        //Admin SearchBox dah daha onceden Create etti "Konyali"ulkesini aratir
        adminDashboard.sefadminSearchboxElementi.sendKeys("Konyali");
        extentTest.pass("Sayfada side navigation'in varligini dogrular.");

        //Admin arattigi ullkeinin "Operations" colum altinda yer alan "Remove" butonunua tiklar
        adminDashboard.sefadminDeleteButton.click();
        ReusableMethods.wait(1);
        extentTest.pass("Admin, arattigi ulkenin 'Operations' sutununda yer alan 'Remove' butonuna tiklar.");
        //Admin acilan"Remove Button" box'inda delete basarak test ulkenin silinmesini onaylar
        adminDashboard.sefadminDeleteConfirmMsg.click();
        extentTest.pass("Admin, acilan 'Remove' kutusunda 'Delete' butonuna basarak ulkenin silinmesini onaylar.");
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
        extentTest.pass("Admin, test ulkesinin 'Location/Countries' altindaki ulkeler listesinden silindigini kontrol eder.");

        //Admin Sayfayi basarli sekilde Logout yapar
        LeventMethods.adminLogoutTesti();
        extentTest.pass("Admin sayfayi basarili sekilde logout yapar.");




    }
}
