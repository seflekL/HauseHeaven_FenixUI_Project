package java.tests.US_044;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.*;

public class TC_R024 extends TestBaseRapor {
    @Test
public void Test01(){
        extentTest=extentReports.createTest
                ("Admin dashboardda newsletterlarin CSV ya da Excel formatinda export edilebilmesi testi");
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

            adminDashboard.exportButonu.click();
            extentTest.pass("Admin Export butonuna tiklar");

            adminDashboard.CSVFormatIndirme.click();
            extentTest.pass("CSV formatinda liste indirmek icin CSV butonuna tiklar");

        ReusableMethods.bekle(3);
        boolean fileExists = RanaMethod.check_file_exist_and_delete("NewsletterTable");
        RanaMethod.deleteDownloadFolder();
        Assert.assertTrue(fileExists);

        adminDashboard.sefadminHeaderUserNameButtonu.click();
        extentTest.pass("Admin username butonuna tiklar");

        adminDashboard.sefadminHeaderLogoutButtonu.click();
        extentTest.pass("Admin Logout butonuna tiklar ve logout olur");

        Driver.getDriver().quit();
        extentTest.pass("Kullanici browseri kapatir.");

}
}
