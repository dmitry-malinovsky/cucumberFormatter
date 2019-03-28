package stepdefs;

import PageObjects.Page;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class GeneralSteps {
    @When("^user is on \"(.*)\" page$")
    public void goToPage(String pageName) {
        WebDriver driver = (WebDriver) ScenarioContext.getData("driver");
        Page desiredPage = (Page) ScenarioContext.getData(pageName);
        driver.get(desiredPage.getUrl());
    }
}
