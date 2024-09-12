package java.tests.US_48;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_R030 extends TestBaseRapor {
    @Test
public void Test01(){
        extentTest=extentReports.createTest
                ("Admin dashboardunda mesajlar listelendiginde silme, duzenleme islemlerinin yapilabilmesi testi.");
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

        adminDashboard.adminContactSayfasiDeleteButonu.click();
        extentTest.pass("Admin herhangi bir mesaji silmek icin delete butonuna tiklar.");
        adminDashboard.adminContactSayfasiConfirmDeleteButonu.click();
        extentTest.pass("Admin herhangi bir mesaji silmek icin delete butonuna tikladiktan sonra cikan confirm mesajinda yine delete butonuna tiklar.");
        String expectedResult="Deleted successfully";
        String actualResult=adminDashboard.adminContactDeletedSuccessfullyYazisi.getText();

        Assert.assertEquals(actualResult,expectedResult);
        ReusableMethods.bekle(3);
        extentTest.pass("Admin herhangi bir mesajin silindigini Deleted successfully yazisinin gorulmesiyle dogrular.");

        adminDashboard.adminContactEditButonu.click();
        extentTest.pass("Admin contact sayfasinda bir mesaj duzenlemek icin edit butonuna tiklar.");
        Assert.assertTrue(adminDashboard.adminContactEditViewContactYazisi.isDisplayed());
        extentTest.pass("Admin contact sayfasinda duzenleme sayfasinin acildigini gorur.");

        Select select=new Select(adminDashboard.contactEditPageStatusDDM);
        adminDashboard.contactEditPageStatusDDM.click();
        select.selectByValue("read");
        ReusableMethods.bekle(3);
        extentTest.pass("Admin contact sayfasinda duzenleme sayfasinda sectigi mesaji okundu olarak isaretler.");

        adminDashboard.contactSayfasiEditSaveExitButonu.click();
        ReusableMethods.bekle(3);
        extentTest.pass("Admin contact sayfasinda duzenleme sayfasinda sectigi mesaji duzenler ve cikar.");

        Assert.assertTrue(adminDashboard.contactSayfasiUpdatedSuccessfullyYazisi.isDisplayed());
        extentTest.pass("Admin contact sayfasinda duzenleme yapildigini dogrular.");

        Driver.getDriver().quit();
        extentTest.pass("Ziyaretci browseri kapatir.");

}
}
