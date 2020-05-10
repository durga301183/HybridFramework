package ReportManager;

import BaseTest.BaseTest;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import org.apache.commons.lang3.SystemUtils;

import java.io.File;
import java.util.Date;


public class ReportManager  {

    public static ExtentReports extent;
    //helper methods created as static and can be directly called
    public static ExtentReports getInstance(){
        //if already an extent report exists then don't create an instance
        if(extent == null) {
            Date d = new Date();
            String filename = d.toString().replace(" ", "_").replace(":", "_")+".html";
            String reportPath = SystemUtils.getUserDir()+"/target/"+filename;

            //1. create a new instance of extent report/constructor
            extent = new ExtentReports(reportPath, true, DisplayOrder.OLDEST_FIRST);
            //2. load the config file
            extent.loadConfig(new File(SystemUtils.getUserDir()+ "/src/main/resources/config.xml"));
        }
        return extent;
    }
}
