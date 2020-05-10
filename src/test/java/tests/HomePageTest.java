package tests;

import BaseTest.BaseTest;
import Sync_utils.TestUtil;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactsPage;
import pages.HomePage;
import pages.LaunchPage;
import pages.LoginPage;

public class HomePageTest extends BaseTest {

    LaunchPage launchpage;
    LoginPage loginpage;
    HomePage homepage;
    TestUtil testUtil;
    ContactsPage contactpage;

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {

        test= report.startTest("Testing CRM Practice Portal");
        initialization();
        testUtil= new TestUtil();
        launchpage =new LaunchPage();
        launchpage.navigateToLogin();
        loginpage = new LoginPage();
        //this will return the hoempage object which is why it is initliased so that hoempage methods can be called
        homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
        Thread.sleep(2000);
        reportInfo("HomePage Launched");
       // contactpage.selectContacts();
        homepage.clickonContactslink();


    }

    @Test
    public void verifyHomePageTitleTest() {
        String title = homepage.verifyHomePageTitle();
        Assert.assertEquals(title, "Cogmento CRM", "HomePage title not matched");
        test.log(LogStatus.PASS, "HomePage Test Passed");
        takeFullScreenshot();
    }

  //  @Test
    public void dealpageTest(){
        homepage.clickonDealslink();
        homepage.checktext();
        Assert.assertTrue(true, "Deals pageis displayed");
    }

    @AfterMethod

    public void tearDown()
    {
        report.endTest(test);
        report.flush();
        driver.quit();
    }
}


