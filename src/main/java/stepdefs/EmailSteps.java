package stepdefs;

import PageObjects.EmailPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EmailSteps {

    @Given("^user creates new message$")
    public void createNewMessage() {
        EmailPage emailPage = (EmailPage) ScenarioContext.getData("emailPage");
        emailPage.composeEmail.click();
    }

    @When("^user sends valid message to \"(.*)\"$")
    public void sendMessageToUser(String email) {
        EmailPage emailPage = (EmailPage) ScenarioContext.getData("emailPage");
        emailPage.recepientEmail.sendKeys(email);
        emailPage.emailSubject.sendKeys("Test");
        emailPage.emailBody.sendKeys("Test");
        emailPage.send.click();
    }

    @Then("^email is successfully recieved$")
    public void emailIsReceived() throws InterruptedException {
        EmailPage emailPage = (EmailPage) ScenarioContext.getData("emailPage");
        Thread.sleep(3000);
        emailPage.receivedEmails.size();
    }
}
