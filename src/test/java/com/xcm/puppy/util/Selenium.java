package com.xcm.puppy.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Selenium {
    private static Logger logger = Logger.getLogger(Selenium.class);

    private WebDriver driver;
    private long timeOutInSeconds = 10;

    public Selenium(WebDriver driver) {
        this.driver = driver;
        this.timeOutInSeconds = GlobalSettings.timeOutInSeconds;
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    /**
     * 打开web网页
     *
     * @param url
     */
    public void open(final String url) {
        try {
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                public void run() {
                    driver.get(url);
                }
            }, 60000);
            driver.get(url);
            timer.cancel();
            logger.info("Opened the specified page " + url);
        } catch (Exception e) {
            e.printStackTrace();
            handleFailure("Failed to open the page " + url);
        }
        //driver.manage().window().maximize();
    }

    /**
     * 退出
     */
    public void quit() {
        try {
            driver.quit();
            logger.info("Quits this driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭窗口
     */
    public void close() {
        try {
            driver.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 原生selenium的鼠标点击
     *
     * @param locator
     */
    public void click(String locator) {
        WebElement element = findElement(locator);
        if (null != element) {
            try {
                element.click();
                logger.info("Clicked on the element " + locator);
            } catch (Exception e) {
                e.printStackTrace();
                handleFailure("Failed to click the web element " + locator);
            }
        }
    }

    /**
     * 通过js滚屏到位置
     */
    public void scrollTo(int x, int y) {
        String js = "window.scrollTo(" + x + "," + y + ")";
        try {
            ((JavascriptExecutor) driver).executeScript(js);
            logger.info("Scroll to the position (" + x + "," + y + ")");
        } catch (Exception e) {
            e.printStackTrace();
            handleFailure("Failed to scroll to the web element (" + x + "," + y + ")");
        }
    }

    /**
     * 通过js滚屏到元素
     */
    public void scrollTo(String locator) {
        WebElement element = findElement(locator);
        if (null != element) {
            try {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
                logger.info("Scroll to the element " + locator);
            } catch (Exception e) {
                e.printStackTrace();
                handleFailure("Failed to scroll to the web element " + locator);
            }
        }
    }

    /**
     * 通过js滚屏到元素
     */
    public void scrollTo(WebElement element) {
        if (null != element) {
            try {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
                logger.info("Scroll to the element ");
            } catch (Exception e) {
                e.printStackTrace();
                handleFailure("Failed to scroll to the web element ");
            }
        }
    }

    /**
     * 原生的Selenium移动
     *
     * @param element
     */
    public void moveToElement(WebElement element) {
        try {
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
            logger.info("Scroll to the element ");
        } catch (Exception e) {
            e.printStackTrace();
            handleFailure("Failed to scroll to the web element ");
        }
    }

    /**
     * 原生的Selenium移动
     *
     * @param locator
     */
    public void moveToElement(String locator) {
        WebElement element = findElement(locator);
        if (null != element) {
            try {
                Actions builder = new Actions(driver);
                builder.moveToElement(element).perform();
                logger.info("Scroll to the element " + locator);
            } catch (Exception e) {
                e.printStackTrace();
                handleFailure("Failed to scroll to the web element " + locator);
            }
        }
    }

    /**
     * 原生selenium的鼠标点击
     *
     * @param locator
     */
    public void tap(String locator) {
        WebElement element = findElement(locator);
        if (null != element) {
            try {
                ((MobileElement) element).tap(1, 100);
                logger.info("Clicked on the element " + locator);
            } catch (Exception e) {
                e.printStackTrace();
                handleFailure("Failed to click the web element " + locator);
            }
        }
    }

    /**
     * 在坐标(x,y)上点击
     *
     * @param x
     * @param y
     */
    public void tap(int x, int y) {
        AppiumDriver appiumDriver = (AppiumDriver) driver;
        try {
            appiumDriver.tap(1, x, y, 100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 调用js，鼠标点击操作
     *
     * @param
     */
    public void mouseClick(WebElement element) {
        Robot rb = null;
        try {
            rb = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        rb.mouseMove(0, 0);

        String code = "var fireOnThis = arguments[0];"
                + "var evObj = document.createEvent('MouseEvents');"
                + "evObj.initEvent('click',true,true);"
                + "fireOnThis.dispatchEvent(evObj);";
        if (null != element) {
            try {
                ((JavascriptExecutor) driver).executeScript(code, element);
                logger.info("Click on the page element ");
            } catch (Exception e) {
                e.printStackTrace();
                handleFailure("Failed to click the page element ");
            }
        }
    }

    /**
     * 调用js，鼠标点击操作
     *
     * @param locator
     */
    public void mouseClick(String locator) {
        Robot rb = null;
        try {
            rb = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        rb.mouseMove(0, 0);

        WebElement element = findElement(locator);
        String code = "var fireOnThis = arguments[0];"
                + "var evObj = document.createEvent('MouseEvents');"
                + "evObj.initEvent('click',true,true);"
                + "fireOnThis.dispatchEvent(evObj);";
        if (null != element) {
            try {
                ((JavascriptExecutor) driver).executeScript(code, element);
                logger.info("Click on the page element " + locator);
            } catch (Exception e) {
                e.printStackTrace();
                handleFailure("Failed to click the page element " + locator);
            }
        }
    }

    /**
     * 从下向上滑动屏幕
     */
    public void swipeUp(int duration) {
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();

        AppiumDriver appiumDriver = (AppiumDriver) driver;
        appiumDriver.swipe(width / 2, height / 2, width / 2, height / 2 - height * 3 / 10, duration);

    }

    /**
     * 从下向上滑动屏幕
     */
    public void swipe(double startX, double startY, double endX, double endY, int duration) {
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();

        AppiumDriver appiumDriver = (AppiumDriver) driver;
        appiumDriver.swipe((int) (width * startX), (int) (height * startY), (int) (width * startX) - (int) (width * endX), (int) (height * startY) - (int) (height * endY), duration);

    }

    public void moveTo(WebElement element) {
        AppiumDriver appiumDriver = (AppiumDriver) driver;
        TouchAction builder = new TouchAction(appiumDriver);
        builder.moveTo(element).waitAction(300).perform();
    }


    /**
     * 向左滑动屏幕
     */
    public void swipeToLeft(int duration) {
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();

        int startX = width * 9 / 10;
        int startY = height / 2;
        int endX = width / 10;

        AppiumDriver appiumDriver = (AppiumDriver) driver;
        try {
            appiumDriver.swipe(startX, startY, endX-startX, startY, duration);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 在文本输入框中输入内容
     *
     * @param locator
     * @param text
     */
    public void sendkeys(String locator, String text) {
        WebElement element = findElement(locator);
        if (null != element) {
            try {
                element.clear();
                element.sendKeys(text);
                logger.info("Type " + text + " in the page element " + locator);
            } catch (Exception e) {
                e.printStackTrace();
                handleFailure("Failed to type " + text
                        + " in the page element " + locator);
            }
        }
    }

    /**
     * 通过条用js，使光标悬浮在某个元素上方
     *
     * @param locator
     */
    public void mouseOver(String locator) {
        Robot rb = null;
        try {
            rb = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        rb.mouseMove(0, 0);

        WebElement element = findElement(locator);
        String code = "var fireOnThis = arguments[0];"
                + "var evObj = document.createEvent('MouseEvents');"
                + "evObj.initEvent('mouseover',true,true);"
                + "fireOnThis.dispatchEvent(evObj);";
        if (null != element) {
            try {
                ((JavascriptExecutor) driver).executeScript(code, element);
                logger.info("Mouse over the page element " + locator);
            } catch (Exception e) {
                e.printStackTrace();
                handleFailure("Failed to mouseover the page element " + locator);
            }
        }
    }

    /**
     * 根据元素路径，获取元素的文本内容
     *
     * @param locator 元素路径
     * @return 文本内容
     */
    public String getText(String locator) {
        String text = "";
        WebElement element = findElement(locator);
        if (null != element) {
            try {
                text = element.getText();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return text;
    }

    /**
     * 获取元素属性值
     */
    public String getAttribute(WebElement element, String attribute) {
        String text = null;
        try {
            text = element.getAttribute(attribute);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return text;
    }

    /**
     * 根据元素路径，获取元素的文本内容
     *
     * @param
     * @return 文本内容
     */
    public String getAttribute(String locator, String attribute) {
        String text = null;
        WebElement element = findElement(locator);
        if (null != element) {
            try {
                text = element.getAttribute(attribute);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return text;
    }

    /**
     * 根据元素路径，获取元素的文本内容
     *
     * @param
     * @return 文本内容
     */
    public String getText(WebElement element) {
        String text = "";
        try {
            text = element.getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }

    /**
     * Select选择值
     *
     * @param selectLocator
     * @param option
     */
    public void select(String selectLocator, String option) {
        WebElement element = findElement(selectLocator);
        if (null != element) {
            Select select = new Select(element);
            try {
                select.selectByVisibleText(option);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 根据页面源码内容跳转到相应的窗口
     *
     * @param pageMsg 源码内容
     */
    public void selectWindow(String pageMsg) {
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            if (driver.getPageSource().contains(pageMsg)) {
                logger.info("Switched to window " + pageMsg);
                break;
            }
        }
    }

    /**
     * 切换到另一窗口
     */
    public void switchToAnotherWindow() {
        String current = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        windowHandles.remove(current);
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            break;
        }
    }

    /**
     * 切换到Frame
     */
    public void accessFrame(String nameOrId) {
        driver.switchTo().frame(nameOrId);
        logger.info("Entered iframe " + nameOrId);
    }

    /**
     * 截图
     */
    public String takesScreenshot() {
        String dir = "screenshot";
        String time = new SimpleDateFormat("yyyyMMdd-HHmmss")
                .format(new Date());
        String screenshotPath = dir + File.separator + time + ".png";

        driver = new Augmenter().augment(driver);
        File srcFile = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File(screenshotPath));
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to take screenshot";
        }
        return screenshotPath.replace("\\", "/");
    }

    /**
     * 根据元素路径，返回WebElement组件
     *
     * @param locator 元素路径
     * @return WebElement
     */
    public WebElement findElement(String locator) {
        By by = parseLocator(locator);
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
            element = wait.until(ExpectedConditions
                    .presenceOfElementLocated(by));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Can't locate the web element by the locator "
                    + locator);
        }
        return element;
    }

    /**
     * 根据元素路径，返回WebElement组件
     *
     * @param locator 元素路径
     * @return WebElement
     */
    public WebElement findElement(WebElement subElement, String locator) {
        By by = parseLocator(locator);
        WebElement element = null;
        if (null == subElement) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
                element = wait.until(ExpectedConditions
                        .presenceOfElementLocated(by));
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("Can't locate the web element by the locator "
                        + locator);
            }
        } else {
            try {
                element = subElement.findElement(by);
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("Can't locate the web element by the locator "
                        + locator);
            }
        }
        return element;
    }

    /**
     * 根据元素路径，返回WebElement组件
     *
     * @param locator 元素路径
     * @return WebElement
     */
    public WebElement findElement(String subLocator, String locator) {
        By by1 = parseLocator(subLocator);
        By by2 = parseLocator(locator);
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
            WebElement subElement = wait.until(ExpectedConditions
                    .presenceOfElementLocated(by1));
            element = subElement.findElement(by2);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Can't locate the web element by the locator "
                    + locator);
        }

        return element;
    }

    /**
     * 根据元素路径，返回WebElement组件
     *
     * @param locator 元素路径
     * @return WebElement
     */
    public List<WebElement> findElements(String locator) {
        By by = parseLocator(locator);
        List<WebElement> elements = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
            elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Can't locate the web element by the locator "
                    + locator);
        }
        return elements;
    }

    /**
     * 原生selenium的鼠标点击
     *
     * @param element
     */
    public void click(WebElement element) {
        if (null != element) {
            try {
                element.click();
                logger.info("Clicked on the element ");
            } catch (Exception e) {
                e.printStackTrace();
                handleFailure("Failed to click the web element ");
            }
        }
    }

    /**
     * 取消alert
     */
    public void dismiss() {
        try {
            driver.switchTo().alert().dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 确认alert
     */
    public void accept() {
        try {
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 处理错误，截图并且打印日志
     *
     * @param msg 错误内容
     */
    public void handleFailure(String msg) {
        boolean takingScreenshots = GlobalSettings.takingScreenshots;
        if (takingScreenshots) {
            String basePath = System.getProperty("user.dir") + "/";
            String pngPath = takesScreenshot();
            Reporter.log("<a target=\"_blank\" href=\"" + basePath + pngPath
                    + "\" >" + msg + "</a>");
            msg = msg + " >> capture screenshot at " + pngPath;
        }
        logger.error(msg);
    }

    /**
     * 路径解析器
     *
     * @param locator 元素路径
     * @return By
     */
    private By parseLocator(String locator) {
        String lowerLocator = locator.toLowerCase();
        String actualLocator;
        By by = null;
        if (lowerLocator.startsWith("id=")) {
            actualLocator = locator.substring(3);
            by = By.id(actualLocator);
        } else if (lowerLocator.startsWith("name=")) {
            actualLocator = locator.substring(5);
            by = By.name(actualLocator);
        } else if (lowerLocator.startsWith("class=")) {
            actualLocator = locator.substring(6);
            by = By.className(actualLocator);
        } else if (lowerLocator.startsWith("tag=")) {
            actualLocator = locator.substring(4);
            by = By.tagName(actualLocator);
        } else if (lowerLocator.startsWith("link=")) {
            actualLocator = locator.substring(5);
            by = By.partialLinkText(actualLocator);
        } else if (lowerLocator.startsWith("css=")) {
            actualLocator = locator.substring(4);
            by = By.cssSelector(actualLocator);
        } else if (lowerLocator.startsWith("xpath=")) {
            actualLocator = locator.substring(6);
            by = By.xpath(actualLocator);
        } else {
            logger.error("Format Error: id=,class=,tag=,name=,link=,css=,xpath=");
        }
        return by;
    }

}
