package common;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


@Slf4j
@Getter
@Setter
public class Base {
    public static RemoteWebDriver webDriver;

    Config config = ConfigFactory.load();
    String locale = config.getString("locale");
    String browser = config.getString("browser");
    String chromePath = config.getString("chromePath");
    String firefoxPath = config.getString("firefoxPath");

    public void init() throws MalformedURLException {
        if(browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", firefoxPath);
            selectFirefoxLocalRemoteDriver();
        }
        else {
            System.setProperty("webdriver.chrome.driver", chromePath);
            selectChromeLocalRemoteDriver();
        }
    }

    public void setWebDriver(String driver) throws MalformedURLException {
        browser = driver;
        if(sanitize(driver).equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", firefoxPath);
            selectFirefoxLocalRemoteDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", chromePath);
            selectChromeLocalRemoteDriver();
        }
    }

    private String sanitize(String arg) {
        return arg.replaceAll("[^\\w\\d]","").toLowerCase();
    }

    private void selectFirefoxLocalRemoteDriver() throws MalformedURLException {
        if(locale.equals("remote")) {
            DesiredCapabilities cap = DesiredCapabilities.firefox();
            URL url = new URL("http://localhost:4445/wd/hub");
            webDriver = new RemoteWebDriver(url, cap);
        } else {
            FirefoxOptions options = new FirefoxOptions();
            options.setLogLevel(FirefoxDriverLogLevel.ERROR);
            webDriver = new FirefoxDriver(options);
        }
    }

    private void selectChromeLocalRemoteDriver() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", chromePath);
        if(locale.equals("remote")) {
            DesiredCapabilities cap = DesiredCapabilities.chrome();
            URL url = new URL("http://localhost:4444/wd/hub");
            webDriver = new RemoteWebDriver(url, cap);
        } else {
            webDriver = new ChromeDriver();
        }
    }

}
