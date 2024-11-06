package PageobjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TricentisDemoWorkshop {
    public static String websiteURL="https://demowebshop.tricentis.com/";
    public String getWebsiteURL="https://demowebshop.tricentis.com/";
    public static WebDriver driver = new ChromeDriver();
    public WebElement ComputersTab = driver.findElement(By.xpath("//a[@class='hover']"));
    public WebElement DesktopIcon = driver.findElement(By.xpath("//img[@title='Show products in category Desktops']"));
    //Webelemente erweitern

    public WebElement jewelryTab = driver.findElement(By.linkText("Jewelry"));
    public WebElement BlackandWhiteNecklace = driver.findElement(By.xpath("//h2/a[contains(text(), 'Black & White Diamond Heart')]"));
    public WebElement addToCartButton = driver.findElement(By.xpath("//input[@id='add-to-cart-button-14']"));
    public WebElement greenBar = driver.findElement(By.id("bar-notification"));
    public WebElement topCart= driver.findElement(By.id("topcartlink"));

    public static WebElement Login = driver.findElement(By.xpath("//a[@class='ico-login']"));
    public static WebElement emailField = driver.findElement(By.id("Email"));



}
