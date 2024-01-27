import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SwagLabTest {
    WebDriver driver;
    WebDriverWait wait;

    @Test
    public void loginWithValidDataTest() {
        driver.get("https://www.saucedemo.com");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
            WebElement userInput = driver.findElement(By.id("user-name"));
            userInput.sendKeys("standard_user");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
            WebElement userPassword = driver.findElement(By.id("password"));
            userPassword.sendKeys("secret_sauce");

            wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();

            WebElement productsTitle = driver.findElement(By.className("title"));
            Assert.assertNotNull(productsTitle);
        }catch (NoSuchElementException ex){
            System.err.println("No Such element" + ex.getMessage());
        }
    }
    @Test
    public void loginWithInValidDataTest(){
        driver.get("https://www.saucedemo.com");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("user-name")));
            WebElement userInput = driver.findElement(By.id("user-name"));
            userInput.sendKeys("littleDog");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
            WebElement userPassword = driver.findElement(By.id("password"));
            userPassword.sendKeys("littleCat");

            wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();
            WebElement errorMessageContainer = driver.findElement(By.className("error-message-container"));
            String errorMessage = errorMessageContainer.getText();
            Assert.assertEquals(errorMessage,
                    "Epic sadface: Username and password do not match any user in this service",
                    "A hibaüzenet nem felel meg a követelményeknek"); // ez csak akkor jelenik meg ha eltört a teszt.

        }catch (NoSuchElementException ex){
            System.err.println("No Such element" + ex.getMessage());
        }
    }
    @Test
    public void loginWithEmptyDataTest(){
        driver.get("https://www.saucedemo.com");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("user-name")));
            WebElement userInput = driver.findElement(By.id("user-name"));
            userInput.sendKeys("");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
            WebElement userPassword = driver.findElement(By.id("password"));
            userPassword.sendKeys("");

            wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();
            WebElement errorMessageContainer = driver.findElement(By.className("error-message-container"));
            String errorMessage = errorMessageContainer.getText();
            Assert.assertEquals(errorMessage, "Epic sadface: Username is required");

        }catch (NoSuchElementException ex){
            System.err.println("No Such element" + ex.getMessage());
        }
    }
    @Test
    public void loginWithEmptyUserNameDataTest(){
        driver.get("https://www.saucedemo.com");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("user-name")));
            WebElement userInput = driver.findElement(By.id("user-name"));
            userInput.sendKeys("");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
            WebElement userPassword = driver.findElement(By.id("password"));
            userPassword.sendKeys("secret_sauce");

            wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();

            WebElement errorMessageContainer = driver.findElement(By.className("error-message-container"));
            String errorMessage = errorMessageContainer.getText();
            Assert.assertEquals(errorMessage, "Epic sadface: Username is required");

        }catch (NoSuchElementException ex){
            System.err.println("No Such element" + ex.getMessage());
        }
    }
    @Test
    public void loginWithEmptyPasswordDataTest(){
        driver.get("https://www.saucedemo.com");
        try {
            List<WebElement> inputElements = driver.findElements(By.tagName("input"));
            WebElement userNameInput = inputElements.get(0);
            userNameInput.sendKeys("standard_user");

            WebElement passwordInput = inputElements.get(1);
            passwordInput.sendKeys("");

            WebElement loginButton = inputElements.get(2);
            loginButton.click();

            WebElement errorMessageContainer = driver.findElement(By.className("error-message-container"));
            String errorMessage = errorMessageContainer.getText();
            Assert.assertEquals(errorMessage, "Epic sadface: Password is required");
        } catch (NoSuchElementException ex) {
            System.err.println(ex.getMessage());
            System.err.println("Cannot find username/password input field or login button");
        }
    }
    @Test
    public void loginWithInValidUserNameValidPasswordDataTest(){
        driver.get("https://www.saucedemo.com");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
            WebElement userInput = driver.findElement(By.id("user-name"));
            userInput.sendKeys("littleDog");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
            WebElement userPassword = driver.findElement(By.id("password"));
            userPassword.sendKeys("secret_sauce");

            wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();

            WebElement errorMessageContainer = driver.findElement(By.className("error-message-container"));
            String errorMessage = errorMessageContainer.getText();
            Assert.assertEquals(errorMessage,
                    "Epic sadface: Username and password do not match any user in this service",
                    "A hibaüzenet nem felel meg a követelményeknek"); // ez csak akkor jelenik meg ha eltört a teszt.
        }catch (NoSuchElementException ex){
            System.err.println("No Such element" + ex.getMessage());
        }
    }
    @Test
    public void loginWithValidUserNameInValidPasswordDataTest(){
        driver.get("https://www.saucedemo.com");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
            WebElement userInput = driver.findElement(By.id("user-name"));
            userInput.sendKeys("standard_user");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
            WebElement userPassword = driver.findElement(By.id("password"));
            userPassword.sendKeys("littleCat");

            wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();

            WebElement errorMessageContainer = driver.findElement(By.className("error-message-container"));
            String errorMessage = errorMessageContainer.getText();
            Assert.assertEquals(errorMessage,
                    "Epic sadface: Username and password do not match any user in this service",
                    "A hibaüzenet nem felel meg a követelményeknek"); // ez csak akkor jelenik meg ha eltört a teszt.
        }catch (NoSuchElementException ex){
            System.err.println("No Such element" + ex.getMessage());
        }
    }
    @Test
    public void loginWith_problem_user_ValidUserNameDataTest(){
        driver.get("https://www.saucedemo.com");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("user-name")));
            WebElement userInput = driver.findElement(By.id("user-name"));
            userInput.sendKeys("problem_user");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
            WebElement userPassword = driver.findElement(By.id("password"));
            userPassword.sendKeys("secret_sauce");

            wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();
        }catch (NoSuchElementException ex){
            System.err.println("No Such element" + ex.getMessage());
        }
    }
    @Test
    public void loginWith_performance_glitch_user_ValidUserNameDataTest(){
        driver.get("https://www.saucedemo.com");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("user-name")));
            WebElement userInput = driver.findElement(By.id("user-name"));
            userInput.sendKeys("performance_glitch_user");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
            WebElement userPassword = driver.findElement(By.id("password"));
            userPassword.sendKeys("secret_sauce");

            wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();
        }catch (NoSuchElementException ex){
            System.err.println("No Such element" + ex.getMessage());
        }
    }
    @Test
    public void loginWith_Locked_out_ValidUserNameDataTest(){
        driver.get("https://www.saucedemo.com");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("user-name")));
            WebElement userInput = driver.findElement(By.id("user-name"));
            userInput.sendKeys("locked_out_user");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
            WebElement userPassword = driver.findElement(By.id("password"));
            userPassword.sendKeys("secret_sauce");

            wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();
        }catch (NoSuchElementException ex){
            System.err.println("No Such element" + ex.getMessage());
        }
    }
    @Test
    public void loginWith_error_user_ValidUserNameDataTest(){
        driver.get("https://www.saucedemo.com");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("user-name")));
            WebElement userInput = driver.findElement(By.id("user-name"));
            userInput.sendKeys("error_user");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
            WebElement userPassword = driver.findElement(By.id("password"));
            userPassword.sendKeys("secret_sauce");

            wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();
        }catch (NoSuchElementException ex){
            System.err.println("No Such element" + ex.getMessage());
        }
    }
    @Test
    public void loginWith_visual_user_ValidUserNameDataTest(){
        driver.get("https://www.saucedemo.com");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("user-name")));
            WebElement userInput = driver.findElement(By.id("user-name"));
            userInput.sendKeys("visual_user");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
            WebElement userPassword = driver.findElement(By.id("password"));
            userPassword.sendKeys("secret_sauce");

            wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();
        }catch (NoSuchElementException ex){
            System.err.println("No Such element" + ex.getMessage());
        }
    }

    @AfterSuite
    public void webDriverTearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    @BeforeSuite
    public void webDriverSetup() {
        /* ------ configuration starts ------ */
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(30000)); // megadott sec-ig várakozik az oldal betöltésére
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(30000)); // megadott sec-ig várakozik, hogy a megadott elemeknek legyen elég ideje megjelenni
        //driver.manage().window().maximize(); // teljes képernyőre nagyítás
        driver.get("https://www.saucedemo.com/");  // weboldal megnyitása

        // Explicit wait beállítás
        wait = new WebDriverWait(driver, Duration.ofMillis(30000)); // változót hoz létre a várakozáshoz
        /* ------ configuration ends ------ */
    }
}