package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By UserName= By.id("sign-username");
    private By Password=By.id("sign-password");
    private By SignUp=By.xpath("//button[contains(.,'Sign up')]");
    public RegisterPage(WebDriver driver){
        this.driver=driver;}
    public void FillUsername(String username){
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(UserName));
        driver.findElement(UserName).sendKeys(username);
    }
    public void FillPassword(String password){
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(Password));
        driver.findElement(Password).sendKeys(password);
    }
    public void ClickOnSignUpButton(){
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(SignUp));
        driver.findElement(SignUp).click();
    }
    public void AcceptAlert(){
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }
    public String getAlert(){
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();

    }
}
