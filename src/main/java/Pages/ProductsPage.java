package Pages;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductsPage {

    private WebDriver driver;
    private By Mointor=By.xpath("//a[contains(.,'Monitors')]");
    private By Laptop=By.xpath("//a[contains(.,'Laptops')]");
    private By Product=By.xpath("//div[@id='tbodyid']/div[2]");
    private By AddCart=By.xpath("//a[contains(.,'Add to cart')]");
    private By Phones=By.xpath("//a[contains(.,'Phones')]");
    public ProductsPage(WebDriver driver){
        this.driver=driver;
    }
    public void ClickLaptop(){
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(Laptop));
        driver.findElement(Laptop).click();
    }
    public void ClickOnMointor(){
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(Mointor));
        driver.findElement(Mointor).click();
    }
    public void ClickOnPhones(){
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(Phones));
        driver.findElement(Phones).click();
    }


    public void countProduct(){

        List<WebElement> list = driver.findElements(By.xpath("//div[@id='tbodyid']/div"));
        int itemsCount = list.size();
        System.out.println(itemsCount);

    }

    public void selectProduct(){
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(Product));
        driver.findElement(Product).click();
    }
    public void ClickOnAddCart(){
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(AddCart));
        driver.findElement(AddCart).click();
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
