package demoshop;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import webshop.data.ItemData;
import webshop.data.UserData;
import webshop.models.User;

public class AddItemToCartTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {

        if (!app.getUser().isLogOutPresent()) {
            app.getUser().clickOnLoginLink();
            app.getUser().fillLoginForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
            app.getUser().clickOnEnterButton();
        }
    }

    @Test
    public void addItemtoCartTest() {
        app.getCart().findItemOnPage();
        app.getCart().addItemToCart();
        app.getCart().moveToCart();
        Assert.assertEquals(app.getCart().getNameOfCartsItem(), ItemData.LAPTOP);
    }
}