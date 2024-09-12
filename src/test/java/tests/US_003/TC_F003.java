package tests.US_003;

import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_F003 extends TestBaseRapor {

    @Test
    public void test03(){

        extentTest = extentReports.createTest("How It Works bolumunun gorunur ve okunabilir olmasi testi");
        Driver.getDriver().get(ConfigReader.getProperty("hauseUrl"));
        extentTest.info("Ziyaretci anasayfaya gider");

        HomePage homePage=new HomePage();

        // "How It Works" bolumune kadar gider
        ReusableMethods.hover(homePage.HowItWorks);
        extentTest.pass("Ziyaretçi How It Works baslikli yazinin varligini test eder");

        // "How It Works" adimlarinin ilk adiminin gorunur oldugunu dogrular.
        ReusableMethods.hover(homePage.EvaluateProperty);
        extentTest.pass("Ziyaretçi How It Works baslikli yazinin Evaluate Property adimini test eder");

        // "How It Works" adimlarinin gorunur oldugunu dogrular.
        ReusableMethods.hover(homePage.MeetYourAgent);
        extentTest.pass("Ziyaretçi How It Works baslikli yazinin Meet Your Agent adimini test eder");

        // "How It Works" adimlarinin gorunur oldugunu dogrular.
        ReusableMethods.hover(homePage.CloseTheDeal);
        extentTest.pass("Ziyaretçi How It Works baslikli yazinin Close The Deal adimini test eder");


    }

}
