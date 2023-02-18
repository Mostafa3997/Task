package Tests;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

public class Tests {

    private WebDriver driver;
    private HomePage homePage;
    private RegisterPage registerPage;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CheckoutPage checkoutPage;
    private CartPage cartPage;

    String currentTime=new SimpleDateFormat("yyyyMMddHHMMssSSS").format(new Date());
    @BeforeClass
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().maximize();
         homePage=new HomePage(driver);
         registerPage=new RegisterPage(driver);
         loginPage=new LoginPage(driver);
         productsPage=new ProductsPage(driver);
         checkoutPage=new CheckoutPage(driver);
         cartPage=new CartPage(driver);


    }

    @Test
    public void UserRegister(){
        homePage.ClickOnSignUpButton();

        String Username="Mostafa"+currentTime;
        registerPage.FillUsername(Username);
        registerPage.FillPassword("123456");
        registerPage.ClickOnSignUpButton();
        Assert.assertEquals("Sign up successful.",registerPage.getAlert());
        registerPage.AcceptAlert();

    }
    @Test(dependsOnMethods = {"UserRegister"})
    public void UserLogin(){
        homePage.ClickOnLogInButton();
        loginPage.FillUsernameAtLoginForm("Mostafa311");
        loginPage.FillPasswordAtLoginForm("123456");
        loginPage.ClickOnLoginButton();
        Assert.assertEquals("Welcome Mostafa311",homePage.getname());

    }


    @Test(dependsOnMethods = {"UserLogin"})
    public void AddProductsToCart(){
        productsPage.countProduct();
        productsPage.selectProduct();
        productsPage.ClickOnAddCart();
        Assert.assertEquals("Product added.",productsPage.getAlert());
        productsPage.AcceptAlert();
      homePage.ClickOnHomeLink();
        productsPage.ClickLaptop();
        productsPage.selectProduct();
        productsPage.ClickOnAddCart();
        Assert.assertEquals("Product added.",productsPage.getAlert());
        productsPage.AcceptAlert();
    }
    @Test(dependsOnMethods = {"AddProductsToCart"})
    public void DeleteProductFromCart(){
        homePage.ClickOnCartPage();
        cartPage.DeleteProduct();
        homePage.ClickOnHomeLink();
    }

    @Test(dependsOnMethods = {"DeleteProductFromCart"})
    public void CheckOut(){
        homePage.ClickOnCartPage();
        cartPage.ClickOnPlaceOrder();
        checkoutPage.SetName("Mostafa");
        checkoutPage.SetCity("Cairo");
        checkoutPage.SetMonth("March");
        checkoutPage.SetCountry("Egypt" );
        checkoutPage.SetCard(currentTime);
        checkoutPage.SetYear("2023");
        checkoutPage.ClickPurchase();

    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }



}
