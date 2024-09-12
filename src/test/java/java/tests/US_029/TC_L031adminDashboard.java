package java.tests.US_029;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.*;

import java.util.List;

public class TC_L031adminDashboard extends TestBaseRapor {

    @Test
     public void TCL031 (){
         AdminDashboard adminDashboard=new AdminDashboard();
        extentTest = extentReports.createTest("Admin Dashboard Gorunurluk Testi");

        //Admin hauseheaven Admin sayfasina onceden verilmis Username ve Password Ile basarili sekilde giris saglar
        LeventMethods.admingirisDashboard();
        extentTest.pass("Admin hauseheaven Admin sayfasina onceden verilmis Username ve Password Ile basarili sekilde giris saglar");
         //Adminadmin sayfasinin icinde sideNavigation yer alan blog linkine tiklar
         adminDashboard.sefadminsideDashBlogButtonElementi.click();
         ReusableMethods.wait(1);
        extentTest.pass("Adminadmin sayfasinin icinde sideNavigation yer alan blog linkine tiklar");
         //Admin"Posts","Categories","Tags"  menulerin gorunur oldugunu test eder
        List<String> admingBlogTabList= ReusableMethods.getStringList(adminDashboard.sefadminsideDashBlogList);
        System.out.println(admingBlogTabList);
        for (String tagElement : admingBlogTabList) {
            Assert.assertTrue(tagElement.contains("Tags"));
            Assert.assertTrue(tagElement.contains("Categories"));
            Assert.assertTrue(tagElement.contains("Posts"));
            extentTest.pass("/Admin\"Posts\",\"Categories\",\"Tags\"  menulerin gorunur oldugunu test eder");
        }
        //Admin basarili sekilde cikis yapar ve taraciyi kapatir

        LeventMethods.adminLogoutTesti();
        extentTest.pass("Ziyaretci hausehaen Url'ine giris saglar");

     }

}
