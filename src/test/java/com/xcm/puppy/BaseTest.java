package com.xcm.puppy;

import com.xcm.puppy.util.GlobalSettings;
import com.xcm.puppy.util.Selenium;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.net.URL;
import java.util.Map;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class BaseTest {
    public RemoteWebDriver driver;
    public Selenium selenium;
    private String driverType = GlobalSettings.driverType;
    private String firefoxBinary = GlobalSettings.firefoxBinary;
    private String chromeBinary = GlobalSettings.chromeBinary;
    private String remoteAddress = GlobalSettings.remoteAddress;
    private String apkPath = GlobalSettings.apkPath;
    private String ipaPath = GlobalSettings.ipaPath;
    private String baseUrl = GlobalSettings.baseUrl;
    private String platformName = GlobalSettings.platformName;
    private String platformVersion = GlobalSettings.platformVersion;
    private String deviceName = GlobalSettings.deviceName;
    private String appActivity = GlobalSettings.appActivity;
    private String appPackage = GlobalSettings.appPackage;
    private String bundleId = GlobalSettings.bundleId;
    private String udid = GlobalSettings.udid;
    private String browserName = GlobalSettings.browserName;

    /**
     * 获取属性
     *
     * @param envAttribute
     * @param testngAttribute
     * @param globalSettingsAttribute
     * @return
     */
    public static String getAttribute(String envAttribute, String testngAttribute, String globalSettingsAttribute) {
        String attribute = System.getProperty(envAttribute);
        if (("${" + envAttribute + "}").equals(attribute) || null == attribute || "".equals(attribute)) {
            attribute = testngAttribute;
            if (null == attribute || "".equals(attribute)) {
                attribute = globalSettingsAttribute;
            }
        }
        return attribute;
    }

    @Parameters({"driver-type", "remote-address", "apk-path", "ipa-path", "platform-name", "platform-version", "device-name", "app-activity", "app-package","bundle-id", "ud-id", "firefox-binary", "chrome-binary", "base-url", "browser-name"})
    @BeforeTest(alwaysRun = true, description = "Initialize AppiumDriver")
    public void setUp(@Optional String driverType, @Optional String remoteAddress, @Optional String apkPath,
                      @Optional String ipaPath, @Optional String platformName, @Optional String platformVersion,
                      @Optional String deviceName, @Optional String appActivity, @Optional String appPackage,
                      @Optional String bundleid, @Optional String udid, @Optional String firefoxBinary,
                      @Optional String chromeBinary, @Optional String baseUrl, @Optional String browserName) throws Exception {

        String type = getAttribute("driverType", driverType, this.driverType);
        String pName = getAttribute("platformName", platformName, this.platformName);
        String version = getAttribute("platformVersion", platformVersion, this.platformVersion);
        String dName = getAttribute("deviceName", deviceName, this.deviceName);
        String pkg = getAttribute("appPackage", appPackage, this.appPackage);
        String activity = getAttribute("appActivity", appActivity, this.appActivity);
        String aPath = getAttribute("apkPath", apkPath, this.apkPath);
        String iPath = getAttribute("ipaPath", ipaPath, this.ipaPath);
        String address = getAttribute("remoteAddress", remoteAddress, this.remoteAddress);
        String bundle = getAttribute("bundleId", bundleid, this.bundleId);
        String id = getAttribute("udid", udid, this.udid);
        String firefoxPath = getAttribute("firefoxBinary", firefoxBinary, this.firefoxBinary);
        String chromePath = getAttribute("chromeBinary", chromeBinary, this.chromeBinary);
        final String url = getAttribute("baseUrl", baseUrl, this.baseUrl);
        String browser = getAttribute("browserName", browserName, this.browserName);

        if ("Android".equals(type)) {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName", pName);
            desiredCapabilities.setCapability("platformVersion", version);
            desiredCapabilities.setCapability("deviceName", dName);
            desiredCapabilities.setCapability("newCommandTimeout", "120");

            if (null == browser || "".equals(browser.trim())) {
                File appDir = new File(aPath);
                desiredCapabilities.setCapability("app", appDir.getAbsolutePath());
                desiredCapabilities.setCapability("appPackage", pkg);
                desiredCapabilities.setCapability("appActivity", activity);
            } else {
                desiredCapabilities.setCapability("browserName", browser);
            }

            driver = new AndroidDriver(new URL(address), desiredCapabilities);

            Thread.currentThread().sleep(10000);

        } else if ("IOS".equals(type)) {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName", pName);
            desiredCapabilities.setCapability("platformVersion", version);
            desiredCapabilities.setCapability("deviceName", dName);
            desiredCapabilities.setCapability("newCommandTimeout", "120");
            if (null != id) {
                desiredCapabilities.setCapability("udid", id);
            }
            if (null != bundle) {
                desiredCapabilities.setCapability("bundleId", bundle);
            }

            if (null == browser || "".equals(browser.trim())) {
                File appDir = new File(iPath);
                desiredCapabilities.setCapability("app", appDir.getAbsolutePath());
            } else {
                desiredCapabilities.setCapability("browserName", browser);

                Thread.currentThread().sleep(60000);
            }

            driver = new IOSDriver(new URL(address), desiredCapabilities);


        } else if ("Firefox".equals(type)) {
            if (!"default".equals(firefoxPath)) {
                System.setProperty("webdriver.firefox.bin", firefoxPath);
            }
           driver = new FirefoxDriver();

        } else if ("Chrome".equals(type)) {
            if ("Mac".equals(pName) || "iOS".equals(pName)) {
                System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
            } else {
                System.setProperty("webdriver.chrome.driver", "resources/chromedriver_for_win.exe");
            }

            if ("default".equals(chromePath)) {
                driver = new ChromeDriver();
            } else {
                Map<String, Object> chromeOptions = new HashMap<String, Object>();
                chromeOptions.put("binary", chromePath);
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                driver = new ChromeDriver(capabilities);
            }

        } else if ("IE".equals(type)) {
            if ("Win32".equals(pName)) {
                System.setProperty("webdriver.ie.driver", "resources/IEDriverServer.exe");
            } else if ("Win64".equals(pName)) {
                System.setProperty("webdriver.ie.driver", "resources/IEDriverServer_x64.exe");
            }

            DesiredCapabilities desiredCapabilities = DesiredCapabilities.internetExplorer();
            desiredCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            driver = new InternetExplorerDriver(desiredCapabilities);
        }

        selenium = new Selenium(driver);

        if (driver instanceof FirefoxDriver || driver instanceof ChromeDriver || driver instanceof InternetExplorerDriver) {
            selenium.open(url);
            driver.manage().window().maximize();
        }
        else if ("Safari".equals(browser) || "Chrome".equals(browser))
        {
            selenium.open(url);
        }
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

}
