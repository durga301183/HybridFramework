package tests;

import BaseTest.BaseTest;
import Sync_utils.TestUtil;
import org.jsoup.Connection;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LaunchPage;
import pages.LoginPage;

public class LaunchLoginTest extends BaseTest {
    LaunchPage launchpage;
    LoginPage loginpage;
    HomePage homepage;

    public LaunchLoginTest() {
        super();
    }

    @BeforeTest
    public void setUp() {
        initialization();
        launchpage = new LaunchPage();
        loginpage = new LoginPage();
    }


       @Test
        public void loginTesta() throws InterruptedException {

        launchpage.navigateToLogin();
           // String title = loginpage.validateLoginPageTitle();
            //Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
           // launchpage.navigateToLogin();
        homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
    }


    @AfterTest
        public void tearDown () {
            driver.quit();
        }
    }


