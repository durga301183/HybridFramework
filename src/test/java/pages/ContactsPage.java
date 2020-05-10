package pages;

import BaseTest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactsPage extends BaseTest {

    @FindBy(xpath ="//span[contains(text(),'Contacts')]")
    WebElement contactele;

    @FindBy(name = "first_name")
    WebElement firstname;

    @FindBy(name = "last_name")
    WebElement lastname;

   // @FindBy(xpath ="//div[@name='category']")
   // WebElement category;

    @FindBy(xpath= "//button[@class='ui linkedin button']")
    WebElement savebut;

    @FindBy(xpath = "//div[@class='ui header item mb5 light-black']")
    WebElement label;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/table[1]/thead[1]/tr[1]/th[1]/div[1]/input[1]")
    WebElement checkbox;

    @FindBy(xpath ="//textarea[@name='description']")
    WebElement des;
    @FindBy(xpath ="//div[@class='ui checked toggle checkbox']//label[contains(text(),'Do not Text')]")
    WebElement slide;

    public ContactsPage() {

        PageFactory.initElements(driver, this);
    }

    public boolean verifyLabel() {

        return label.isDisplayed();
    }

    public void selectContacts(){
        contactele.click();
        // checkbox.click();
    }

     public void createnewContact(String fname, String lname, String descrip) throws InterruptedException {
      firstname.sendKeys(fname);
      lastname.sendKeys(lname);
      des.sendKeys(descrip);
      Thread.sleep(2000);
         JavascriptExecutor js= (JavascriptExecutor) driver;
         Thread.sleep(2000);
         js.executeScript("window.scrollBy(0,1000)");



      //  Select options = new Select(driver.findElement(By.xpath("//div[@name='category']")));
      //   Select options = new Select(driver.findElement(By.xpath("//div[@name='category']")));
    // options.selectByVisibleText(descrip);

    // slide.click();
         Thread.sleep(1000);

       savebut.click();

     }
}

