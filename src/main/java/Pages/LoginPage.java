package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    public LoginPage (WebDriver driver){
        this.driver=driver;
    }

    private By Username_login= By.id("loginusername");
    private By Password_login=By.id("loginpassword");
    private By LoginButton=By.xpath("//button[contains(.,'Log in')]");

    public void FillUsernameAtLoginForm(String username){
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(Username_login));
        driver.findElement(Username_login).sendKeys(username);
    }
    public void FillPasswordAtLoginForm(String Password){
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(Password_login));
        driver.findElement(Password_login).sendKeys(Password);
    }
    public void ClickOnLoginButton(){
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(LoginButton));
        driver.findElement(LoginButton).click();
    }
    public void AcceptAlert(){
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }


}
