package com.xcm.puppy.page.wap;

import com.xcm.puppy.util.PageLocator;
import com.xcm.puppy.util.Selenium;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

/**
 * Created by jenkins on 9/1/17.
 */
public class Homepage {

    private String productName = PageLocator.home_product_name_wap;
    private String productBtn = PageLocator.product_button_bottom_wap;
    private String accountBtn = PageLocator.account_button_bottom_wap;
    private String productBox = PageLocator.home_product_box_wap;
    private String productDesc = PageLocator.product_detail_description_wap;


    public static RemoteWebDriver driver;
    public static Selenium selenium;

    public Homepage(RemoteWebDriver driver)
    {
        this.driver = driver;
        this.selenium = new Selenium(driver);
    }

    /**
     * 获取精选页的产品名称
     * @return
     */
    public String getProductName()
    {
        return selenium.getText(productName);
    }

    /**
     * 点击"理财",打开理财列表页
     */
    public void openProduct()
    {
        selenium.click(productBtn);
    }

    /**
     * 点击"账户",打开账户中心页
     */
    public void openAccount()
    {
        selenium.click(accountBtn);
    }

    /**
     * 点击"导航菜单"
     * @param menu
     * @param content
     * @return
     */
    public WebElement openMenu(String menu, String content)
    {
        selenium.click(menu);
        WebElement element = selenium.findElement(content);
        back();
        return element;
    }

    /**
     * 打开推荐标的详情页
     * @return
     */
    public String openRecommendation()
    {
        selenium.click(productBox);
        String description = selenium.getText(productDesc);
        return description;
    }

    /**
     * 回退
     */
    public void back()
    {
        driver.navigate().back();
    }





}
