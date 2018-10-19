package com.xcm.puppy.website;

import com.xcm.puppy.BaseTest;
import com.xcm.puppy.page.website.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by jenkins on 16/8/16.
 */
public class SmokeTest extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;
    private ListPage listPage;
    private ProductPage productPage;
    private CheckoutPage checkoutPage;

    @BeforeClass(alwaysRun = true)
    public void init() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        listPage = new ListPage(driver);
        productPage = new ProductPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Parameters({"username", "password", "expected"})
    @Test(alwaysRun = true, description = "输入账户和密码,点击'立即登录'按钮")
    public void login(String username, String password, String expected) {
        homePage.openLoginPage();
        String actual = loginPage.login(username, password);
        Assert.assertTrue(actual.contains(expected));
    }

    @Test(alwaysRun = true, dependsOnMethods = {"login"}, description = "点击'我要理财'菜单,验证打开产品列表页")
    public void openListPage() {
        WebElement actual = homePage.openListPage();
        Assert.assertNotNull(actual);
    }

    @Test(alwaysRun = true, dependsOnMethods = {"openListPage"}, description = "点击第1个'立即购买'按钮,打开产品详情页")
    public void openProductPage() {
        String actual = listPage.chooseFirstProduct();
        Assert.assertTrue(actual.contains("购买规则"));
    }

    @Test(alwaysRun = true, dependsOnMethods = {"openProductPage"}, description = "点击'立即购买'进行购买,打开结算页")
    public void buy() {
        String bonus = productPage.buy();
        Assert.assertTrue(bonus.contains("."));
    }

    @Test(alwaysRun = true, dependsOnMethods = {"buy"}, description = "在结算页,点击'立即充值'")
    public void confirm() {
        String actual = checkoutPage.submitOrd();
        Assert.assertEquals(actual, "订单详情");
    }



}
