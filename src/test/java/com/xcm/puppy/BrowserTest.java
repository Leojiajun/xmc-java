package com.xcm.puppy;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;


/**
 * Created by jenkins on 18/9/16.
 */
public class BrowserTest {

    @Test(alwaysRun = true)
    public void test() throws Exception
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "iPhone 6");
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "9.3");
        capabilities.setCapability("browserName", "safari");
        RemoteWebDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


        System.out.println("======START======");
        driver.get("http://m.91xcm.com/share.html");
        System.out.println("======END======");

        Thread.sleep(10000);

        driver.quit();
    }
}
