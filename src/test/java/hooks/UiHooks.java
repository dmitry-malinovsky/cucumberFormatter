package hooks;

import PageObjects.EmailPage;
import PageObjects.LoginPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import stepdefs.ScenarioContext;

public class UiHooks {
    @Before
    public void initEnvironment() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        ScenarioContext.saveData("driver", driver);

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        ScenarioContext.saveData("Login", loginPage);

        EmailPage emailPage = PageFactory.initElements(driver, EmailPage.class);
        ScenarioContext.saveData("Email", emailPage);

        driver.get(loginPage.baseUrl);
    }

    @After
    public void wrapUp(){
        WebDriver driver = (WebDriver) ScenarioContext.getData("driver");
        driver.close();
    }
}

