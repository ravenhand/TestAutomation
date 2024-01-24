import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainV2 {
    static WebDriver driver;
    static WebDriverWait wait;

    public static void main(String[] args) throws InterruptedException {
        webDriverSetup();
        //loginByIdTest();
        //loginByNameTest();
        //loginByClassNameTest();
        //loginByTagNameTest();
        loginByCSSSelectorTest();
        webDriverTearDown();
        System.out.println("Test execution ended");
    }

    public static void webDriverTearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    public static void webDriverSetup() {
        /** ------ konfigurálás eleje ------ **/
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(30000)); // megadott sec-ig várakozik az oldal betöltésére
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(30000)); // megadott sec-ig várakozik, hogy a megadott elemeknek legyen elég ideje megjelenni
        driver.manage().window().maximize(); // teljes képernyőre nagyítás
        driver.get("https://www.saucedemo.com/");  // weboldal megnyitása

        // Explicit wait beállítás
        wait = new WebDriverWait(driver, Duration.ofMillis(30000)); // változót hoz létre a várakozáshoz
        /** ------ konfigurálás vége ------ **/
    }

    public static void loginByIdTest() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));  // megadott sec-ig a megadott elemre várakozik h megjelenjen
            WebElement userNameInput = driver.findElement(By.id("user-name"));
            userNameInput.sendKeys("standard_user");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
            WebElement passwordInput = driver.findElement(By.id("password"));
            passwordInput.sendKeys("secret_sauce");

            wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
            WebElement loginButton = driver.findElement(By.id("login-button"));

            loginButton.click();
        } catch (NoSuchElementException ex) {
            System.err.println(ex.getMessage());
            System.err.println("Cannot find username/password input field or login button");
        }
    }
    public static void loginByNameTest(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("user-name")));  // megadott sec-ig a megadott elemre várakozik h megjelenjen
            WebElement userNameInput = driver.findElement(By.name("user-name"));
            userNameInput.sendKeys("standard_user");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
            WebElement passwordInput = driver.findElement(By.name("password"));
            passwordInput.sendKeys("secret_sauce");

            wait.until(ExpectedConditions.elementToBeClickable(By.name("login-button")));
            WebElement loginButton = driver.findElement(By.name("login-button"));

            loginButton.click();
        } catch (NoSuchElementException ex) {
            System.err.println(ex.getMessage());
            System.err.println("Cannot find username/password input field or login button");
        }
    }
    public static void loginByClassNameTest(){
        try {
            WebElement userNameInput = driver.findElement(By.className("input_error"));
            userNameInput.sendKeys("standard_user");

            WebElement passwordInput = driver.findElement(By.className("input_error"));
            passwordInput.sendKeys("secret_sauce");

            WebElement loginButton = driver.findElement(By.className("submit_button"));
            loginButton.click();
        } catch (NoSuchElementException ex) {
            System.err.println(ex.getMessage());
            System.err.println("Cannot find username/password input field or login button");
        }
    }
    public static void loginByTagNameTest(){
        try {
            List<WebElement> inputElements = driver.findElements(By.tagName("input"));
            WebElement userNameInput = inputElements.get(0);
            userNameInput.sendKeys("standard_user");

            WebElement passwordInput = inputElements.get(1);
            passwordInput.sendKeys("secret_sauce");

            WebElement loginButton = inputElements.get(2);
            loginButton.click();
        } catch (NoSuchElementException ex) {
            System.err.println(ex.getMessage());
            System.err.println("Cannot find username/password input field or login button");
        }
    }
    public static void loginByCSSSelectorTest(){
        try {
            WebElement userNameInput = driver.findElement(By.cssSelector("input#user-name"));
            userNameInput.sendKeys("standard_user");

            WebElement passwordInput = driver.findElement(By.cssSelector("input#password"));
            passwordInput.sendKeys("secret_sauce");

            WebElement loginButton = driver.findElement(By.cssSelector("input[id='login-button']"));
            loginButton.click();
        } catch (NoSuchElementException ex) {
            System.err.println(ex.getMessage());
            System.err.println("Cannot find username/password input field or login button");
        }
    }
}