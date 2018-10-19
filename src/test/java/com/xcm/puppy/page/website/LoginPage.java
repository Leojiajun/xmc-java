package com.xcm.puppy.page.website;

import com.xcm.puppy.util.PageLocator;
import com.xcm.puppy.util.Selenium;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by jenkins on 16/8/16.
 */
public class LoginPage {
    public RemoteWebDriver driver;
    public Selenium selenium;

    private String username_text;
    private String password_text;
    private String login_button;
    private String logout_button;
    private String prompt_msg;

    public LoginPage(RemoteWebDriver driver) {
        this.driver = driver;
        this.selenium = new Selenium(driver);

        username_text = PageLocator.login_username_text_website;
        password_text = PageLocator.login_password_text_website;
        login_button = PageLocator.login_login_button_website;
        logout_button = PageLocator.login_logout_button_website;
        prompt_msg = PageLocator.login_prompt_msg_website;

    }

    /**
     * 根据手机号和密码登录
     *
     * @param username 手机号
     * @param password 密码
     * @return "登录"或者 "登录错误信息"
     */
    public String login(String username, String password) {
        String msg = null;
        selenium.sendkeys(username_text, username);
        selenium.sendkeys(password_text, password);
        selenium.click(login_button);
        msg = selenium.getText(logout_button);
        if (null == msg || "".equals(msg))
        {
            msg = selenium.getText(prompt_msg);
        }
        return  msg;
    }

}
