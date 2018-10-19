package com.xcm.puppy.page.website;

import com.xcm.puppy.util.PageLocator;
import com.xcm.puppy.util.Selenium;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jenkins on 16/8/16.
 */
public class ListPage {

    private RemoteWebDriver driver;
    private Selenium selenium;

    private String product_list;
    private String buy_button;
    private String product_name;
    private String next_page;
    private String progress_bar;
    private String rule_text;
    private String dead_line;
    private String order_by_deadline;
    private String rate;
    private String status;


    public ListPage(RemoteWebDriver driver) {
        this.driver = driver;
        this.selenium = new Selenium(driver);

        product_list = PageLocator.product_page_list_website;
        buy_button = PageLocator.product_buy2_button_website;
        product_name = PageLocator.product_name_label_website;
        next_page = PageLocator.product_next_page_website;
        progress_bar = PageLocator.product_progress_bar_website;
        rule_text = PageLocator.product_detail_rule_label_website;
        dead_line = PageLocator.product_deadline_website;
        order_by_deadline = PageLocator.product_order_by_deadline_website;
        rate = PageLocator.product_rate_website;
        status = PageLocator.product_process_website;

    }

    /**
     * 过滤
     * @param filter
     * @return
     */
    public String search(String filter)
    {
        String attribute = selenium.getAttribute(filter, "onclick");
        selenium.click(filter);
        return attribute;
    }

    /**
     * 获取"期限"
     * @return
     */
    public List<String> getDeadline()
    {
        List<String> deadlines = new ArrayList<String>();
        List<WebElement> elements = selenium.findElements(dead_line);
        for(WebElement element : elements)
        {
            deadlines.add(selenium.getText(element));
        }
        return deadlines;
    }

    /**
     * 获取"收益"
     * @return
     */
    public List<String> getRate()
    {
        List<String> deadlines = new ArrayList<String>();
        List<WebElement> elements = selenium.findElements(rate);
        for(WebElement element : elements)
        {
            deadlines.add(selenium.getText(element));
        }
        return deadlines;
    }

    /**
     * 获取"投资进度"
     * @return
     */
    public List<String> getStatus()
    {
        List<String> deadlines = new ArrayList<String>();
        List<WebElement> elements = selenium.findElements(status);
        for(WebElement element : elements)
        {
            deadlines.add(selenium.getText(element));
        }
        return deadlines;
    }


    /**
     * 排序
     */
    public void sort(String sorter)
    {
        selenium.click(sorter);
    }

    /**
     * 根据"产品名称",打开产品详情页。
     *
     * @return
     */
    public String chooseProduct(String name) {
        do {
            List<WebElement> products = selenium.findElements(product_name);
            for (WebElement product : products) {
                WebElement productName = selenium.findElement(product, "tag=a");
                String bidTitle = selenium.getText(productName);
                if (bidTitle.equals(name)) {
                    selenium.click(productName);
                    break;
                }
            }
            selenium.click(next_page);
        } while (null != selenium.findElement(next_page));

        return selenium.getText(rule_text);
    }

    /**
     * 选择第1个可购买的产品
     */
    public String chooseFirstProduct() {
        selenium.click(buy_button);
        return selenium.getText(rule_text);
    }


}
