package java.tests.US_044;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_R025 extends TestBaseRapor {
    @Test
public void Test01() {
        extentTest = extentReports.createTest
                ("Admin dashboardda newsletterlarin 10/30/50/100/500/All seklinde siralanabilmesi testi");
        Driver.getDriver().get(ConfigReader.getProperty("hauseAdminUrl"));
        extentTest.pass("Hause Heaven Admin dashboarda gidildi.");

        AdminDashboard adminDashboard = new AdminDashboard();

        adminDashboard.usernameTextbox.sendKeys("rananurulker.admin@hauseheaven.com");
        extentTest.pass("Admin Email/Username textboxa belirlenmis emaili girer");
        adminDashboard.passwordAdminTextbox.sendKeys("Hven.150820");
        extentTest.pass("Admin Password textbox'a belirlenmis passwordu girer");
        adminDashboard.signInButonu.click();
        extentTest.pass("Admin Sign In Butonuna tiklar");

        adminDashboard.adminNewsletter.click();
        extentTest.pass("Admin Newsletter Butonuna tiklar");

        ReusableMethods.hover(adminDashboard.mesajlariSiralamaButonu);
        ReusableMethods.bekle(3);
        adminDashboard.mesajlariSiralamaButonu.click();
        extentTest.pass("Admin siralanan newsletterlari 10lu sekilde gorebilmek icin 10 yazili siralama kutusuna tiklar.");
        Select select=new Select(adminDashboard.mesajlariSiralamaButonu);
        select.selectByValue("30");
        ReusableMethods.bekle(3);
        ReusableMethods.hover(adminDashboard.mesajlariSiralamaButonu);
        select.selectByValue("50");
        ReusableMethods.bekle(3);
        ReusableMethods.hover(adminDashboard.mesajlariSiralamaButonu);
        select.selectByValue("100");
        ReusableMethods.bekle(3);
        ReusableMethods.hover(adminDashboard.mesajlariSiralamaButonu);
        select.selectByValue("500");
        ReusableMethods.bekle(3);
        ReusableMethods.hover(adminDashboard.mesajlariSiralamaButonu);
        select.selectByValue("-1");
        ReusableMethods.bekle(3);

        ReusableMethods.hover(adminDashboard.sefadminHeaderUserNameButtonu);

        adminDashboard.sefadminHeaderUserNameButtonu.click();
        extentTest.pass("Admin username butonuna tiklar");

        adminDashboard.sefadminHeaderLogoutButtonu.click();
        extentTest.pass("Admin Logout butonuna tiklar ve logout olur");

        Driver.getDriver().quit();
        extentTest.pass("Kullanici browseri kapatir.");

    }

}
