package Runner;

import Base.BaseTest;
import Pages.MainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;


public class MySteps extends BaseTest {
    

    @Given("Application in the main page and ready to test")
    public void applicationInTheMainPageAndReadyToTest() {
       boolean actual= waitForElement(MainPage.title, "Title");
        Assert.assertTrue(actual, "Application can not navigated to main page");

    }

    @When("Add {int} number of elements")
    public void addNumberOfElements(int iteration) throws InterruptedException {
        for (int i=0; i<iteration;i++){
            clickElement(MainPage.addElementButton, "Add elemet button");
            //Thread.sleep(2000);
        }
        Thread.sleep(5000);

    }

    @Then("Page should show {int} element")
    public void pageShouldShowElement(int expectedCount) {
       int  deleteButtonCount = getElements(MainPage.deleteElementButton).size();
       Assert.assertEquals(deleteButtonCount,expectedCount, "Delete button count doesnt match");
    }
}
