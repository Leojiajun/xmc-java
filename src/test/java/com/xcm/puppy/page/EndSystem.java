package com.xcm.puppy.page;

import com.xcm.puppy.util.Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by jenkins on 8/2/17.
 */
public class EndSystem {

    private RemoteWebDriver driver;
    private Selenium selenium;

    public EndSystem(RemoteWebDriver driver)
    {
        this.driver = driver;
        this.selenium = new Selenium(driver);
    }

    /**
     * 登录
     * @param username
     * @param password
     */
    public void login(String username, String password)
    {
        WebElement element = selenium.findElement("id=j_username");
        if (element != null) {
            selenium.sendkeys("id=j_username", username);
            selenium.sendkeys("id=j_password", password);
            selenium.click("id=loginBtn");
        }
    }

    /**
     * 在open系统中查询会员归属渠道
     * @param username
     */
    public String queryMemberInOpenSys(String username)
    {
        WebElement element = selenium.findElement("xpath=//ul[@id='MO2000000000001650']");
        String js = "arguments[0].style='display:block'";
        ((JavascriptExecutor) driver).executeScript(js, element);
        selenium.click("link=会员交易解析");
        selenium.sendkeys("id=member_phone", username);
        selenium.click("id=btnQuery");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        selenium.click("link=末页");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement tBody = selenium.findElement("xpath=//div[@id='queryMemberMqMsgList']/div/div/div[2]/table/tbody");
        List<WebElement> elements = tBody.findElements(By.tagName("tr"));
        int i = elements.size();
        String xpath = "xpath=//div[@id='queryMemberMqMsgList']/div/div/div[2]/table/tbody/tr[" + i + "]/td[8]";

        String message = selenium.getText(xpath);
        System.out.println("========================================");
        System.out.println("Message : " + message);
        System.out.println("========================================");

        String registerTime = getValue(message, "registerTime\":\"");

        Date regTime = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            regTime = dateFormat.parse(registerTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long seconds = ((new Date()).getTime() - regTime.getTime()) / 1000;
        if( seconds > 180)
        {
            return registerTime;
        } else {
            return getValue(message, "openId\":\"");
        }

    }

    /**
     * 在Member系统中查询验证码
     * @param mobile
     * @return
     */
    public String queryVerificationCodeInMemberSys(String mobile)
    {
        selenium.click("link=验证码管理");
        selenium.sendkeys("id=txtPhone", mobile);
        selenium.click("id=btnQuery");
        return selenium.getText("xpath=//div[@id='smsCodeList']/table/tbody/tr/td[4]");

    }

    /**
     * 在Member系统中删除账户
     * @param mobile
     */
    public void deleteMember(String mobile)
    {
        selenium.click("link=可删用户管理");
        selenium.sendkeys("id=mbPhone", mobile);
        selenium.click("id=btnQuery");
        WebElement element = selenium.findElement("xpath=//div[@id='memberDelList']/table/tbody/tr/td/a");
        if(element != null) {
            selenium.click("xpath=//div[@id='memberDelList']/table/tbody/tr/td/a");
            selenium.click("xpath=//button[@i-id='ok']");
        }
    }

    private String getValue(String parameter, String value)
    {
        int i = parameter.indexOf(value);
        String str = parameter.substring(i + value.length());
        int j = str.indexOf("\"");
        return str.substring(0, j);
    }

}
