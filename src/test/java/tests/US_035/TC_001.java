package tests.US_035;

import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.*;

import java.time.Duration;

public class TC_001 extends TestBaseRapor {

    @Test
    public void Test14(){

        extentTest = extentReports.createTest("Admin sayfasina gidip, giriş yapıp, admin dashboarduna erişim testi.");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        AdminDashboard adminDashboard=new AdminDashboard();

        BunyaminMethods.adminGiris();
        extentTest.pass("HauseHeaven admin sayfasina giris yapildi.");

        Driver.quitDriver();
        extentTest.pass("Driver kapatildi.");

    }


}
