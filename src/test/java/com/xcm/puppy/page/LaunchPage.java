package com.xcm.puppy.page;

import com.xcm.puppy.util.PageLocator;
import com.xcm.puppy.util.Selenium;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


/**
 * 产品列表页
 */
public class LaunchPage {

    public RemoteWebDriver driver;
    public Selenium selenium;

    private String cancel_button;
    private String go_button;
    private String activity_button;
    private String close_button;

    public LaunchPage(RemoteWebDriver driver) {
        this.driver = driver;
        this.selenium = new Selenium(driver);

        if (driver instanceof AndroidDriver<?>) {
            this.go_button = PageLocator.go_button_android;
            this.cancel_button = PageLocator.cancel_button_android;
            this.activity_button = PageLocator.activity_button_android;
            close_button = PageLocator.close_version_button_android;

        } else {
            this.go_button = PageLocator.go_button_ios;
            this.cancel_button = PageLocator.cancel_button_ios;
            this.activity_button = PageLocator.activity_button_android;
            close_button = PageLocator.close_version_button_ios;

        }
    }


    /**
     * 进入小财迷main page
     */
    public void load() {
        selenium.swipeToLeft(1000);
        selenium.swipeToLeft(1000);
        selenium.tap(go_button);

        selenium.tap(close_button);
        selenium.tap(cancel_button);
        selenium.dismiss();
        selenium.tap(activity_button);



        /*
        int index = cancel_button.indexOf(",");
        int x = Integer.parseInt(cancel_button.substring(0, index));
        int y = Integer.parseInt(cancel_button.substring(index + 1));
        selenium.tap(x, y);
        */

    }


}
