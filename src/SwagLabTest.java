import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SwagLabTest {
    static WebDriver driver;
    static WebDriverWait wait;

    public static void main(String[] args) throws InterruptedException {
        webDriverSetup();
        //loginWithValidDataTest();
        //loginWithInValidDataTest();
        loginWithEmptyDataTest();
        //loginWithEmptyPasswordDataTest();
        //loginWithEmptyUserNameDataTest();
        //loginWithInValidUserNameValidPasswordDataTest();
        //loginWithValidUserNameInValidPasswordDataTest();
        //loginWith_problem_user_ValidUserNameDataTest();
        //loginWith_Locked_out_ValidUserNameDataTest();
        //loginWith_performance_glitch_user_ValidUserNameDataTest();
        //loginWith_error_user_ValidUserNameDataTest();
        //loginWith_visual_user_ValidUserNameDataTest();

        webDriverTearDown();
        System.out.println("Test execution ended");
    }

    public static void loginWithValidDataTest() throws InterruptedException {
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
        }catch (NoSuchElementException ex){
            System.err.println("No Such element" + ex.getMessage());
        }
    }
    public static void loginWithInValidDataTest(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("user-name")));
            WebElement userInput = driver.findElement(By.id("user-name"));
            userInput.sendKeys("kiskutya");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
            WebElement userPassword = driver.findElement(By.id("password"));
            userPassword.sendKeys("kismacska");

            wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();
        }catch (NoSuchElementException ex){
            System.err.println("No Such element" + ex.getMessage());
        }
    }
    public static void loginWithEmptyDataTest(){
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
        }catch (NoSuchElementException ex){
            System.err.println("No Such element" + ex.getMessage());
        }
    }

    public static void loginWithEmptyUserNameDataTest(){
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
        }catch (NoSuchElementException ex){
            System.err.println("No Such element" + ex.getMessage());
        }
    }
    public static void loginWithEmptyPasswordDataTest(){
        try {
            List<WebElement> inputElements = driver.findElements(By.tagName("input"));
            WebElement userNameInput = inputElements.get(0);
            userNameInput.sendKeys("standard_user");

            WebElement passwordInput = inputElements.get(1);
            passwordInput.sendKeys("");

            WebElement loginButton = inputElements.get(2);
            loginButton.click();
        } catch (NoSuchElementException ex) {
            System.err.println(ex.getMessage());
            System.err.println("Cannot find username/password input field or login button");
        }
    }

    public static void loginWithInValidUserNameValidPasswordDataTest(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
            WebElement userInput = driver.findElement(By.id("user-name"));
            userInput.sendKeys("Kiskutya");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
            WebElement userPassword = driver.findElement(By.id("password"));
            userPassword.sendKeys("secret_sauce");

            wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();
        }catch (NoSuchElementException ex){
            System.err.println("No Such element" + ex.getMessage());
        }
    }
    public static void loginWithValidUserNameInValidPasswordDataTest(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
            WebElement userInput = driver.findElement(By.id("user-name"));
            userInput.sendKeys("standard_user");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
            WebElement userPassword = driver.findElement(By.id("password"));
            userPassword.sendKeys("kismacska");

            wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();
        }catch (NoSuchElementException ex){
            System.err.println("No Such element" + ex.getMessage());
        }
    }

    public static void loginWith_problem_user_ValidUserNameDataTest(){
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

    public static void loginWith_performance_glitch_user_ValidUserNameDataTest(){
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

    public static void loginWith_Locked_out_ValidUserNameDataTest(){
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

    public static void loginWith_error_user_ValidUserNameDataTest(){
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

    public static void loginWith_visual_user_ValidUserNameDataTest(){
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
}