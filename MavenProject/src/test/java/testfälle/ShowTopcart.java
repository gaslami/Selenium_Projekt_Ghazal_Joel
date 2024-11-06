package testfälle;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ShowTopcart {
    public static void main(String[] args) {

        //Webdriver
        WebDriver driver = new ChromeDriver();

        //Seite aufrufen
        driver.get("https://demowebshop.tricentis.com");

        //Suchleiste finden, Laptop eingeben
        WebElement searchTerm= driver.findElement(By.id("small-searchterms"));
        searchTerm.sendKeys("laptop");
        searchTerm.sendKeys(Keys.ENTER);

        //14.inch Laptop auswählen
        WebElement productLaptop = driver.findElement(By.xpath("//img[@title='Show details for 14.1-inch Laptop']"));
        productLaptop.click();

        //Zum Warenkorb hinzufügen
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button-31"));
        addToCartButton.click();

        //Warten
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Warenkorb aufrufen
        WebElement topCartLink = driver.findElement(By.id("topcartlink"));
        topCartLink.click();

        //AGBs zustimmen
        WebElement checkboxTermsOfService = driver.findElement(By.id("termsofservice"));
        checkboxTermsOfService.click();

        //Checkout
        WebElement checkOutButton = driver.findElement(By.id("checkout"));
        checkOutButton.click();






    }
}
