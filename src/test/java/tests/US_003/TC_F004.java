package tests.US_003;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_F004 extends TestBaseRapor {

    @Test
    public void test04(){


        extentTest = extentReports.createTest(" “Explore Good Places” blogunda kiralık ve satılık 6 ürün olmasi ve bunların görünürlüğünün doğrulanması testi");
        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.info("Ziyaretci anasayfaya gider");

        HomePage homePage=new HomePage();

        ReusableMethods.hover(homePage.ExploreGoodPlaces);
        Assert.assertTrue(homePage.ExploreGoodPlaces.isDisplayed());
        extentTest.pass("Explore Good Places baslikli yazinin varligini test eder");


        int expectedList = 6;
        int actualList = homePage.ExploreGoodPlacesList.size();
        Assert.assertEquals(actualList, expectedList);
        extentTest.pass("Explore Good Places bolumunde ilanlarin listesini test eder.");

        int expectedIkonList = 18;
        int actualIkonList = homePage.ExploreGoodPlacesIkonList.size();
        Assert.assertEquals(actualIkonList, expectedIkonList);
        extentTest.pass("Explore Good Places bolumunde ilanlardaki mulklerin yatak banyo ve metrekarelerinin varligini test eder.");



        int expectedDetayList = 6;
        int actualDetayList = homePage.ExploreGoodPlacesDetayList.size();
        Assert.assertEquals(actualDetayList, expectedDetayList);
        extentTest.pass("Explore Good Places bolumunde ilanlardaki mulklerin detaylarinin varligini test eder." +
                "(Kiralik, satilik, fiyat, yildiz degerlendirmesi, kac kez goruntulendigi, aylik ya da gunluk kiralanacagi");

        int expectedLokasyonList = 6;
        int actualLokasyonList = homePage.ExploreGoodPlacesLokasyonList.size();
        Assert.assertEquals(actualLokasyonList, expectedLokasyonList);
        extentTest.pass("Explore Good Places bolumunde ilanlarin lokasyonlarinin varligini test eder.");

        int expectedKalpEmojiList = 6;
        int actualKalpEmojiList = homePage.KalpEmojiList.size();
        Assert.assertEquals(actualKalpEmojiList, expectedKalpEmojiList);
        extentTest.pass("Explore Good Places bolumunde ilanlarin uzerinde kalp emojilerinin varligini test eder.");

        ReusableMethods.hover(homePage.KalpEmoji);
        homePage.KalpEmoji.click();
        ReusableMethods.bekle(1);
        extentTest.info("Mulklerden birini begenir.");

        ReusableMethods.hover(homePage.Wishlist);
        Assert.assertTrue(homePage.Wishlist.isDisplayed());
        extentTest.pass("Begenilerin Wishlist'te gorundugunu test eder.");
        Driver.getDriver().navigate().back();
        ReusableMethods.bekle(1);

        ReusableMethods.hover(homePage.View);
        homePage.View.click();
        ReusableMethods.bekle(1);
        extentTest.info("Ilgili mulkun ayrintilari icin View butonuna tiklar.");

        ReusableMethods.hover(homePage.Description);
        Assert.assertTrue(homePage.Description.isDisplayed());
        extentTest.pass("View butonunun aciklama sayfasina gittigini goruntuler.");
        Driver.getDriver().navigate().back();
        ReusableMethods.bekle(3);

        ReusableMethods.hover(homePage.BrowseMoreProperties);
        homePage.BrowseMoreProperties.click();
        ReusableMethods.bekle(2);
        extentTest.info("Daha fazla mulke ulasmak icin Browse More Properties butonuna tiklar.");

        ReusableMethods.hover(homePage.PropertiesSayfasi);
        Assert.assertTrue(homePage.PropertiesSayfasi.isDisplayed());
        extentTest.pass("View butonunun aciklama sayfasina gittigini goruntuler.");


        Driver.quitDriver();

    }
}
