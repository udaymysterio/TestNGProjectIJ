package baseSetPackage;

import PropertyPackage.PropertyPage;
import com.beust.jcommander.Parameter;
import com.paulhammant.ngwebdriver.NgWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class BaseHerokuSet extends PropertyPage implements ITestNGListener {
        protected WebDriver driver;
        protected FluentWait<WebDriver> wait;
        protected NgWebDriver ngWebDriver;
        protected JavascriptExecutor jsDriver;

        @Parameters({"browser"})
        @Test
        private WebDriver returnDriver(String browser) throws IOException, InterruptedException {
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
//            System.out.println("Chrome selected");
            } else if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                System.out.println("Firefox selected");
            } else {
                throw new IllegalArgumentException("Invalid browser");
            }
            jsDriver = (JavascriptExecutor) driver;
            ngWebDriver = new NgWebDriver(jsDriver);
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            wait = new FluentWait<WebDriver>(driver);
            wait.ignoring(NoSuchElementException.class);
            wait.withTimeout(Duration.ofSeconds(10));
//        GetProperty();
//        driver.get(prop.getProperty("url"));
//        driver.manage().window().maximize();
//        Thread.sleep(5000);
            //       ngWebDriver.waitForAngularRequestsToFinish();
            return driver;
        }
        @BeforeClass
        public void initBaseTest(ITestContext context) throws IOException, InterruptedException {
            driver = returnDriver("chrome");
            context.setAttribute("webdriver", driver);
            Thread.sleep(4000);
        }
        @AfterClass
        public void endweb() throws IOException, InterruptedException {
            //       if (driver != null) {
            driver.close();
        }}