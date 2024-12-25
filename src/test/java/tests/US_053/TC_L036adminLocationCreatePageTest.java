package tests.US_053;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.LeventMethods;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_L036adminLocationCreatePageTest extends TestBaseRapor {

    @Test
    public void Test036adminLocationCreateTestPage()

    {
        extentTest = extentReports.createTest("Yeni Location Ekleme Testi");

        AdminDashboard adminDashboard = new AdminDashboard();
        //Admin hauseheaven Admin sayfasina onceden verilmis Username ve Password Ile basarili sekilde giris saglar
        LeventMethods.admingirisDashboard();
        extentTest.pass("Admin sayfasina, onceden tanimlanmis Username ve Password ile basarili sekilde giris saglar.");
        //Admin sayfasinda SideNavigation da yer alan "Location" basliginat tiklar
        adminDashboard.sefadminLocationButtonElementi.click();
        extentTest.pass("Admin sayfasinda side navigation'da yer alan 'Location' basligina tiklar.");
        //Admin sayfasinda SideNavigation da yer alan Location basliginin altinda ki "Countires" tiklar
        adminDashboard.sefadminCountiresButtonElementi.click();
        extentTest.pass("Admin sayfasinda side navigation'da yer alan 'Location' basligi altindaki 'Countries' secenegine tiklar.");
        //Ayni sekmede acildigini   kontrol eder
        LeventMethods.windowsHanldes(1);
        extentTest.pass("Sayfanin ayni sekmede acildigini kontrol eder.");
        //Admin  sayfasinda Countiries  Url'sinin dogru Url oldugunu test eder

        LeventMethods.urlTest("https://qa.hauseheaven.com/admin/countries");
        extentTest.pass("Admin sayfasinda 'Countries' URL'sinin dogru URL oldugunu test eder.");

        //Admin  sayfasinda SideNavigation da yer alan Location basliginin altinda ki "Countires" tiklar  acilan  sayfa da "sideNavigationoldugunu test eder

        Assert.assertTrue(adminDashboard.sefadminSidedDashElementi.isDisplayed());
        extentTest.pass("Admin sayfasinda side navigation'da yer alan 'Location' basligi altindaki 'Countries' secenegine tiklar ve acilan sayfada side navigation'in goruntulendigini dogrular.");

        //Admin "Countires" sayfasinda yer alan "+Create" butonuna tiklar
        adminDashboard.sefadminCountiresCreateButtonElementi.click();
        extentTest.pass("Admin 'Countries' sayfasinda yer alan '+Create' butonuna tiklar.");
        //Admin "Countires/Create" sayfasinda yer alan "Name Box" Test ulke ismi girer
        adminDashboard.sefadminCountiresNameBoxElementi.sendKeys("Konyali");
        extentTest.pass("Admin 'Countries/Create' sayfasinda yer alan 'Name Box' alanina test ulke ismi girer.");

        //Admin "Countires/Create" sayfasinda yer alan "Nationality Box" Test Nationality ismi girer
        adminDashboard.sefadminCountiresNationalityElementi.sendKeys("Thunder");
        extentTest.pass("Admin 'Countries/Create' sayfasinda yer alan 'Nationality Box' alanina test ulke milliyeti girer.");
        //Admin "Country ISO Code Box"   kisimina buyuk harfler ile ulkenin girlein uklenin birinci ve ikinci harfini girer
        adminDashboard.sefadminCountiresISOBoxElementi.sendKeys("KO");
        extentTest.pass("Admin 'Country ISO Code Box' kismina ulkenin birinci ve ikinci harfini buyuk harflerle girer.");

        //Admin "Countires/Create" sayfasinda yer alan "Dial Code"  kisminda rakami siler
        adminDashboard.sefadminCountiresDialCodeBoxElementi.sendKeys("42");
        extentTest.pass("Admin 'Countries/Create' sayfasinda yer alan 'Dial Code' kismina giderek rakami siler.");
        //Admin "Countires/Create" sayfasinda yer alan "Order Box"kismina "1" rakamani girer
        adminDashboard.sefadminCountiresOrderBoxElementi.clear();
        adminDashboard.sefadminCountiresOrderBoxElementi.sendKeys("99");
        extentTest.pass("Admin 'Countries/Create' sayfasinda yer alan 'Order Box' kismina '1' rakamini girer.");

        //Admin "Countires/Create" sayfasinda yer alan "StatusBox" dropdown menusenden  "Published" secer
        adminDashboard.sefadminCountiresStatusBoxElementi.click();
        ReusableMethods.waitForVisibility(adminDashboard.sefadminCountiresPublishedselectElementi,10);
        Select selectpublishedStatus=new Select(adminDashboard.sefadminCountiresPublishedselectElementi);
         selectpublishedStatus.selectByValue("draft");
         adminDashboard.sefadminCountiresStatusBoxElementi.click();
        extentTest.pass("Admin 'Countries/Create' sayfasinda yer alan 'StatusBox' dropdown menusunden 'Published' secenegini secer.");
         //Admin "Countires/Create" sayfasinda yer alan "Save"butonuna tiklar
        adminDashboard.sefadminCountiresSaveElementi.click();
        ReusableMethods.wait(2);
        extentTest.pass("Admin 'Countries/Create' sayfasinda yer alan 'Save' butonuna tiklar.");
        //Admin basarli sekilde ulkenin kayit oldugunu dogrular
        ReusableMethods.waitForVisibility(adminDashboard.sefadminCreateEditPageKayyitMSGElementi,10);
        Assert.assertTrue(adminDashboard.sefadminCreateEditPageKayyitMSGElementi.isDisplayed());
        extentTest.pass("Admin basarili sekilde ulkenin kaydedildigini dogrular.");
        //Admin "Countires/Create" sayfasinda yer alan "Save & Exit" butonunu tiklar
        adminDashboard.sefadminCountiresSaveExitElementi.click();
        extentTest.pass("Admin 'Countries/Create' sayfasinda yer alan 'Save & Exit' butonuna tiklar.");

        //Admin basarli sekilde cikis yapar
        LeventMethods.adminLogoutTesti();
        extentTest.pass("Admin basarli sekilde cikis yapar");

    }

}
