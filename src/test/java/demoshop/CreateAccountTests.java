package demoshop;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import webshop.data.UserData;
import webshop.models.User;

import java.util.Date;

public class CreateAccountTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (app.getUser().isLogOutPresent()) {
            app.getUser().clickOnLogOutButton();
        }
    }

    @Test
    public void newUserPositivTest() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        app.getUser().clickOnRegistrButton();
        app.getUser().fillRegisterLoginForm(new User().setFirstName(UserData.FIRSTNAME).setLastName(UserData.SECONDNAME).setEmail("cheburek13223" + i +"@gmail.com").setPassword(UserData.PASSWORD).setPassword(UserData.PASSWORD));
        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isRegistrationComplete());
    }

}