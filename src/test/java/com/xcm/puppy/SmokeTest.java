package com.xcm.puppy;

import com.xcm.puppy.page.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * 1. 打开商品列表页
 * 2. 打开商品详情页
 */
public class SmokeTest extends BaseTest {

    private LoginPage loginPage;
    private ListPage listPage;
    private ProductPage productPage;
    private CheckoutPage checkoutPage;
    private LaunchPage launchPage;

    private String product;

    @BeforeClass(alwaysRun = true,
            description = "Initialization")
    public void init() {
        loginPage = new LoginPage(driver);
        listPage = new ListPage(driver);
        productPage = new ProductPage(driver);
        checkoutPage = new CheckoutPage(driver);
        launchPage = new LaunchPage(driver);

        launchPage.load();
    }

    @Parameters({"username", "password"})
    @Test(alwaysRun = true, description = "Login with different users")
    public void login(String username, String password){
        String actual = loginPage.login(username, password);
        Assert.assertFalse(actual.startsWith("0.00"));

    }

    @Parameters({"page-title"})
    @Test(alwaysRun = true,
            description = "Open product list page")
    public void openListPage(@Optional String pageTitle) {
        String expected = "理财";
        if (null != pageTitle) {
            expected = pageTitle;
        }

        String actual = listPage.open();
        Assert.assertTrue(actual.startsWith(expected));
    }

    @Parameters({"product-name"})
    @Test(dependsOnMethods = {"openListPage"},
            description = "Open product detail page")
    public void openProductPage(@Optional String productName) {
        product = getAttribute("productName", productName, "any product");
        listPage.selectProduct();
        Assert.assertEquals(productPage.getDay(), "期限");
    }

    @Test(dependsOnMethods = {"openProductPage"},
            description = "Buy a product")
    public void checkout(){
        productPage.buy();
        String actual = checkoutPage.buy();
        Assert.assertTrue(actual.startsWith("新浪支付"));

    }



}
