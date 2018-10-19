package com.xcm.puppy.website;

import com.xcm.puppy.BaseTest;
import com.xcm.puppy.page.EndSystem;
import com.xcm.puppy.util.ApacheHttpClient;
import com.xcm.puppy.util.StaticDataProvider;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by jenkins on 6/2/17.
 */
public class LandingpageTest extends BaseTest {

    private EndSystem endSystem;
    private String mobile, username, password;

    @Parameters({"mobile", "end-username", "end-password"})
    @BeforeClass(alwaysRun = true)
    public void init(String mobile, String username, String password) {
        endSystem = new EndSystem(driver);

        this.mobile = mobile;
        this.username = username;
        this.password = password;

    }

    @Test(alwaysRun = true, dataProvider = "PageData4LandingPage", dataProviderClass = StaticDataProvider.class)
    public void register(String url, String phone, String imgCode, String smsBtn, String smsCode, String regBtn, String msg ) {
        String windowHandle = driver.getWindowHandle();
        deleteMember(mobile, username, password, windowHandle);    //注册之前,先删除注册记录
        driver.switchTo().window(windowHandle);
        /**
         * 着陆页注册
         */
        selenium.open(url);
        selenium.sendkeys(phone, mobile);
        selenium.sendkeys(imgCode, "9999");
        //selenium.click(smsBtn);
        sendSMS(mobile);
        String code = getVerificationCode(mobile, username, password, windowHandle);
        driver.switchTo().window(windowHandle);
        selenium.sendkeys(smsCode, code);
        selenium.click(regBtn);

        WebElement element = selenium.findElement(msg);
        if(null == element) {
            Assert.fail("注册失败, 请检查注册流程, 着陆页为 - " + url);
        } else {
            int j = url.indexOf("openid=");
            String openid = url.substring(j + 7);
            int k = openid.indexOf("&");
            openid = openid.substring(0, k);

            String c = getOpenID(mobile, username, password, windowHandle);
            deleteMember(mobile, username, password, windowHandle);    //注册之后,删除注册记录
            Assert.assertTrue(c.contains(openid));
        }

    }

    //@Test(alwaysRun = true, priority = 1, dataProvider = "LandingPageData4Test", dataProviderClass = StaticDataProvider.class)
    public void test(String url, String checkpoint)
    {
        selenium.open(url);
        WebElement element = selenium.findElement(checkpoint);
        Assert.assertNotNull(element);
    }

    private String getOpenID(String mobile, String username, String password, String handle) {
        openEndSys("http://open.91xcm.com/login.jsp", handle);
        endSystem.login(username, password);
        return  endSystem.queryMemberInOpenSys(mobile);
    }

    private String sendSMS(String mobile)
    {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("phone", mobile);
        params.put("imgCode", "9999");
        ApacheHttpClient client = new ApacheHttpClient();
        return client.getResponse("http://m.91xcm.com/msg/sendRegTextMessage.do", params);
    }

    private void deleteMember(String mobile, String username, String password, String handle) {
        openEndSys("http://member.91xcm.com/", handle);
        endSystem.login(username, password);
        endSystem.deleteMember(mobile);
    }

    private String getVerificationCode(String mobile, String username, String password, String handle) {
        openEndSys("http://member.91xcm.com/", handle);
        endSystem.login(username, password);
        return endSystem.queryVerificationCodeInMemberSys(mobile);
    }

    private void openEndSys(String url, String handle)
    {
        String js = "window.open(\"" + url + "\")";

        Set<String> handles = driver.getWindowHandles();
        if(1 == handles.size())
        {
            JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
            jsDriver.executeScript(js);
            handles = driver.getWindowHandles();
            for(String h : handles)
            {
                if(!h.equals(handle)) {
                    driver.switchTo().window(h);
                    break;
                }
            }
        } else {
            for(String h : handles)
            {
                if(!h.equals(handle)) {
                    driver.switchTo().window(h);
                    break;
                }
            }
            driver.get(url);
        }






    }







}
