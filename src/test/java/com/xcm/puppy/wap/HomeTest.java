package com.xcm.puppy.wap;

import com.xcm.puppy.BaseTest;
import com.xcm.puppy.page.wap.Homepage;
import com.xcm.puppy.util.StaticDataProvider;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by jenkins on 12/1/17.
 */
public class HomeTest extends BaseTest {

    private Homepage homePage;

    @BeforeTest(alwaysRun = true)
    public void init()
    {
        homePage = new Homepage(driver);

    }

    @Test(alwaysRun = true, dataProvider = "HomeTestData4menuTest", dataProviderClass = StaticDataProvider.class)
    public void testMenu(String locator, String content)
    {
        WebElement element = homePage.openMenu(locator, content);
        Assert.assertNotNull(element);
    }

    @Test(alwaysRun = true)
    public void testProduct()
    {
        String description = homePage.openRecommendation();
        homePage.back();
        Assert.assertTrue(description.contains("还款方式"));
    }

}
