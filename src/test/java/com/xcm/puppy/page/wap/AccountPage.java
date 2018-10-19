package com.xcm.puppy.page.wap;

import com.xcm.puppy.util.PageLocator;
import com.xcm.puppy.util.Selenium;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

/**
 * Created by jenkins on 9/1/17.
 */
public class AccountPage {
    private RemoteWebDriver driver = Homepage.driver;
    private Selenium selenium = Homepage.selenium;

    private String loginBtn = PageLocator.account_login_button_wap;
    private String availableNav = PageLocator.account_nav01_wap;
    private String rechargeBtn = PageLocator.account_recharge_menu_wap;
    private String moneyInput = PageLocator.account_money_number_wap;
    private String rechargeNext = PageLocator.account_recharge_button_wap;
    private String sina = PageLocator.purchase_sina_label_wap;
    private String goldBtn = PageLocator.account_nav02_wap;
    private String goldList = PageLocator.account_gold_list_wap;
    private String goldPrdBtn = PageLocator.account_nav03_wap;
    private String goldPrd = PageLocator.account_ctx_wap;
    private String couponBtn = PageLocator.account_nav04_wap;
    private String coupon = PageLocator.account_coupon_wap;
    private String assetBtn = PageLocator.account_nav05_wap;
    private String finishAsset = PageLocator.account_finish_link_wap;
    private String assetItem = PageLocator.account_asset_list_wap;
    private String agreement = PageLocator.account_agreement_wap;
    private String agreementTitle = PageLocator.account_agreement_title_wap;
    private String investList = PageLocator.account_invest_wap;
    private String investItem = PageLocator.account_invest_item_wap;


    /**
     * 点击"登录"按钮
     */
    public void openLogin()
    {
        selenium.click(loginBtn);
    }

    /**
     * 点击"可用余额"
     */
    public void openAvailability()
    {
        selenium.click(availableNav);
    }

    /**
     * 点击"充值"
     */
    public void openRecharge()
    {
        selenium.click(rechargeBtn);
    }

    /**
     * 充值
     * @param money
     * @return
     */
    public WebElement goRecharge(double money)
    {
        selenium.sendkeys(moneyInput, money+"");
        selenium.click(rechargeNext);
        return selenium.findElement(sina);
    }

    /**
     * 点击"体验金"
     * @return
     */
    public WebElement openGold()
    {
        selenium.click(goldBtn);
        return selenium.findElement(goldList);
    }

    /**
     * 点击"芝麻开门"
     * @return
     */
    public WebElement openGoldPrd() {
        selenium.click(goldPrdBtn);
        return selenium.findElement(goldPrd);
    }

    /**
     * 点击"优惠券"
     * @param tab
     * @return
     */
    public int openCoupon(String tab)
    {
        int size = 0;
        selenium.click(couponBtn);
        selenium.click(tab);
        List<WebElement> elements = selenium.findElements(coupon);
        if(null != elements)
        {
            size = elements.size();
        }
        return size;
    }

    /**
     * 点击"持有资产"
     * @return
     */
    public WebElement openAsset()
    {
        selenium.click(assetBtn);
        return selenium.findElement(finishAsset);
    }

    /**
     * 打开"订单详情"
     * @return
     */
    public void openHoldingAsset()
    {
        selenium.click(finishAsset);
        selenium.click(assetItem);
    }

    /**
     * 打开"订单协议"
     * @return
     */
    public String openAgreement()
    {
        selenium.click(agreement);
        return selenium.getText(agreementTitle);
    }

    /**
     * 打开"标的详情"
     */
    public void openOrder()
    {
        selenium.click(investList);
        selenium.click(investItem);
    }








}
