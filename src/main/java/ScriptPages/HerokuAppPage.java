package ScriptPages;

import PropertyPackage.PropertyPage;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.apache.hc.core5.util.Timeout;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestListener;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static PropertyPackage.PropertyPage.GetProperty;
import static PropertyPackage.PropertyPage.prop;

public class HerokuAppPage extends PropertyPage implements ITestListener {
        WebDriver driver;
        FluentWait<WebDriver> wait;
        JavascriptExecutor jsDriver;
        NgWebDriver ngWebDriver;

        public HerokuAppPage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            jsDriver = (JavascriptExecutor) driver;
            ngWebDriver = new NgWebDriver(jsDriver);
        }
        public void herokuWeb() throws InterruptedException, IOException {
            GetProperty();
            driver.get(prop.getProperty("url"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            //           Thread.sleep(8000);
        }

        public void CheckUncheckBox() throws InterruptedException {
            driver.findElement(By.xpath("//li//a[text()='Checkboxes']")).click();
 //           Thread.sleep(3000);
            driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
 //           Thread.sleep(2000);
            driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
 //           Thread.sleep(3000);
            //       driver.close();
        }
        public void AddRemoveElement() throws InterruptedException {
            driver.findElement(By.xpath("//li//a[text()='Add/Remove Elements']")).click();
 //           Thread.sleep(3000);
            driver.findElement(By.xpath("//button[normalize-space()='Add Element']")).click();
  //          Thread.sleep(2000);
            driver.findElement(By.xpath("//button[normalize-space()='Delete']")).click();
  //          Thread.sleep(2000);
            //       driver.close();
        }
        public void BasicAuth() throws InterruptedException {
            driver.findElement(By.xpath("//li//a[text()='Basic Auth']")).click();
 //           Thread.sleep(4000);
            //       driver.close();
        }
        public void DisappearElement() throws InterruptedException {
            driver.findElement(By.xpath("//li//a[text()='Disappearing Elements']")).click();
//            Thread.sleep(2000);
            driver.findElement(By.xpath("//li//a[text()='Home']")).click();
 //           Thread.sleep(2000);
            driver.findElement(By.xpath("//li//a[text()='Disappearing Elements']")).click();
 //           Thread.sleep(2000);
            driver.findElement(By.xpath("//li//a[text()='Contact Us']")).click();
 //           Thread.sleep(2000);
            //       driver.close();
        }
        public void FormAuthenticate() throws InterruptedException {
            driver.findElement(By.xpath("//li//a[text()='Form Authentication']")).click();
 //           Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@id='username']")).click();
//            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@id='username']")).sendKeys("loginuser");
//            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@id='password']")).click();
//            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@id='password']")).sendKeys("loginpassword");
//            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[@type='submit']")).click();
//            Thread.sleep(3000);
            //       driver.close();
        }
        public void Inputs() throws InterruptedException {
            driver.findElement(By.xpath("//li//a[text()='Inputs']")).click();
  //          Thread.sleep(3000);
            driver.findElement(By.xpath("//input[@type='number']")).click();
  //          Thread.sleep(3000);
            Actions actionify = new Actions(driver);
//		actioner.click(epagescroll).build().perform();
            actionify.sendKeys("565645").perform();
  //          Thread.sleep(3000);
            actionify.sendKeys(Keys.ARROW_DOWN).perform();
            actionify.sendKeys(Keys.ARROW_DOWN).perform();
  //          Thread.sleep(3000);
            actionify.sendKeys(Keys.ARROW_UP).perform();
            actionify.sendKeys(Keys.ARROW_UP).perform();
  //          Thread.sleep(3000);
            actionify.sendKeys(Keys.ARROW_DOWN).perform();
            actionify.sendKeys(Keys.ARROW_DOWN).perform();
  //          Thread.sleep(3000);
            //       driver.close();
        }
        public void ePageScroll() throws InterruptedException {
            driver.findElement(By.xpath("//li//a[text()='Infinite Scroll']")).click();
//            Thread.sleep(2000);
            driver.findElement(By.xpath("//html[@class='no-js'][1]")).click();
//		Thread.sleep(2000);
            Actions actioner = new Actions(driver);
//		actioner.click(epagescroll).build().perform();
            actioner.sendKeys(Keys.ARROW_DOWN).perform();
 //           Thread.sleep(2000);
            actioner.sendKeys(Keys.ARROW_DOWN).perform();
 //           Thread.sleep(2000);
            actioner.sendKeys(Keys.ARROW_UP).perform();
 //           Thread.sleep(2000);
            actioner.sendKeys(Keys.ARROW_UP).perform();
 //           Thread.sleep(2000);
            actioner.sendKeys(Keys.ARROW_DOWN).perform();
//            Thread.sleep(2000);
            actioner.sendKeys(Keys.ARROW_DOWN).perform();
//            Thread.sleep(2000);
            //       driver.close();
//		JavascriptExecutor Jscr = (JavascriptExecutor) driver;
//		Jscr.executeScript("arguments[0].scrollIntoView(true);", epagescroll);
        }
        public void dragsndrops() throws InterruptedException {
            driver.findElement(By.linkText("Drag and Drop")).click();
 //           Thread.sleep(3000);
            WebElement dragdropsA = driver.findElement(By.xpath("//div[normalize-space()='A']"));
            WebElement drapdropsB = driver.findElement(By.xpath("//div[normalize-space()='B']"));
            Actions actes = new Actions(driver);
            actes.dragAndDrop(dragdropsA, drapdropsB).perform();
 //           Thread.sleep(3000);
            actes.dragAndDrop(drapdropsB, dragdropsA).perform();
 //           Thread.sleep(3000);
//        driver.close();
        }
        public void dropdownopt() throws InterruptedException {
            driver.findElement(By.linkText("Dropdown")).click();
 //           Thread.sleep(3000);
            WebElement dropdownElement = driver.findElement(By.id("dropdown")); // Replace with actual ID
            Select dropdownsA = new Select(dropdownElement);
            dropdownsA.selectByVisibleText("Option 1");
 //           Thread.sleep(2000);
            WebElement selectedOptionA = dropdownsA.getFirstSelectedOption();
            System.out.println("Selected Option: " + selectedOptionA.getText());
 //           Thread.sleep(3000);
            Select dropdownsB = new Select(dropdownElement);
            dropdownsB.selectByVisibleText("Option 2");
 //           Thread.sleep(2000);
            WebElement selectedOptionB = dropdownsB.getFirstSelectedOption();
            System.out.println("Selected Option: " + selectedOptionB.getText());
 //           Thread.sleep(3000);
            //       driver.close();
        }
    }

