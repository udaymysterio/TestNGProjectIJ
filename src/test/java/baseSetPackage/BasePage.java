package baseSetPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestListener;
import java.time.Duration;

public class BasePage implements ITestListener {
        protected WebDriver driver;
        protected WebDriverWait wait;
        public BasePage(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            PageFactory.initElements(driver, this);
        }
        public BasePage() {
        }
        protected WebElement find(By locator) {
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }
        protected void click(By locator) {
            find(locator).click();
        }
        protected void type(By locator, String text) {
            WebElement element = find(locator);
            element.clear();
            element.sendKeys(text);
        }
        protected boolean isDisplayed(By locator) {
            try {
                return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
            } catch (Exception e) {
                return false;
            }
        }
        protected String getText(By locator) {

            return find(locator).getText();
        }
        public String getTitle() {
            return driver.getTitle();
        }
    }