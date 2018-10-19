package com.xcm.puppy.wap;

import com.xcm.puppy.util.Selenium;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.URL;

/**
 * Created by jenkins on 5/1/17.
 */
public class WapBaseTest {

    public RemoteWebDriver driver;
    public Selenium selenium;

    @BeforeTest(alwaysRun = true)
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "9.3");
        capabilities.setCapability("deviceName", "iPhone 6");
        capabilities.setCapability("browserName", "safari");
        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.get("http://m.91xcm.com");

    }

    @AfterTest(alwaysRun = true)
    public void tearDown()
    {
        driver.quit();
    }
}
