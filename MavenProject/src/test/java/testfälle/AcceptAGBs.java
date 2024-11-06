package testfälle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AcceptAGBs {

    public static void main(String[] args) {

        //Webdriver
        WebDriver driver = new ChromeDriver();

        //Seite aufrufen
        driver.get("https://demowebshop.tricentis.com/");

        WebElement computer = driver.findElement(By.xpath("//div[@class='picture']//img[@title='Show details for Build your own cheap computer']"));
        computer.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button-72"));
        addToCartButton.click();

        WebElement barNotification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bar-notification")));
        //Überprüfe die Korrektheit der BEnachrichtigung
        if (barNotification.getText().contains("The product has been added to your shopping cart")) {
            System.out.println("Test bestanden -  Produkt wurde hinzugefügt");
        } else {
            System.out.println("Test fehlgeschlagen - Produkt wurde nicht dem Warenkorb hinzugefügt");
        }

        //grüne Benachrichtigungsleiste schließen,damit Warenkorb Link nicht blockiert wird
        WebElement closeNotificationButton = driver.findElement(By.cssSelector("#bar-notification .close"));
        closeNotificationButton.click();

        // Warten, bis die Benachrichtigungsleiste vollständig verschwindet
        wait.until(ExpectedConditions.invisibilityOf(barNotification));

        WebElement topCart = driver.findElement(By.id("topcartlink"));
        topCart.click();

        WebElement checkOutButton = driver.findElement(By.id("checkout"));
        checkOutButton.click();

        //Überprüfen ob das Popover mit der Warnung erscheint
        WebElement warningBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("terms-of-service-warning-box")));
        String warningText = warningBox.getText();

        //Textinhalt des Popovers überprüfen
        if (warningText.contains("Please accept the terms of service before the next step.")) {
            System.out.println("Test bestanden: AGB Warnung wird angezeigt");
        } else {
            System.out.println("Test fehlgeschlagen: Falscher AGB Text");
        }

        driver.quit();
        }

    }
