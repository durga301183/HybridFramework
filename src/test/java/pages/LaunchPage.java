package pages;

import BaseTest.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LaunchPage extends BaseTest {

    @FindBy(xpath="//span[contains(text(),'Log In')]")
    WebElement lnkSignIn;
//Initialising the PageObjects
 public LaunchPage(){
     PageFactory.initElements(driver, this);
 }
//Actions
  public LoginPage navigateToLogin(){
     lnkSignIn.click();
     return PageFactory.initElements(driver, LoginPage.class);
  }

}
