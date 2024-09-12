package tests.US_011;

import org.bouncycastle.pqc.crypto.util.PQCOtherInfoGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.awt.*;

public class TC_ME04 extends TestBaseRapor {

    @Test
    public  void test04(){
        HomePage homePage=new HomePage();
        Actions actions=new Actions(Driver.getDriver());

        extentTest=extentReports.createTest("adresindogrulugutesti");


        extentTest .pass("Ziyaretçi HauseHeaven url girer.");
        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));

        extentTest .pass(" Ziyaretçi HauseHeaven anasayfa header a ulaşır.");
        Assert.assertTrue(homePage.hauseheavenlogo.isDisplayed());

        extentTest .pass("Ziyaretçi Contact linkine tıklar.");
        homePage.contactlinkibutonu.click();

        extentTest .pass(" Ziyaretçi Contact sayfasına ulaşır.");
        ReusableMethods.hover(homePage.contactdırections);

        extentTest .pass(" Ziyaretçi sayfada Reach Us kısmındaki adresi görür.");

        Assert.assertTrue(homePage.contactreachuselementi.isDisplayed());
        extentTest .pass(" Ziyaretçi adres dogrulamak için Directions kısmındaki harita alanından scrool yaparak Reach Us kısmındaki adresin aynı olduğunu dogrular.");

        ReusableMethods.hover(homePage.contactsingontoday);

        ReusableMethods.bekle(2);
        //Levent  Yol
        WebElement iframe = Driver.getDriver().findElement(By.xpath("//iframe[contains(@src, 'maps')]"));
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", iframe);
        Driver.getDriver().switchTo().frame(iframe);

        WebElement map = Driver.getDriver().findElement(By.xpath("//body"));
        ReusableMethods.hover(map);
        ReusableMethods.wait(3);
        actions.click(map).perform();
        actions.click(map).perform();
        actions.click(map).perform();




      //  Driver.getDriver().switchTo().frame(homePage.contcatiframe);
       // homePage.contcatiframe.click();
      //  homePage.contcatiframe.click();
      //  homePage.contcatiframe.click();
     //  homePage.contcatiframe.click();

       //actions.doubleClick(homePage.contactharitagoruntule).perform();


        ReusableMethods.bekle(3);


        extentTest .pass("Ziyaretçi açılan sekmeyi kapatır.");
       Driver.getDriver().quit();


    }
}
