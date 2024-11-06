package testfälle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AddComputerToCart {

    public static void main(String[] args) throws InterruptedException {

        //Webdriver
        WebDriver driver = new ChromeDriver();

        //Seite aufrufen
        driver.get("https://demowebshop.tricentis.com/");

        //Klicke auf das Produkt Build your own cheap computer
        WebElement product = driver.findElement(By.xpath("//img[@title='Show details for Build your own cheap computer']"));
        product.click();

        //Klicke auf Add to Cart
        WebElement addComputerToCart = driver.findElement(By.id("add-to-cart-button-72"));
        addComputerToCart.click();

        // WebDriverWait für dynamische Elemente
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        //Warte auf die grüne Bestätigungsleiste
        //WebElement barNotification = driver.findElement(By.id("bar-notification"));
        WebElement barNotification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bar-notification")));

        //Überprüfe die Korrektheit der BEnachrichtigung
        if (barNotification.getText().contains("The product has been added to your shopping cart")) {
            System.out.println("Test bestanden -  Produkt wurde hinzugefügt");
        } else {
            System.out.println("Test fehlgeschlagen - Produkt wurde nicht dem Warenkorb hinzugefügt");
        }

        // WebDriverWait für dynamische Elemente
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Schließe Browser
        driver.quit();
    }
}
