package com.xcm.puppy.page.wap;

import com.xcm.puppy.util.PageLocator;
import com.xcm.puppy.util.Selenium;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by jenkins on 11/1/17.
 */
public class CheckoutPage {
    private RemoteWebDriver driver = Homepage.driver;
    private Selenium selenium = Homepage.selenium;

    private String checkoutBtn = PageLocator.purchase_checkout_button_wap;
    private String sinaTxt = PageLocator.purchase_sina_label_wap;

    /**
     * 点击"还需充值xxx"按钮
     */
    public WebElement checkout()
    {
        selenium.click(checkoutBtn);
        return selenium.findElement(sinaTxt);

    }

}
