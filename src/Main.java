import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) throws InterruptedException{

        /** ------ konfigurálás eleje ------ **/
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(30000)); // megadott sec-ig várakozik, hogy a megadott elemeknek legyen elég ideje megjelenni
        driver.manage().window().maximize(); // teljes képernyőre nagyítás
        driver.get("https://www.saucedemo.com/");  // weboldal megnyitása

        // Explicit wait beállítás
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(30000)); // változót hoz létre a várakozáshoz
        /** ------ konfigurálás vége ------ **/

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));  // megaddott sec-ig a megadott elemre várakozik h megjelenjen
            WebElement userNameInput = driver.findElement(By.id("user-name"));
            userNameInput.sendKeys("standard_user");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
            WebElement passwordInput = driver.findElement(By.id("password"));
            passwordInput.sendKeys("secret_sauce");

            wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
            WebElement loginButton = driver.findElement(By.id("login-button"));

            loginButton.click();
        } catch (NoSuchElementException ex){
            System.err.println(ex.getMessage());
            System.err.println("Cannot find username/password input field or login button");
        }

        Thread.sleep(3000);
        driver.quit();
    }
}