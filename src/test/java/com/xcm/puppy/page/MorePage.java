package com.xcm.puppy.page;

import com.xcm.puppy.util.PageLocator;
import com.xcm.puppy.util.Selenium;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by guoxiaofeng on 16/7/19.
 * 更多
 */
public class MorePage {

    public RemoteWebDriver driver;
    public Selenium selenium;

    private String more_button;
    private String aboutus_button;
    private String aboutus_content;
    private String back_button;

    public MorePage(RemoteWebDriver driver) {
        this.driver = driver;
        this.selenium = new Selenium(driver);

        if (driver instanceof AndroidDriver) {
            this.more_button = PageLocator.more_button_android;
            this.aboutus_button = PageLocator.aboutus_button_android;
            this.aboutus_content = PageLocator.aboutus_content_android;
            this.back_button = PageLocator.back_button_android;
        } else {
            this.more_button = PageLocator.more_button_ios;
            this.aboutus_button = PageLocator.aboutus_button_ios;
            this.aboutus_content = PageLocator.aboutus_content_ios;
            this.back_button = PageLocator.back_button_ios;
        }
    }

    /**
     * 打开更多
     *
     * @return 返回关于我们按钮
     */
    public WebElement openMorePage() {
        selenium.tap(more_button);
        return selenium.findElement(aboutus_button);
    }

    /**
     * 打开关于我们
     *
     * @return 返回内容对象
     */
    public WebElement openAboutUs() {
        selenium.tap(aboutus_button);
        return selenium.findElement(aboutus_content);
    }

    /**
     * 返回 点击返回
     */
    public void getBack() {
        while (null != selenium.findElement(back_button)) {
            selenium.tap(back_button);
        }
    }
}
