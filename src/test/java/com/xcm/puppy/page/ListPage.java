package com.xcm.puppy.page;

import com.xcm.puppy.util.PageLocator;
import com.xcm.puppy.util.Selenium;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * 产品列表页
 */
public class ListPage {

    public RemoteWebDriver driver;
    public Selenium selenium;

    private String product_button;
    private String main_title_label;
    private String product_block;
    private String product_name_label;


    public String go_back;

    public ListPage(RemoteWebDriver driver) {
        this.driver = driver;
        this.selenium = new Selenium(driver);

        if (driver instanceof AndroidDriver<?>) {
            this.product_button = PageLocator.product_button_bottom_android;
            this.main_title_label = PageLocator.product_main_title_label_android;
            this.product_block = PageLocator.product_unit_block_android;
            this.product_name_label = PageLocator.product_name_label_android;
            this.go_back = PageLocator.back_button_android;

        } else {
            this.product_button = PageLocator.product_button_bottom_ios;
            this.main_title_label = PageLocator.product_main_title_label_ios;
            this.product_block = PageLocator.product_unit_block_ios;
            this.product_name_label = PageLocator.product_name_label_ios;
            this.go_back = PageLocator.go_button_ios;

        }
    }

    /**
     * 打开商品列表页
     *
     * @return 列表页的页头文字: 理财列表   --作为是否打开该页面的检查点
     */
    public String open() {
        selenium.tap(product_button);
        return selenium.getText(main_title_label);
    }

    /**
     * 打开商品列表页
     *
     * @return 列表页的产品块控件作为是否打开该页面的检查点
     */
    public WebElement openList(){
        selenium.tap(product_button);
        return selenium.findElement(product_block);
    }

    /**
     * 根据产品名称,打开商品详情页
     *
     * @param title 产品名称
     * @return 商品详情页
     */
    public ProductPage selectProduct(String title) {

        /**
         * 获取产品块
         */
        List<WebElement> elements = selenium.findElements(product_block);
        int count = elements.size();
        int limit = 1;

        /**
         * 遍历当前屏上的所有产品块
         * 若是找到指定产品名称的产品,则点击该产品; 若是第1页未找到指定的产品,则点击最后1个产品
         */
        for (WebElement element : elements) {
            /**
             * 获取产品名
             */
            limit++;
            WebElement product_name = selenium.findElement(element, product_name_label);
            if (title.equals(product_name.getText())) {
                selenium.click(product_name);
                break;
            }
            selenium.swipeUp(1000);
            if (limit == count - 3) {
                selenium.click(product_block);
                break;
            }
        }
        return new ProductPage(driver);
    }

    /**
     * 根据产品名称,打开商品详情页
     *
     * @return 商品详情页
     */
    public List<String> getProductName() {
        List<String> names = new ArrayList<String>();
        List<WebElement> elements = selenium.findElements(product_name_label);
        for (WebElement element : elements) {
            String name = selenium.getText(element);
            names.add(name);
        }
        return names;
    }

    /**
     * 打开商品列表第1个商品的商品详情页
     *
     * @return 商品详情页
     */
    public ProductPage selectProduct() {

        /**
         * 获取产品块
         */
        List<WebElement> elements = selenium.findElements(product_block);
        int count = elements.size();
        if (0 != count) {
            WebElement element = elements.get(0);
            selenium.click(element);
        }
        return new ProductPage(driver);
    }

    /**
     * 获取产品
     *
     * @return
     */
    public List<WebElement> getCurrentPageProducts() {
        return selenium.findElements(product_block);
    }


    public String clickProduct(WebElement element) {
        ProductPage productPage = new ProductPage(driver);
        selenium.click(element);
        return productPage.getDay();
    }

    public void goBack() {
        selenium.tap(go_back);
    }

    public void swipUp() {
        selenium.swipe(0.5, 0.3, 0.5, 0.1, 500);
    }

    public void nextShot() {
        selenium.swipe(0.5, 0.6, 0.5, 0.1, 1000);
    }


}
