package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;

    // elements

    private By Signup =By.id("signin2");
    private By login=By.id("login2");
    private By GetUsername =By.id("nameofuser");
    private By cart=By.id("cartur");
    private By HomeLink=By.xpath("//a[contains(.,'Home')]");

    //Create Constractor
    public HomePage(WebDriver driver){this.driver=driver;}

    public void ClickOnSignUpButton(){
        driver.findElement(Signup).click();
    }
    public void ClickOnLogInButton(){
        driver.findElement(login).click();
    }
    public String getname(){
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(GetUsername));
        return driver.findElement(GetUsername).getText();
    }
    public void ClickOnCartPage(){
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(GetUsername));
        driver.findElement(cart).click();
    }
    public void ClickOnHomeLink(){
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(HomeLink));
        driver.findElement(HomeLink).click();
    }
}
