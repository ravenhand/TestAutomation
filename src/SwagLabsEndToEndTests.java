import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.lang.model.util.Elements;
import java.util.List;
import java.util.Random;

public class SwagLabsEndToEndTests extends SwagLabTest{

    @Test
    @Description("Standard user log in and buy a product.")
    public void standardUserHappyPath(){
        // Előfeltétel
        driver.get("https://www.saucedemo.com"); // weboldal betöltése

        // Teszt lépések

//        1. Beírjuk a felhasználó nevet: standard_user
        WebElement userNameInput = driver.findElement(By.id("user-name"));
        userNameInput.sendKeys("standard_user");
//        2. Beírjuk a jelszót: secret_sauce
        WebElement userPwInput = driver.findElement(By.id("password"));
        userPwInput.sendKeys("secret_sauce");
//        3. Rákattintunk a login gombra
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
//        4. Rákattintunk az Add to cart gombra a "Sauce Labs Bolt T-shirt"-nek
        WebElement sauceLabsBackpackCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        sauceLabsBackpackCartButton.click();
//        5. Rákattintunk a kosár gombra a jobb felső sarokban
        WebElement shoppingCartIcon = driver.findElement(By.className("shopping_cart_link"));
        shoppingCartIcon.click();
//        6. Rákattintunk a checkout gombra
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();
//        7. Kitöltjük a first name inputot: Elek
        WebElement firstNameInput = driver.findElement(By.id("first-name"));
        firstNameInput.sendKeys("Elek");
//        8. Kitöltjük a last name inputot: Mekk
        WebElement lastNameInput = driver.findElement(By.id("last-name"));
        lastNameInput.sendKeys("Mekk");
//        9. Kitöltjük a zip code inputot: 1111
        WebElement zipCodeInput = driver.findElement(By.id("postal-code"));
        zipCodeInput.sendKeys("1111");
//        10. Rákattintunk a Continue gombra
        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();
//        11. Rákattintunk a Finish gombra
        WebElement finishButton = driver.findElement(By.id("finish"));
        finishButton.click();
//        12. Sikeres vásárlás esetén rákattintunk a Back Home gombra
        WebElement backHomeButton = driver.findElement(By.id("back-to-products"));
        backHomeButton.click();

        // Elvárt működés

        //- A felület címe "Product" legyen
        WebElement productsTitle = driver.findElement(By.className("title"));
        Assert.assertTrue(productsTitle.isDisplayed());
        //- A cart badge nem jelenik meg a kosár ikonon
        // 1. megoldás
//        try{
//            WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
//            Assert.assertFalse(cartBadge.isDisplayed());
//        }catch (NoSuchElementException ex){
//            System.err.println("No such element: " + ex.getMessage());
//            Assert.assertTrue(true);
//        }
        // 2. megoldás
        boolean shoppingCartBadge = driver.getPageSource().contains("shopping_cart-badge"); // logikai érték: megvizsgálja hogy egy elem megtalálható e az egész oldalon
        Assert.assertFalse(shoppingCartBadge);
    }
    @Test
    @Description("Standard user log in and buy multiple products with cart modification")
    public void standardUserMultipleProductPath(){
        // Előfeltétel
        driver.get("https://www.saucedemo.com"); // weboldal betöltése

        // Teszt lépések

//        1. Beírjuk a felhasználó nevet: standard_user
        List<WebElement> input = driver.findElements(By.className("input_error"));
        WebElement userNameInput = input.get(0);
        userNameInput.sendKeys("standard_user");
//        2. Beírjuk a jelszót: secret_sauce
        WebElement userPwInput = input.get(1);
        userPwInput.sendKeys("secret_sauce");
//        3. Rákattintunk a login gombra
        WebElement loginButton = driver.findElement(By.className("submit-button"));
        loginButton.click();
//        4. Rákattintunk az Add to cart gombra a "Sauce Labs Bolt T-shirt"-nek
        WebElement sauceLabsBoltTShirtCartButton = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]"));
        sauceLabsBoltTShirtCartButton.click();
//        5. Rákattintunk az Add to cart gombra a "Sauce Labs Backpack"-nek
        WebElement sauceLabsBackpackCartButton = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]"));
        sauceLabsBackpackCartButton.click();
//        6. Rákattintunk az Add to cart gombra a "Sauce Labs Bike Light"-nek
        WebElement sauceLabsBikeLight = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]"));
        sauceLabsBikeLight.click();
//        7. Rákattintunk a kosár gombra a jobb felső sarokban
        WebElement shoppingCartIcon = driver.findElement(By.className("shopping_cart_link"));
        shoppingCartIcon.click();
//        8. Remove gombbal eltávolítjuk a középső terméket
        List<WebElement> productRemoveButtons = driver.findElements(By.className("btn"));
        WebElement middleProductRemoveButton= productRemoveButtons.get(1);
        middleProductRemoveButton.click();
//        9. Rákattintunk a Checkout gombra
        WebElement checkoutButton = driver.findElement(By.className("checkout_button"));
        checkoutButton.click();
//        10. Kitöltjük a first name inputot: Elek
        WebElement firstNameInput = driver.findElement(By.cssSelector("input#first-name"));
        firstNameInput.sendKeys("Elek");
//        11. Kitöltjük a last name inputot: Mekk
        WebElement lastNameInput = driver.findElement(By.cssSelector("input#last-name"));
        lastNameInput.sendKeys("Mekk");
//        12. Kitöltjük a zip code inputot: 1111
        WebElement zipCodeInput = driver.findElement(By.cssSelector("input#postal-code"));
        Random random = new Random();
        int zipCode = random.nextInt(1000,9999);
        zipCodeInput.sendKeys(String.valueOf(zipCode));
//        13. Rákattintunk a Continue gombra
        WebElement continueButton = driver.findElement(By.className("submit-button"));
        continueButton.click();
//        14. Rákattintunk a Finish gombra
        WebElement finishButton = driver.findElement(By.className("btn_action"));
        finishButton.click();
//              - Jelenjen meg a Thank you for your order! felirat a képernyőn (Assert használat)
        WebElement completeHeaderText = driver.findElement(By.className("complete-header"));
        String completeText = completeHeaderText.getText();
        Assert.assertEquals(completeText,"Thank you for your order!");
//        15. Rákattintunk a menü "logout" gombra
        WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));
        menuButton.click();
        WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]"));
        logoutButton.click();

//        Elvárt működés
//        Bejelentkezési képernyőre való navigálás sikeres
        WebElement loginCredentials = driver.findElement(By.className("login_credentials"));
        Assert.assertTrue(loginCredentials.getText().contains("visual_user"));
    }
}
