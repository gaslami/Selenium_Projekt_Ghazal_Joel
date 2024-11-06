package day1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


import java.security.Key;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumDemo {

 private static Object TimeUnit;

 public static void main(String[] args) {
       int customTimeout = 10000;

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Ghazal Aslami\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.get("https://demowebshop.tricentis.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.id("small-searchterms")).sendKeys("laptop");
        driver.findElement(By.id("small-searchterms")).sendKeys(Keys.ENTER);
        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2/a[contains(text(), '14.1 inch Laptop')]")));
        product.click();

        //WebElement productLink = driver.findElement(By.xpath("//h2/a[contains(text(), '14.1-inch Laptop')]"));
        //productLink.click();
        WebElement showDetailsButton = driver.findElement(By.xpath("//h2/a[contains(text(), '14.1-inch Laptop')]/following::button[contains(text(), 'Show details')]"));
        showDetailsButton.click();

        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button-14")));
        addToCartButton.click();


        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(customTimeout));

        // Warte, bis das Element mit dem angegebenen XPath vorhanden und klickbar ist
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div[2]/div[3]/div[2]/input")));

        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div[2]/div[3]/div[2]/input")).click();


        driver.findElement(By.xpath("//input[@class='button-2 product-box-add-to-cart-button']")).click();
        driver.findElement(By.xpath("//input[@class='button-2 product-box-add-to-cart-button' and @value='Add to cart']")).click();

        // Warte maximal 10 Sekunden

        // Warte, bis das Element sichtbar ist und klicke darauf
        //WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='button-2 product-box-add-to-cart-button']")));
        //button.click();

        //  driver.findElement(By.xpath("//span[@class='cart-label']")).click();
        //driver.findElement(By.xpath("//span[normalize-space()='Shopping cart']")).click();
       // driver.findElement(By.xpath("//span[@class='cart-label' and text()='Shopping cart']")).click();
        //driver.findElement(By.xpath("//html[1]/body[1]/div[4]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]/span[1]")).click();
        driver.findElement(By.linkText("topcartlink")).click();

        driver.findElement(By.xpath("//id='topcartlink'")).click();
        driver.findElement(By.linkText("shopping cart")).click();
    }

}

