package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Sachin on 25/06/2017.
 */
public class Homepage {


    private WebDriver driver;

    private static final By latestNewsHeaderLocator = By.xpath("//*[@id='container']/div[2]/div[3]/div[1]/header/h2");
    private static final By locationsLocator = By.xpath(".//*[@id='footer']/div/div[2]/p[2]");



    public Homepage(WebDriver driver) {
        this.driver = driver;
    }

    public String locateLatestNewsHeaderText(){
        WebElement latestNewsHeaderElement = driver.findElement(latestNewsHeaderLocator);
        String locateNewsHeaderText = latestNewsHeaderElement.getText();
        return locateNewsHeaderText;
    }

    public String outputLocations(){
        WebElement locationsElement = driver.findElement(locationsLocator);
         return locationsElement.getText();

    }

}
