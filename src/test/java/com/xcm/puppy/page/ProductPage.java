package com.xcm.puppy.page;

import com.xcm.puppy.util.PageLocator;
import com.xcm.puppy.util.Selenium;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * 产品详情页
 */
public class ProductPage {
    public RemoteWebDriver driver;
    public Selenium selenium;

    private String product_name;
    private String product_day;
    private String buy_button;
    private String investRec_button;
    private String projectInfo_button;
    private String safeProtect_button;
    private String productinfo_title;
    private String investCount_label;
    private String productInfo_content;
    private String minus_button;

    private String back_button;

    public ProductPage(RemoteWebDriver driver) {
        this.driver = driver;
        this.selenium = new Selenium(driver);

        if (driver instanceof AndroidDriver<?>) {
            product_name = PageLocator.product_title_label_android;
            product_day = PageLocator.product_day_label_android;
            buy_button = PageLocator.product_buy_button_android;
            investRec_button = PageLocator.invest_record_button_android;
            projectInfo_button = PageLocator.project_info_button_android;
            safeProtect_button = PageLocator.safe_protect_button_android;
            productinfo_title = PageLocator.product_info_title_android;
            back_button = PageLocator.back_button_android;
            investCount_label = PageLocator.product_info_invest_count_label_android;
            productInfo_content = PageLocator.product_info_content_android;
            minus_button = PageLocator.product_minus_button_android;

        } else {
            product_name = PageLocator.product_title_label_ios;
            product_day = PageLocator.product_day_label_ios;
            buy_button = PageLocator.product_buy_button_ios;
            investRec_button = PageLocator.invest_record_button_ios;
            projectInfo_button = PageLocator.project_info_button_ios;
            safeProtect_button = PageLocator.safe_protect_button_ios;
            productinfo_title = PageLocator.product_info_title_ios;
            back_button = PageLocator.back_button_ios;
            investCount_label = PageLocator.product_info_invest_count_label_ios;
            productInfo_content = PageLocator.product_info_content_ios;
            minus_button = PageLocator.product_minus_button_ios;

        }
    }

    /**
     * 获取商品详情页"期限"文本,作为是否打开产品详情页的一个检查点
     *
     * @return
     */
    public String getDay() {
        return selenium.getText(product_day);
    }

    public String getProductName() {
        return selenium.getText(product_name);
    }


    /**
     * 购买
     */
    public void buy() {
        selenium.tap(minus_button);
        selenium.tap(buy_button);
    }


    /**
     * 检查投资记录
     */
    public WebElement openInvestRec() {
        selenium.tap(investRec_button);
        WebElement element = selenium.findElement(investCount_label);
        String title = selenium.findElement(productinfo_title).getText();
        if (title.equals("投资记录") || title.equals("项目描述") || title.equals("安全保障")) {
            selenium.tap(back_button);
        }
        return element;
    }

    /**
     * 检查项目描述
     */
    public WebElement openProjectInfo() {
        selenium.tap(projectInfo_button);
        WebElement element = selenium.findElement(productInfo_content);
        String title = selenium.findElement(productinfo_title).getText();
        if (title.equals("投资记录") || title.equals("项目描述") || title.equals("安全保障")) {
            selenium.tap(back_button);
        }
        return element;
    }

    /**
     * 检查安全保障
     */
    public WebElement openSafeProtect() {
        selenium.tap(this.safeProtect_button);
        WebElement element = selenium.findElement(this.productInfo_content);
        String title = selenium.findElement(productinfo_title).getText();
        if (title.equals("投资记录") || title.equals("项目描述") || title.equals("安全保障")) {
            selenium.tap(back_button);
        }
        return element;
    }


}
