package ListenerPackage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import utility.ExtentReporter;
import utility.Utilities;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.FileHandler;

public class ListenerPage extends Utilities implements ITestListener {

        /*    public void onTestStart(ITestResult result) {
            System.out.println("Test started: " +result.getName());
            System.out.println(result.getTestClass());
            }
            public void onTestSuccess(ITestResult result) {
                System.out.println("Test passed: " +result.getName());
                System.out.println(result.getTestClass());
            }
            public void onTestFailure(ITestResult result) {
                System.out.println("Test failed: " +result.getName());
                System.out.println(result.getTestClass());
            }
        }   */
        ExtentReports extentReport;
        ExtentTest extentTest;

        @Override
        public void onStart(ITestContext context) {
            System.out.println("On start");
            extentReport = ExtentReporter.generateExtentReport();
        }
        @Override
        public void onTestStart(ITestResult result) {
            System.out.println(result.getTestClass());
            System.out.println(result.getName()+ "Started");
//		extentTest = extentReport.createTest(result.getMethod().getDescription());
            extentTest = extentReport.createTest(result.getName());
            extentTest.log(Status.INFO, result.getName() + " started executing");
            extentTest.info(result.getName()+ "started executing");
        }
        @Override
        public void onTestSuccess(ITestResult result)  {
            System.out.println(result.getName()+ "Success");
            extentTest.log(Status.PASS, result.getName() + " got successfully executed");
            extentTest.pass(result.getName()+ "successfully executed");
        }
        @Override
        public void onTestFailure(ITestResult result) {
            ITestContext context = result.getTestContext();
            WebDriver driver = (WebDriver) context.getAttribute("webdriver");
            String testName = result.getName();
            String destinationScreenshotPath = Utilities.captureScreenshot(driver, testName);
            extentTest.addScreenCaptureFromPath(destinationScreenshotPath);
            System.out.println(result.getName()+ "Failure");
            extentTest.log(Status.INFO, result.getThrowable());
            extentTest.info(result.getThrowable()+ "exception");
            extentTest.log(Status.FAIL, result.getName() + "execution failed");
            extentTest.fail(result.getName() + " got failed");
        }
        @Override
        public void onTestSkipped(ITestResult result) {
            System.out.println(result.getName()+ "Skipped");
            extentTest.log(Status.INFO, result.getThrowable());
            extentTest.info(result.getName()+ "skipped");
            extentTest.log(Status.SKIP, result.getName() + " got skipped");
            extentTest.skip(result.getName()+ "skipped");
        }
        @Override
        public void onFinish(ITestContext context) {
            System.out.println("Test execution Completed");
            extentReport.flush();
            ExtentReports extent = new ExtentReports();
            String pathOfExtentReport = System.getProperty("user.dir") + "\\test-output\\ExtentReports\\extentReport.html";
            File extentReport = new File(pathOfExtentReport);
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReport);
            extent.attachReporter(sparkReporter);
            try {
                Desktop.getDesktop().browse(extentReport.toURI());
            }
            catch (IOException e) {
                e.printStackTrace();
            }}}

