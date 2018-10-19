package com.xcm.puppy;

import com.xcm.puppy.util.Selenium;
import com.xcm.puppy.util.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

/**
 * Created by jenkins on 2/11/16.
 */
public class ProductRelease {

    private WebDriver driver = new FirefoxDriver();
    private Selenium selenium = new Selenium(driver);
    private String url = "http://192.168.3.240:8080/fund-war/login.jsp";


    @BeforeClass(alwaysRun = true)
    public void login() {
        selenium.open(url);
        selenium.sendkeys("id=j_username", "admin");
        selenium.sendkeys("id=j_password", "111111");
        selenium.click("id=loginBtn");

    }


    @Test(alwaysRun = true, priority = 0, dataProvider = "test_data")
    public void create(@Optional String pCode, @Optional String pName, @Optional String totalAmount,
                       @Optional String defaultAmount, @Optional String collected, @Optional String minAmount,
                       @Optional String incrementAmount) {

        selenium.click("link=发布理财计划");
        selenium.select("id=businessId", "百财车贷");
        selenium.select("id=mbProductId", "百财车贷");
        selenium.select("id=pcode", pCode);
        selenium.sendkeys("id=bidTitle", pName);
        selenium.select("id=repayType", "到期一次性还本付息");
        selenium.sendkeys("id=totalBidAmount", totalAmount);
        selenium.sendkeys("id=defaultInvestmentAmount", defaultAmount);
        selenium.select("id=isCollected", collected);
        selenium.sendkeys("id=minInvestAmount", minAmount);
        selenium.sendkeys("id=incrementInvestmentAmount", incrementAmount);
        selenium.select("id=did", "天");
        selenium.sendkeys("id=startInvestDate", StringUtils.now("yyyy-MM-dd"));
        selenium.sendkeys("id=planEndInvestDate", StringUtils.getDate("yyyy-MM-dd", 15));
        selenium.select("id=assetsType", "直投");
        selenium.click("xpath=//button[@onclick='saveBidInfo2();']");
        selenium.dismiss();
    }

    @Test(alwaysRun = true, priority = 1, dataProvider = "test_data")
    public void confirm(@Optional String pCode, @Optional String pName, @Optional String totalAmount,
                        @Optional String defaultAmount, @Optional String collected, @Optional String minAmount,
                        @Optional String incrementAmount) {

        selenium.click("link=标的管理");
        selenium.sendkeys("id=txtbidTitle", pName);
        selenium.select("id=optPcode", pCode);
        selenium.click("id=stateCodeAll");
        selenium.click("id=btnQuery");
        selenium.click("xpath=//input[@type='radio']");
        selenium.click("id=btnLoanConfirm");
        selenium.click("class=ui-dialog-autofocus");

    }

    @Test(alwaysRun = true, priority = 2, dataProvider = "test_data")
    public void publish(@Optional String pCode, @Optional String pName, @Optional String totalAmount,
                        @Optional String defaultAmount, @Optional String collected, @Optional String minAmount,
                        @Optional String incrementAmount) {

        selenium.click("link=标的管理");
        selenium.sendkeys("id=txtbidTitle", pName);
        selenium.select("id=optPcode", pCode);
        selenium.click("id=stateCodeAll");
        selenium.click("id=btnQuery");
        selenium.click("xpath=//input[@type='radio']");
        selenium.click("id=btnStartSellTime");
        selenium.accept();
        selenium.accept();
    }

    @AfterClass(alwaysRun = true)
    public void quit()
    {
        selenium.quit();
    }

    @DataProvider(name = "test_data")
    public static Object[][] generateData() {
        String code = System.getProperty("pCode");
        String name = System.getProperty("pName");
        String count = System.getProperty("pCount");
        String tAmount = System.getProperty("totalAmount");
        String dAmount = System.getProperty("defaultAmount");
        String collect = System.getProperty("collected");
        String mAmount = System.getProperty("minAmount");
        String iAmount = System.getProperty("incrementAmount");

        int n = Integer.parseInt(name);
        int c = Integer.parseInt(count);

        Object[][] obj = new Object[c][];

        for (int i = 0; i < c; i++) {
            String productName = code + "T" + n;
            Object[] rows = {code, productName, tAmount, dAmount, collect, mAmount, iAmount};
            obj[i] = rows;
            n++;
        }
        return obj;
    }


    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
