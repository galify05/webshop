package demoshop;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import webshop.data.UserData;
import webshop.models.User;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (app.getUser().isLogOutPresent()) {
            app.getUser().clickOnLogOutButton();
        }
    }

    @Test
    public void loginPositiveTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
        app.getUser().clickOnEnterButton();

        Assert.assertTrue(app.getUser().isLogOutPresent());
    }

    @Test
    public void loginNegativeTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(new User().setEmail(UserData.EMAIL));
        app.getUser().clearPss();
        app.getUser().clickOnEnterButton();

        Assert.assertTrue(app.getUser().isLoginUsuccessful());
    }
}