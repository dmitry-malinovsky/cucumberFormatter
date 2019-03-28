package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage implements Page {

    public String baseUrl = "https://gmail.com";
    public String name = "Login";

    @FindBy(xpath = "//input[@id='identifierId']")
    public WebElement email;

    @FindBy(xpath = "//div[@id='identifierNext']")
    public WebElement next;

    @FindBy(xpath = "//input[@type = 'password']")
    public WebElement passwd;

    @FindBy(xpath = "//div[@id='passwordNext']")
    public WebElement login;

    @Override
    public String getUrl() {
        return this.baseUrl;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
