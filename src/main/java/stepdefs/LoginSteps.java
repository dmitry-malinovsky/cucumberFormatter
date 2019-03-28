package stepdefs;

import PageObjects.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class LoginSteps {
    private LoginPage loginPage = (LoginPage) ScenarioContext.getData("Login");

    @Given("^user logs in \"Gmail\"$")
    public void userLogsIn() throws InterruptedException {
        userLogin("mandoeswhathedoes", "19374628590");
    }

    private void userLogin(String email, String password) throws InterruptedException {
        loginPage.email.sendKeys(email);
        loginPage.next.click();
        Thread.sleep(3000);
        loginPage.passwd.sendKeys(password);
        loginPage.login.click();
        Thread.sleep(7000);
    }

    @When("^user types in password as (.*)$")
    public void userTypesInPassword(String password) {
        loginPage.email.sendKeys(password);
        loginPage.next.click();
    }

    @When("^user types in username as (.*)$")
    public void userTypesInUsername(String email) {
        loginPage.email.sendKeys(email);
        loginPage.next.click();
    }

    @When("^user clicks next$")
    public void userClicksNext() {
        loginPage.next.click();
    }

    @When("^user clicks login$")
    public void userClicksLogin() {
        loginPage.login.click();
    }

}
