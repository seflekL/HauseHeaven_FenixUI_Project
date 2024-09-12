package tests.US_005;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_L006_footerAdress extends TestBaseRapor {

    @Test
    public void Test06(){

         HomePage homePage=new HomePage();
        extentTest = extentReports.createTest("Footer Address Gorunluk Testi");

         //Ziyaretci hausehaen Url'ine giris saglar
        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.pass("Ziyaretci hausehaen Url'ine giris saglar");


        //Ziyaretci ana sayfa yuklendikten sonra sayfa sonunda yer alan footer bolumune scroll yapar
        ReusableMethods.hover(homePage.SefFooterElementi);
        homePage.sefUsercookies.click();
        extentTest.pass("Ziyaretci ana sayfa yuklendikten sonra sayfa sonunda yer alan footer bolumune scroll yapar");
        //Ziyaretci footer bolumunde hauseheaven logosun yer aldigini dogrular
        Assert.assertTrue(homePage.sefFooterLogo.isDisplayed());
        extentTest.pass("Ziyaretci footer bolumunde hauseheaven logosun yer aldigini dogrular");

        //Ziyaretci fotoer bolumunde  hauseheaven  sirket adresinin yer aldigini dogrular
        Assert.assertTrue(homePage.seffooterAddresselementi.isDisplayed());
        extentTest.pass("Ziyaretci fotoer bolumunde  hauseheaven  sirket adresinin yer aldigini dogrular");

        //Ziyaretci taraciyi kapatir

        Driver.quitDriver();
        extentTest.pass("Ziyaretci taraciyi kapatir");


    }




}
