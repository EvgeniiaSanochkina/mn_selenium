package test;

import data.Data;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class Selenium {

//    void createBrowser() {
//        driver = new ChromeDriver();
//    }
private WebDriver driver;



    @BeforeEach
    void createBrowser() {
        driver = new ChromeDriver();
    }

//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }



    @Test
    public void completeOrder() {
        driver.get(Data.baseURL);
        WebElement cats = driver.findElement(By.linkText("Кошки"));
        cats.click();
        WebElement itemToCart = driver.findElements(By.className("to-basket-link")).get(1);
        itemToCart.click();
        WebElement cart = driver.findElement(By.className("basket-link__icon"));
        cart.click();
        WebElement buyButton = driver.findElement(By.id("create-order"));
        buyButton.click();
        WebElement name = driver.findElement(By.className("recipient-name"));
        name.sendKeys("колян");
        WebElement number = driver.findElement(By.className("recipient-phone"));
        number.sendKeys("1111111111");
        WebElement next = driver.findElements(By.tagName("button")).get(3);
        next.click();

        WebElement selectPickUpPointButton = driver.findElement(By.className("open-pickup-retail-points-popup"));
        //Assert.assertTrue(selectPickUpPointButton.isDisplayed());
//        wait.until(ExpectedConditions.invisibilityOfElementLocated
//                (By.className("open-pickup-retail-points-popup")));
        selectPickUpPointButton.click();
    }

}
