package com.xcm.puppy.page;

import com.xcm.puppy.util.PageLocator;
import com.xcm.puppy.util.Selenium;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * 确认购买页
 */
public class CheckoutPage {
    public RemoteWebDriver driver;
    public Selenium selenium;

    private String max_day;
    private String checkout_button;
    private String sina_pay;


    public CheckoutPage(RemoteWebDriver driver) {
        this.driver = driver;
        this.selenium = new Selenium(driver);

        if (driver instanceof AndroidDriver<?>) {
            max_day = PageLocator.purchase_day_label_android;
            checkout_button = PageLocator.purchase_checkout_button_android;
            sina_pay = PageLocator.purchase_sina_label_android;

        } else {
            max_day = PageLocator.purchase_day_label_ios;
            checkout_button = PageLocator.purchase_checkout_button_ios;
            sina_pay = PageLocator.purchase_sina_label_ios;

        }
    }

    /**
     * 获取期限
     *
     * @return
     */
    public String getDay() {
        return selenium.getText(max_day);
    }

    /**
     * 确认购买
     */
    public String buy() {
        selenium.tap(checkout_button);
        try {
            Thread.currentThread().sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return selenium.getText(sina_pay);

    }


}
