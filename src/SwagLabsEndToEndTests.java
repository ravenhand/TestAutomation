import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

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
}
