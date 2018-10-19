package com.xcm.puppy.page.wap;

import com.xcm.puppy.util.PageLocator;
import com.xcm.puppy.util.Selenium;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by jenkins on 9/1/17.
 */
public class LoginPage {

    private RemoteWebDriver driver = Homepage.driver;
    private Selenium selenium = Homepage.selenium;

    private String mobile = PageLocator.mobile_text_login_wap;
    private String nextBtn = PageLocator.next_button_login_wap;
    private String password = PageLocator.login_password_text_wap;
    private String loginBtn = PageLocator.login_logon_button_wap;
    private String totalAmount = PageLocator.account_balance_label_wap;

    /**
     * 登录
     * @param phone
     * @param pwd
     */
    public String login(String phone, String pwd)
    {
        selenium.sendkeys(mobile, phone);
        selenium.click(nextBtn);
        selenium.sendkeys(password, pwd);
        selenium.click(loginBtn);

        return  selenium.getText(totalAmount);

    }






}
