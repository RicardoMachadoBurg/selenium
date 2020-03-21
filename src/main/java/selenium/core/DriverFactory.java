package selenium.core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import selenium.core.Properties.ExecutionType;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>(){
        @Override
        protected synchronized WebDriver initialValue(){
            return initDriver();
        }
    };

    private DriverFactory() {}

    public static WebDriver getDriver(){
        return threadDriver.get();
    }

    public static WebDriver initDriver(){
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        WebDriver driver = null;
        if(Properties.EXECUTION_TYPE == ExecutionType.LOCAL) {
            switch (Properties.BROWSER) {
                case FIREFOX: driver = new FirefoxDriver(); break;
                case CHROME: driver = new ChromeDriver(); break;
            }
        }
        if(Properties.EXECUTION_TYPE == ExecutionType.GRID) {
            DesiredCapabilities cap = null;
            switch (Properties.BROWSER) {
                case FIREFOX: cap = DesiredCapabilities.firefox(); break;
                case CHROME: cap = DesiredCapabilities.chrome(); break;
            }
            try {
                driver = new RemoteWebDriver(new URL("http://192.168.0.184:4444/wd/hub"), cap);
            } catch (MalformedURLException e) {
                System.err.println("Falha na conexão com o GRID");
                e.printStackTrace();
            }
        }
        driver.manage().window().setSize(new Dimension(1200, 765));
        return driver;
    }

    public static void killDriver(){
        System.out.println("executou killDriver()");
        WebDriver driver = getDriver();
        if(driver != null) {
            driver.quit();
            driver = null;
        }
        if(threadDriver != null) {
            threadDriver.remove();
        }
    }
}
