package com.xcm.puppy.wap;

import com.xcm.puppy.BaseTest;
import com.xcm.puppy.page.wap.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by jenkins on 3/1/17.
 */
public class SmokeTest extends BaseTest{

    private Homepage homepage;
    private ProductPage productPage;
    private LoginPage loginPage;
    private AccountPage accountPage;
    private CheckoutPage checkoutPage;

    @BeforeClass(alwaysRun = true)
    public void init()
    {
        homepage = new Homepage(driver);
        productPage = new ProductPage();
        loginPage = new LoginPage();
        accountPage = new AccountPage();
        checkoutPage = new CheckoutPage();

    }

    @Test(alwaysRun = true, priority = 1)
    public void openHome()
    {
        String productHome = homepage.getProductName();
        Assert.assertTrue(productHome.endsWith("期"));
    }

    @Parameters({"username", "password"})
    @Test(dependsOnMethods = {"openHome"}, priority = 2)
    public void login(String username, String password)
    {
        homepage.openAccount();
        accountPage.openLogin();
        String actual = loginPage.login(username, password);
        double amount = Double.parseDouble(actual);
        Assert.assertTrue(amount > 0);
    }

    @Test(dependsOnMethods = {"login"}, priority = 3)
    public void openProduct()
    {
        homepage.openProduct();
        List<WebElement> products = productPage.getProductBox();
        Assert.assertNotNull(products);
    }

    @Test(dependsOnMethods = {"openProduct"}, priority = 4)
    public void buy()
    {
        productPage.openFirstProduct();
        productPage.buy();
        WebElement element = checkoutPage.checkout();
        Assert.assertNotNull(element);
    }


}
