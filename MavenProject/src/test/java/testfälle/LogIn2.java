import PageobjectModel.TricentisDemoWorkshop;
import PageobjectModel.TricentisDemoWorkshop2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LogIn2 extends TricentisDemoWorkshop2 {

    public static void main(String[] args) {

        LogIn2 login2 = new LogIn2();

        //ChromeDriver
        WebDriver driver = new ChromeDriver();
        //driver.get(websiteURL);
        //driver.get(websiteURL);
        driver.get("https://demowebshop.tricentis.com/");

        //Seite maximieren
        WebDriver.Window window = driver.manage().window();
        window.maximize();

        // Instanz der TricentisDemoWorkshop-Klasse erstellen
        //TricentisDemoWorkshop2 tricentisPage = new TricentisDemoWorkshop(driver);

        //tricentisPage.loginLink.click();

        //tricentisPage.clickLoginLink();

        //Auf Login klicken
        //Login.click();

        // E-Mail-Adresse eingeben
        //emailField.sendKeys("gaslami@nelta.de");

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
