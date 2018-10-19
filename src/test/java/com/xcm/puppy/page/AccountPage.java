package com.xcm.puppy.page;

import com.xcm.puppy.util.PageLocator;
import com.xcm.puppy.util.Selenium;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

/**
 * Created by jenkins on 26/7/16.
 */
public class AccountPage {
    public RemoteWebDriver driver;
    public Selenium selenium;

    private String favicon;
    private String logout_button;
    private String back_button, back2_button, back3_button;
    private String table_cell;
    private String table_content1;
    private String table_content2;
    private String table_content3;

    private String available_balance_menu, available_balance, charge_menu, money_input, money_label,
            money_submit, sina_pay, cash_menu, fee_link, fee_content, cash_record_menu,
            cash_record_item, experience_gold_menu, experience_gold_record, experience_product_menu,
            experience_product_price, shipping_address, shipping_content;



    public AccountPage(RemoteWebDriver driver) {
        this.driver = driver;
        this.selenium = new Selenium(driver);

        if (driver instanceof AndroidDriver<?>) {
            favicon = PageLocator.account_favicon_android;
            logout_button = PageLocator.account_logout_button_android;
            back_button = PageLocator.back_button_android;
            back2_button = PageLocator.back_button_android;
            table_cell = PageLocator.account_table_cell_android;
            table_content1 = PageLocator.account_table_content1_android;
            table_content2 = PageLocator.account_table_content2_android;
            table_content3 = PageLocator.account_table_content2_android;



        } else {
            favicon = PageLocator.account_favicon_ios;
            logout_button = PageLocator.account_logout_button_ios;
            back_button = PageLocator.back_button_ios;
            back2_button = PageLocator.back2_button_ios;
            table_cell = PageLocator.account_table_cell_ios;
            table_content1 = PageLocator.account_table_content1_ios;
            table_content2 = PageLocator.account_table_content2_ios;
            table_content3 = PageLocator.account_table_content3_ios;

            available_balance_menu = PageLocator.account_available_balance_menu_ios;
            available_balance = PageLocator.account_available_balance_ios;
            charge_menu = PageLocator.account_charge_menu_ios;
            money_input = PageLocator.account_money_input_ios;
            money_submit = PageLocator.account_money_submit_ios;
            money_label = PageLocator.account_money_limit_ios;
            sina_pay = PageLocator.purchase_sina_label_ios;
            back3_button = PageLocator.back3_button_ios;
            cash_menu = PageLocator.account_cash_menu_ios;
            fee_link = PageLocator.account_fee_link_ios;
            fee_content = PageLocator.account_fee_content_ios;
            cash_record_menu = PageLocator.account_cash_record_menu_ios;
            cash_record_item = PageLocator.account_cash_record_ios;
            experience_gold_menu = PageLocator.account_experience_gold_menu_ios;
            experience_gold_record = PageLocator.account_gold_record_ios;
            experience_product_menu = PageLocator.account_gold_product_menu_ios;
            experience_product_price = PageLocator.account_gold_product_content_ios;
            shipping_address = PageLocator.account_shipping_address_menu_ios;
            shipping_content = PageLocator.account_shipping_address_content_ios;

        }
    }
    /**
     * 打开资金记录页
     * @return
     */
    public WebElement openCashRecordPage()
    {
        selenium.click(cash_record_menu);
        return selenium.findElement(cash_record_item);
    }

    /**
     * 充值页"输入充值金额",点击"下一步",打开新浪页面
     * @param money
     * @return
     */
    public String recharge(String money)
    {
        selenium.sendkeys(money_input, money);
        selenium.click(money_label);
        selenium.click(money_submit);
        try {
            Thread.currentThread().sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return selenium.getText(sina_pay);

    }

    /**
     * 在"提现"页面,点击"如何免费提现?"
     * @return
     */
    public String openFeePage()
    {
        selenium.click(fee_link);
        return selenium.getText(fee_content);
    }

    /**
     * 在可用余额页面,点击"提现"菜单,打开提现页面
     * @return
     */
    public WebElement openCashPage()
    {
        selenium.click(cash_menu);
        return selenium.findElement(money_input);
    }

    /**
     * 在可用余额页面,点击"充值"菜单,打开充值页面
     * @return
     */
    public WebElement openChargePage()
    {
        selenium.click(charge_menu);
        return selenium.findElement(money_input);
    }


    /**
     * 点击"可用余额"菜单,打开可用余额页
     * @return
     */
    public WebElement openBalancePage()
    {
        selenium.click(available_balance_menu);
        return selenium.findElement(charge_menu);
    }

    /**
     * 返回到账户首页
     */
    public void backToHome()
    {
        while (! getFavicon())
        {
            goBack();
        }
    }

    /**
     * 验证页面中是否有"头像"元素
     * @return
     */
    public boolean getFavicon()
    {
        boolean b = false;
        WebElement element = selenium.findElement(favicon);
        if(null != element)
        {
            b = true;
        }
        return b;
    }

    /**
     * 点击"头像"
     */
    public String clickFavicon() {
        selenium.tap(favicon);
        return selenium.getText(logout_button);
    }

    /**
     * 点击"返回"
     */
    public void goBack() {
        if (null != selenium.findElement(back_button)) {
            selenium.tap(back_button);
        } else if (null != selenium.findElement(back2_button)) {
            selenium.click(back2_button);
        } else
        {
            selenium.click(back3_button);
        }
    }


    /**
     * 获取所有的Menu
     *
     * @return
     */
    public List<WebElement> getCells() {
        return selenium.findElements(table_cell);
    }

    /**
     * 点击Menu
     *
     * @param element
     */
    public WebElement clickMenu(WebElement element) {
        WebElement content = null;
        selenium.click(element);
        content = selenium.findElement(table_content1);
        if (null == content) {
            content = selenium.findElement(table_content2);
        }
        if (null == content) {
            content = selenium.findElement(table_content3);
        }
        return content;
    }


    public Object[][] getMenu()
    {
        return new Object[][] {
                {available_balance_menu, available_balance, "0.49"},
                {experience_gold_menu, experience_gold_record, "投资项目成功扣除"}
        };
    }


}
