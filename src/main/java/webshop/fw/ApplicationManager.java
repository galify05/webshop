package webshop.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.json.StringCoercer;

import java.time.Duration;

public class ApplicationManager {

    String browser;

    UserHelper user;
    CartHelper cart;

    WebDriver driver;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {

        if(browser.equalsIgnoreCase("chrome")){
        driver = new ChromeDriver();

        } else if(browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();

        }
        else if (browser.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
        }

        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        user = new UserHelper(driver);
        cart = new CartHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

    public UserHelper getUser() {
        return user;
    }

    public CartHelper getCart() {
        return cart;
    }
}
