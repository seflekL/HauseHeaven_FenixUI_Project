package tests.US_48;

import org.apache.hc.core5.util.ReflectionUtils;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_R032 extends TestBaseRapor {
    @Test
    public void Test01(){
        extentTest=extentReports.createTest
                ("Admin dashboardda mesajlarin 10/30/50/100/500/All seklinde siralanabilmesi testi");
        Driver.getDriver().get(ConfigReader.getProperty("hauseAdminUrl"));
        extentTest.pass("Hause Heaven Admin dashboarda gidildi.");

        AdminDashboard adminDashboard = new AdminDashboard();
        adminDashboard.usernameTextbox.sendKeys("rananurulker.admin@hauseheaven.com");
        extentTest.pass("Admin Email/Username textboxa belirlenmis emaili girer");
        adminDashboard.passwordAdminTextbox.sendKeys("Hven.150820");
        extentTest.pass("Admin Password textbox'a belirlenmis passwordu girer");
        adminDashboard.signInButonu.click();
        extentTest.pass("Admin Sign In Butonuna tiklar");

        adminDashboard.adminContactLink.click();
        extentTest.pass("Admin Contact linkine tiklar");

        ReusableMethods.hover(adminDashboard.contactSayfasiMesajSIralama10lu);
        ReusableMethods.bekle(3);
        adminDashboard.contactSayfasiMesajSIralama10lu.click();
        extentTest.pass("Admin siralanan mesajlari 10lu sekilde gorebilmek icin 10 yazili siralama kutusuna tiklar.");
        Select select=new Select(adminDashboard.contactSayfasiMesajSIralama10lu);
        select.selectByValue("30");
        ReusableMethods.bekle(3);
        ReusableMethods.hover(adminDashboard.contactSayfasiMesajSIralama10lu);
        select.selectByValue("100");
        ReusableMethods.bekle(3);
        ReusableMethods.hover(adminDashboard.contactSayfasiMesajSIralama10lu);
        select.selectByValue("500");
        ReusableMethods.bekle(3);
        ReusableMethods.hover(adminDashboard.contactSayfasiMesajSIralama10lu);
        select.selectByValue("-1");
        ReusableMethods.bekle(3);
        ReusableMethods.hover(adminDashboard.sefadminHeaderUserNameButtonu);
        adminDashboard.sefadminHeaderUserNameButtonu.click();
        extentTest.pass("Admin username butonuna tiklar");

        adminDashboard.sefadminHeaderLogoutButtonu.click();
        extentTest.pass("Admin Logout butonuna tiklar ve logout olur");


        Driver.getDriver().quit();
        extentTest.pass("Ziyaretci browseri kapatir.");
    }
}
