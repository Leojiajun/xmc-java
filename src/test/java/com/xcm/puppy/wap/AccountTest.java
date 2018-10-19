package com.xcm.puppy.wap;

import com.xcm.puppy.BaseTest;
import com.xcm.puppy.page.wap.AccountPage;
import com.xcm.puppy.page.wap.Homepage;
import com.xcm.puppy.page.wap.LoginPage;
import com.xcm.puppy.util.StaticDataProvider;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by jenkins on 16/1/17.
 */
public class AccountTest extends BaseTest{

    private Homepage homePage;
    private AccountPage accountPage;
    private LoginPage loginPage;


    @BeforeClass(alwaysRun = true)
    public void init()
    {
        homePage = new Homepage(driver);
        accountPage = new AccountPage();
        loginPage = new LoginPage();
    }

    @Parameters({"base-url"})
    @BeforeMethod(alwaysRun = true)
    public void openAccount(String url) {
        selenium.open(url);
        homePage.openAccount();
    }

    @Parameters({"username", "password"})
    @Test(alwaysRun = true)
    public void login(String username, String password)
    {
        accountPage.openLogin();
        String actual = loginPage.login(username, password);
        double amount = Double.parseDouble(actual);
        Assert.assertTrue(amount > 0);
    }

    @Test(alwaysRun = true, priority = 1)
    public void doRecharge()
    {
        accountPage.openAvailability();
        accountPage.openRecharge();
        WebElement element = accountPage.goRecharge(12.12);
        Assert.assertNotNull(element);
    }

    @Test(alwaysRun = true, priority = 2)
    public void testGold()
    {
        WebElement element = accountPage.openGold();
        Assert.assertNotNull(element);
    }

    @Test(alwaysRun = true, priority = 3)
    public void testGoldPrd()
    {
        WebElement element = accountPage.openGoldPrd();
        Assert.assertNotNull(element);
    }

    @Test(alwaysRun = true, priority = 4, dataProvider = "AccountData4CouponTest", dataProviderClass = StaticDataProvider.class)
    public void testCoupon(String tab)
    {
        int size = accountPage.openCoupon(tab);
        Assert.assertTrue(size > 0);
    }

    @Test(alwaysRun = true, priority = 5)
    public void testAgreement()
    {
        accountPage.openAsset();
        accountPage.openHoldingAsset();
        String agreementTitle = accountPage.openAgreement();
        Assert.assertEquals(agreementTitle, "【投资计划】产品服务协议");
    }

    @Test(alwaysRun = true, priority = 6)
    public void testInvest()
    {
        accountPage.openAsset();
        accountPage.openHoldingAsset();
        accountPage.openOrder();
    }









}
