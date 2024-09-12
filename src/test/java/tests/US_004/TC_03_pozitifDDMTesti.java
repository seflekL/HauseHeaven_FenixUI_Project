package tests.US_004;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_03_pozitifDDMTesti extends TestBaseRapor {
    @Test
    public void TC03dropDownTest(){
        extentTest = extentReports.createTest("PozitifDropDownSearchBoxTesti");
        HomePage homePage=new HomePage();
        //Ziyaretci hausehaen Url'ine giris saglar
        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Ziyaretci hausehaen Url'ine giris saglar");
        //Ziyaretci anasayfa Body bolumune erisim saglar
        ReusableMethods.hover(homePage.sefUserBodysearchButtonElementi);
        extentTest.pass("Ziyaretci anasayfa Body bolumune erisim saglar");

        //Ziyaretci search for location box'ina tiklar
        homePage.sefUserSearhforloactionboxElementi.click();
        extentTest.pass("Ziyaretci search for location box'ina tiklar");
        //Ziyaretci  searchbox'a istedigi ulke veya sehir ismini yazar
        homePage.sefUserSearhforloactionboxElementi.sendKeys("New York");
        extentTest.pass("Ziyaretci  searchbox'a istedigi ulke veya sehir ismini yazar");
        //Ziyaretci "Min Price" ddm menusunde  istedigi fiyati secer
         Select selectMinPrice=new Select(homePage.sefSearchBoxMinPriceDDM);
        selectMinPrice.selectByValue("500");
        extentTest.pass("Ziyaretci \"Min Price\" ddm menusunde  istedigi fiyati secer");

        //Ziyaretci "MaxPrice" ddm menusunde istedigi fiyati secer
        Select selectMax=new Select(homePage.sefSearchBoxMaxPriceDDM);
        selectMax.selectByValue("2000");
        extentTest.pass("Ziyaretci \"MaxPrice\" ddm menusunde istedigi fiyati secer");
        //Ziyaretci "Property Type" ddm menusunde  istgedi ev turunu secer
        Select  selectProperty=new Select(homePage.sefSearchBoxPropertyTypeDDM);
        selectProperty.selectByValue("3");
        extentTest.pass("Ziyaretci \"Property Type\" ddm menusunde  istgedi ev turunu secer");
        //Ziyaretci "Bed Rooms"ddm menusunde istedigi  Bedroom turunu secer
        Select  selectBedroom=new Select(homePage.sefSearchBoxBedroomTypeDDM);
        selectBedroom.selectByValue("3");
        extentTest.pass("Ziyaretci \"Bed Rooms\"ddm menusunde istedigi  Bedroom turunu secer");

        //Ziyaretci acilan  tarayici kapatir
        Driver.quitDriver();
        extentTest.pass("Ziyaretci acilan  tarayici kapatir");

    }

}

