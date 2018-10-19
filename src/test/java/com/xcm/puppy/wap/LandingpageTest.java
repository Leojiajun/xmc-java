package com.xcm.puppy.wap;

import com.xcm.puppy.BaseTest;
import com.xcm.puppy.page.EndSystem;
import com.xcm.puppy.util.ApacheHttpClient;
import com.xcm.puppy.util.Selenium;
import com.xcm.puppy.util.StaticDataProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * Created by jenkins on 6/2/17.
 */
public class LandingpageTest extends BaseTest {

    private EndSystem endSystem;
    private RemoteWebDriver wd;
    private Selenium selm;

    private String mobile, username, password;

    @Parameters({"mobile", "end-username", "end-password"})
    @BeforeClass(alwaysRun = true)
    public void init(String mobile, String username, String password) {
        wd = new FirefoxDriver();
        selm = new Selenium(wd);
        endSystem = new EndSystem(wd);

        this.mobile = mobile;
        this.username = username;
        this.password = password;
    }

    @Test(alwaysRun = true, dataProvider = "PageData4LandingPage", dataProviderClass = StaticDataProvider.class)
    public void register(String url, String phone, String imgCode, String smsBtn, String smsCode, String regBtn, String msg) {
        deleteMember(mobile, username, password);    //注册之前,先删除注册记录
        /**
         * 着陆页注册
         */
        selenium.open(url);
        selenium.sendkeys(phone, mobile);
        selenium.sendkeys(imgCode, "9999");
        selenium.click(smsBtn);
        //sendSMS(mobile);
        String code = getVerificationCode(mobile, username, password);
        selenium.sendkeys(smsCode, code);
        selenium.click(regBtn);

        //WebElement element = selenium.findElement(msg);
        // if(null == element) {
        //     Assert.fail("注册失败, 请检查注册流程, 着陆页为 - " + url);
        //} else {
        int j = url.indexOf("openid=");
        String openid = url.substring(j + 7);
        int k = openid.indexOf("&");
        openid = openid.substring(0, k);

        String c = getOpenID(mobile, username, password);
        deleteMember(mobile, username, password);    //注册之后,删除注册记录

        Assert.assertEquals(c, openid);
        // }

    }

    @Test(alwaysRun = true, priority = 1, dataProvider = "LandingPageData4Test", dataProviderClass = StaticDataProvider.class)
    public void test(String url, String checkpoint) {
        selenium.open(url);
        WebElement element = selenium.findElement(checkpoint);
        Assert.assertNotNull(element);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        selm.quit();
    }

    private String getOpenID(String mobile, String username, String password) {
        selm.open("http://open.91xcm.com/login.jsp");
        wd.manage().window().maximize();
        endSystem.login(username, password);
        return endSystem.queryMemberInOpenSys(mobile);
    }

    private String sendSMS(String mobile) {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("phone", mobile);
        params.put("imgCode", "9999");
        ApacheHttpClient client = new ApacheHttpClient();
        String response = client.getResponse("http://m.91xcm.com/msg/sendRegTextMessage.do", params);
        System.out.println(response);
        return null;
    }

    private void deleteMember(String mobile, String username, String password) {
        selm.open("http://member.91xcm.com/");
        wd.manage().window().maximize();
        endSystem.login(username, password);
        endSystem.deleteMember(mobile);
    }

    private String getVerificationCode(String mobile, String username, String password) {
        selm.open("http://member.91xcm.com/");
        wd.manage().window().maximize();
        endSystem.login(username, password);
        return endSystem.queryVerificationCodeInMemberSys(mobile);
    }

    public static void main(String[] args) {
        LandingpageTest test = new LandingpageTest();
        test.init("18521797800", "sunlichao", "slc123456");
        test.sendSMS("18521797800");
        String c = test.getOpenID("18521797800", "sunlichao", "slc123456");
        System.out.println(c);
    }


}
