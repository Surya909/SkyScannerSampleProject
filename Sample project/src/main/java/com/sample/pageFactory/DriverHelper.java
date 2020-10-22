package com.sample.pageFactory;

import cucumber.api.Scenario;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverHelper extends Pages {
    Properties prop;
    public static WebDriver driver;

    public Properties loadPropertiesFiles(String file) throws IOException {
        prop = new Properties();
        InputStream propertyFile;
        propertyFile = new FileInputStream(
                System.getProperty("user.dir") + "/src/test/resources/config/" + file + ".properties");
        prop.load(propertyFile);
        return prop;
    }

    public void openBrowser(Scenario scenario) throws IOException {
        prop = loadPropertiesFiles("env");
        String browser = prop.getProperty("browser");
        String url;
            url = prop.getProperty("url");
        switch (browser) {
            case "chrome":
                ChromeDriverManager.getInstance().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("no-sandbox");
                System.setProperty("webdriver.chrome.silentOutput", "true");
                System.setProperty("parentLoaderPriority", "false");
                driver = (new ChromeDriver(options));
                break;
            case "ie":
                InternetExplorerDriverManager.getInstance().setup();
                driver = (new InternetExplorerDriver());
                break;
            case "safari":
                driver = (new SafariDriver());
                break;
            case "Firefox":
                driver = (new FirefoxDriver());
                break;
            case "FirefoxRemote":
                DesiredCapabilities capability = new DesiredCapabilities();
                capability.setBrowserName("firefox");
                capability.setVersion("80.0");
                break;
            case "htmlDriver":
                driver = (new HtmlUnitDriver(true));
                break;
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(url);
        log.info("Executing -> " + scenario.getSourceTagNames() + "  <-  " + scenario.getName());
    }

    public void closeBrowser() {
        driver.close();
        driver.quit();
    }

    public static String getUrl() {
        return driver.getCurrentUrl();
    }

    public DriverHelper logScenarioStatus(Scenario scenario) {
        if (scenario.isFailed()) {
            log.error((scenario.getSourceTagNames() + scenario.getName() + " ** STATUS **: "
                    + scenario.getStatus().toUpperCase() + System.lineSeparator()));
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenshotFile,
                        new File(System.getProperty("user.dir") + "/screenShot/_" + scenario.getName() + ".png"));
                log.info("Took screen shot..." + System.lineSeparator());
            } catch (IOException e) {
                log.error("Problem in taking screen shots" + System.lineSeparator());
            }

        } else {
            log.info(((scenario.getSourceTagNames() + scenario.getName() + " ** STATUS **: "
                    + scenario.getStatus().toUpperCase() + System.lineSeparator())));
        }
        return this;
    }

    public void set(int min, int max) {
        driver.manage().window().setSize(new Dimension(min, max));
    }
}
