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
public class ProductPage {

    private RemoteWebDriver driver;
    private Selenium selenium;

    private String rule_text;
    private String availability_text;
    private String amount_input;
    private String buy_button;
    private String expected_bonus;
    private String product_name, product_list_name;
    private String sesame_block;
    private String sesame_amount;
    private String product_block;
    private String next_page;
    private String info_tab;
    private String order_tab;
    private String info_title;
    private String table_title;


    public ProductPage(RemoteWebDriver driver) {
        this.driver = driver;
        this.selenium = new Selenium(driver);

        rule_text = PageLocator.product_detail_rule_label_website;
        availability_text = PageLocator.product_detail_available_amount_website;
        amount_input = PageLocator.product_detail_amount_text_website;
        buy_button = PageLocator.product_detail_buy_button_website;
        expected_bonus = PageLocator.purchase_expected_label_website;
        product_name = PageLocator.product_detail_name_website;
        sesame_block = PageLocator.product_sesame_website;
        sesame_amount = PageLocator.product_detail_sesame_website;
        product_block = PageLocator.product_block_website;
        product_list_name = PageLocator.product_list_name_website;
        next_page = PageLocator.product_next_page_website;
        info_tab = PageLocator.product_detail_tab1_menu_website;
        order_tab = PageLocator.product_detail_tab3_menu_website;
        info_title = PageLocator.product_detail_info_title_website;
        table_title = PageLocator.product_detail_order_title_website;

    }

    /**
     * 获取产品详情页产品名称
     *
     * @return
     */
    public String getProduct_name() {
        return selenium.getText(product_name);
    }

    /**
     * 获取产品列表
     *
     * @return
     */
    public List<WebElement> getProductList() {
        List<WebElement> elements = selenium.findElements(product_block);
        return elements;
    }

    /**
     * 获取列表页上产品名称
     *
     * @param element
     * @return
     */
    public String getProductName(WebElement element) {
        String txt = null;
        WebElement we = selenium.findElement(element, product_list_name);
        if (null != we) {
            txt = selenium.getText(we);
        }
        return txt;
    }

    /**
     * 获取列表页产品
     *
     * @param element
     * @return
     */
    public WebElement getProduct(WebElement element) {
        return selenium.findElement(element, product_list_name);

    }

    /**
     * 打开芝麻开门页
     *
     * @return
     */
    public WebElement openSesame() {
        selenium.click(sesame_block);
        return selenium.findElement(sesame_amount);
    }

    /**
     * 查找是否存在"下一页"
     * @return
     */
    public boolean findNextPage()
    {
        if (null != selenium.findElement(next_page)) {
            return true;
        }
        return false;

    }
    /**
     * 点击"下一页"
     */
    public void nextPage() {
        if (null != selenium.findElement(next_page)) {
            selenium.scrollTo(next_page);
            selenium.click(next_page);
        }
    }

    /**
     * 打开第xx页
     * @param pageNo
     */
    public void openPage(int pageNo)
    {
        for(int i=1; i<pageNo; i++)
        {
            nextPage();
        }
    }

    /**
     * 点击"项目详情"选项卡
     * @return
     */
    public int openInfo()
    {
        selenium.scrollTo(info_tab);
        selenium.click(info_tab);
        List<WebElement> elements = selenium.findElements(info_title);
        return elements.size();
    }

    /**
     * 点击"投资记录"选项卡
     * @return
     */
    public int openOrderRecord()
    {
        selenium.scrollTo(order_tab);
        selenium.click(order_tab);
        List<WebElement> elements = selenium.findElements(table_title);
        return elements.size();
    }


    /**
     * 购买
     */
    public String buy() {
        String rule = selenium.getText(rule_text);
        String availability = selenium.getText(availability_text);
        if (!"".equals(rule) && !"".equals(availability)) {
            double min_amount = Double.parseDouble(StringUtils.substring(rule, "购买规则：", "元起投"));
            String availability_amount = StringUtils.substring(availability, "", "元");
            if (availability_amount.contains(",")) {
                availability_amount = availability_amount.replace(",", "");
            }
            double remains = Double.parseDouble(availability_amount);
            double amount = (remains > min_amount ? min_amount : remains);
            selenium.sendkeys(amount_input, amount + "");

            selenium.click(buy_button);
        }
        selenium.selectWindow("账户余额");
        return selenium.getText(expected_bonus);
    }




}
