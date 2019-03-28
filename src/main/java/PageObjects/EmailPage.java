package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EmailPage implements Page {
    public String baseUrl = "https://gmail.com";
    public String name = "Email";

    @FindBy(xpath = "//div[contains(text(),'Compose')]")
    public WebElement composeEmail;

    @FindBy(xpath = "//textarea[@name='to']")
    public WebElement recepientEmail;

    @FindBy(xpath = "//input[@name='subjectbox']")
    public WebElement emailSubject;

    @FindBy(xpath = "//div[contains(text(),'Send')]")
    public WebElement send;

    @FindBy(xpath = "//div[@aria-label='Message Body']")
    public WebElement emailBody;

    @FindBy(xpath = "//tr[@draggable='true']")
    public List<WebElement> receivedEmails;

    @Override
    public String getUrl() {
        return this.baseUrl;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
