package Runner;

import Base.BaseTest;
import Base.DriverManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


@CucumberOptions(
        features = "src/test/resources/test.feature",
        plugin = { "pretty", "json:target/cucumber/cucumber-reports.json" })
        //glue = "org.example.Runner.MySteps")

public class Runner extends AbstractTestNGCucumberTests {
    DriverManager driverManager;
    @BeforeClass
    public void beforeClass(){
    driverManager = new DriverManager();
    driverManager.createWebDriver();
    }

    @AfterClass
    public void tearDown(){
       driverManager.tearDown();
    }

}
