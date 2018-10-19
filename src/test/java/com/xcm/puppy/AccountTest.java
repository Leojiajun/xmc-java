package com.xcm.puppy;

import com.xcm.puppy.page.AccountPage;
import com.xcm.puppy.page.LaunchPage;
import com.xcm.puppy.page.LoginPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

/**
 * Created by jenkins on 26/7/16.
 */
public class AccountTest extends BaseTest {
    private LaunchPage launchPage;
    private LoginPage loginPage;
    private AccountPage accountPage;

    @Parameters({"username", "password"})
    @BeforeClass(alwaysRun = true)
    public void init(@Optional String username, @Optional String password) {
        launchPage = new LaunchPage(driver);
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);

        launchPage.load();
        loginPage.login(username, password);
    }

    @Test(alwaysRun = true, priority = 4,
            description = "打开充值页面,并充值")
    public void testRecharge() {
        accountPage.openBalancePage();
        accountPage.openChargePage();
        String str = accountPage.recharge("1000");
        accountPage.backToHome();
        Assert.assertTrue(str.startsWith("新浪支付"));
    }

    @Test(alwaysRun = true, priority = 1,
            description = "打开提现页面,并提现")
    public void testCash() {
        accountPage.openBalancePage();
        accountPage.openCashPage();
        String str = accountPage.recharge("0.49");
        accountPage.backToHome();
        Assert.assertTrue(str.startsWith("新浪支付"));
    }

    @Test(alwaysRun = true, priority = 2,
            description = "在提现页面,打开提现说明页面")
    public void testCashRecord() {
        accountPage.openBalancePage();
        accountPage.openCashPage();
        String str = accountPage.openFeePage();
        accountPage.backToHome();
        Assert.assertTrue(str.startsWith("如何获得免费提现机会"));
    }

    @Test(alwaysRun = true, priority = 3,
            description = "打开资金记录页")
    public void testFreeFee() {
        accountPage.openBalancePage();
        WebElement element = accountPage.openCashRecordPage();
        accountPage.backToHome();
        Assert.assertNotNull(element);
    }


    public void openProfile() {
        String logout = accountPage.clickFavicon();
        Assert.assertEquals(logout, "安全退出");
    }

    @Test(alwaysRun = true, dataProvider = "menu4account",
            description = "遍历账户首页所有的Menu,并一一执行click操作")
    public void testMenu(String menu, String content, String expected) {
        selenium.click(menu);
        String actual = selenium.getText(content);
        accountPage.backToHome();
        Assert.assertTrue(actual.startsWith(expected));

    }

    @DataProvider(name = "menu4account")
    public Object[][] getMenu()
    {
        return accountPage.getMenu();
    }

}
