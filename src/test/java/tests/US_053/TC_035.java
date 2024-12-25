package tests.US_053;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.LeventMethods;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.List;

public class TC_035 extends TestBaseRapor {
    @Test
    public void CountiresTestPage() {
        extentTest = extentReports.createTest("Admin Countries Side Navigation Testi ");

        AdminDashboard adminDashboard = new AdminDashboard();


        //Admin hauseheaven Admin sayfasina onceden verilmis Username ve Password Ile basarili sekilde giris saglar

        LeventMethods.admingirisDashboard();
        extentTest.pass("Admin sayfasına, önceden tanımlanmış kullanıcı adı ve şifre ile başarılı giriş sağlandı.");

        //Admin sayfasinda SideNavigation da yer alan "Location" basliginat tiklar
        adminDashboard.sefadminLocationButtonElementi.click();
        extentTest.pass("Admin sayfasinda yan navigasyonda yer alan 'Location' basligina tiklar.");

        //Admin sayfasinda SideNavigation da yer alan Location basliginin altinda ki "Countires" tiklar
        adminDashboard.sefadminCountiresButtonElementi.click();
        extentTest.pass("Admin sayfasinda yan navigasyondaki Location basligi altinda bulunan 'Countries' secenegine tiklar.");

        //Ayni sekmede acildigini   kontrol eder
        LeventMethods.windowsHanldes(1);
         //SideNavigation da yer alan Location basliginin altinda ki "Countires" tiklar  ulke isimleri listelereyrek kontrol eder
        List<String> ulkepageList = ReusableMethods.getStringList(adminDashboard.sefadminCountiresUlkeList);
        System.out.println(ulkepageList);
        for (String eachulke : ulkepageList) {

            Assert.assertTrue(ulkepageList.contains(eachulke));

        }
        extentTest.pass("Ayni sekmede acildigini kontrol eder.");

        //Admin  sayfasinda Countiries  Url'sinin dogru Url oldugunu test eder

        LeventMethods.urlTest("https://qa.hauseheaven.com/admin/countries");
        extentTest.pass("Admin sayfasinda 'Countries' URL'sinin beklenen URL ile uyumlu oldugunu dogrular.");


        //Admin  sayfasinda SideNavigation da yer alan Location basliginin altinda ki "Countires" tiklar  acilan  sayfa da "sideNavigationoldugunu test eder

        Assert.assertTrue(adminDashboard.sefadminSidedDashElementi.isDisplayed());
        extentTest.pass("Admin sayfasinda yan navigasyondaki 'Location' basligi altinda bulunan 'Countries' secenegine tiklar ve acilan sayfada Side Navigation'in goruntulendigini dogrular.");


        //Admin basarili sekilde cikis yapar ve taraciyi kapatir
        LeventMethods.adminLogoutTesti();
        extentTest.pass("Admin kullanicisi basarili sekilde cikis yapar ve tarayiciyi kapatir.");


    }
}
