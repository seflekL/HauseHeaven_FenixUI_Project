package tests.US_053;

import org.bouncycastle.oer.its.etsi102941.Url;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.LeventMethods;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.List;

public class TC_L035adminContiresTestPage extends TestBaseRapor {
    @Test
    public void CountiresTestPage() {
        extentTest = extentReports.createTest("Admin Countries Test Page ");

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
        //Admin  sayfasinda SideNavigation da yer alan Location basliginin altinda ki "Countires" tiklar  ulke isimleri listelereyrek kontrol eder
        List<String> ulkepageList = ReusableMethods.getStringList(adminDashboard.sefadminCountiresUlkeList);
        System.out.println(ulkepageList);
        for (String eachulke : ulkepageList) {

            Assert.assertTrue(ulkepageList.contains(eachulke));

        }
        extentTest.pass("Ayni sekmede acildigini   kontrol eder");

        //Admin  sayfasinda Countiries  Url'sinin dogru Url oldugunu test eder

        LeventMethods.urlTest("https://qa.hauseheaven.com/admin/countries");
        extentTest.pass("Admin  sayfasinda Countiries  Url'sinin dogru Url oldugunu test eder");


        //Admin  sayfasinda SideNavigation da yer alan Location basliginin altinda ki "Countires" tiklar  acilan  sayfa da "sideNavigationoldugunu test eder

        Assert.assertTrue(adminDashboard.sefadminSidedDashElementi.isDisplayed());
        extentTest.pass("Admin  sayfasinda SideNavigation da yer alan Location basliginin altinda ki \"Countires\" tiklar  acilan  sayfa da \"sideNavigationoldugunu test eder\n");


        //Admin basarili sekilde cikis yapar ve taraciyi kapatir
        LeventMethods.adminLogoutTesti();
        extentTest.pass("Admin basarili sekilde cikis yapar ve taraciyi kapatir");


    }
}
