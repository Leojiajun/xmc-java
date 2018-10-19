package com.xcm.puppy;

import com.xcm.puppy.page.LaunchPage;
import com.xcm.puppy.page.ListPage;
import com.xcm.puppy.page.ProductPage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by jenkins on 27/9/16.
 */
public class ProductTest extends BaseTest {
    private LaunchPage launchPage;
    private ListPage listPage;

    @BeforeClass(alwaysRun = true, description = "Initialization")
    private void init() {
        launchPage = new LaunchPage(driver);
        listPage = new ListPage(driver);

        launchPage.load();
    }

    @Test(alwaysRun = true, description = "浏览所有的产品")
    public void openProductOneByOne() {
        listPage.open();
        if (driver instanceof AndroidDriver) {
            int before = 0;
            int after = 1;
            Set<String> products = new HashSet<String>();

            while (before != after) {
                List<String> productNames = listPage.getProductName();
                List<WebElement> elements = listPage.getCurrentPageProducts();
                for (int i = 0; i < elements.size(); i++) {
                    Assert.assertNotNull(listPage.clickProduct(elements.get(i)));
                    listPage.goBack();
                }
                before = products.size();
                products.addAll(productNames);
                after = products.size();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                listPage.nextShot();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            List<WebElement> products = listPage.getCurrentPageProducts();
            for (int i = 0; i < products.size(); i++) {
                List<WebElement> product = listPage.getCurrentPageProducts();
                Assert.assertNotNull(listPage.clickProduct(product.get(i)));
                listPage.goBack();
                listPage.swipUp();
            }
        }
    }
}
