package base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by s.mylavarapu on 27/10/2016.
 */


public class TestBase {
    public  boolean initialized = false;
    public  WebDriver driver;
    public  String workingDirectory = System.getProperty("user.dir");
    public  InputStream inputStream;
    public  Properties properties;
    public  String browserType;
    public  String url;




    public  WebDriver getDriver() {
        driver = initializeBase();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    public   WebDriver initializeBase(){
        if(!initialized) {
            initialized = true;


            properties = new Properties();

            try {
                inputStream = new FileInputStream(workingDirectory + "//src/main//java/config//config.properties");
                properties.load(inputStream);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            browserType = properties.getProperty("browser");
            url = properties.getProperty("url");

            switch (browserType) {
                case "chrome":
                    driver =initializeChromeBrowser(url);
                    break;

                case "firefox":
                    driver =initializeFirefoxBrowser(url);
                    break;

                default:
                    driver =initializeFirefoxBrowser(url);
                    break;
            }


        }
        return driver;

    }


    public WebDriver initializeChromeBrowser(String url){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        return driver;

    }

    public  WebDriver  initializeFirefoxBrowser(String url){
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/geckodriver");
        driver = new FirefoxDriver();
        driver.get(url);
        return driver;
    }





}
