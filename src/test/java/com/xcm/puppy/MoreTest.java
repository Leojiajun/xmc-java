package com.xcm.puppy;

import com.xcm.puppy.page.*;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.*;

/**
 * 1. 打开更多s
 */
public class MoreTest extends BaseTest {

    private MorePage morePage;
    private LaunchPage launchPage;

    @BeforeClass(alwaysRun = true,
            description = "Initialization")
    public void init() {
        morePage = new MorePage(driver);
        launchPage = new LaunchPage(driver);

        launchPage.load();
    }

    @Test(alwaysRun = true, description = "更多")
    public void openMorePage() {
        Assert.assertNotNull(morePage.openMorePage());

    }

    @Test(alwaysRun = true, dependsOnMethods = "openMorePage", description = "关于我们")
    public void openAboutUs() {
        AssertJUnit.assertNotNull(morePage.openAboutUs());
    }

}
