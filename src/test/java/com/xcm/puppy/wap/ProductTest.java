package com.xcm.puppy.wap;

import com.xcm.puppy.BaseTest;
import com.xcm.puppy.page.wap.Homepage;
import com.xcm.puppy.page.wap.ProductPage;
import com.xcm.puppy.util.StaticDataProvider;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by jenkins on 12/1/17.
 */
public class ProductTest extends BaseTest{

    private Homepage homePage;
    private ProductPage productPage;

    @BeforeTest(alwaysRun = true)
    public void init()
    {
        homePage = new Homepage(driver);
        productPage = new ProductPage();

        homePage.openProduct();
    }

    @Test(alwaysRun = true, priority = 1)
    public void testItem()
    {
        List<WebElement> elements = productPage.getProductBox();
        for(WebElement element : elements)
        {
            selenium.click(element);
            String description = productPage.getDescription();
            productPage.back();
            Assert.assertTrue(description.contains("购买规则"));
        }
    }

    @Test(alwaysRun = true, priority = 2)
    public void openProduct()
    {
        productPage.openFirstProduct();
    }

    @Test(alwaysRun = true, priority = 3, dataProvider = "ProductData4ItemTest", dataProviderClass = StaticDataProvider.class)
    public void testMenu(String locator, String content)
    {
        WebElement element = productPage.openItem(locator, content);
        Assert.assertNotNull(element);
    }



}
