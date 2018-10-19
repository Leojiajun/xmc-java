package com.xcm.puppy.website;

import com.xcm.puppy.BaseTest;
import com.xcm.puppy.page.website.HomePage;
import com.xcm.puppy.page.website.ListPage;
import com.xcm.puppy.page.website.ProductPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by jenkins on 2/11/16.
 */
public class ProductDetailTest extends BaseTest {

    private HomePage homePage;
    private ListPage listPage;
    private ProductPage productPage;

    @BeforeClass(alwaysRun = true)
    public void init()
    {
        homePage = new HomePage(driver);
        listPage = new ListPage(driver);
        productPage = new ProductPage(driver);

    }

    @Test(alwaysRun = true, priority = 0)
    public void openProductPage()
    {
        homePage.openListPage();
        String name = listPage.chooseFirstProduct();
        Assert.assertTrue(name.contains("起息日"));
    }

    @Test(alwaysRun = true, priority = 1)
    public void testInfo()
    {
        int count = productPage.openInfo();
        Assert.assertEquals(count, 5);
    }

    @Test(alwaysRun = true, priority = 2)
    public void testOrder()
    {
        int count = productPage.openOrderRecord();
        Assert.assertEquals(count, 4);
    }
}
