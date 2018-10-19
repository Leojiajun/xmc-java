package com.xcm.puppy;

import com.xcm.puppy.page.LaunchPage;
import com.xcm.puppy.page.ListPage;
import com.xcm.puppy.page.ProductPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2016/7/21.
 */
public class ProductInfoTest extends BaseTest {

    private LaunchPage launchPage;
    private ListPage listPage;
    private ProductPage productPage;

    @BeforeClass(alwaysRun = true, description = "Initialization")
    private void init() {
        launchPage = new LaunchPage(driver);
        listPage = new ListPage(driver);

        launchPage.load();
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

    @Test(alwaysRun = true, dependsOnMethods = "openListPage", description = "打开产品详情")
    public void openProductInfo() {
        productPage = listPage.selectProduct();
        Assert.assertNotNull(productPage);
    }

    @Test(alwaysRun = true, dependsOnMethods = "openProductInfo", description = "打开项目描述")
    public void openProjectInfo() {
        Assert.assertNotNull(productPage.openProjectInfo());
    }

    @Test(alwaysRun = true, dependsOnMethods = "openProductInfo", description = "打开安全保障")
    public void openSafeProtect() {
        Assert.assertNotNull(productPage.openSafeProtect());
    }

    @Test(alwaysRun = true, dependsOnMethods = "openProductInfo", description = "打开投资记录")
    public void openInvestRec() {
        Assert.assertNotNull(productPage.openInvestRec());
    }


}
