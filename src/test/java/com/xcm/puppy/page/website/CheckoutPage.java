package com.xcm.puppy.page.website;

import com.xcm.puppy.util.PageLocator;
import com.xcm.puppy.util.Selenium;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by jenkins on 24/8/16.
 */
public class CheckoutPage {

    private RemoteWebDriver driver;
    private Selenium selenium;

    private String recharge_button;
    private String buy_button;
    private String sina_link;

    public CheckoutPage(RemoteWebDriver driver) {
        this.driver = driver;
        this.selenium = new Selenium(driver);

        recharge_button = PageLocator.purchase_recharge_button_website;
        buy_button = PageLocator.purchase_buy_button_website;
        sina_link = PageLocator.purchase_sina_label_website;

    }

    /**
     * 点击"立即购买"或者"立即充值"
     */
    public String submitOrd() {
        selenium.selectWindow("账户余额");
        if(null != selenium.findElement(recharge_button))
        {
            selenium.click(recharge_button);
        } else {
            selenium.click(buy_button);
        }

        selenium.selectWindow("微博客服电话");
        return selenium.getText(sina_link);
    }
}
