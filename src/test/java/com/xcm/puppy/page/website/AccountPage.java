package com.xcm.puppy.page.website;

import com.xcm.puppy.util.PageLocator;
import com.xcm.puppy.util.Selenium;
import com.xcm.puppy.util.StringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

/**
 * Created by jenkins on 16/8/16.
 */
public class AccountPage {

    private RemoteWebDriver driver;
    private Selenium selenium;

    private String account_menu;
    private String navigation_bar;
    private String content;



    public AccountPage(RemoteWebDriver driver) {
        this.driver = driver;
        this.selenium = new Selenium(driver);

        account_menu = PageLocator.account_home_button_website;
        navigation_bar = PageLocator.account_navigation_website;
        content = PageLocator.account_content_website;

    }

    /**
     *  打开我的账户首页
     */
    public void open()
    {
        selenium.click(account_menu);
    }

    /**
     * 获取用户中心菜单
     */
    public List<WebElement> getMenu() {
        return selenium.findElements(navigation_bar);
    }

    /**
     * 获取用户中心的页面内容
     * @return
     */
    public WebElement getContent(WebElement element)
    {
        selenium.click(element);
        return selenium.findElement(content);
    }







}
