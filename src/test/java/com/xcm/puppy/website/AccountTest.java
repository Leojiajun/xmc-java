package com.xcm.puppy.website;

import com.xcm.puppy.BaseTest;
import com.xcm.puppy.page.*;
import com.xcm.puppy.page.website.*;
import com.xcm.puppy.page.website.AccountPage;
import com.xcm.puppy.page.website.CheckoutPage;
import com.xcm.puppy.page.website.ListPage;
import com.xcm.puppy.page.website.LoginPage;
import com.xcm.puppy.page.website.ProductPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by jenkins on 24/8/16.
 */
public class AccountTest extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;
    private AccountPage accountPage;

    @BeforeClass(alwaysRun = true)
    public void init() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
    }

    @Parameters({"username", "password", "expected"})
    @Test(alwaysRun = true, description = "输入账户和密码,点击'立即登录'按钮")
    public void login(String username, String password, String expected) {
        homePage.openLoginPage();
        String actual = loginPage.login(username, password);
        System.out.println("The message after login is : " + actual);
        Assert.assertTrue(actual.contains(expected));
    }

    @Test(alwaysRun = true, dependsOnMethods = {"login"}, description = "点击'我的账户'菜单,遍历所有的账户页面")
    public void traversalAccountPage() {
        accountPage.open();
        List<WebElement> menu = accountPage.getMenu();
        for(int i=0; i<menu.size(); i++)
        {
            List<WebElement> elements = accountPage.getMenu();
            WebElement content = accountPage.getContent(elements.get(i));
            Assert.assertNotNull(content);
        }
    }
}
