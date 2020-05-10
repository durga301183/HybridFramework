package BaseTest;

import ReportManager.ReportManager;
import Sync_utils.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//Initialising the properties and browser

public class BaseTest {

    public static WebDriver driver;
    public static Properties prop;
    public ExtentReports report = ReportManager.getInstance();
    public ExtentTest test;


    //constructor
    public BaseTest() {
        try {

            String path = System.getProperty("user.dir") + "/src/test/resources/configuration.properties";
            prop = new Properties();
            FileInputStream fis = new FileInputStream(path);
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //method to launch the browser from the property file
    public static void initialization() {
        String browserName = prop.getProperty("browser");
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }


    public void takeFullScreenshot () {
        Date d = new Date();
        String filename = d.toString().replace(" ", "_").replace(":", "_") + ".png";
        String screenshotPath = SystemUtils.getUserDir() + "/target/screenshots/" + filename;

        //fluent style coding
        //1. Take the Screenshot image
        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(driver);
        //2. Write to a location
        try {
            ImageIO.write(screenshot.getImage(), "PNG", new File(screenshotPath));
            test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(screenshotPath));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    //reporting methods

        public void reportInfo (String infoMessage){
            test.log(LogStatus.INFO, infoMessage);

        }
        public void reportPass (String passMessage){
            test.log(LogStatus.PASS, "Page Launched");


        }
        public void reportFail (String failMessage){
            test.log(LogStatus.FAIL, "failMessage");


        }
    }


