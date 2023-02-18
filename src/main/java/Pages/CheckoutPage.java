package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    private WebDriver driver;
    public CheckoutPage(WebDriver driver){
        this.driver=driver;
    }
    private By name= By.id("name");
    private By country=By.id("country");
    private By city=By.id("city");
    private By card =By.id("card");
    private By month=By.id("month");
    private By year=By.id("year");
    private By Purchase=By.xpath("//button[contains(.,'Purchase')]");
    private By successMessage=By.xpath("//h2[contains(.,'Thank you for your purchase!')]");
    private By OkButton=By.xpath("//button[@class='confirm btn btn-lg btn-primary']");


    public void SetName(String Name){
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(name));
        driver.findElement(name).sendKeys(Name);
    }
    public void SetCountry(String Country){
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(country));
        driver.findElement(country).sendKeys(Country);}
    public void SetCity(String City){
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(city));
        driver.findElement(city).sendKeys(City);
    }
    public void SetCard(String Card){
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(card));
        driver.findElement(card).sendKeys(Card);
    }
    public void SetMonth(String Month){
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(month));
        driver.findElement(month).sendKeys(Month);}
    public void SetYear(String Year){
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(year));
        driver.findElement(year).sendKeys(Year);}
    public void ClickPurchase(){
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(Purchase));
        driver.findElement(Purchase).click();}

    public String GetSuccessMessage(){
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(successMessage));
        return driver.findElement(successMessage).getText();
    }
    public void GoToHomePage(){

        driver.findElement(OkButton).click();

    }











}
