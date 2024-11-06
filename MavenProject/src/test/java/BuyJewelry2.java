import PageobjectModel.TricentisDemoWorkshop;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.*;
import java.time.Duration;


public class BuyJewelry2 extends TricentisDemoWorkshop {

    public static void main(String[] args) throws InterruptedException {

        // Instanz von BuyJewelry erstellen, um auf Webelemente zuzugreifen
        BuyJewelry2 buyJewelry = new BuyJewelry2();

        //ChromeDriver
        WebDriver driver = new ChromeDriver();
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\Ghazal Aslami\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        //Initialisieren
        //WebDriver driver = new ChromeDriver();

        //Seite öffnen
        driver.get(websiteURL);
        buyJewelry.driver.get(buyJewelry.websiteURL);;
        //driver.get("https://demowebshop.tricentis.com");

        //Warten
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Seite maximieren
        WebDriver.Window window = driver.manage().window();
        window.maximize();

        //  Zum Jewelry Tab
        //WebElement jewelryTab = driver.findElement(By.linkText("Jewelry"));
        buyJewelry.jewelryTab.click();

        // Kette auswählen
        //WebElement BlackandWhiteNecklace = driver.findElement(By.xpath("//h2/a[contains(text(), 'Black & White Diamond Heart')]"));
        buyJewelry.BlackandWhiteNecklace.click();

        // Warte bis das Quantity-Feld sichtbar ist und ändere es auf 2
        //Thread.sleep(3000);
        WebElement quantityInput = driver.findElement(By.xpath("//input[@id='addtocart_14_EnteredQuantity']"));
        wait.until(ExpectedConditions.visibilityOf(quantityInput));
        quantityInput.clear();  // Lösche den vorhandenen Wert
        quantityInput.clear();  // Lösche den vorhandenen Wert
        quantityInput.sendKeys("2");  // Setze den Wert auf 2


        //  "Add to Cart"-Button klicken finden, darauf warten
        //WebElement addToCartButton = driver.findElement(By.xpath("//input[@id='add-to-cart-button-14']"));
        wait.until(ExpectedConditions.elementToBeClickable(buyJewelry.addToCartButton));
        buyJewelry.addToCartButton.click();  // Klicke auf den "Add to Cart"-Button

        // grüne Bestätigungsleiste finden
        //WebElement greenBar = driver.findElement(By.id("bar-notification"));
        wait.until(ExpectedConditions.visibilityOf(buyJewelry.greenBar));
        // Text überprüfen
        String notificationText = buyJewelry.greenBar.getText();
        System.out.println("The product has been added to your shopping cart " + notificationText);

        // Warte 3 Sekunden
        Thread.sleep(3000);
        //Klicke erneut add to Cart
        buyJewelry.addToCartButton.click();
        Thread.sleep (3000);

        // Gehe in den Warenkorb
        //WebElement topCart= driver.findElement(By.id("topcartlink"));
        buyJewelry.topCart.click();

        Thread.sleep(3000);
        driver.quit();

    }

}
