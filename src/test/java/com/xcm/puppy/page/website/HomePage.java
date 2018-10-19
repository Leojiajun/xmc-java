package com.xcm.puppy.page.website;

import com.xcm.puppy.util.PageLocator;
import com.xcm.puppy.util.Selenium;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

/**
 * Created by jenkins on 16/8/16.
 */
public class HomePage {

    private RemoteWebDriver driver;
    private Selenium selenium;

    private String home_menu;
    private String logo;
    private String product_menu;
    private String banner_block;
    private String buy_button;
    private String login_link;
    private String password_tab;
    private String product_block;
    private String product_big;
    private String product_name;
    private String article_link;
    private String article_content;
    private String home_product;

    public HomePage(RemoteWebDriver driver)
    {
        this.driver = driver;
        this.selenium = new Selenium(driver);

        home_menu = PageLocator.home_home_menu_website;
        product_menu = PageLocator.home_product_menu_website;
        banner_block = PageLocator.home_banner_website;
        buy_button = PageLocator.product_buy_button_website;
        login_link = PageLocator.home_login_link_website;
        password_tab = PageLocator.login_password_tab_website;
        logo = PageLocator.home_logo_website;
        home_product = PageLocator.home_product_block_website;
        product_block = PageLocator.product_block_website;
        product_name = PageLocator.home_product_name_website;
        article_link = PageLocator.home_article_link_website;
        article_content = PageLocator.help_notice_website;
        product_big = PageLocator.home_product_big_website;
    }

    /**
     * 点击"首页"菜单
     * @return Banner
     */
    public WebElement open()
    {
        selenium.click(home_menu);
        return selenium.findElement(banner_block);
    }

    /**
     * 点击"logo"
     */
    public void backHome()
    {
        String locator = logo;
        WebElement element = selenium.findElement(locator);
        if(null == element)
            locator = PageLocator.home_logo2_website;
        selenium.click(locator);
    }

    /**
     * 点击所有的, 且不在新窗口打开的link.
     * @param link
     * @param checkPoint
     * @return
     */
    public WebElement openLink(String link, String checkPoint)
    {
        selenium.scrollTo(link);
        selenium.click(link);
        WebElement element = selenium.findElement(checkPoint);
        return element;
    }

    /**
     * 获取所有的文章链接
     * @return
     */
    public List<WebElement> getArticles()
    {
        return selenium.findElements(article_link);
    }

    /**
     *
     * @return
     */
    public WebElement getArticleContent()
    {
        WebElement element = selenium.findElement(article_content);
        return element;
    }

    /**
     * 点击所有的, 且在新窗口打开的link.
     * @param link
     * @param checkPoint
     * @return
     */
    public WebElement openAnotherPage(String link, String checkPoint)
    {
        String handle = driver.getWindowHandle();
        selenium.scrollTo(link);
        selenium.click(link);
        selenium.switchToAnotherWindow();
        WebElement element = selenium.findElement(checkPoint);
        selenium.close();
        driver.switchTo().window(handle);
        return element;
    }

    /**
     * 获取首页上的产品列表
     * @return
     */
    public List<WebElement> getProductList()
    {
        List<WebElement> elements = selenium.findElements(home_product);
        return elements;
    }

    /**
     * 获取首页上的产品列表
     * @return
     */
    public List<WebElement> getBigProductList()
    {
        List<WebElement> elements = selenium.findElements(product_big);
        return elements;
    }

    /**
     * 获取产品名称
     * @param element
     * @return
     */
    public String getPrdName(WebElement element)
    {
        String txt = null;
        WebElement we = selenium.findElement(element, PageLocator.home_product_name2_website);
        if(null != we)
        {
            txt = we.getText();
        }
        return txt;
    }

    /**
     * 获取产品名称
     * @param element
     * @return
     */
    public String getProductName(WebElement element)
    {
        String txt = null;
        WebElement we = selenium.findElement(element, product_name);
        if(null != we)
        {
            txt = we.getText();
        }
        return txt;
    }

    /**
     * 点击"我要理财"菜单
     * @return 产品列表页文字: 转入体验金
     */
    public WebElement openListPage()
    {
        selenium.click(product_menu);
        return selenium.findElement(product_block);

    }

    /**
     * 点击"登录"链接,打开登录页
     * @return 登录页的"密码登录"文字
     */
    public String openLoginPage()
    {
        selenium.click(login_link);
        return selenium.getText(password_tab);

    }
}
