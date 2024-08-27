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
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Selenium2 {

    private WebDriver driver;

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    public void completeOrder() {
        driver = new ChromeDriver();
        driver.get(Data.baseURL);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
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
        wait.until(ExpectedConditions.elementToBeClickable
                (next));
        next.click();

        WebElement selectPickUpPointButton = driver.findElement(By.className("open-pickup-retail-points-popup"));
        wait.until(ExpectedConditions.elementToBeClickable
                (selectPickUpPointButton));
        selectPickUpPointButton.click(); // до этого места доходит

        List<WebElement> pickUpPoints = driver.findElements(By.className("modal__body_address_block"));
        wait.until(ExpectedConditions.visibilityOfAllElements(pickUpPoints)); // Expected condition failed: waiting for visibility of all
        WebElement pickUpPoint = driver.findElements(By.className("modal__body_address_block")).get(0);
        pickUpPoint.click();

//        List<WebElement> pickUpPoints = driver.findElements(By.className("filial"));
//        wait.until(ExpectedConditions.visibilityOfAllElements(pickUpPoints)); // Expected condition failed: waiting for visibility of all
//        WebElement pickUpPoint = pickUpPoints.get(3);
//        pickUpPoint.click();

        WebElement selectCertainPickUpPoint = driver.findElement(By.className("place__button"));
        selectCertainPickUpPoint.click();

    }

}