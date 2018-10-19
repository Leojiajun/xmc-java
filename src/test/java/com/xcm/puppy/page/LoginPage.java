package com.xcm.puppy.page;

import com.xcm.puppy.util.PageLocator;
import com.xcm.puppy.util.Selenium;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


/**
 * 登录页
 */
public class LoginPage {

    public RemoteWebDriver driver;
    public Selenium selenium;

    private String logon_button;
    private String account_button;
    private String mobile_text;
    private String next_button;
    private String password_text;
    private String login_button;
    private String skip_button;
    private String balance_label;


    public LoginPage(RemoteWebDriver driver) {
        this.driver = driver;
        this.selenium = new Selenium(driver);

        if (driver instanceof AndroidDriver<?>) {
            this.logon_button = PageLocator.account_login_button_android;
            this.account_button = PageLocator.account_button_bottom_android;
            this.mobile_text = PageLocator.mobile_text_login_android;
            this.next_button = PageLocator.next_button_login_android;
            this.password_text = PageLocator.login_password_text_android;
            this.login_button = PageLocator.login_logon_button_android;
            this.skip_button = PageLocator.login_skip_button_android;
            this.balance_label = PageLocator.account_balance_label_android;

        } else {
            this.logon_button = PageLocator.account_login_button_ios;
            this.account_button = PageLocator.account_button_bottom_ios;
            this.mobile_text = PageLocator.mobile_text_login_ios;
            this.next_button = PageLocator.next_button_login_ios;
            this.password_text = PageLocator.login_password_text_ios;
            this.login_button = PageLocator.login_logon_button_ios;
            this.skip_button = PageLocator.login_skip_button_ios;
            this.balance_label = PageLocator.account_balance_label_ios;

        }
    }

    /**
     * 根据手机号和密码登录
     *
     * @param username 手机号
     * @param password 密码
     * @return
     */
    public String login(String username, String password) {
        selenium.tap(account_button);
        selenium.tap(logon_button);
        selenium.sendkeys(mobile_text, username);
        if (null == selenium.findElement(next_button)) {
            selenium.tap(100, 210);
        } else {
            selenium.tap(next_button);
        }
        selenium.sendkeys(password_text, password);
        selenium.tap(login_button);
        selenium.tap(skip_button);
        selenium.tap(account_button);
        return selenium.getText(balance_label);

    }


}
