package testfälle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LogIn1 {

    public static void main(String[] args) {

        //ChromeDriver
        WebDriver driver = new ChromeDriver();
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\Ghazal Aslami\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        driver.get("https://demowebshop.tricentis.com");

        //Warten
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Seite maximieren
        WebDriver.Window window = driver.manage().window();
        window.maximize();

        //Auf Login klicken
        WebElement Login = driver.findElement(By.xpath("//a[@class='ico-login']"));
        Login.click();

        // E-Mail-Adresse eingeben
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("gaslami@nelta.de");

        //Passwort eingeben
        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("123456");

        // Auf den Login-Button klicken
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log in']"));
        loginButton.click();

        // Überprüfen, ob der Login erfolgreich war
        // Dadurch, dass nach dem Login was BEstimmtes sichtbar wird
        WebElement accountLink = driver.findElement(By.xpath("//a[@class='account']"));
        if (accountLink.isDisplayed()) {
            System.out.println("Login erfolgreich!");
        } else {
            System.out.println("Login fehlgeschlagen.");
        }

        //Thread.sleep(3000);
        driver.quit();
    }
}
