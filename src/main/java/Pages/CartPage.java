package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage {
    private WebDriver driver;
    private By Delete=By.xpath("//tbody[@id='tbodyid']/tr[1]/td/a[contains(.,'Delete')]");
    private By PlaceOrder=By.xpath("//button[@class='btn btn-success']");
    public By DeleteButton=By.xpath("//a[contains(.,'Delete')]");

    public CartPage (WebDriver driver){
        this.driver=driver;
    }
    public void DeleteProduct(){
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(Delete));
        driver.findElement(Delete).click();
    }
    public void ClickOnPlaceOrder(){
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(PlaceOrder));
        driver.findElement(PlaceOrder).click();
    }



}
