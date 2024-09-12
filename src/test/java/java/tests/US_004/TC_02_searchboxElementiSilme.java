package java.tests.US_004;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_02_searchboxElementiSilme extends TestBaseRapor {

    @Test
    public void searchboxTesti() {
        HomePage homePage = new HomePage();
        Actions actions = new Actions(Driver.getDriver());
        extentTest = extentReports.createTest("SearchBox Elementi Silme");

        //Ziyaretci admin hausehaen Url'ine giris saglar
        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Ziyaretci admin hausehaen Url'ine giris saglar");
        //Ziyaretci anasayfa Body bolumune erisim saglar
        ReusableMethods.hover(homePage.sefUserBodysearchButtonElementi);
        homePage.sefUsercookies.click();
        extentTest.pass("Ziyaretci anasayfa Body bolumune erisim saglar");

        //Ziyaretci body de yer alan search for location box'ina tiklar
        homePage.sefUserSearhforloactionboxElementi.click();
        extentTest.pass("Ziyaretci body de yer alan search for location box'ina tiklar");

        //Ziyaretci anasayfada yer alan "Homes to Rent" icinde yer alan "Search for location " box icine yazi ve rakam girer
        homePage.sefUserSearhforloactionboxElementi.sendKeys("zonya42@");
        homePage.sefUserSearhforloactionboxElementi.click();
        ReusableMethods.wait(1);
        homePage.sefUserSearhforloactionboxElementi.sendKeys(Keys.BACK_SPACE);
        homePage.sefUserSearhforloactionboxElementi.sendKeys(Keys.BACK_SPACE);
        homePage.sefUserSearhforloactionboxElementi.sendKeys(Keys.BACK_SPACE);
        homePage.sefUserSearhforloactionboxElementi.sendKeys(Keys.BACK_SPACE);
        homePage.sefUserSearhforloactionboxElementi.sendKeys(Keys.BACK_SPACE);
        homePage.sefUserSearhforloactionboxElementi.sendKeys(Keys.BACK_SPACE);
        homePage.sefUserSearhforloactionboxElementi.sendKeys(Keys.BACK_SPACE);
        homePage.sefUserSearhforloactionboxElementi.sendKeys(Keys.BACK_SPACE);
        extentTest.pass("Ziyaretci anasayfada yer alan Homes to Rent icinde yer alan Search for location  box icine yazi ve rakam girer");
        //Ziyaretci taraciyi kapatir
        Driver.quitDriver();
        extentTest.pass("Ziyaretci Taraciyi Kapatir");

    }
}
