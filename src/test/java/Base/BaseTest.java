package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class BaseTest {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();


    public WebElement getElement(By loc, String elementName) {

        Instant start = Instant.now();

        try {
            System.out.println("Getting [" + elementName + "]");
            WebElement element = driver.get().findElement(loc);
            Instant end = Instant.now();
            Duration timeElapsed = Duration.between(start, end);
            System.out.println("Got [" + elementName + "] - WAIT TIME - Over Try: " + timeElapsed.toMillis() / 1000.0 + " second");
            return element;
        } catch (Exception e) {
            Instant end = Instant.now();
            Duration timeElapsed = Duration.between(start, end);
            System.out.println("*** UNABLE to get [" + elementName + "] ***- WAIT TIME - Over Catch: " + timeElapsed.toMillis() / 1000.0 + " second");
            System.out.println("Locator: " + loc.toString());
            System.out.println("Page Source ===>>> " + driver.get().getPageSource());
            System.out.println("*** Error Message: " + e.getMessage());
            Assert.fail("*** UNABLE to get [" + elementName + "] ***- WAIT TIME - Over Catch: " + timeElapsed.toMillis() / 1000.0 + " second");
            return null;
        }

    }
    public List<WebElement> getElements (By locator){
        return driver.get().findElements(locator);
    }

    public boolean clickElement(By loc, String elementName){
        try {
            //WebElement element = driver.get().findElement(loc);
            WebElement element = getElement(loc,elementName);
            System.out.println("Trying to click [" + elementName + "]");
            element.click();
            System.out.println("Successfully clicked the [" + elementName + "]");
            return true;
        } catch (Exception e) {
                System.out.println(e);
               return false;
        }

    }

    public boolean waitForElement(By locator, String eleName) {
        WebElement element;
        Instant start = Instant.now();
        try {
            System.out.println("Waiting for: [" + eleName + "]");
            element = driver.get().findElement(locator);
            Instant end = Instant.now();
            Duration timeElapsed = Duration.between(start, end);
            System.out.println("Found [" + eleName + "] in " + timeElapsed.toMillis() / 1000.0 + " second");
            return true;
        } catch (Exception e) {
            Instant end = Instant.now();
            Duration timeElapsed = Duration.between(start, end);
            System.out.println("*** CAN NOT FIND [" + eleName.toUpperCase() + "] in " + timeElapsed.toMillis() / 1000.0 + " second ***");
            System.out.println("Locator: " + locator.toString());
            //  log().info("Page Source ===>>> "+driver.get().getPageSource());
            return false;
        }
    }

}
