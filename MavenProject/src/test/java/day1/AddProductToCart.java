package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AddProductToCart {
    public static void main(String[] args) {

        // Setzen des ChromeDriver-Pfades
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ghazal Aslami\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Initialisieren des WebDrivers
        WebDriver driver = new ChromeDriver();

        // WebDriverWait für dynamische Elemente
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebDriver.Window window = driver.manage().window();
        window.maximize();

        try {
            // 1. Öffne die Website
            driver.get("https://demowebshop.tricentis.com");
            

            // Warte, bis das Produkt auf der Startseite sichtbar ist
            WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-grid']//a[contains(text(), 'Build your own computer')]")));

            // 2. Klicke auf das Produkt
            product.click();

            // 3. Warte, bis die Produktseite vollständig geladen ist (z.B. auf das "Add to Cart"-Feld warten)
            WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button-1")));

            // 4. Klicke auf "Add to Cart"
            addToCartButton.click();

            // 5. Warte auf die Bestätigung, dass das Produkt erfolgreich zum Warenkorb hinzugefügt wurde
            WebElement cartSuccessMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bar-notification")));

            // Überprüfe, ob das Produkt erfolgreich zum Warenkorb hinzugefügt wurde
            System.out.println("Produkt erfolgreich zum Warenkorb hinzugefügt: " + cartSuccessMessage.getText());

        } finally {
            // Browser schließen
            driver.quit();
        }
    }
}
