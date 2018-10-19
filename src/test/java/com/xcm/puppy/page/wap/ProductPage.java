package com.xcm.puppy.page.wap;

import com.xcm.puppy.util.PageLocator;
import com.xcm.puppy.util.Selenium;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

/**
 * Created by jenkins on 9/1/17.
 */
public class ProductPage {

    private RemoteWebDriver driver = Homepage.driver;
    private Selenium selenium = Homepage.selenium;

    private String productBox = PageLocator.product_unit_block_wap;
    private String buyBtn = PageLocator.product_buy_button_wap;
    private String backBtn = PageLocator.back_button_wap;
    private String productDesc = PageLocator.product_detail_description_wap;

    /**
     * 获取产品列表
     * @return
     */
    public List<WebElement> getProductBox()
    {
        return selenium.findElements(productBox);
    }

    /**
     * 打开产品详情
     */
    public void openFirstProduct()
    {
        selenium.click(productBox);
    }

    /**
     * 获取产品描述信息
     * @return
     */
    public String getDescription()
    {
        return selenium.getText(productDesc);
    }

    /**
     * 点击"立即抢购"按钮
     */
    public void buy()
    {
        selenium.click(buyBtn);
    }

    /**
     * 点击"导航菜单"
     * @param menu
     * @param content
     * @return
     */
    public WebElement openItem(String menu, String content)
    {
        selenium.click(menu);
        WebElement element = selenium.findElement(content);
        back();
        return element;
    }

    /**
     * 后退
     */
    public void back()
    {
        selenium.click(backBtn);

    }







}
