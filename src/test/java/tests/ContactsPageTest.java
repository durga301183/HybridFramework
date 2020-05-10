package tests;

import BaseTest.BaseTest;
import Sync_utils.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ContactsPage;
import pages.HomePage;
import pages.LaunchPage;
import pages.LoginPage;

import static Sync_utils.TestUtil.sheetName;

public class ContactsPageTest extends BaseTest {
    LaunchPage launchpage;
    LoginPage loginpage;
    HomePage homepage;
    TestUtil testUtil;
    ContactsPage contactspage;

    ///TestUtil testUtil;

    public ContactsPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        test= report.startTest("Testing CRM Practice Portal");
        initialization();
        testUtil = new TestUtil();
        launchpage = new LaunchPage();
        launchpage.navigateToLogin();
        loginpage = new LoginPage();
        contactspage = new ContactsPage();
        //this will return the hoempage object which is why it is initialiased so that hoempage methods can be called
        homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
        Thread.sleep(2000);
        reportInfo("HomePage Launched");
        homepage.clickonContactslink();
    }

    @DataProvider
     public Object[][] getData(){
        Object[][] data =   TestUtil.getTestData(sheetName);
        return data;
    }

    @Test(priority = 1, dataProvider = "getData")
    public void createNewContact(String fname, String lname, String descrip) throws InterruptedException {
      //  homepage.clickonContactslink();
        contactspage.createnewContact(fname, lname, descrip);
        reportInfo("Newcontact added");
        takeFullScreenshot();
    }

    @AfterMethod
    public void tearDown(){
        reportPass("Test Passed");
        takeFullScreenshot();
        report.endTest(test);
        report.flush();
        driver.quit();
    }
}
