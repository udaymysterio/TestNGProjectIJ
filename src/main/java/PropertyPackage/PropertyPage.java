package PropertyPackage;

import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyPage {
        protected WebDriver driver;// = new ChromeDriver();
        protected JavascriptExecutor jsDriver;
        protected NgWebDriver ngWebDriver;

        //    public static Properties dataProp;
        public static Properties prop;

        public static void GetProperty() throws IOException {
            prop = new Properties();
            File propFile = new File(System.getProperty("user.dir") + "\\src\\main\\java\\config\\config.properties");
            FileInputStream fisa = new FileInputStream(propFile);
            prop.load(fisa);
    /*    dataProp = new Properties();
        File dataPropFile = new File(System.getProperty("user.dir") + "\\src\\main\\java\\testdata\\testdata.properties");
        FileInputStream fisb = new FileInputStream(dataPropFile);
        prop.load(fisb);
    */  }
    }
