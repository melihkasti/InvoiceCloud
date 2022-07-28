package Base;

import Base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.internal.BaseTestMethod;

import java.util.concurrent.TimeUnit;

public class DriverManager extends BaseTest {


    public void createWebDriver(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        BaseTest.driver.set(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        driver.manage().window().fullscreen();

    }

    public void tearDown(){
        if (driver.get()!=null) {
            driver.get().quit();
        }
    }

}
