package testfälle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BuyJewelry1 {
    public static void main(String[] args) throws InterruptedException {

        //ChromeDriver
        WebDriver driver = new ChromeDriver();
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\Ghazal Aslami\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        //Initialisieren
        //WebDriver driver = new ChromeDriver();

        //Seite öffnen
        //driver.get(websiteURL);
        //buyJewelry.driver.get(buyJewelry.websiteURL);;
        driver.get("https://demowebshop.tricentis.com");

        //Warten
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Seite maximieren
        WebDriver.Window window = driver.manage().window();
        window.maximize();

        //  Zum Jewelry Tab
        WebElement jewelryTab = driver.findElement(By.linkText("Jewelry"));
        jewelryTab.click();

        // Kette auswählen
        WebElement BlackandWhiteNecklace = driver.findElement(By.xpath("//h2/a[contains(text(), 'Black & White Diamond Heart')]"));
        BlackandWhiteNecklace.click();

        // Warte bis das Quantity-Feld sichtbar ist und ändere es auf 2
        WebElement quantityInput = driver.findElement(By.xpath("//input[@id='addtocart_14_EnteredQuantity']"));
        wait.until(ExpectedConditions.visibilityOf(quantityInput));

        //Lösche den vorhandenen Wert
        quantityInput.clear();

        //Setze Wert auf 2
        quantityInput.sendKeys("2");

        //  "Add to Cart"-Button klicken finden, darauf warten
        WebElement addToCartButton = driver.findElement(By.xpath("//input[@id='add-to-cart-button-14']"));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();

        // grüne Bestätigungsleiste finden
        WebElement greenBar = driver.findElement(By.id("bar-notification"));
        wait.until(ExpectedConditions.visibilityOf(greenBar));
        // Text überprüfen
        String notificationText = greenBar.getText();
        System.out.println("The product has been added to your shopping cart " + notificationText);

        // Warte 3 Sekunden
        Thread.sleep(5000);
        //Klicke erneut add to Cart
        addToCartButton.click();
        Thread.sleep (5000);

        // Gehe in den Warenkorb
        WebElement topCart= driver.findElement(By.id("topcartlink"));
        topCart.click();

        driver.quit();

    }

}
