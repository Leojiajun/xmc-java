package com.xcm.puppy.website;

import com.xcm.puppy.BaseTest;
import com.xcm.puppy.page.website.HomePage;
import com.xcm.puppy.page.website.ProductPage;
import com.xcm.puppy.util.StaticDataProvider;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by jenkins on 17/10/16.
 */
public class HomeTest extends BaseTest {
    private HomePage homePage;
    private ProductPage productPage;

    @BeforeClass(alwaysRun = true)
    public void init()
    {
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);

    }

    @Test(alwaysRun = true)
    public void openHome()
    {
        WebElement element = homePage.open();
        Assert.assertNotNull(element);
    }

    @Test(dependsOnMethods = {"openHome"}, dataProvider = "HomeTestData4LinkTest", dataProviderClass = StaticDataProvider.class)
    public void testLink(String link, String check)
    {
        WebElement element = homePage.openLink(link, check);
        homePage.backHome();
        Assert.assertNotNull(element);
    }

    @Test(dependsOnMethods = {"openHome"})
    public void testArticle()
    {
        List<WebElement> elements = homePage.getArticles();
        int size = elements.size();
        for(int i=0; i<size; i++)
        {
            List<WebElement> articles = homePage.getArticles();
            WebElement element = articles.get(i);
            selenium.scrollTo(element);
            selenium.click(element);
            WebElement content = homePage.getArticleContent();
            homePage.backHome();
            Assert.assertNotNull(content);
        }
    }

    @Test(dependsOnMethods = {"openHome"})
    public void openProduct()
    {
        List<WebElement> elements = homePage.getProductList();
        if(null == elements)
        {
            Assert.assertTrue(false);
        }
        for(int i=0; i<elements.size(); i++)
        {
            List<WebElement> productList = homePage.getProductList();
            WebElement element = productList.get(i);
            String productName = homePage.getProductName(element);
            selenium.scrollTo(element);
            selenium.click(element);
            String name = productPage.getProduct_name();
            System.out.println("product on homepage : " + productName );
            homePage.backHome();
            Assert.assertEquals(productName, name);
        }
        elements = homePage.getBigProductList();
        if(null == elements)
        {
            Assert.assertTrue(false);
        }
        for(int i=0; i<elements.size(); i++)
        {
            List<WebElement> productList = homePage.getBigProductList();
            WebElement element = productList.get(i);
            String productName = homePage.getPrdName(element);
            selenium.scrollTo(element);
            selenium.click(element);
            String name = productPage.getProduct_name();
            System.out.println("product on homepage : " + productName );
            homePage.backHome();
            Assert.assertEquals(productName, name);
        }

    }




}
