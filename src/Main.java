import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://totalcar.hu/");
        System.out.println("Hello world!");
    }
}