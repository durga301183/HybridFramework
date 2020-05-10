package pages;

import BaseTest.BaseTest;
import org.jsoup.Connection;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseTest {

    @FindBy(xpath = "//span[@class='user-display']")
    WebElement usernameLabel;

    @FindBy(xpath = "//span[contains(text(),'Contacts')]")
    WebElement contacts;

    @FindBy(xpath ="//button[contains(text(),'New')]")
    WebElement newcontact;

    @FindBy(className = "item-text")
    WebElement deals;

    @FindBy(xpath = "//span[contains(text(),'Tasks')]")
    WebElement tasks;

//initiolizing page object

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyHomePageTitle() {
        return driver.getTitle();
    }

    public ContactsPage clickonContactslink() throws InterruptedException {
        contacts.click();
        Thread.sleep(3000);
        newcontact.click();

        return new ContactsPage();

    }

    public DealsPage clickonDealslink() {
        deals.click();
        return new DealsPage();
    }

    public String checktext(){
         return driver.getTitle();


    }


}
